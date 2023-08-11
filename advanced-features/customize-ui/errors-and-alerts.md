# Errors & alerts

Some information messages are displayed to the user during the purchase life cycle like:

* Purchase completed
* Restoration completed

Many errors can occure during the purchase process and are embedded in these messages liek:

* Network error
* Product not found
* Purchase impossible (or canceled)
* Restoration incomplete
* And some more listed in `PLYError` object and translated in the supported languages of the SDK.

All these alerts are listed in `PLYAlertMessage` enum.

The SDK displays these alerts using a standard `UIAlertController` (iOS) / `AlertDialog` (Android) message with a single `Ok` button to dismiss.

If you wish a more customised way to display error messages, a way that reflects more your app, you can override the default behaviour by setting yourself as the delegate (`PLYUIDelegate` on iOS) or listner (`UIListener` on Android) you will then be responsible for displaying the messages yourself.

That way you could also override the behaviour and trigger some specific actions when the user taps on the button for example.

{% tabs %}
{% tab title="Swift" %}
```swift
Purchasely.setUIDelegate(self)

func display(alert: PLYAlertMessage, error: Error?) {
	let alertTitle = alert.title
	let alertContent = alert.content ?? error?.localizedDescription
	let alertButtin = alert.buttonTitle

	// Display your modal
}
```
{% endtab %}

{% tab title="Objective-C" %}
```objectivec
[Purchasely setUIDelegate:self];

- (void)displayWithAlert:(enum PLYAlertMessage)alert error:(NSError *)error {
	// Display your modal
}
```
{% endtab %}

{% tab title="Kotlin" %}
```kotlin
Purchasely.uiListener = object: UIListener {
    override fun onAlert(alert: PLYAlertMessage) {
					when(alert) {
	    				PLYAlertMessage.InAppSuccess -> displaySuccessDialog(alert)
	    				PLYAlertMessage.InAppSuccessUnauthentified -> displaySuccessDialog(alert)
	    				is PLYAlertMessage.InAppError -> displayErrorDialog(alert)
					}
    }
}
```
{% endtab %}

{% tab title="Java" %}
```java
Purchasely.setUiListener(new UIListener() {
    @Override
    public void onAlert(@NotNull PLYAlertMessage alert) {
	    if(alert instanceof PLYAlertMessage.InAppSuccess) {
	     //TODO display success view
	    }
    }
});
```
{% endtab %}
{% endtabs %}
