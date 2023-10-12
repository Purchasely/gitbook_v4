# Deeplinks automations

Purchasely supports the use of Deeplinks to trigger different actions to improve conversion, retention and upsell. You can send a Push or an email with that deeplink and Purchasely will open the requested presentation or page for you.

Here are the actions Purchasely supports:

* Display a **product page** (paywall)
* Display the user **subscriptions**
* Display the cancellation **survey**
* Update credit card (Deeplink to App Store)

### Integration

To integrate these automations you need 2 things:

* Pass the deeplink to Purchasley when it is received by the application
* Allow Purchasely to display content over your interface

#### Pass the Deeplink to Purchasely

The first thing you need to do is to pass the deeplink URL to Purchasely when your app receives it:

{% tabs %}
{% tab title="Swift" %}
```swift
// ---------------------------------------------------
// If you are **NOT** using SceneDelegate
// ---------------------------------------------------

// AppDelegate.swift

import Purchasely

func application(_ application: UIApplication, open url: URL, sourceApplication: String?, annotation: Any) -> Bool {
	// You can chain calls to multiple handler using a OR
	return Purchasely.isDeeplinkHandled(deeplink: url) 
}

// ---------------------------------------------------
// If you are using SceneDelegate
// ---------------------------------------------------

// SceneDelegate.swift

import Purchasely

func scene(_ scene: UIScene, willConnectTo session: UISceneSession, options connectionOptions: UIScene.ConnectionOptions) {

	// …

	if let url = connectionOptions.urlContexts.first?.url {
		_ = Purchasely.isDeeplinkHandled(deeplink: url)
	}
}

func scene(_ scene: UIScene, openURLContexts URLContexts: Set<UIOpenURLContext>) {
	if let url = URLContexts.first?.url {
		_ = Purchasely.isDeeplinkHandled(deeplink: url)
	}
}

```
{% endtab %}

{% tab title="Objective-C" %}
```objectivec
// ---------------------------------------------------
// If you are **NOT** using SceneDelegate
// ---------------------------------------------------

// AppDelegate.m

#import <Purchasely/Purchasely-Swift.h>

- (BOOL)application:(UIApplication *)app openURL:(NSURL *)url options:(NSDictionary<UIApplicationOpenURLOptionsKey,id> *)options {
	// You can chain calls to multiple handler using a OR
	return [Purchasely isDeeplinkHandled:url];
}

// ---------------------------------------------------
// If you are using SceneDelegate
// ---------------------------------------------------

// SceneDelegate.m

#import <Purchasely/Purchasely-Swift.h>

- (void)scene:(UIScene *)scene willConnectToSession:(UISceneSession *)session options:(UISceneConnectionOptions *)connectionOptions {

	// …

	NSURL *url = connectionOptions.URLContexts.allObjects.firstObject.URL;
	if (url != nil) {
		[Purchasely isDeeplinkHandled:url];
	}
}

- (void)scene:(UIScene *)scene openURLContexts:(NSSet<UIOpenURLContext *> *)URLContexts {
	NSURL *url = URLContexts.allObjects.firstObject.URL;
	if (url != nil) {
		[Purchasely isDeeplinkHandled:url];
	}
}
```
{% endtab %}

{% tab title="Kotlin" %}
```kotlin
class MyActivity : FragmentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        
        //retrieve intent data to get deeplink that opened your activity
        val data = intent.data
        if(data != null) {
            //Purchasely sdk will return true if it handles the deeplink
            val isHandledByPurchasely = Purchasely.isDeeplinkHandled(data)
        }
    }    

}
```
{% endtab %}

{% tab title="Java" %}
```java
public class MyActivity extends FragmentActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //retrieve intent data to get deeplink that opened your activity
        Uri data = getIntent().getData();
        if(data != null) {
            //Purchasely sdk will return true if it handles the deeplink
            boolean isHandledByPurchasely = Purchasely.isDeeplinkHandled(data);
        }
    }
}
```
{% endtab %}

{% tab title="React Native" %}
```typescript
Purchasely.isDeeplinkHandled('app://ply/presentations/')
          .then((value) => console.log('Deeplink handled by Purchasely ? ' + value));
```
{% endtab %}

{% tab title="Cordova" %}
```javascript
// If you grab the deeplink inside your Cordova code you can call
Purchasely.handle("app://ply/presentations/", (handled) => {
	console.log("Was deeplink handled by Purchasely? " + handled);
});
```
{% endtab %}

{% tab title="Flutter" %}
```dart
Purchasely.handle('app://ply/presentations/')
          .then((value) => print('Deeplink handled by Purchasely ? $value'));
```
{% endtab %}
{% endtabs %}

#### Allow display

Your app might have a launch routine that requires to be fulfilled before another screen can be displayed. It can be splash screen, on boarding, login …

The display of Purchasely deeplinks is deferred until you authorize it. Once your app is ready, notify Purchasely.

{% tabs %}
{% tab title="Swift" %}
```swift
Purchasely.readyToOpenDeeplink(true)
```
{% endtab %}

{% tab title="Objective-C" %}
```objectivec
[Purchasely readyToOpenDeeplink: YES];
```
{% endtab %}

{% tab title="Kotlin" %}
```kotlin
Purchasely.readyToOpenDeeplink = true
```
{% endtab %}

{% tab title="Java" %}
```java
Purchasely.setReadyToOpenDeeplink(true);
```
{% endtab %}

{% tab title="React Native" %}
```javascript
Purchasely.readyToOpenDeeplink(true);
```
{% endtab %}

{% tab title="Cordova" %}
```javascript
Purchasely.isReadyToPurchase(true);
```
{% endtab %}

{% tab title="Flutter" %}
```
Purchasely.readyToOpenDeeplink(true);
```
{% endtab %}
{% endtabs %}

#### Get presentation result

When a deeplink is called, as you don't instanciate the paywall yourself, no closure will be called to tell you what happened.\
You can retrieve the result of the user action in a paywall opened with a deeplink by setting a `DefaultPresentationResultHandler`.

{% tabs %}
{% tab title="Swift" %}
```swift
Purchasely.setDefaultPresentationResultHandler { [weak self](result, plan) in
    switch result {
        case .purchased:
            break
        case .restored:
            break
        case .cancelled:
            break
        @unknown default:
				    break
    }
}
```
{% endtab %}

{% tab title="Objective-C" %}
```objectivec
[Purchasely setDefaultPresentationResultHandler:^(enum PLYProductViewControllerResult result, PLYPlan * _Nullable plan) {
	switch (result) {
		case PLYProductViewControllerResultPurchased:
			break;
		case PLYProductViewControllerResultRestored:
			break;
		case PLYProductViewControllerResultCancelled:
			break;
		default:
			break;
	}
}];
```
{% endtab %}

{% tab title="Kotlin" %}
```kotlin
Purchasely.setDefaultPresentationResultHandler { result, plan ->
    /* You can set a callback to know when your user purchased a product */
    when(result) {
        PLYProductViewResult.PURCHASED -> Log.d("Purchasely", "Purchased $plan")
        PLYProductViewResult.CANCELLED ->  Log.d("Purchasely", "Cancelled purchase of $plan")
        PLYProductViewResult.RESTORED -> Log.d("Purchasely", "Restored $plan")
    }
}
```
{% endtab %}

{% tab title="Java" %}
```java
Purchasely.setDefaultPresentationResultHandler(new ProductViewResultListener() {
    @Override
    public void onResult(@NotNull PLYProductViewResult result, @org.jetbrains.annotations.Nullable PLYPlan plan) {
        /* You can set a callback to know when your user purchased a product */
        switch (result) {
            case PURCHASED:
                break;
            case CANCELLED:
                break;
            case RESTORED:
                break;
        }
    }
});
```
{% endtab %}

{% tab title="React Native" %}
```javascript
Purchasely.setDefaultPresentationResultCallback((result) => {
  console.log('Presentation View Result : ' + result.result);

  if (result.plan != null) {
    console.log('Plan Vendor ID : ' + result.plan.vendorId);
    console.log('Plan Name : ' + result.plan.name);
  }
});
```
{% endtab %}

{% tab title="Cordova" %}
```javascript
Purchasely.setDefaultPresentationResultHandler((result) => {
	console.log("Presentation View Result: " + result.result);

	if (result.plan != null) {
		console.log("Plan Vendor ID: " + result.plan.vendorId);
		console.log("Plan Name:  " + result.plan.name);
	}
});
```
{% endtab %}

{% tab title="Flutter" %}
```dart
Purchasely.setDefaultPresentationResultCallback(
          (PresentPresentationResult value) {
  print('Presentation Result : ' + value.result.toString());

  if (value.plan != null) {
    //User bought a plan
  }
});
```
{% endtab %}
{% endtabs %}

{% hint style="info" %}
The callback `PLYProductViewControllerResult`(iOS) / `ProductViewResultListener` (Android) is optional, you can set to null if you do not need it. You can override it when you display a presentation directly.
{% endhint %}

### Supported deeplinks

| Product                                                                                                                                                                                                                          |
| -------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------- |
| You can open a product presentation directly to the user with the default presentation or a specific one used for a specific purpose / promotion.                                                                                |
| ⚠️ This kind of push **requires users opt-in** (see [App Store Review Guidelines - 4.5.4](https://developer.apple.com/app-store/review/guidelines/#apple-sites-and-services)).                                                   |
| <p><code>app_scheme://ply/presentations/PRESENTATION_VENDOR_ID</code></p><p><code>app_scheme://ply/presentations</code><br><code>app_scheme://ply/placements/PLACEMENT_ID</code><br><code>app_scheme://ply/placements</code></p> |
|                                                                                                                                                                                                                                  |
|                                                                                                                                                                                                                                  |

| Cancellation survey                                                                                                                |
| ---------------------------------------------------------------------------------------------------------------------------------- |
| Cancellation survey can be triggered to get some feedback by the user after a subscription cancellation.                           |
| <p><code>app_scheme://ply/cancellation_survey</code></p><p><code>app_scheme://ply/cancellation_survey/PRODUCT_VENDOR_ID</code></p> |
|                                                                                                                                    |

| Subscriptions                                                  |
| -------------------------------------------------------------- |
| This deeplink will open the subscriptions view inside the app. |
| `app_scheme://ply/subscriptions`                               |
|                                                                |

| Update billing                                                                                                              |
| --------------------------------------------------------------------------------------------------------------------------- |
| This deeplink will open the App Store / Play Store setttings for the user to updates its credit card after a payment error. |
| `app_scheme://ply/update_billing`                                                                                           |
|                                                                                                                             |
