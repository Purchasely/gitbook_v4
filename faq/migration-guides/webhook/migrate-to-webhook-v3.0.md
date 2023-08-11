# Migrate to Webhook v3.0

We have added new events to the webhook to bring you a deep understanding of your customers behavior and help you trigger powerful automations.

We have separated transactional and marketing events to make access control management as simple as a switch button. Additionally over 20 events are now available to you to track and understand you subscribers lifecycle. We also changed the attributes attached to the events to ease integration and give you more context and understanding of your subscription system.

## 1. Migrate transactional events

Transactional events are declaring a subscription start and stop. You shall be using them to store the subscriber state in the database and grant/revoke access to contents or features of your app.

Prior to this version you were using 3 events to control the access:

* `PURCHASE_VALIDATED` used to grant access
* `SUBSCRIPTION_RENEWED` used to grant access (after a pause period) or confirm (renewal)
* `SUBSCRIPTION_EXPIRED` used to revoke access

They are replaced by 2 simple events:

* `ACTIVATE` use to grant access immediately (will be triggered at each renewal)
* `DEACTIVATE` use to revoke access immediately

![](<../../../.gitbook/assets/timeline (1).png>)

`PURCHASE_VALIDATED` _and_ `SUBSCRIPTION_EXPIRED` will no longer be triggered. `SUBSCRIPTION_RENEWED` **must** only be used for marketing purposes.

If you want to keep track of the start and end of a subscription (e.g. for your analytics or CRM) you can use `SUBSCRIPTION_STARTED` _and_ `SUBSCRIPTION_TERMINATED`. Once again, you must not use them to handle access control as there might be other subscription terminated events such as `SUBSCRIPTION_REFUNDED_REVOKED`.

Learn more and find the full list of events [here](../../../analytics/events/webhook-events/subscription-events.md).

## 2. Attributes

Event attributes give you deep context about the subscription such as plan, product, store, country, currency...

Prior to this version we provided a structure with nested attributes like:

```javascript
{
  "name": "PURCHASE_VALIDATED",
  "user": {
    "vendor_id": "<user id you provided through the sdk>"
  },
  "properties": {
    "app": {
      "platform": "ANDROID",
      "package_id": "<app bundle id defined in the store console>"
    },
    "store": "GOOGLE_PLAY_STORE",
    "product": {
      "plan": {
        "type": "RENEWING_SUBSCRIPTION",
        "vendor_id": "<plan vendorID defined in the Purchasely console>",
        "store_product_id": "<store product id defined in the store console>"
      },
      "vendor_id": "<product vendorID define in the Purchasely console>"
    },
    "expires_at": "2021-05-21T12:58:55.097Z",
    "period_type": "NORMAL",
    "purchase_id": "subs_XFJFJEBFFU757FUJH",
    "purchased_at": "2021-05-21T12:51:59.066Z",
    "original_transaction_id": "GPA.100000099999999"
  },
  "api_version": 2,
  "received_at": "2021-05-21T12:52:03.968Z"
```

This structure has been flattened to ease integration and match what we sent to third parties tools (Braze, Amplitude...).

```javascript
{
  "ab_test_variant": "<variant ID defined in the Purchasely console>",
  "ab_test": "<placement ID defined in the Purchasely console>",
  "api_version": 3,
  "content_id": "<content id you provided through the sdk>",
  "effective_next_renewal_at_ms": 1649065399733,
  "effective_next_renewal_at": "2022-04-04T09:43:19.733Z",
  "environment": "SANDBOX",
  "event_created_at_ms": 1649064988442,
  "event_created_at": "2022-04-04T09:36:28.442Z",
  "event_name": "ACTIVATE",
  "is_family_shared": false,
  "next_renewal_at_ms": 1649065399733,
  "next_renewal_at": "2022-04-04T09:43:19.733Z",
  "offer_type": "NONE",
  "original_purchased_at_ms": 1649064982355,
  "original_purchased_at": "2022-04-04T09:36:22.355Z",
  "placement": "<placement ID defined in the Purchasely console>",
  "plan": "<plan vendorID defined in the Purchasely console>",
  "presentation": "<presentation ID defined in the Purchasely console>",
  "product": "<product vendorID defined in the Purchasely console>",
  "purchase_type": "RENEWING_SUBSCRIPTION",
  "purchased_at_ms": 1649064982355,
  "purchased_at": "2022-04-04T09:36:22.355Z",
  "purchasely_subscription_id": "subs_XXXXXXXFFFFFFFFF",
  "store_app_bundle_id": "<app bundle id defined in the store console>",
  "store_country": "FR",
  "store_original_transaction_id": "0000000000001111",
  "store_product_id": "<store product id defined in the store console>",
  "store_transaction_id": "0000000000002222",
  "store": "APPLE_APP_STORE",
  "subscription_status": "AUTO_RENEWING",
  "user_id": "<user id you provided through the sdk>"
}
```

Learn more and find the full list of attributes [here](../../../analytics/events/webhook-events/attributes.md).



Here is the mapping between old and new attributes:

| Old property                                                                                                | New property                                                                                               |
| ----------------------------------------------------------------------------------------------------------- | ---------------------------------------------------------------------------------------------------------- |
| api\_version                                                                                                | api\_version                                                                                               |
| name                                                                                                        | event\_name                                                                                                |
| properties.app.package\_id                                                                                  | store\_app\_bundle\_id                                                                                     |
| properties.app.platform (ANDROID/IOS)                                                                       | -                                                                                                          |
| properties.content\_id                                                                                      | content\_id                                                                                                |
| properties.<mark style="color:red;">**`expires_at`**</mark>                                                 | <mark style="color:green;">**`effective_next_renewal_at`**</mark> / effective\_next\_renewal\_at\_ms       |
| properties.original\_purchased\_at                                                                          | original\_purchased\_at / original\_purchased\_at\_ms                                                      |
| properties.original\_transaction\_id                                                                        | store\_original\_transaction\_id                                                                           |
| properties.period\_type (<mark style="color:red;">**`NORMAL`**</mark>/FREE\_TRIAL/INTRO\_OFFER/PROMO\_CODE) | properties.offer\_type (<mark style="color:green;">**`NONE`**</mark>/FREE\_TRIAL/INTRO\_OFFER/PROMO\_CODE) |
| properties.previous\_period\_type                                                                           | properties.previous\_offer\_type                                                                           |
| properties.product.plan.store\_product\_id                                                                  | store\_product\_id                                                                                         |
| properties.product.plan.type                                                                                | purchase\_type                                                                                             |
| properties.product.plan.vendor\_id                                                                          | plan                                                                                                       |
| properties.product.vendor\_id                                                                               | product                                                                                                    |
| properties.purchase\_id                                                                                     | purchasely\_one\_time\_purchase\_id / purchasely\_subscription\_id                                         |
| properties.purchased\_at                                                                                    | purchased\_at / purchased\_at\_ms                                                                          |
| properties.store                                                                                            | store (AMAZON\_APP\_STORE/APPLE\_APP\_STORE/GOOGLE\_PLAY\_STORE/HUAWEI\_APP\_GALLERY)                      |
| received\_at                                                                                                | event\_created\_at / event\_created\_at\_ms                                                                |
| user.vendor\_id                                                                                             | user\_id                                                                                                   |
| user.anonymous\_id                                                                                          | anonymous\_user\_id                                                                                        |

⚠️ Be cautious,  <mark style="color:red;">**`properties.expires_at`**</mark> has been renamed to <mark style="color:green;">**`effective_next_renewal_at`**</mark>. DO NOT use the new `next_renewal_at` field which has a totally different meanings (see the [full list of attributes](../../../analytics/events/webhook-events/attributes.md) for more details) ⚠️



If you have any question reach us on our [help center](https://help.purchasely.com/en/) .
