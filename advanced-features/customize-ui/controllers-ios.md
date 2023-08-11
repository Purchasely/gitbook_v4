# Controllers (iOS) / Fragments (Android)

The SDK can pop controllers above your UI like product presentation pages (see [Promoting In-App Purchases](../promoting-your-products/promoting-in-app-purchases.md)) or the subscription lists or any deeplink triggered by a push service.&#x20;

Of course we will wait for you to tell us when we are free to cover your content by calling `isReadyToPurchase` ([more details](../../quick-start-1/sdk-configuration/config-appendices/#notifying-the-sdk-when-the-app-is-ready-loaded)) but you might want to take control on the controller animation, position… It can be a side bar with the offer on tablets or toaster messages for the error messages.

You can override the default behaviors and implement yours by using the `PLYUIDelegate`.

{% tabs %}
{% tab title="Swift" %}
```swift
Purchasely.setUIDelegate(self)
```
{% endtab %}

{% tab title="Objective-C" %}
```objectivec
[Purchasely setUIDelegate:self];
```
{% endtab %}

{% tab title="Kotlin" %}
```kotlin
Purchasely.uiListener = this
```
{% endtab %}

{% tab title="Java" %}
```java
Purchasely.setUiListener(this);
```
{% endtab %}
{% endtabs %}

To change the transition, size, position … of a presented controller (`PLYUIControllerType` gives you the type of controller displayed):

{% tabs %}
{% tab title="Swift" %}
```swift
func display(controller: UIViewController, type: PLYUIControllerType) {
	// Present the controller your way
}
```
{% endtab %}

{% tab title="Objective-C" %}
```objectivec
- (void)displayWithController:(UIViewController *)controller type:(enum PLYUIControllerType)type {
	// Present the controller your way
}
```
{% endtab %}

{% tab title="Kotlin" %}
```kotlin
override fun onAlert(alert: PLYAlertMessage) {
    //TODO display alert dialog, see "Errors & alerts" page
}

override fun onFragment(fragment: Fragment, type: PLYUIFragmentType) {
    //TODO display fragment as you wish in your activity
    //type can be PRODUCT_PAGE, SUBSCRIPTION_LIST or CANCELLATION_PAGE
}
```
{% endtab %}

{% tab title="Java" %}
```java
@Override
public void onAlert(@NotNull PLYAlertMessage alert) {
  //TODO display alert dialog, see "Errors & alerts" page
}

@Override
public void onFragment(@NotNull Fragment fragment, @NotNull PLYUIFragmentType type) {
  //TODO display fragment as you wish in your activity
  //type can be PRODUCT_PAGE, SUBSCRIPTION_LIST or CANCELLATION_PAGE
}
```
{% endtab %}
{% endtabs %}



{% hint style="warning" %}
Android only : We advise you to call `Purchasely.setUiListener(null)`when done to remove all references to your activity if you are not using `WeakReference`
{% endhint %}
