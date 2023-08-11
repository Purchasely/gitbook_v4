# Disable placements

{% hint style="warning" %}
The feature described in this section is supported on the following versions and above:

* iOS: 3.5.0
* Android: 3.5.0
* ReactNative: 2.5.0
* Cordova: 2.5.0
* Flutter: 1.5.0
{% endhint %}

[Placements](../quick-start-1/sdk-configuration/config-appendices/present-paywalls.md) are a powerful tool to trigger a paywall at a certain moment in your app journey. Once you define a placement in the code the marketer can choose what to display to whom.

During your Purchasely setup you will be designing and defining the placements needed. You could also be tempted to add some placements that you might want to use in the future but as it would display a paywall you didn't.

This is exactly why this **paywall disablement feature** is made for. It is now possible to pre-create placements but associated to a paywall yet.

## Use cases

Besides this ability to be more flexible in your marketing strategy, here are some good uses cases you can unlock with this feature

* Test the impact of a paywall at the beginning of the on boarding process or at the end
* Launch a specific promo to specific [audiences](audiences.md) on app launch

{% hint style="success" %}
You should now be defining as many placements as imagined even if you don't intend to use them to avoid app releases.
{% endhint %}

## Implementation

{% tabs %}
{% tab title="Swift" %}
```swift
Purchasely.fetchPresentation(for: "onboarding", fetchCompletion: { presentation, error in
    guard let presentation = presentation, error == nil else {
        print("Error while fetching presentation: \(error?.localizedDescription ?? "unknown")")
        return
    }
    
    if presentation.type == .deactivated {
        
        // nothing to display
        
    }
})
```
{% endtab %}

{% tab title="Objective-C" %}
```objectivec
[Purchasely fetchPresentationFor:@"onboarding" fetchCompletion:^(PLYPresentation * _Nullable presentation, NSError * _Nullable error) {
    if (error != nil) {
        NSLog(@"Error while fetching presentation: %@", error.localizedDescription);
        return;
    }
    
    if (presentation.type == PLYPresentationTypeDeactivated) {
        // nothing to display
    }
} completion:nil];
```
{% endtab %}

{% tab title="Kotlin" %}
```kotlin
Purchasely.fetchPresentationForPlacement("onboarding") { presentation, error ->
    if(error != null) {
        Log.d("Purchasely", "Error fetching paywall", error)
        return@fetchPresentationForPlacement
    }

    when(presentation?.type) {
        PLYPresentationType.NORMAL,
        PLYPresentationType.FALLBACK -> {
            val paywallView = presentation.buildView(
                context = this@MainActivity,
                viewProperties = PLYPresentationViewProperties(
                    onClose = {
                        // TODO remove view
                    }
                )
            )
            // Display Purchasely paywall
        }
        PLYPresentationType.DEACTIVATED -> {
            // No paywall to display for that placement
        }
        PLYPresentationType.CLIENT -> {
            // Display your own paywall
        }
        else -> {
            //No presentation, it means an error was triggered
        }
    }
}
```
{% endtab %}

{% tab title="Java" %}
```java
Purchasely.fetchPresentationForPlacement(
    this,
    "onboarding",
    null,
    (presentation, error) -> {
        if(error != null) {
            Log.d("Purchasely", "Error fetching paywall", error);
            return null;
        }
    
        if(presentation.getType() == PLYPresentationType.DEACTIVATED) {
            // No paywall to display
        }
    
        return null;
    }
);
```
{% endtab %}

{% tab title="React Native" %}
```javascript
try {
  // Fetch presentation to display
  const presentation = await Purchasely.fetchPresentation({
      placementId: 'onboarding'
  })

  if(presentation.type == PLYPresentationType.DEACTIVATED) {
    // No paywall to display
    return
  }
} catch (e) {
  console.error(e);
}
```
{% endtab %}

{% tab title="Flutter" %}
```dart
try {
  var presentation = await Purchasely.fetchPresentation("ONBOARDING");

  if (presentation == null) {
    print("No presentation found");
    return;
  }

  if (presentation.type == PLYPresentationType.deactivated) {
    // No paywall to display
    return;
  }
} catch (e) {
  print(e);
}
```
{% endtab %}

{% tab title="Cordova" %}
```javascript
// coming soon
```
{% endtab %}
{% endtabs %}



