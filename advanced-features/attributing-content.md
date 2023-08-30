# Associating content

When you purchase an item / subscription, in most cases, you will know what it is meant for without needing additional details. This is the case if you purchase 200 coins, unlock level 3 of your game or subscribe to a service.

In some cases the identifier of the plan purchased is not enough to precisely identify the purchase. This is especially the case when it comes to consumables. As subscriptions and consumables cannot be purchased multiple times their usages are usually unambiguous.

There are many use cases in which you need to identify the content purchased:

* **Pay-per-view app / book store**\
  You will have several consumables that define the different possible prices of each movie on your platform. Several movies will have the same pricing and the plan identifier is not enough to know which movie was purchased as it only dexscribes a price.\
  You will need to identify the program additionally.
* **Fantasy league**\
  If you develop a fantasy league app with multiple league and you can unlock boosters, you will have to know which league the booster must be applied to.
* **Multiple user account app**\
  If your app or game has several profiles / accounts you will want to associate the account to the purchase.
* … in fact each time the plan identifier is not enough to identify what you purchased and unlock the feature, you will need to pass an additional identifier.

### Introducing Content Ids

`contentId` is a feature that let's you attach your own identifier to a purchase. That identifier will be tied to the purchase during the entire process and will be sent to you through the webhook.

On your pay-per-view app you can attribute the movie identifier to dirctly unlock it without having to make any additional call to your backend to associate the purchase once it is confirmed.

### Implementation

As always the implementation is easy as you just need to pass the (optional) parameter when you want to purchase.

It can be with our own paywalls

{% tabs %}
{% tab title="Swift" %}
```swift
let paywallCtrl = Purchasely.presentationController(with: "my_presentation_id",
													contentId: "my_content_id",
													completion: { (result, plan) in
													
})
present(paywallCtrl, animated: true)
```
{% endtab %}

{% tab title="Objective-C" %}
```objectivec
UIViewController *paywallCtrl = [Purchasely presentationControllerWith:@"my_presentation_id"
															 contentId:@"my_content_id"
															completion:^(enum PLYProductViewControllerResult result, PLYPlan * _Nullable plan) {

}];
[self presentViewController:paywallCtrl animated:YES completion:nil];
```
{% endtab %}

{% tab title="Kotlin" %}
```kotlin
Purchasely.presentationView(
    context = context,
    properties = properties
) { result, plan ->
}
```
{% endtab %}

{% tab title="Java" %}
```java
Purchasely.presentationView(context, properties,
new ProductViewResultListener() {
    @Override
    public void onResult(@NotNull PLYProductViewResult result, @Nullable PLYPlan plan) {
   }
});
```
{% endtab %}

{% tab title="React Native" %}
```javascript
await Purchasely.presentPresentationWithIdentifier('my_presentation_id', 'my_content_id');

```
{% endtab %}

{% tab title="Cordova" %}
```javascript
Purchasely.presentPresentationWithIdentifier(
    'my_presentation_id',
    'my_content_id',
    (callback) => {
    },
    (error) => {
    }
);
```
{% endtab %}

{% tab title="Flutter" %}
```dart
await Purchasely.presentPresentationWithIdentifier('my_presentation_id', 'my_content_id');
```
{% endtab %}
{% endtabs %}

or manually

{% tabs %}
{% tab title="Swift" %}
```swift
Purchasely.purchase(plan: plan,	contentId: "my_content_id", success: {
	// Unlock / reload content and display a success / thank you message to user
} failure: { (error) in
	// Display error
}
```
{% endtab %}

{% tab title="Objective-C" %}
```objectivec
[Purchasely purchaseWithPlan:plan
				   contentId:@"my_content_id"
					 success:^{
	// Unlock / reload content and display a success / thank you message to user
} failure:^(NSError * _Nonnull) {
	// Display error
}];
```
{% endtab %}

{% tab title="Kotlin" %}
```kotlin
Purchasely.purchase(this@MainActivity, plan, offer, "content_id", object: PurchaseListener {
    override fun onPurchaseStateChanged(state: State) {
    }
})
```
{% endtab %}

{% tab title="Java" %}
```java
Purchasely.purchase(this, plan, offer, "my_content_id", (PurchaseListener) state -> {
});
```
{% endtab %}

{% tab title="React Native" %}
```javascript
try {
  const plan = await Purchasely.purchaseWithPlanVendorId(
    'PLAN_VENDOR_ID',
    'my_content_id'
  );
  console.log('Purchased ' + plan);
} catch (e) {
  console.log(e);
}
```
{% endtab %}

{% tab title="Cordova" %}
```javascript
Purchasely.purchaseWithPlanVendorId("PLAN_VENDOR_ID", "my_content_id", (plan) => {
	console.log('Purchased ' + plan);
}, (error) => {
	console.log(error);
});
```
{% endtab %}

{% tab title="Flutter" %}
```dart
try {
    Map<dynamic, dynamic> plan =
        await Purchasely.purchaseWithPlanVendorId('PURCHASELY_PLUS_MONTHLY');
    print('Purchased $plan');
} catch (e) {
    print(e);
}
```
{% endtab %}
{% endtabs %}

Once we have checked that the customer purchase is genuine and wasn't already used, we will send you the following event on the Webhook that includes `content_id` :

```javascript
{
  "event_name": "ACTIVATE",
  "api_version": 3,
  "content_id": "my_movie_id",
  "environment": "SANDBOX",
  "event_created_at": "2021-11-22T09:23:38.559Z",
  "event_created_at_ms": 1637573018559,
  "is_family_shared": false,
  "offer_type": "NONE",
  "original_purchased_at": "2021-11-22T09:23:36.000Z",
  "original_purchased_at_ms": 1637573016000,
  "plan": "<plan vendorID defined in the Purchasely console>",
  "product": "<product vendorID define in the Purchasely console>",
  "purchased_at": "2021-11-22T09:23:36.000Z",
  "purchased_at_ms": 1637573016000,
  "purchasely_one_time_purchase_id": "otp_XXXXXXXFFFFFFFFF",
  "store": "APPLE_APP_STORE",
  "store_app_bundle_id": "<app bundle id defined in the store console>",
  "store_country": "US",
  "store_original_transaction_id": "100000099999999",
  "store_product_id": "<store product id defined in the store console>",
  "store_transaction_id": "100000099999999",
  "user_id": "<user id you provided through the sdk>"
}
```

### Security concerns

While you receive the `contentId`, you shouldn't blindly unlock the content and attribute the purchase.\
\
Some (smart) users could rewrite the request that leaves the phone and set a content\_id for an expensive item after purchasing a cheaper one.

You should check that the `content_id` and the plan `vendor_id` match what you have in your database. If not raise an exception in your backend and contact the user.
