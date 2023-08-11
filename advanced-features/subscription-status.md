# Subscription status

Purchasely offers a way to retrieve active subscriptions directly from your mobile app without calling your own backend.

This API is built for heavy usage and high availability and can be called on your app startup to check for subscriber status.

{% tabs %}
{% tab title="Swift" %}
```swift
Purchasely.userSubscriptions(success: { (subscriptions) in
	// Subscription object contains the plan purchased and the source it was purchased from (iOS or Android)
	// Calling unsubscribe() will either switch the user to its AppStore settings 
	// or display a procedure on how to unsubscribe on Android
}, failure: { (error) in
	// Display error
})
```
{% endtab %}

{% tab title="Objective-C" %}
```objectivec
[Purchasely userSubscriptionsWithSuccess:^(NSArray<PLYSubscription *> * _Nullable) {
	// Subscription object contains the plan purchased and the source it was purchased from (iOS or Android)
	// Calling unsubscribe() will either switch the user to its AppStore settings 
	// or display a procedure on how to unsubscribe on Android
} failure:^(NSError * _Nullable) {
	// Display error
}];
```
{% endtab %}

{% tab title="Kotlin" %}
```kotlin
Purchasely.userSubscriptions(
    onSuccess = { list ->
        // Subscription object contains the plan purchased and the source it was purchased from (iOS or Android)
        // Calling unsubscribe() will either switch the user to its Google Play settings
        // or display a procedure on how to unsubscribe on iOS
    },
    onError = { throwable ->
        //Display error
    }
)
```
{% endtab %}

{% tab title="Java" %}
```java
Purchasely.userSubscriptions(new SubscriptionsListener() {
    @Override
    public void onSuccess(@NotNull List<PLYSubscriptionData> list) {
        // Subscription object contains the plan purchased and the source it was purchased from (iOS or Android)
        // Calling unsubscribe() will either switch the user to its Google Play settings
        // or display a procedure on how to unsubscribe on iOS
    }

    @Override
    public void onFailure(@NotNull Throwable throwable) {
        //Display error
    }
});
```
{% endtab %}

{% tab title="React Native" %}
```javascript
try {
  const subscriptions = await Purchasely.userSubscriptions();
  console.log(' ==> Subscriptions');
  if (subscriptions[0] !== undefined) {
    console.log(subscriptions[0].plan);
    console.log(subscriptions[0].subscriptionSource);
    console.log(subscriptions[0].nextRenewalDate);
    console.log(subscriptions[0].cancelledDate);
  }
} catch (e) {
  console.log(e);
}
```
{% endtab %}

{% tab title="Cordova" %}
```javascript
Purchasely.userSubscriptions(subscriptions => {
       console.log("Subscriptions " + subscriptions);
		}, (error) => {
		   console.log(error);
		}
);
```
{% endtab %}

{% tab title="Flutter" %}
```dart
try {
  List<PLYSubscription> subscriptions =
      await Purchasely.userSubscriptions();
  print(' ==> Subscriptions');
  if (subscriptions.isNotEmpty) {
    print(sdaubscriptions.first.plan);
    print(subscriptions.first.subscriptionSource);
    print(subscriptions.first.nextRenewalDate);
    print(subscriptions.first.cancelledDate);
  }
} catch (e) {
  print(e);
}
```
{% endtab %}
{% endtabs %}

{% hint style="warning" %}
If you consider using that feature intead of doing the backend integration your self, be aware that this approach is limited.

First of all, this approach can only be used if\
1- Your app doesn't sell consumables\
2- The content / service is blocked by the app\
3- All your subscribers are handled by Purchasely, you don't have a Web payment or Web site where your users could purchase or use your service.\


Then, you should be aware that it is less secured than checking with your server.\
If your device obfuscates the content or block the features based on a server info telling you are subscribed, if this info is altered by a third party you would be offering the content. This is exactly the case of a man in the middle approach.\
The most secured approach remains handling the subscription with your backend and send the right amount of data depending on the status.
{% endhint %}
