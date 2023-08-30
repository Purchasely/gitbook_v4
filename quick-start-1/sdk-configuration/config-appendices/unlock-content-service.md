# Unlock content / service

### On paywall displayed

When you display a paywall with [Purchasely.presentation](https://docs.purchasely.com/quick-start/sdk-configuration/config-appendices/present-paywalls) you have a closure for the **result** of user action `PLYProductViewControllerResult` with three possible values

* Purchased
* Restored
* Cancelled\\

You also have as a second argument the `plan` bought or restored by the user, it is set to `nil` if no purchase was made.\
This is the preferred way to get notified when a purchase or restoration was made from a Purchasely paywall.

{% tabs %}
{% tab title="Swift" %}
```swift
let paywallCtrl = Purchasely.presentationController(
   for: "my_placement_id",
   contentId: "my_content_id",
   completion: { (result, plan) in
	switch result {
                case .purchased:
                    print("User purchased: \(plan?.name)")
                    break
                case .restored:
                    print("User restored: \(plan?.name)")
                    break
                case .cancelled:
                    break
                @unknown default:
                    break
	}												
})
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
Purchasely.presentationViewForPlacement(
    context = this,
    placementId = "my_placement_id",
    contentId = "my_content_id",
    onClose = { },
    onLoaded  = { isLoaded -> }
) { result, plan ->
    when(result) {
        PLYProductViewResult.PURCHASED -> Log.d("Purchasely", "User purchased ${plan?.name}")
        PLYProductViewResult.CANCELLED -> Log.d("Purchasely", "User cancelled purchased")
        PLYProductViewResult.RESTORED -> Log.d("Purchasely", "User restored ${plan?.name}")
    }
}
```
{% endtab %}

{% tab title="Java" %}
```java
Purchasely.presentationFragmentForPlacement(
        "my_placement_id",
        "my_content_id",
        isLoaded -> null,
        onClose,
        (result, plan) -> {
            switch (result) {
                case PURCHASED:
                    Log.d("Purchasely", "User purchased" + plan.getName());
                    break;
                case RESTORED:
                    Log.d("Purchasely", "User restored" + plan.getName());
                    break;
                case CANCELLED:
                    Log.d("Purchasely", "User cancelled purchase");
                    break;
            }
        }
);
```
{% endtab %}

{% tab title="React Native" %}
```javascript
try {
  const result = await Purchasely.presentPresentationForPlacement({
    placementVendorId: 'onboarding',
    isFullscreen: true,
  });

  switch (result.result) {
    case ProductResult.PRODUCT_RESULT_PURCHASED:
    case ProductResult.PRODUCT_RESULT_RESTORED:
      if (result.plan != null) {
        console.log('User purchased ' + result.plan.name);
      }
      break;
    case ProductResult.PRODUCT_RESULT_CANCELLED:
      break;
  }
} catch (e) {
  console.error(e);
}
```
{% endtab %}

{% tab title="Cordova" %}
```javascript
Purchasely.presentPresentationForPlacement(
	'onboarding', //placementId
	null, //contentId
	true, //fullscreen
	(callback) => {
		if(callback.result == Purchasely.PurchaseResult.PURCHASED) {
			console.log("User purchased " + callback.plan.name);
		} else if(callback.result == Purchasely.PurchaseResult.RESTORED) {
			console.log("User restored " + callback.plan.name);
		} else if(callback.result == Purchasely.PurchaseResult.CANCELLED) {
			console.log("User cancelled purchased");
		}
	},
	(error) => {
		console.log("Error with purchase : " + error);
	}
);
```
{% endtab %}

{% tab title="Flutter" %}
```dart
try {
  var result = await Purchasely.presentPresentationForPlacement(
      "onboarding",
      isFullscreen: true);

  switch (result.result) {
    case PLYPurchaseResult.purchased:
      print('User purchased: ${result.plan?.name}');
      break;
    case PLYPurchaseResult.restored:
      print('User restored: ${result.plan?.name}');
      break;
    case PLYPurchaseResult.cancelled:
      print("User cancelled purchased");
      break;
  }
} catch (e) {
  print(e);
}
```
{% endtab %}
{% endtabs %}

### Anywhere in your application

When a purchase or restoration is made, you can listen to our notification.\
This is the method to use in parts of your application where you wish to unlock some features after a purchase was made but you should only use it to **unlock** content, not to notify your server of a purchase or check the current state of user subscription.\
\
Once the purchase is made to Apple Servers, registered in our systems, Purchasely sends a local `Notification` in the `NotificationCenter`. You can use it to unlock the content or refresh it.

You can catch it like this

{% tabs %}
{% tab title="Swift" %}
```swift
 NotificationCenter.default.addObserver(self, selector: #selector(reloadContent(_:)), name: .ply_purchasedSubscription, object: nil)
```
{% endtab %}

{% tab title="Objective-C" %}
```objectivec
[[NSNotificationCenter defaultCenter] addObserver:self
											 selector:@selector(reloadContent)
												 name: @"ply_purchasedSubscription"
											   object:nil];
```
{% endtab %}

{% tab title="Kotlin" %}
```kotlin
Purchasely.livePurchase().observe(this) { plan: PLYPlan? -> 
    reloadContent(plan) 
}

Purchasely.purchaseListener = purchaseListener
```
{% endtab %}

{% tab title="Java" %}
```java
// You can use LiveData
Purchasely.livePurchase().observe(this, (plan) -> {
    reloadContent(plan);
});

// Or PurchaseListener
Purchasely.setPurchaseListener(purchaseListener);
```
{% endtab %}

{% tab title="ReactNative" %}
```javascript
Purchasely.addPurchasedListener(() => {
    // User has successfully purchased a product, reload content
});
```
{% endtab %}

{% tab title="Cordova" %}
```javascript
Purchasely.purchasedSubscription(() => {
	// User has successfully purchased a product, reload content
});
```
{% endtab %}

{% tab title="Flutter" %}
```dart
Purchasely.listenToPurchases(() {
    print('User has purchased a product');
});

//when no longer needed, remove listener
Purchasely.stopListeningToPurchases();
```
{% endtab %}
{% endtabs %}

And use it like that

{% tabs %}
{% tab title="Swift" %}
```swift
 @objc func reloadContent(_ notification: Notification) {
     // Reload the content
 }
```
{% endtab %}

{% tab title="Objective-C" %}
```objectivec
- (void)reloadContent: (NSNotification *)aNotification {
    // Reload the content
}
```
{% endtab %}

{% tab title="Kotlin" %}
```kotlin
private fun reloadContent(plan: PLYPlan?) {
    //Reload the content
}

//Instance of PurchaseListener
private val purchaseListener: PurchaseListener = object : PurchaseListener {
    override fun onPurchaseStateChanged(@NotNull state: State) {
        if (state is State.PurchaseComplete) {
            reloadContent(state.plan)
        } else if (state is State.RestorationComplete) {
            reloadContent(state.plan)
        }
    }
}
```
{% endtab %}

{% tab title="Java" %}
```java
private void reloadContent(@Nullable PLYPlan plan) {
    //Reload the content
}

//Instance of PurchaseListener
private PurchaseListener purchaseListener = new PurchaseListener() {
    @Override
    public void onPurchaseStateChanged(@NotNull State state) {
        if(state instanceof State.PurchaseComplete) {
            PLYPlan plan = ((State.PurchaseComplete) state).getPlan();
            reloadContent(plan);
        } else if(state instanceof State.RestorationComplete) {
            PLYPlan plan = ((State.RestorationComplete) state).getPlan();
            reloadContent(plan);
        }
    }
};
```
{% endtab %}
{% endtabs %}

For example, this can be done in every controller that displays premium content. That way you won't have to reload the content each time the controller is displayed unless a payment was made

##
