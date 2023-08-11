# Notify when the app is ready

The SDK needs to display messages above your UI. It can be the continuation of a purchase started on the App Store, the result from a notification linking to our product, …

Your app needs to tell Purchasely SDK when it is ready to be covered by our UI.

This is done to handle cases like:

* a loading screen that dismisses upon completion
* an on boarding that needs to be displayed before purchasing
* a subscribe process mandatory for app usage

When your app is ready, call the following method and the SDK will handle the continuation of whatever was in progress (purchase, push message, …)

This is mandatory to be able to handle [**Promoted In-App Purchases**](../../../advanced-features/promoting-your-products/promoting-in-app-purchases.md) and [**Deeplinks automations**](../../../advanced-features/deeplinks-and-automations.md).

{% tabs %}
{% tab title="Swift" %}
```swift
// Call me in your viewDidAppear
Purchasely.isReadyToPurchase(true)
```
{% endtab %}

{% tab title="Objective-C" %}
```objectivec
[Purchasely isReadyToPurchase: true];
```
{% endtab %}

{% tab title="Kotlin" %}
```kotlin
Purchasely.isReadyToPurchase = true
```
{% endtab %}

{% tab title="Java" %}
```java
Purchasely.setIsReadyToPurchase(true);
```
{% endtab %}

{% tab title="React Native" %}
```javascript
Purchasely.isReadyToPurchase(true);
```
{% endtab %}

{% tab title="Cordova" %}
```javascript
Purchasely.isReadyToPurchase(true);
```
{% endtab %}

{% tab title="Flutter" %}
```dart
Purchasely.isReadyToPurchase(true);
```
{% endtab %}
{% endtabs %}

You can set it back to false when the app goes in the background when you have a screen that blocks UI in background mode and that is dismissed when the app is in foreground (like in banking apps).
