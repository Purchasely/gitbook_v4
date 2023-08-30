# Managing entitlements

## Determining which user is concerned by the _**Event**_

When receiving an event on the Webhook, you can parse the attributes `user_id` or `anonymous_user_id` to determine which user is concerned by the **Event**.

The attribute `user_id` will only be populated if a user identifier was set within the app, using the `setUserId` method of Purchasely SDK.

If the user is not signed-in inside the application, you can rely on the property `anonymous_id` which will be automatically populated by the Purchasely Cloud Platform.

## Determining if new entitlements should be set or removed

The **Event** name carries the information about the event signification.

* If the name is `ACTIVATE`, this means that a new purchase has been made or the subscription has renewed. The corresponding user shall be entitled.\\
* If the name is `DEACTIVATE`, this means that the user subscription has expired. Entitlements shall thus be removed immediately.\\

Entitlements can be seen as an on/off switch.

![](https://files.gitbook.com/v0/b/gitbook-x-prod.appspot.com/o/spaces%2FGgUdOzhqa07uh7nB2iZA%2Fuploads%2FulI7ohPKrNWZ0vxipexE%2FFrame%204.png?alt=media\&token=3a534d34-4117-4b37-b107-7447d886adfe)

## Determining which entitlements shall be granted to the user

The **Event** is also carrying the information related to the **Product** and **Plan** purchased by the user. These object are carrying an identifier that you can set yourself in the Purchasely Console (called `vendor_id` see [Configuring Products & Plans](../../quick-start-1/console-configuration/create-your-products/products-and-plans.md)).

Sample payload for a user that has purchased the `PURCHASELY_PLUS_MONTHLY` **Plan** attached to the `PURCHASELY_PLUS` **Product**.

```
{
  "event_name": "ACTIVATE",
  "user_id": "<user id you provided through the sdk>",
  "plan": "PURCHASELY_PLUS_MONTHLY",
  "product": "PUCHASELY_PLUS",
}
```

## To Sum-up

The following events are the ones that your backend **MUST** implement. They are basically a switch to lock and unlock content / service to your users.

You **MUST** return a `HTTP 200` or `HTTP 404` to tell our backend that you successfully handled the message. If you don't we will continue sending you the message following our retry strategy.

<table><thead><tr><th>Event Name</th><th>Description</th><th data-hidden></th></tr></thead><tbody><tr><td>ACTIVATE</td><td>You have to give the user access to the rights of a subscription using our attributes for the specifics.</td><td></td></tr><tr><td>DEACTIVATE</td><td>You have to withdraw the user access to the rights of a subscription using our attributes for the specifics.</td><td></td></tr></tbody></table>

Attached to those events you will only need to look a at 2 attributes to make it work:

* `user_id` or `anonymous_user_id` to identify the user and grant him with the access to the ressource he purchased.
* `plan` to identify precisely what the user has subscribed to. You may also refer to `product` for more details.

Additionally to these two "transactional" events we have added over 20 events for more of a marketing purposes for you to be able to track and understand you subscribers lifecycle. We also added attributes attached to the events to ease integration and give you more context and understanding of your subscription system.

You can find the full list of these events [here ](../../analytics/events/webhook-events/subscription-events.md)and the attributes [there](../../analytics/events/webhook-events/attributes.md).
