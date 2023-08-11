---
description: Guide to migrate your existing subscriptions to Purchasely.
---

# Migrate to Purchasely

## Quick overview of the migration process

A quick overview of the migration process to help you understand why we are doing things when we'll go deeper in the explanations:

1. **Configure your app/products/plans in the Purchasely console**: without this data, we won't be able to do anything
2. **Send us every new subscription created on you side with a call on our API**: this step ensure we'll know everything about the subscriptions created from this point in time (needed for the users still using old versions of your app)
3. **Extract your existing subscriptions into a CSV**: this step ensure we'll known everything about the subscriptions created in the past
4. **Release your new app**: at this point, our backend will know every past/present/future subscriptions and you'll be able to release your app, everything will work smoothly.

## Migration process in details

### 1. Configure your app/products/plans in the Purchasely console

Everything is explained here: [https://docs.purchasely.com/quick-start/console-configuration](https://docs.purchasely.com/quick-start/console-configuration)

If you have a lot of products / plans that you want to migrate, you can fill the following CSV file and send it to support@purchasely.com. We will import it for you.

\
The following values for the field `Type` are accepted

* RENEWING\_SUBSCRIPTION
* NON\_RENEWING\_SUBSCRIPTION
* CONSUMABLE
* NON\_CONSUMABLE

The following values for the field Periodicity are accepted (only for renewing and non renewing subscription)

* P1W
* P2W
* P1M
* P2M
* P3M
* P6M
* P1Y

{% file src="../../.gitbook/assets/plans-migration.csv" %}

### 2. Send us every new subscription created on you side with a call on our API

{% swagger baseUrl="https://s2s.purchasely.io" path="/receipts" method="post" summary="Post receipt" %}
{% swagger-description %}
This endpoint allows you to update Purchasely with new purchases made by a previous version of your app.
{% endswagger-description %}

{% swagger-parameter in="header" name="X-PLATFORM-TYPE" type="string" required="false" %}
The subscription platform (

`APP_STORE`

, 

`PLAY_STORE`

, 

`APPGALLERY`

)
{% endswagger-parameter %}

{% swagger-parameter in="header" name="X-API-KEY" type="string" required="false" %}
API Key associated to your application (available in Purchasely console)
{% endswagger-parameter %}

{% swagger-parameter in="body" name="intro_cycles" type="integer" %}
number of periods the intro price is available: for a double 4-weeks intro pricing, the intro_cycles would be 

`2`
{% endswagger-parameter %}

{% swagger-parameter in="body" name="intro_duration" type="integer" %}
number of periods the intro price is available: for a double 4-weeks intro pricing, the intro_duration would be 

`4`
{% endswagger-parameter %}

{% swagger-parameter in="body" name="intro_period" type="string" %}
unit of a subscription's intro period (

`day`

, 

`week`

, 

`month`

, 

`year`

): for a double 4-weeks intro pricing, the intro_period would be 

`week`
{% endswagger-parameter %}

{% swagger-parameter in="body" name="duration" type="integer" %}
number of periods before renewing: for a subscription renewing every 3 months, the duration would be 

`3`
{% endswagger-parameter %}

{% swagger-parameter in="body" name="period" type="string" %}
unit of a subscription's duration (

`day`

, 

`week`

, 

`month`

, 

`year`

): for a subscription renewing every 3 months, the period would be 

`month`
{% endswagger-parameter %}

{% swagger-parameter in="body" name="intro_amount_cents" type="integer" %}
subscriptions's intro price in cents ($12.35 => 1235, $12.3 => 1230, $12 => 1200)
{% endswagger-parameter %}

{% swagger-parameter in="body" name="quantity" type="integer" %}
number of products purchased (always 1 for subscriptions)
{% endswagger-parameter %}

{% swagger-parameter in="body" name="currency" type="string" %}
ISO 4217 format (

`USD`

, 

`EUR`

, ...)
{% endswagger-parameter %}

{% swagger-parameter in="body" name="amount_cents" type="integer" %}
subscription's price in cents ($12.35 => 1235, $12.3 => 1230, $12 => 1200)
{% endswagger-parameter %}

{% swagger-parameter in="body" name="store_product_id" type="string" %}
product id as defined in your store console
{% endswagger-parameter %}

{% swagger-parameter in="body" name="user_id" type="string" %}
id of your user as defined in your backend
{% endswagger-parameter %}

{% swagger-parameter in="body" name="purchase_token" type="string" %}
**[GOOGLE PLAY ONLY]**

 purchase token given by the SDK during the purchase, used to request Play Store servers
{% endswagger-parameter %}

{% swagger-parameter in="body" name="receipt_data" type="string" %}
**[APP STORE ONLY]**

 Base64 encoded receipt data given by the SDK during the purchase, used to request App Store servers
{% endswagger-parameter %}

{% swagger-parameter in="header" name="Content-Type" type="String" required="false" %}
application/json
{% endswagger-parameter %}

{% swagger-response status="200" description="Cake successfully retrieved." %}
```
{ "id": "transaction-id" }
```
{% endswagger-response %}

{% swagger-response status="403" description="(X-API-KEY, X-PLATFORM-TYPE) doesn't match any platform" %}
```
{ "errors": ["unknown api_key"] }
```
{% endswagger-response %}

{% swagger-response status="422" description="Returned when a parameter is invalid" %}
```
{ "errors": ["missing mandatory property \"purchase_token\""] }
```
{% endswagger-response %}
{% endswagger %}

{% hint style="info" %}
&#x20; The not-mandatory-fields are highly recommended: we use them to calculate the LTV (life-time value) of your users and track your revenues.
{% endhint %}

#### 2.1. Body parameters exemple

{% tabs %}
{% tab title="Apple App Store" %}
```javascript
{
  // Mandatory
  "receipt_data": "abcdFEbsbs",
  "user_id": "1234",
  
  // Country - highly recommanded
  "country": "FR",
  
  // Pricings
  "store_product_id": "com.foo.bar",
  "amount_cents": 1235,
  "currency": "EUR",
  "intro_amount_cents": 0,
  "intro_cycles": 2,
  "intro_duration": 4,
  "intro_period": "week"
}
```
{% endtab %}

{% tab title="Google Play Store" %}
```javascript
{
  // Mandatory
  "purchase_token": "abcdFEbsbs",
  "store_product_id": "com.foo.bar",
  "user_id": "1234",
  
  // Pricing
  "quantity": 1
}
```
{% endtab %}
{% endtabs %}

#### 2.2. Requests example

{% tabs %}
{% tab title="cURL" %}
```bash
curl \
  --request POST \
  -i \
  -H "Content-Type: application/json" \
  -H "X-API-KEY:00000000-1111-2222-3333-444444444444" \
  -H "X-PLATFORM-TYPE:PLAY_STORE" \
  --data '{"purchase_token":"aaaNNNcccDDDeeeFFF","user_id":"1234567890","store_product_id":"com.my.product","quantity":1}' \
  https://s2s.purchasely.io/receipts
```
{% endtab %}

{% tab title="ruby" %}
```ruby
require 'net/http'
require 'json'

# Url
url = URI('https://s2s.purchasely.io/receipts')
request = Net::HTTP::Post.new(url)

# Headers
request['Content-Type'] = 'application/json'
request['X-API-KEY'] = '00000000-1111-2222-3333-444444444444'
request['X-PLATFORM-TYPE'] = 'PLAY_STORE'

# Payload
payload = {
  purchase_token: "abcdeFGHIJklmnoPQRSTuvwxyZ",
  user_id: "1234567890",
  store_product_id: "product.monthly",
  quantity: 1
}
request.body = payload.to_json

# Send request
http = Net::HTTP.new(url.host, url.port)
http.use_ssl = true
http.verify_mode = OpenSSL::SSL::VERIFY_NONE
response = http.request(request)

# Response
case response.code
when '200'
  transaction_id = JSON.parse(response.body)['id']
when '403', '422'
  errors = JSON.parse(response.body)['errors']
end
```
{% endtab %}
{% endtabs %}

### 3. Extract your existing subscriptions into a CSV

It's time to extract all you existing subscriptions (active and expired)!

As before, we'll need different fields, depending of the platform (same rules apply for mandatory/recommended fields).

When extracted, send us these files and we'll take care of importing them.

#### 3.1. App Store

Mandatory fields: user\__id, receipt\_data_

{% code title="example-apple.csv" %}
```
user_id;receipt_data
1234;abcdFEbsbs
```
{% endcode %}

Or if you have the information you can also provide more information

{% code title="example-apple.csv" %}
```
user_id;receipt_data;store_product_id;amount_cents;currency;intro_amount_cents;intro_cycles;intro_duration;intro_period;country
1234;abcdFEbsbs;com.foo.bar;1235;EUR;0;2;4;week;FR
```
{% endcode %}

{% file src="../../.gitbook/assets/purchasely-appstore-migration (3).csv" %}

#### 3.2. Play Store

Mandatory fields: user\__id, purchase\_token, store\_product\_Id_

{% code title="example-google.csv" %}
```
user_id;purchase_token;store_product_id;quantity
1234;abcdFEbsbs;com.foo.bar;1
```
{% endcode %}

{% file src="../../.gitbook/assets/purchasely-playstore-migration (2).csv" %}

### 4. Release your new app

When everything is ok on our side, we'll send you a confirmation that you can release your apps.
