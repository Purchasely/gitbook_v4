# Migrate to SDK v4.0.0

## Introducing Promotional offers

At Purchasely, we believe that every app deserves to be profitable. That's why we're excited to announce the release of our new SDK version **4.0.0**, which allows you to set promotional offers.\
\
This new version makes it easier than ever to create and manage effective promotional campaigns, helping you to increase your app's revenue.

{% hint style="warning" %}
Take note that we have adopted **Google Billing v5.2.1** and the minimum required **Kotlin** version is **1.7.0**.
{% endhint %}

## Update `Builder` class

The Builder class no longer includes the `uiListener` and `eventListener` configuration options as part of its initial configuration, but they can still be set after calling the `start()` method.

{% tabs %}
{% tab title="Swift" %}
```swift
// Some code
```
{% endtab %}

{% tab title="Objective-C" %}
```objectivec
// Some code
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
{% endtabs %}

## Update for deeplinks

The attribute `isReadyToPurchase` , to indicate that your app is ready to open deeplinks, has been renamed to `readyToOpenDeeplink`

We have additionally changed the name of the method `handle` to `isDeeplinkHandled`

{% tabs %}
{% tab title="Swift" %}
```
// Some code
```
{% endtab %}

{% tab title="Objective-C" %}
```
// Some code
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
        //TODO add paywallView to layout
        }
    }
}

Purchasely.fetchPresentation(properties = PLYPresentationViewProperties(presentationId = "paywall_id")) { presentation, error ->
    if(presentation?.type == PLYPresentationType.NORMAL || presentation?.type == PLYPresentationType.FALLBACK) {
        val paywallView = presentation?.buildView(context, viewProperties = PLYPresentationViewProperties(onClose = {
            //TODO remove paywallView from layout
        })) { result, plan ->
            //TODO add paywallView to layout
        }
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
// Some code
```
{% endtab %}

{% tab title="Objective-C" %}
```objectivec
// Some code
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
