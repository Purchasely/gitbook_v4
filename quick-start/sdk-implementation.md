---
description: The only required steps to get started with Purchasely
---

# SDK Implementation

This is a simplified overview of our SDK implementation, you can find a more detailed one in [SDK configurations](../quick-start-1/sdk-configuration/config-appendices/) section

### Configuration

The `start` method must be called **as soon as possible** to catch every purchase / renewal.

{% tabs %}
{% tab title="Swift" %}
```swift
import Purchasely

func application(_ application: UIApplication, didFinishLaunchingWithOptions launchOptions: [UIApplicationLaunchOptionsKey: Any]?) -> Bool {
    Purchasely.start(withAPIKey: "API_KEY,
                         appUserId: nil,
			 runningMode: .full,
			 eventDelegate: nil,
			 logLevel: .debug) { (success, error) in
		print(success)
        }
	return true
}
```
{% endtab %}

{% tab title="Objective-C" %}
```objectivec
#import <Purchasely/Purchasely-Swift.h>

- (BOOL)application:(UIApplication *)application didFinishLaunchingWithOptions:(NSDictionary *)launchOptions {
	// Override point for customization after application launch.

	[Purchasely startWithAPIKey:@"API_KEY"
			  appUserId:@"USER_ID"
			runningMode: PLYRunningModeFull
	              eventDelegate:nil
			 uiDelegate:nil
	  paywallActionsInterceptor:nil
		           logLevel: LogLevelInfo
			initialized: nil];
	return YES;
}
```
{% endtab %}

{% tab title="Kotlin" %}
```kotlin
import io.purchasely.ext.Purchasely

Purchasely.Builder(applicationContext)
    .apiKey("API_KEY")
    .logLevel(LogLevel.DEBUG) // set to warning or error for release
    .userId("USER_ID")
    .eventListener(eventListener)
    .runningMode(PLYRunningMode.Full)
    .stores(listOf(GoogleStore(), HuaweiStore()))
    .build()

// When you are ready for Purchasely to initialize,
// you must call start() method that will grab configuration and products
// from the selected stores.
Purchasely.start { isConfigured ->
}
```
{% endtab %}

{% tab title="Java" %}
```java
List<Store> stores = new ArrayList();
stores.add(new GoogleStore(), new HuaweiStore());

new Purchasely.Builder(getApplicationContext())
    .apiKey("API_KEY")
    .logLevel(LogLevel.DEBUG) // set to warning or error for release
    .userId("USER_ID")
    .eventListener(this)
    .runningMode(PLYRunningMode.Full.INSTANCE)
    .stores(stores)
    .build();

// When you are ready for Purchasely to initialize,
// you must call start() method that will grab configuration and products
// from the selected stores.
Purchasely.start(isConfigured -> {
    null;
});
```
{% endtab %}

{% tab title="React Native" %}
```javascript
import Purchasely from 'react-native-purchasely';

/**
* @params String apiKey
* @params StringArray stores : may be Google, Amazon and Huawei
* @params String userId
* @params Purchasley.LogLevel logLevel
* @params RunningMode runningMode
**/
Purchasely.startWithAPIKey(
  'API_KEY',
  ['Google'],
  'USER_ID',
  Purchasely.logLevelDebug,
  RunningMode.FULL
);

```
{% endtab %}

{% tab title="Cordova" %}
```javascript
/**
* @params String apiKey
* @params StringArray stores : may be Google, Amazon and Huawei
* @params String userId
* @params Purchasley.LogLevel logLevel
* @params Purchasely.RunningMode runningMode
**/
Purchasely.startWithAPIKey(
    'API_KEY', 
    ['Google'], 
    null, 
    Purchasely.LogLevel.DEBUG, 
    Purchasely.RunningMode.full
);
```
{% endtab %}

{% tab title="Flutter" %}
```dart
/**
* @params String apiKey
* @params StringArray stores : may be Google, Amazon and Huawei
* @params String userId
* @params PLYLogLevel logLevel
* @params PLYRunningMode runningMode
**/
bool configured = await Purchasely.startWithApiKey(
        'API_KEY',
        ['Google'],
        null,
        PLYLogLevel.debug,
        PLYRunningMode.full
    );
    
if (!configured) {
        print('Purchasely SDK not configured');
        return;
}
```
{% endtab %}
{% endtabs %}

The `userID` parameter is optional and allows you to associate the purchase to a user instead of a device.

### Display a placement

Paywalls are displayed by calling a Placement.

A Placement represents a specific location in your user journey inside your app (e.g. Onboarding, Settings, Home page, Article). A placement is linked to a paywall and a single paywall can be used for different Placements. You can create as many Placements as you want, and this is the only thing that ties the app developer to the marketer.&#x20;

Once the placements are defined and called from the app, you can change the displayed paywall remotely without any developer action.



{% hint style="info" %}
You can also preload paywalls [asynchronously](../advanced-features/asynchronous-paywalls.md) using `fetchPresentation` method
{% endhint %}



{% tabs %}
{% tab title="Swift" %}
```swift
let placementId = "ONBOARDING"
paywallCtrl = Purchasely.presentationController(for: placementId, contentId: contentId, loaded: { _, _, _ in
            }, completion: completion)
```
{% endtab %}

{% tab title="Objective-C" %}
```objectivec
UIViewController *paywallCtrl = [Purchasely presentationControllerFor:@"my_placement_id"
						            contentId:@"my_content_id"
                                                            completion:^(enum PLYProductViewControllerResult result, PLYPlan * _Nullable plan) {
}];

```
{% endtab %}

{% tab title="Kotlin" %}
```kotlin
val placementId = "onboarding"
val contentId = "my_content_id" //or null
Purchasely.presentationFragmentForPlacement(placementId, contentId) { result, plan ->
      Log.d("Purchasely", "Result is $result with plan $plan")
}
```
{% endtab %}

{% tab title="Java" %}
```java
String placementId = "onboarding"
String contentId = "my_content_id" //or null
Purchasely.presentationFragmentForPlacement(placementId, contentId);
```
{% endtab %}

{% tab title="React Native" %}
```jsx
await Purchasely.presentPresentationForPlacement({
    placementVendorId: 'onboarding',
    contentId: 'my_content_id',
    isFullscreen: true,
});
```
{% endtab %}

{% tab title="Cordova" %}
```jsx
Purchasely.presentPresentationForPlacement('onboarding');
```
{% endtab %}

{% tab title="Flutter" %}
```jsx
await Purchasely.presentPresentationForPlacement('onboarding');
```
{% endtab %}
{% endtabs %}

### Unlock content

With the method to display a placement, you get the result of the user action on the paywall.

* Cancelled: User did not purchase a plan
* Restored: User restored a previous purchased plan
* Purchased: User purchased a plan which was validated by the store and your webhook

You also have as a second argument the `plan` bought or restored by the user, it is set to `nil` if no purchase was made.

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
Purchasely.presentationFragmentForPlacement(
    placementId = "my_placement_id",
    contentId = "my_content_id",
    callbackLoaded = { isLoaded -> }
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