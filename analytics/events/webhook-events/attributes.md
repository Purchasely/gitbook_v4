# Subscription events attributes

## Attributes

All our subscription events are broadcast with attributes, you will find here the full list of those attributes and their specifics. We encourage you to use those attributes to take decision (for exemple whether you will make a special offer to your customer or not) and to tailor your communications.

<table><thead><tr><th width="330.3333333333333">Attribute</th><th width="419.83797352806937">Description</th><th>Mandatory</th><th data-hidden></th></tr></thead><tbody><tr><td>api_version</td><td><p><strong>int</strong></p><p></p><p>Contains the webhook API version.</p></td><td>Yes</td><td></td></tr><tr><td>event_name</td><td><p><strong>string</strong> </p><p></p><p>Contains the name of the event. <a href="subscription-events.md"><em>learn more</em></a></p></td><td>Yes</td><td></td></tr><tr><td>event_created_at</td><td><p><strong>string</strong> </p><p><em>in ISO 8601</em></p><p></p><p>Contains the date which the event was sent the first time. In case of retry that attribute will still be set with the time at the first try.</p></td><td>Yes</td><td></td></tr><tr><td>event_created_at_ms</td><td><p><strong>int</strong></p><p><em>in milliseconds since the Epoch</em></p><p></p><p>Contains the date which the event was sent the first time. In case of retry that attribute will still be set with the time at the first try.</p></td><td>Yes</td><td></td></tr><tr><td>product</td><td><p><strong>string</strong></p><p></p><p>Contains the <em>Product id</em> that carries the plan that was bought. Reference to the <em>Product vendor id</em> you created in the Purchasely console.</p></td><td>Yes</td><td></td></tr><tr><td>offer_identifier</td><td><strong>string</strong><br><br>Contains the promo code used at the time of the purchase.</td><td>No</td><td></td></tr><tr><td>content_id</td><td><p><strong>string</strong></p><p></p><p>Contains the content_id you may have set on the SDK to display the paywall. <a href="../../../advanced-features/attributing-content.md"><em>learn more</em></a></p></td><td>No</td><td></td></tr><tr><td>plan</td><td><p><strong>string</strong></p><p></p><p>Contains the <em>Plan id</em> that was bought. Reference to the <em>Plan vendor id</em> you created in the Purchasely console.</p></td><td>No</td><td></td></tr><tr><td>plan_price_in_xxx</td><td><strong>float</strong><br><br>Contains the price paid by a customer in the current period of its subscription (so 0 during a free trial) using the currency defined in Purchasely's App Settings.<br><br><code>xxx</code> is the <a href="https://en.wikipedia.org/wiki/ISO_4217">ISO 4217</a> code of the currency and will be replaced accrodingly to the selected currency in the settings.</td><td></td><td></td></tr><tr><td>plan_price_in_customer_currency </td><td><strong>float</strong><br><br>Contains the price paid by a customer in its own currency (<code>customer_currency</code>) in the current period of its subscription (so 0 during a free trial).</td><td>No</td><td></td></tr><tr><td>customer_currency</td><td><strong>string</strong><br><br>Contains the customers's store currency.</td><td>No</td><td></td></tr><tr><td>amount_in_xxx</td><td><p><strong>float</strong><br><br><strong>⚠️</strong> Only available for <code>TRANSACTION_PROCESSED</code> event<br><br>Contains the amount of the transaction associated with the event <code>TRANSACTION_PROCESSED</code> using the currency defined in Purchasely's App Settings. This amount is the price paid by the customer VAT included.<br></p><p>This amount can also be negative in case of a refund or an plan upgrade with a partial refund.<br><br><code>xxx</code> is the <a href="https://en.wikipedia.org/wiki/ISO_4217">ISO 4217</a> code of the currency and will be replaced accordingly to the selected currency in the settings.</p></td><td>No</td><td></td></tr><tr><td>amount_in_customer_currency</td><td><p><strong>float</strong></p><p></p><p><strong>⚠️</strong> Only available for <code>TRANSACTION_PROCESSED</code> event<br><br>Contains the amount of the transaction associated with the event <code>TRANSACTION_PROCESSED</code> using the customer's currency (<code>customer_currency</code>). This amount is the price paid by the customer VAT included.<br></p><p>This amount can also be negative in case of a refund or an plan upgrade with a partial refund.<br><br><code>xxx</code> is the <a href="https://en.wikipedia.org/wiki/ISO_4217">ISO 4217</a> code of the currency and will be replaced accordingly to the selected currency in the settings.</p></td><td>No</td><td></td></tr><tr><td>source_event_name</td><td><strong>string</strong><br><br><strong>⚠️</strong> Only available for <code>TRANSACTION_PROCESSED</code> event<br><br>Contains the name of the subscription event which was associated with the <code>TRANSACTION_PROCESSED</code> event</td><td>No</td><td></td></tr><tr><td>cumulated_revenues_in_xxx</td><td><strong>float</strong><br><br>Contains the cumulated revenues for the associated user in the currency defined in Purchasely's App Settings. This amount is VAT included.<br><br><code>xxx</code> is the <a href="https://en.wikipedia.org/wiki/ISO_4217">ISO 4217</a> code of the currency and will be replaced accordingly to the selected currency in the settings.</td><td>No</td><td></td></tr><tr><td>previous_plan</td><td><p><strong>string</strong></p><p></p><p>Contains the P<em>lan vendor id</em> the customer used to have before changing plan.</p><p></p><p>Used with for the following events: </p><ul><li><code>SUBSCRIPTION_CROSSGRADED</code> </li><li><code>SUBSCRIPTION_DOWNGRADED</code></li><li><code>SUBSCRIPTION_UPGRADED</code></li></ul></td><td>No</td><td></td></tr><tr><td>device_type</td><td><p><strong>string</strong><br><br>Contains the device type associated with the purchase.<br><br>Possible values: </p><ul><li><code>COMPUTER</code></li><li><code>PAD</code></li><li><code>PHONE</code></li><li><code>TV</code></li></ul></td><td>No</td><td></td></tr><tr><td>store</td><td><p><strong>string</strong></p><p></p><p>Contains the name of the Store through which the purchase was made.</p><p></p><p>Possible values: </p><ul><li><code>APPLE_APP_STORE</code></li><li><code>GOOGLE_PLAY_STORE</code></li><li><code>AMAZON_APPSTORE</code></li><li><code>HUAWEI_APPGALLERY</code></li></ul></td><td>Yes</td><td></td></tr><tr><td>store_country</td><td><p><strong>string</strong></p><p><em>in ISO 3166</em></p><p></p><p>Contains the store country where the purchase was made.</p><p></p><p>Can be NULL in case the subscription was purchased before Purchasely was implemented in your system.</p></td><td>Yes</td><td></td></tr><tr><td>purchasely_subscription_id</td><td><p><strong>string</strong></p><p></p><p>Contains the Purchasely internal unique idendifier of the subscription.</p><p></p><p>Used with events that regards a subscription.</p></td><td>No</td><td></td></tr><tr><td>purchasely_one_time_purchase_id</td><td><p><strong>string</strong></p><p></p><p>Contains the Purchasely internal unique idendifier of the one time purchase.</p><p></p><p>Used with all events that regards a one time purchase.</p></td><td>No</td><td></td></tr><tr><td>store_product_id</td><td><p><strong>string</strong></p><p></p><p>Contains the product_id you created in the store console.</p></td><td>Yes</td><td></td></tr><tr><td>store_transaction_id</td><td><p><strong>string</strong></p><p></p><p>Contains the transaction_id given by the store.</p></td><td>Yes</td><td></td></tr><tr><td>purchased_at</td><td><p><strong>string</strong></p><p><em>in ISO 8601</em></p><p></p><p>Contains the date of the last transaction (original purchase or renewal).</p></td><td>Yes</td><td></td></tr><tr><td>purchased_at_ms</td><td><p><strong>int</strong></p><p><em>in milliseconds since the Epoch</em></p><p></p><p>Contains the date of the last transaction (original purchase or renewal).</p></td><td>Yes</td><td></td></tr><tr><td>store_original_transaction_id</td><td><p><strong>string</strong></p><p></p><p>Contains the store_transaction_id of the first transaction. </p></td><td>Yes</td><td></td></tr><tr><td>original_purchased_at</td><td><p><strong>string</strong></p><p><em>in ISO 8601</em></p><p></p><p>Contains the date of the first transaction.</p></td><td>Yes</td><td></td></tr><tr><td>original_purchased_at_ms</td><td><p><strong>int</strong></p><p><em>in milliseconds since the Epoch</em></p><p></p><p>Contains the date of the first transaction<strong>.</strong></p></td><td>Yes</td><td></td></tr><tr><td>anonymous_user_id</td><td><p><strong>string</strong></p><p></p><p>Contains the anonymous_user_id that holds the purchase. </p><p></p><p>That attribute will be filled with a Purchasely generated anonymous_id if your app doesn't require the user to be logged in and/or you didn't specified to us a user_id<strong>.</strong></p></td><td>No</td><td></td></tr><tr><td>user_id</td><td><p><strong>string</strong></p><p></p><p>Contains the user_id that holds the purchase.</p><p></p><p>That attribute will be filled with the user_id you provided us through the SDK.</p></td><td>No</td><td></td></tr><tr><td>transferred_from_anonymous_user_id</td><td><p><strong>string</strong></p><p></p><p>Contains the anonymous_user_id the subscription was transferred from. </p><p></p><p>That attribute is filled for the following event:</p><ul><li><code>SUBSCRIPTION_RECEIVED</code></li></ul></td><td>No</td><td></td></tr><tr><td>transferred_to_anonymous_user_id</td><td><p><strong>string</strong></p><p></p><p>Contains the anonymous_user_id the subscription was transferred to. </p><p></p><p>That attribute is filled for the following event:</p><ul><li><code>SUBSCRIPTION_TRANSFERRED</code></li></ul></td><td>No</td><td></td></tr><tr><td>transferred_from_user_id</td><td><p><strong>string</strong></p><p></p><p>Contains the user_id the subscription was transferred from. </p><p></p><p>That attribute is filled for the following event :</p><ul><li>SUBSCRIPTION_RECEIVED</li></ul></td><td>No</td><td></td></tr><tr><td>transferred_to_user_id</td><td><p><strong>string</strong></p><p></p><p>Contains the user_id the subscription was transferred to. </p><p></p><p>That attribute is filled for the following event:</p><ul><li><code>SUBSCRIPTION_TRANSFERRED</code></li></ul></td><td>No</td><td></td></tr><tr><td>environment</td><td><p><strong>string</strong></p><p></p><p>Contains the environment from where the purchase was made.<br></p><p>Possible values:</p><ul><li><code>SANDBOX</code></li><li><code>PRODUCTION</code></li></ul></td><td>Yes</td><td></td></tr><tr><td>is_family_shared</td><td><p><strong>bool</strong></p><p></p><p>Contains true or false depending on if the user has access to the subscription thanks to family sharing.</p></td><td>No</td><td></td></tr><tr><td>previous_offer_type</td><td><p><strong>string</strong></p><p></p><p>Contains the previous offer the subscription was under.</p><p></p><p>That attribute is always filled for events that regards subscriptions except for the very first <code>ACTIVATE</code> and <code>SUBSCRIPTION_STARTED</code>.</p><p></p><p>Possible values:</p><ul><li><code>NONE</code>: the user was paying the normal price, no offer associated</li><li><code>FREE_TRIAL</code></li><li><code>INTRO_OFFER</code></li><li><code>PROMO_CODE</code></li></ul></td><td>No</td><td></td></tr><tr><td>offer_type</td><td><p><strong>string</strong></p><p></p><p>Contains the current offer the subscription is under.</p><p></p><p>Possible values:</p><ul><li><code>NONE</code>: the user is paying the normal price, no offer associated</li><li><code>FREE_TRIAL</code></li><li><code>INTRO_OFFER</code></li><li><code>PROMO_CODE</code></li></ul></td><td>Yes</td><td></td></tr><tr><td>subscription_status</td><td><p><strong>string</strong></p><p></p><p>Contains the current status of the subscription.</p><p></p><p>Filled for events that regards a subscription.</p><p></p><p>Possible Values :</p><ul><li><code>AUTO_RENEWING</code></li><li><code>ON_HOLD</code></li><li><code>IN_GRACE_PERIOD</code></li><li><code>AUTO_RENEWING_CANCELED</code></li><li><code>DEACTIVATED</code></li><li><code>REVOKED</code></li><li><code>PAUSED</code></li><li><code>UNPAID</code></li></ul></td><td>No</td><td></td></tr><tr><td>grace_period_expires_at</td><td><p><strong>string</strong></p><p><em>in ISO 8601</em></p><p></p><p>Filled for events that regards a subscription which is in grace period.</p><p></p><p>Contains the date when the grace period will end.</p></td><td>No</td><td></td></tr><tr><td>grace_period_expires_at_ms</td><td><p><strong>int</strong></p><p></p><p>Filled for events that regards a subscription which is in grace period.</p><p></p><p>Contains the date when the grace period will end in milliseconds since the Epoch.</p></td><td>No</td><td></td></tr><tr><td>effective_next_renewal_at</td><td><p><strong>string</strong></p><p><em>in ISO 8601</em></p><p></p><p>Filled for events that regards a subscription.</p><p></p><p>Contains the effective next renewal date, taking any grace or defer periods into account. If the subscription isn’t in grace or deferring period the effective date is equal to next_renewal_at. </p></td><td>No</td><td></td></tr><tr><td>effective_next_renewal_at_ms</td><td><p><strong>int</strong></p><p><em>in milliseconds since the Epoch.</em></p><p></p><p>Filled for events that regards a subscription.</p><p></p><p>Contains the effective next renewal date, taking any grace or defer periods into account. If the subscription isn’t in grace or deferring period the effective date is equal to next_renewal_at<strong>.</strong> </p></td><td>No</td><td></td></tr><tr><td>next_renewal_at</td><td><p><strong>string</strong></p><p><em>in ISO 8601</em></p><p></p><p>Filled for events that regards a subscription.</p><p></p><p>Contains the theoretical next automatic renewal date<strong>.</strong></p><p>See effective_newt_renewal_at.</p></td><td>No</td><td></td></tr><tr><td>next_renewal_at_ms</td><td><p><strong>int</strong></p><p><em>in milliseconds since the Epoch</em></p><p></p><p>Filled for events that regards a subscription.</p><p></p><p>Contains the theoretical next automatic renewal date.</p><p>See effective_next_renewal_at.</p></td><td>No</td><td></td></tr><tr><td>defer_end_at</td><td><p><strong>string</strong></p><p><em>in ISO 8601</em></p><p></p><p>Filled for events that regards a subscription.</p><p></p><p>Contains the date when the free time offered will be ending.</p></td><td>No</td><td></td></tr><tr><td>defer_end_at_ms</td><td><p><strong>int</strong></p><p><em>in milliseconds since the Epoch</em></p><p></p><p>Filled for events that regards a subscription.</p><p></p><p>Contains the date when the free time offered will be ending.</p></td><td>No</td><td></td></tr><tr><td>auto_resume_at</td><td><p><strong>string</strong></p><p><em>in ISO 8601</em></p><p></p><p>Filled for events that regards a subscription.</p><p></p><p>Contains the date when the pause will be ending and the subscription will resume.</p></td><td>No</td><td></td></tr><tr><td>auto_resume_at_ms</td><td><p><strong>int</strong></p><p><em>in milliseconds since the Epoch.</em></p><p></p><p>Filled for events that regards a subscription.</p><p></p><p>Contains the date when the pause will be ending and the subscription will resume.</p></td><td>No</td><td></td></tr><tr><td>presentation</td><td><strong>string</strong><br><br>Contains the id of the associated presentation when the initial purchase was made.</td><td>No</td><td></td></tr><tr><td>placement</td><td><strong>string</strong><br><br>Contains the id of the placement from where the subscription was bought. <a href="../../../quick-start-1/sdk-configuration/config-appendices/present-paywalls.md">learn more</a></td><td>No</td><td></td></tr><tr><td>ab_test</td><td><strong>string</strong><br><br>Contains the id of the running AB test when the initial purchase was made.</td><td>No</td><td></td></tr><tr><td>ab_test_variant</td><td><strong>string</strong><br><br>Contains the id of the AB test variant in which the user was when the initial purchase was made.</td><td>No</td><td></td></tr><tr><td>audience</td><td><strong>string</strong><br><br>Contains the id of the audience the user matched within the associated placement when the initial purchase was made. <a href="../../../advanced-features/audiences.md">learn more</a></td><td>No</td><td></td></tr></tbody></table>

## JSON Samples

{% tabs %}
{% tab title="SUBSCRIPTION_STARTED" %}
```javascript
{
  "plan": "<plan vendorID defined in the Purchasely console>",
  "store": "APPLE_APP_STORE",
  "product": "<product vendorID define in the Purchasely console>",
  "user_id": "<user id you provided through the sdk>",
  "event_name": "SUBSCRIPTION_STARTED",
  "offer_type": "NONE",
  "api_version": 3,
  "environment": "SANDBOX",
  "purchased_at": "2021-11-07T17:41:17.000Z",
  "store_country": "FR",
  "next_renewal_at": "2021-11-07T17:44:17.000Z",
  "purchased_at_ms": 1636306877000,
  "event_created_at": "2021-11-07T17:41:34.188Z",
  "is_family_shared": false,
  "store_product_id": "<store product id defined in the store console>",
  "next_renewal_at_ms": 1636307057000,
  "event_created_at_ms": 1636306894188,
  "store_app_bundle_id": "<app bundle id defined in the store console>",
  "subscription_status": "AUTO_RENEWING",
  "store_transaction_id": "100000099999999",
  "original_purchased_at": "2021-11-07T17:41:18.000Z",
  "original_purchased_at_ms": 1636306878000,
  "effective_next_renewal_at": "2021-11-07T17:44:17.000Z",
  "purchasely_subscription_id": "subs_XFJFJEBFFU757FUJH",
  "effective_next_renewal_at_ms": 1636307057000,
  "store_original_transaction_id": "10000009999999"
}
```
{% endtab %}

{% tab title="SUBSCRIPTION_RENEWED" %}
```javascript
{
  "plan": "<plan vendorID defined in the Purchasely console>",
  "store": "APPLE_APP_STORE",
  "product": "<product vendorID define in the Purchasely console>",
  "user_id": "<user id you provided through the sdk>",
  "event_name": "SUBSCRIPTION_RENEWED",
  "offer_type": "NONE",
  "api_version": 3,
  "environment": "SANDBOX",
  "purchased_at": "2021-11-07T17:44:17.000Z",
  "store_country": "FR",
  "next_renewal_at": "2021-11-07T17:47:17.000Z",
  "purchased_at_ms": 1636307057000,
  "event_created_at": "2021-11-07T17:43:35.225Z",
  "is_family_shared": false,
  "store_product_id": "<store product id defined in the store console>",
  "next_renewal_at_ms": 1636307237000,
  "event_created_at_ms": 1636307015225,
  "previous_offer_type": "NONE",
  "store_app_bundle_id": "<app bundle id defined in the store console>",
  "subscription_status": "AUTO_RENEWING",
  "store_transaction_id": "100000099999999",
  "original_purchased_at": "2021-11-07T17:41:18.000Z",
  "original_purchased_at_ms": 1636306878000,
  "effective_next_renewal_at": "2021-11-07T17:47:17.000Z",
  "purchasely_subscription_id": "subs_XFJFJEBFFU757FUJH",
  "effective_next_renewal_at_ms": 1636307237000,
  "store_original_transaction_id": "10000009999999"
}
```
{% endtab %}

{% tab title="RENEWAL_DISABLED" %}
```javascript
{
  "plan": "<plan vendorID defined in the Purchasely console>",
  "store": "APPLE_APP_STORE",
  "product": "<product vendorID define in the Purchasely console>",
  "user_id": "<user id you provided through the sdk>",
  "event_name": "RENEWAL_DISABLED",
  "offer_type": "NONE",
  "api_version": 3,
  "environment": "SANDBOX",
  "purchased_at": "2021-11-07T18:22:46.000Z",
  "store_country": "FR",
  "next_renewal_at": "2021-11-07T18:27:46.000Z",
  "purchased_at_ms": 1636309366000,
  "event_created_at": "2021-11-07T18:27:10.018Z",
  "is_family_shared": false,
  "store_product_id": "<store product id defined in the store console>",
  "next_renewal_at_ms": 1636309666000,
  "event_created_at_ms": 1636309630018,
  "previous_offer_type": "NONE",
  "store_app_bundle_id": "<app bundle id defined in the store console>",
  "subscription_status": "AUTO_RENEWING_CANCELED",
  "store_transaction_id": "10000009999999",
  "original_purchased_at": "2021-11-07T17:41:18.000Z",
  "original_purchased_at_ms": 1636306878000,
  "effective_next_renewal_at": "2021-11-07T18:27:46.000Z",
  "purchasely_subscription_id": "subs_XFJFJEBFFU757FUJH",
  "effective_next_renewal_at_ms": 1636309666000,
  "store_original_transaction_id": "10000009999999"
}
```
{% endtab %}
{% endtabs %}

##
