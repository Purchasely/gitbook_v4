# Migrate to SDK v4.0.0

## Introducing Promotional offers

At Purchasely, we believe that every app deserves to be profitable. That's why we're excited to announce the release of our new SDK version **4.0.0**, which allows you to set promotional offers.\
\
This new version makes it easier than ever to create and manage effective promotional campaigns, helping you to increase your app's revenue.

{% hint style="warning" %}
Take note that : \
On Android, we have adopted **Google Billing v5.2.1** and the minimum required **Kotlin** version is **1.6.0**\
On iOS, setting a StoreKit version is mandatory
{% endhint %}

## Initialization update

The start method no longer includes the `uiListener/uiDelegate` and `eventListener/eventDelegate` configuration options as part of its initial configuration, but they can still be set after calling the `start()` method.

{% tabs %}
{% tab title="Swift" %}
<pre class="language-swift"><code class="lang-swift">import Purchasely

Purchasely.start(withAPIKey: "API_KEY",
                         appUserId: "USER_ID",
<strong>                         runningMode: .full,
</strong><strong>                         paywallActionsInterceptor: PLYPaywallActionsInterceptor,
</strong>                         storekitSettings: .storeKit2, // Set your StoreKit version
                         logLevel: .debug, // set to warning or error for release
                         initialized: PLYSuccessErrorClosure))
                         
// Paywall interceptor can be setted afterwards by calling
Purchasely.setPaywallActionsInterceptor { [weak self] (action, parameters, presentationInfo, proceed) in
}

// Set your ui listener
Purchasely.Purchasely.setUIDelegate(PLYUIDelegate?)

</code></pre>
{% endtab %}

{% tab title="Objective-C" %}
```objectivec
#import <Purchasely/Purchasely-Swift.h>

[Purchasely startWithAPIKey:@"API_KEY"
		appUserId:@"USER_ID"
		runningMode: PLYRunningModeFull
	  	paywallActionsInterceptor:nil
		storekitSettings: [StorekitSettings .storekit2] // optional but set to StoreKit 2 by default. 
		// Fallsback to StoreKit 1 in case the informations are not setup correctly on Purchasely console
		logLevel: LogLevelInfo
		initialized: nil];

// Paywall interceptor can be setted afterwards by calling
[Purchasely setPaywallActionsInterceptor:^(enum PLYPresentationAction, PLYPresentationActionParameters * _Nullable, PLYPresentationInfo * _Nullable, void (^ _Nonnull)(BOOL)) {
}];

// Set your ui listener
[Purchasely setUIDelegate:(id<PLYUIDelegate> _Nullable)
```
{% endtab %}

{% tab title="Kotlin" %}
```kotlin
import io.purchasely.ext.Purchasely

Purchasely.Builder(applicationContext)
    .apiKey("API_KEY")
    .logLevel(LogLevel.DEBUG) // set to warning or error for release
    .userId("USER_ID")
    .readyToOpenDeeplink(true)  
    .runningMode(PLYRunningMode.Full)
    .stores(listOf(GoogleStore(), HuaweiStore()))
    .build()

// When you are ready for Purchasely to initialize,
// you must call start() method that will grab configuration and products
// from the selected stores.
Purchasely.start { isConfigured ->
}

// Set your event listener
Purchasely.eventListener = object : EventListener {
    override fun onEvent(event: PLYEvent) {}
}

// Set your ui listener
Purchasely.uiListener = object : UIListener {
    override fun onAlert(alert: PLYAlertMessage) {}

    override fun onView(view: View, type: PLYUIViewType) {}

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
    .readyToOpenDeeplink(true)
    .runningMode(PLYRunningMode.Full.INSTANCE)
    .stores(stores)
    .build();

// When you are ready for Purchasely to initialize,
// you must call start() method that will grab configuration and products
// from the selected stores.
Purchasely.start(isConfigured -> {
    null;
});

// Set your event listener
Purchasely.setEventListener(
        new EventListener() {
            @Override
            public void onEvent(@NonNull PLYEvent event) {}
        }
);

// Set your ui listener
Purchasely.setUiListener(
        new UIListener() {
            @Override
            public void onAlert(@NonNull PLYAlertMessage alert) {}

            @Override
            public void onView(@NonNull View view, @NonNull PLYUIViewType type) {}
        }
);
```
{% endtab %}

{% tab title="ReactNative" %}
```typescript
// Everything is optional except apiKey and storeKit1
// Example with default values
await Purchasely.start({
          apiKey: 'YOUR_API_KEY',
          storeKit1: false, // set to false to use StoreKit2, true to use StoreKit1,
          logLevel: LogLevels.ERROR, // set to debug in development mode to see logs
          userId: null, // if you know your user id, set it here
          runningMode: RunningMode.FULL, // select between full and paywallObserver
          androidStores: ['Google'] // default is Google, don't forget to add the dependency to the same version
        });
```
{% endtab %}

{% tab title="Flutter" %}
```dart
// Everything is optional except apiKey and storeKit1
// Example with default values
await Purchasely.start(
        apiKey: 'YOUR_API_KEY',
        androidStores: ['Google'], // default is Google, don't forget to add the dependency to the same version
        storeKit1: false, // set to false to use StoreKit2, true to use StoreKit1
        logLevel: PLYLogLevel.error, // set to debug in development mode to see logs
        runningMode: PLYRunningMode.full, // select between full and paywallObserver
        userId: null, // set a user id if you have one
      );
```
{% endtab %}
{% endtabs %}

## Update for deeplinks

The attribute `isReadyToPurchase` , to indicate that your app is ready to open deeplinks, has been renamed to `readyToOpenDeeplink`

We have additionally changed the name of the method `handle` to `isDeeplinkHandled`

{% tabs %}
{% tab title="Swift" %}
```swift
Purchasely.readyToOpenDeeplink(true)

Purchasely.isDeeplinkHandled(deeplink: "URL")
```
{% endtab %}

{% tab title="Objective-C" %}
```objectivec
[Purchasely readyToOpenDeeplink:(BOOL)]

[Purchasely isDeeplinkHandled:(NSURL * _Nonnull)]
```
{% endtab %}

{% tab title="Kotlin" %}
```kotlin
Purchasely.readyToOpenDeeplink = true

Purchasely.isDeeplinkHandled(
    deeplink = deeplink
)
```
{% endtab %}

{% tab title="Java" %}
```java
Purchasely.setReadyToOpenDeeplink(true);
Purchasely.isDeeplinkHandled(deeplink);
```
{% endtab %}

{% tab title="ReactNative" %}
<pre class="language-typescript"><code class="lang-typescript">Purchasely.readyToOpenDeeplink(true);

<strong>Purchasely.isDeeplinkHandled('app://ply/presentations/')
</strong>          .then((value) => console.log('Deeplink handled by Purchasely ? ' + value));
</code></pre>
{% endtab %}
{% endtabs %}

## Methods for presentation display

Only with our bridges SDKs: ReactNative, Flutter and Unity\
\
Before you could call the method `Purchasely.closePresentation()` to hide the presentation or `Purchasely.closePresentation(true)` to close it\
We have changed those methods and added new ones to make it easier to manage and understand, see below

{% tabs %}
{% tab title="ReactNative" %}
```typescript
// Hide the presentation being display
// for example when you are in paywall action interceptor
// to display your own screen like a login screen
Purchasely.hidePresentation();

// Display the presentation previously hidden
Purchasely.showPresentation();

// Close the presentation
// cannot be displayed again until you call Purchasely.presentPresentation()
Purchasely.closePresentation();
```
{% endtab %}

{% tab title="Flutter" %}
```dart
// Hide the presentation being display
// for example when you are in paywall action interceptor
// to display your own screen like a login screen
Purchasely.hidePresentation();

// Display the presentation previously hidden
Purchasely.showPresentation();

// Close the presentation
// cannot be displayed again until you call Purchasely.presentPresentation()
Purchasely.closePresentation();

```
{% endtab %}
{% endtabs %}

## Fetch presentation with context (Android only)

The methods `FetchPresentation` and `FetchPresentationForPresentation` have been updated as well. The previously required parameters `Context` and `PLYPresentationResultHandler` have been removed and are no longer necessary.

{% tabs %}
{% tab title="Kotlin" %}
```kotlin
Purchasely.fetchPresentationForPlacement(placementId = "placementId") { presentation, error ->
    if(presentation?.type == PLYPresentationType.NORMAL || presentation?.type == PLYPresentationType.FALLBACK) {
        val paywallView = presentation?.buildView(context, viewProperties = PLYPresentationViewProperties(onClose = {
            //TODO remove paywallView from layout
        })) { result, plan ->
            // Paywall is closed, check result to know if a purchase happened
            when(result) {
                PLYProductViewResult.PURCHASED -> Log.d("Purchasely", "User purchased ${plan?.name}")
                PLYProductViewResult.CANCELLED -> Log.d("Purchasely", "User cancelled purchased")
                PLYProductViewResult.RESTORED -> Log.d("Purchasely", "User restored ${plan?.name}")
            }
        }
        
        // TODO Add paywallView to your layout to display it
    }
}

// You should always use a placement to display paywalls 
// but if you really need to display a specific paywall
// you can use properties to set the your paywall id
Purchasely.fetchPresentation(properties = PLYPresentationViewProperties(presentationId = "paywall_id")) { presentation, error ->
    if(presentation?.type == PLYPresentationType.NORMAL || presentation?.type == PLYPresentationType.FALLBACK) {
        val paywallView = presentation?.buildView(context, viewProperties = PLYPresentationViewProperties(onClose = {
            //TODO remove paywallView from layout
        })) { result, plan ->
            // Paywall is closed, check result to know if a purchase happened
            when(result) {
                PLYProductViewResult.PURCHASED -> Log.d("Purchasely", "User purchased ${plan?.name}")
                PLYProductViewResult.CANCELLED -> Log.d("Purchasely", "User cancelled purchased")
                PLYProductViewResult.RESTORED -> Log.d("Purchasely", "User restored ${plan?.name}")
            }
        }
        
        // TODO Add paywallView to your layout to display it
    }
}
```
{% endtab %}

{% tab title="Java" %}
```java
Purchasely.fetchPresentationForPlacement("placementId", (plyPresentation, plyError) -> {

    if (plyError != null || plyPresentation == null) {
        // Handle error
        return null;
    }

    if(plyPresentation.getType() == PLYPresentationType.NORMAL || plyPresentation.getType() == PLYPresentationType.FALLBACK) {
        View paywallView = plyPresentation.buildView(
                context,
                new PLYPresentationViewProperties(
                        null, null, null, null, null, true, null, 
                        (Function0<Unit>) () -> {
                    //TODO remove view
                           return null;
                }, null, null),
                (Function2<PLYProductViewResult, PLYPlan, Unit>) (plyProductViewResult, plyPlan) -> null
        );
    }

    return null;
});
```
{% endtab %}
{% endtabs %}

## Use Views instead of Fragments (Android only)

In this version, we have taken the step to entirely eliminate fragment-related methods that had been deprecated in our prior releases. Instead, opt for one of the view-related methods to display your presentations:&#x20;

```kotlin
Purchasely.presentationView(...)

//or 

presentationViewForPlacement(...)
```

And to ensure coherence and consistency, we've gone ahead and renamed all classes, enums, and interfaces related to fragments.

## Update `Purchase` method

By introducing `offer` to the `purchase` method as an optional parameter, we now support the ability to purchase a specific offer of a plan.

{% tabs %}
{% tab title="Swift" %}
```swift
// Purchase with promotional offer    
Purchasely.purchaseWithPromotionalOffer(plan: <PLYPlan>,
                                        contentId: "contentId",
                                        storeOfferId: "storeOfferId") {
// Success completion block
} failure: { error in
// Failure completion block                    
}
```
{% endtab %}

{% tab title="Objective-C" %}
```objectivec
// Purchase with promotional offer
[Purchasely purchaseWithPromotionalOfferWithPlan:plan
                  contentId:@"contentId"
                  storeOfferId:@"storeOfferId"
                  success:^{
// Success completion block
} failure:^(NSError * error) {
// Failure completion block
}];
```
{% endtab %}

{% tab title="Kotlin" %}
```kotlin
Purchasely.purchase(
    activity = activity,
    plan = plan,
    offer = offer 
)
```
{% endtab %}

{% tab title="Java" %}
```java
Purchasely.purchase(activity, plan, offer, null, null, null);
```
{% endtab %}
{% endtabs %}
