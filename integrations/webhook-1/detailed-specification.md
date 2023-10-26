# Receiving and understanding messages

## Request

### Sample header

```bash
Accept: application/json
X-PURCHASELY-REQUEST-SIGNATURE: 506c1...44a180
```

### Authenticating request and verifying signature (recommended)

To ensure that events are indeed coming from Purchasely Cloud Platform, you can authentify these events using informations contained in the HEADER of the HTTP request :

* `X-PURCHASELY-REQUEST-SIGNATURE` : request signature

This verification is optional.

{% hint style="info" %}
Depending on your framework, you may receive the headers under another format:

* Ruby on Rails: `HTTP_X_PURCHASELY_REQUEST_SIGNATURE`
* NestJS: x-purchasely-request-signature
{% endhint %}

The signature relies on a shared secret that you can find in your Purchasely Console (_Client shared secret_)\
_Purchasely Console > Settings > Webhooks_

Sample codes for signature verification:

{% tabs %}
{% tab title="JavaScript" %}
```javascript
const crypto = require("crypto");

// Request headers
// ---------------
const xPurchaselyRequestSignature = "506c1cfbd92bafc81b6b1246ff9addbfdff8cddc07fb7298df2cdc32f144a180";

// Request body
// ------------
const body = {"a_random_key":"a_random_value_amet"};

// Signature verification
// ----------------------
const webhookSharedSecret = "foobar";
const dataToSign = webhookSharedSecret + JSON.stringify(body);
const computedSignature = crypto
                          .createHmac("sha256", webhookSharedSecret)
                          .update(dataToSign)
                          .digest("hex");

if (computedSignature === xPurchaselySignature) {
  // request authenticated
}
```
{% endtab %}

{% tab title="Ruby" %}
```ruby
require 'openssl'

# Request headers
# ---------------
x_purchasely_signature = '506c1cfbd92bafc81b6b1246ff9addbfdff8cddc07fb7298df2cdc32f144a180'

# Request body
# ------------
body = {"a_random_key" => "a_random_value_amet"}

# Signature verification
# ----------------------
webhook_shared_secret = 'foobar'
data_to_sign = webhook_shared_secret + body.to_json
computed_signature = OpenSSL::HMAC.hexdigest('sha256', webhook_shared_secret, data_to_sign)

if (computed_signature == x_purchasely_signature) {
  # request authenticated
}
```
{% endtab %}

{% tab title="Kotlin" %}
```kotlin
// Imports
// -------
import javax.crypto.Mac
import javax.crypto.spec.SecretKeySpec

// Request headers
// ---------------
val xPurchaselySignature = "506c1cfbd92bafc81b6b1246ff9addbfdff8cddc07fb7298df2cdc32f144a180";

// Request body
// ------------
val body = "{\"a_random_key\":\"a_random_value_amet\"}"

// Signature verification
// ----------------------
val webhookSharedSecret = "foobar"
val dataToSign = webhookSharedSecret + body
val hmac = Mac.getInstance("HmacSHA256")
hmac.init(SecretKeySpec(webhookSharedSecret.toByteArray(), "HmacSHA256"))
val computedSignature = hmac.doFinal(dataToSign.toByteArray()).joinToString("") { "%02x".format(it) }

if (computedSignature == xPurchaselySignature) {
    // request authenticated
}
```
{% endtab %}
{% endtabs %}

### Body

#### Sample body

```jsx
{
  "plan": "my_sub_monthly",
  "store": "APPLE_APP_STORE",
  "product": "my_product",
  "event_id": "de3f1e90-28bd-4cf1-9fe7-992fb62811a0",
  "placement": "onboarding",
  "event_name": "SUBSCRIPTION_TRANSFERRED",
  "offer_type": "NONE",
  "api_version": 3,
  "environment": "SANDBOX",
  "presentation": "mailys_paywall",
  "purchased_at": "2022-08-24T09:59:24.000Z",
  "purchase_type": "RENEWING_SUBSCRIPTION",
  "store_country": "FR",
  "next_renewal_at": "2022-08-24T10:04:24.000Z",
  "purchased_at_ms": 1661335164000,
  "event_created_at": "2022-08-24T10:00:18.794Z",
  "is_family_shared": false,
  "store_product_id": "com.purchasely.plus.monthly",
  "anonymous_user_id": "6837C35A-949B-4489-B212-62F66ACA6CC2",
  "customer_currency": "EUR",
  "plan_price_in_usd": 83.71,
  "next_renewal_at_ms": 1661335464000,
  "event_created_at_ms": 1661335218794,
  "previous_offer_type": "NONE",
  "store_app_bundle_id": "com.purchasely.demo",
  "subscription_status": "DEACTIVATED",
  "store_transaction_id": "2000000137582598",
  "original_purchased_at": "2021-10-13T15:09:25.000Z",
  "transferred_to_user_id": "jeff",
  "original_purchased_at_ms": 1634137765000,
  "effective_next_renewal_at": "2022-08-24T10:04:24.000Z",
  "purchasely_subscription_id": "subs_gxAHaBBV6jftATvWf8D1p1kkSSH2yiz",
  "effective_next_renewal_at_ms": 1661335464000,
  "store_original_transaction_id": "1000000892047818",
  "plan_price_in_customer_currency": 83.99
}
```

More information on these properties can be found [here](../../analytics/events/webhook-events/subscription-events.md):

{% hint style="danger" %}
Never use the `next_renewal_at / effective_next_renewal_at` to invalidate a subscription (and always use the webhook sent to you for this sole purpose). This date is only here to help your marketing team take actions (or if you want to display the next renewal date in your app).

If you ever needed a fail safe to unsubscribe users in case an issue occurs with Apple/Google/Huawei/Purchasely/your servers, you should let at least a 24h-margin with the given `next_renewal_at / effective_next_renewal_at`.
{% endhint %}

####

## Response

When called by Purchasely Cloud Platform, client backend should respond with a HTTP code :

* HTTP 200 ⇒ the **Event** has been well received and processed (eg: the subscription has been activated/deactivated)\\
* Other than HTTP 200 or no response (timeout) ⇒ an error has occurred and the **Event** could not be processed :
  * The user is warned through the SDK that something did not work\\
  * Purchasely Cloud Platform will retry several times to send the **Event** (max 25 times) in the following hours.

This response from the client backend to the Purchasely Console is mandatory, particularly for purchase events (e.g. new subscriptions) coming from the SDK, to ensure that the client backend has granted the user with the entitlements corresponding to the new purchase, and unlocked the access to the premium contents or features.

This response from the client backend is forwarded to the mobile SDK and an error message is displayed to the user, if it is different from HTTP 200.

{% hint style="warning" %}
Please note that our webhooks enforce a 10-second read timeout. To avoid any disruptions or errors, ensure that your system responds with an HTTP 200 status code within this 10-second window.
{% endhint %}
