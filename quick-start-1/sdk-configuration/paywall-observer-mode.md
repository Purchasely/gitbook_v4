# Paywall observer mode

### When to use it ?

This mode is perfect to use Purchasely data and Purchasely paywalls without changing your existing purchase layer.

You can use this mode if you want to:

* use Purchasely remotely modifiable paywalls
* benefit of our unified data set of [subscription events](../../analytics/events/webhook-events/subscription-events.md) to get a better understanding of your subscribers' lifecycle
* fuel your marketing tools with these events and create [no-code automations](../../advanced-features/deeplinks-and-automations.md)
* all this without changing your legacy transaction processor / backend

### What you can do in this mode ?

You can:

* Display paywalls and modify them remotely
* Create as many paywalls as you need and multiply the touch points
* Receive our [subscription events](../../analytics/events/webhook-events/subscription-events.md) from our [Webhook](../../integrations/webhook-1/) to trigger your automations
* Connect our data with your marketing tools using our integrations
* Analyse your business with our [great charts](../../analytics/dashboards/introduction.md)

Purchasely will provide the controllers (iOS) and fragments (Android) for your paywalls and will inform you about subscription events through our Webhook and integrations.

{% hint style="danger" %}
In this mode Purchasely won't consume your purchases or acknowledge purchases made.

* On **iOS** we won't finish the transaction of your consumables that will **remain in the queue** if you don't do that in your code.
* On **Android** the transactions will be cancelled and **refunded after 3 days**.
{% endhint %}

## General overview

![](<../../.gitbook/assets/Paywall + Observer animated.gif>)

## Implementation

### 1- Start the SDK

The `start` method must be called **as soon as possible** to catch every purchase / renewal.

{% hint style="info" %}
In this mode, Purchasely will be able to display paywalls and observe transactions but will not process them and validate them with Apple and Google
{% endhint %}

The most important argument to set, besides `apiKey` , of course, is the `runningMode` in **paywallObserver**

The `userID` parameter is optional and allows you to associate the purchase to a user instead of a device. You can also [set it up](config-appendices/set-user-id.md) later if you wish to.

{% tabs %}
{% tab title="Swift" %}
```swift
import Purchasely

func application(_ application: UIApplication, didFinishLaunchingWithOptions launchOptions: [UIApplicationLaunchOptionsKey: Any]?) -> Bool {
    Purchasely.start(withAPIKey: "API_KEY,
                         appUserId: nil,
			 runningMode: .paywallObserver,
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
			runningMode: PLYRunningModePaywallObserver
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
    .runningMode(PLYRunningMode.PaywallObserver)
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
    .runningMode(PLYRunningMode.Full.PaywallObserver)
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
  RunningMode.PaywallObserver
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
    Purchasely.RunningMode.paywallObserver
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
        PLYRunningMode.paywallObserver
    );
    
if (!configured) {
        print('Purchasely SDK not configured');
        return;
}
```
{% endtab %}
{% endtabs %}

\
[View implementation details](config-appendices/start-the-sdk.md)



### 2- Set user identifier

We need to know whenever a user is logged in or logged out to:

* Hide the login button in the paywalls
* Check if the user already used a trial and display the correct price

[View implementation details](config-appendices/set-user-id.md)



Use a [PaywallActionInterceptor](../../advanced-features/paywall-action-interceptor.md) to handle login from a paywall and display your login screen



### 3- Configure and present paywalls

To display a paywall, you need to can get a Controller / Fragment from Purchasely.&#x20;

[View implementation details](config-appendices/present-paywalls.md)

\
Then you must use the Paywall Actions Interceptor to perform the purchase triggered from Purchasely's paywalls with your purchase system.

Here is an example where  `MyPurchaseSystem` is your internal subscription management system.

{% tabs %}
{% tab title="Swift" %}
```swift
Purchasely.setPaywallActionsInterceptor { [weak self] (action, parameters, presentationInfos, proceed) in
	switch action {
		// Intercept the tap on purchase to display the terms and condition
		case .purchase:
			// Grab the plan to purchase
			guard let plan = parameters?.plan, let appleProductId = plan.appleProductId else {
				proceed(false)
				return
			}

			MyPurchaseSystem.purchase(appleProductId) { (success, error) {
				// We handle the purchase so we tell Purchasley not to handle it
				proceed(false)				
				if success {
					presentationInfos?.controller?.dismiss(animated: true, completion: nil)
				}
			}
		
		default:
			proceed(true)
	}
}
```
{% endtab %}

{% tab title="Objective-C" %}
```objectivec
[Purchasely setPaywallActionsInterceptor:^(enum PLYPresentationAction action, PLYPresentationActionParameters *parameters, PLYPresentationInfo *presentationInfos, void (^ proceed)(BOOL)) {
        switch (action) {
            // Intercept the tap on purchase to display the terms and condition
            case PLYPresentationActionPurchase:{
                // Grab the plan to purchase
                NSString *appleProductId = parameters.plan.appleProductId;
                
                if (appleProductId == nil) {
                    proceed(NO);
                    return;
                }
                
                [MyPurchaseSystem purchase:appleProductId completion:^(BOOL success, NSError *Error) {
                    // We handle the purchase so we tell Purchasely not to handle it
                    proceed(false);
                    if (success) {
                        [presentationInfos.controller dismissViewControllerAnimated:YES completion:nil];
                    }
                }];

                break;
            }
            default:
                proceed(YES);
                break;
        }
    }];
```
{% endtab %}

{% tab title="Kotlin" %}
```kotlin
Purchasely.setPaywallActionsInterceptor { info, action, parameters, processAction ->
    if (info?.activity == null) return@setPaywallActionsInterceptor

    when(action) {
        PLYPresentationAction.PURCHASE -> {
            Purchasely.plan("PLAN_VENDOR_ID",
                onSuccess = { plan ->
                    MyPurchaseSystem.purchase(plan.store_product_id)
                    processAction(false)
                },
                onError = { throwable ->
                    //display an error
                    processAction(false)
                }
            )
        }
        else -> processAction(true)
    }
}
```
{% endtab %}

{% tab title="Java" %}
```java
Purchasely.setPaywallActionsInterceptor((info, action, parameters, listener) -> {
    switch (action) {
        case PURCHASE:
            Purchasely.plan("PLAN_VENDOR_ID", new PlanListener() {
                @Override
                public void onSuccess(@Nullable PLYPlan plan) {
                    MyPurchaseSystem.purchase(plan.store_product_id);
                    listener.processAction(false);
                }

                @Override
                public void onFailure(@NotNull Throwable throwable) {
                    //display an error
                    listener.processAction(false);
                }
            });                    
            break;
        default:
            listener.processAction(true);
    }
});
```
{% endtab %}

{% tab title="ReactNative" %}
```typescript
Purchasely.setPaywallActionInterceptorCallback((result) => {
    if (result.action === PLYPaywallAction.PURCHASE) {
      try {
        const plan = await Purchasely.planWithIdentifier('PLAN_VENDOR_ID');
        
        //If you want to intercept it, close paywall and display your screen
        Purchasely.closePaywall();
        
        MyPurchaseSystem.purchase(plan.productId)
        
        Purchasely.onProcessAction(false);
      } catch (e) {
        console.log(e);
        Purchasely.onProcessAction(false);
      }
    } else {
      Purchasely.onProcessAction(true);
    }
  });
```
{% endtab %}

{% tab title="Cordova" %}
```java
Purchasely.setPaywallActionInterceptorCallback((result) => {
    if (result.action === Purchasely.PaywallAction.purchase) {
      Purchasely.planWithIdentifier('PLAN_VENDOR_ID', (plan) => {
      	//If you want to intercept it, close paywall and display your screen
        Purchasely.closePaywall();
        
        MyPurchaseSystem.purchase(plan.productId)
        
        Purchasely.onProcessAction(false);
      }, (error) => {
      	Purchasely.onProcessAction(false);
      });
    } else {
      Purchasely.onProcessAction(true);
    }
  });
```
{% endtab %}

{% tab title="Flutter" %}
```dart
Purchasely.setPaywallActionInterceptorCallback(
          (PaywallActionInterceptorResult result) {
    if (result.action == PLYPaywallAction.purchase) {
      try {
        var plan = await Purchasely.planWithIdentifier('PLAN_VENDOR_ID');
        
        //If you want to intercept it, close paywall and display your screen
        Purchasely.closePaywall();
        
        MyPurchaseSystem.purchase(plan.productId)
        
        Purchasely.onProcessAction(false);
      } catch (e) {
        print(e);
        Purchasely.onProcessAction(false);
      }
    } else {
      Purchasely.onProcessAction(true);
    }
 });
```
{% endtab %}
{% endtabs %}



### 4- Sync your purchases (Android only)

In `oberver` and `paywallObserver` modes, when a purchase or a restoration is made with your current flow, call the `synchronize()` method of our SDK to send the receipt to our backend. This allow us to save the receipts on our server to prepare for your migration.

{% tabs %}
{% tab title="Kotlin" %}
```kotlin
Purchasely.synchronize()
```
{% endtab %}

{% tab title="Java" %}
```
Purchasely.synchronize();
```
{% endtab %}

{% tab title="React Native" %}
```javascript
Purchasely.synchronize();
```
{% endtab %}

{% tab title="Cordova" %}
```javascript
Purchasely.synchronize();
```
{% endtab %}
{% endtabs %}



### 5- Configure deeplinks (optional)

Paywalls can be used in many othe ways that can be:

* [Promoted In-App Purchase](../../advanced-features/promoting-your-products/promoting-in-app-purchases.md)
* [Deeplinks](../../advanced-features/deeplinks-and-automations.md)
* Push notifications deeplinks



### 6- Migrate your existing subscriber base (optional)

If your app already has subscribers, you must migrate them to Purchasely to:

* Have complete dashboards including every subscriber acquired in the past
* Handle status using the `userSubscriptions` &#x20;

Follow [this guide](../../faq/migration-guides/migrate-from-an-existing-setup.md) to import your subscribers to Purchasely.
