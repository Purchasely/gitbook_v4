---
description: How to use your own paywall within Purchasely environment.
---

# Use your own paywall

{% hint style="warning" %}
The feature described in this section is supported on the following versions and above:

* iOS: 3.5.0
* Android: 3.5.0
* ReactNative: 2.5.0
* Cordova: 2.5.0
* Flutter: 1.5.0
{% endhint %}

It could sound weird to use your home made paywall in a No Code paywall environment but it is indeed very useful to:

* A/A test your paywall against the same one implemented using Purchasely's template
* Test your existing paywall against one of our No Code paywall and run tests to beat your reference
* Easily deploy [price A/B testing](https://help.purchasely.io/en/articles/6990589-price-a-b-test) infrastructure without changing your UI

## Implementation

The [basic paywall implementation](../quick-start-1/sdk-configuration/config-appendices/present-paywalls.md) directly returns a piece of UI but to be able to make both your paywall alongside with Purchasely's paywalls you will need to proceed differently.\
\
First, you must [declare your own paywall](https://help.purchasely.io/en/articles/6940803-your-own-paywall-in-the-purchasely-console) in our console along with the plans you wish to offer on your paywall if you want to do [price A/B tests](https://help.purchasely.io/en/articles/6990589-price-a-b-test)

Then you will need to fetch the paywalls and therefore you won't be able to directly display a screen returned by Purchasely.

You will have to first fetch the paywall then check whether you should display your own paywall or display the provided paywall.\


{% tabs %}
{% tab title="Swift" %}
```swift
Purchasely.fetchPresentation(for: "onboarding", fetchCompletion: { presentation, error in
            guard let presentation = presentation, error == nil else {
                print("Error while fetching presentation: \(error?.localizedDescription ?? "unknown")")
                return
            }
            
            if presentation.type == .normal || presentation.type == .fallback {
                let paywallController = presentation.controller
                
                // display paywall controller.
                
            } else if presentation.type == .deactivated {
                
                // nothing to display
                
            } else if presentation.type == .client {
                let presentationId = presentation.id
                let planIds = presentation.plans
                
                // display your own paywall
                
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
        
        if (presentation.type == PLYPresentationTypeNormal || presentation.type == PLYPresentationTypeFallback) {
            PLYPresentationViewController *paywallController = presentation.controller;
            
            // display paywall controller.
            
        } else if (presentation.type == PLYPresentationTypeDeactivated) {
            
            // nothing to display
            
        } else if (presentation.type == PLYPresentationTypeClient) {
            NSString *presentationId = presentation.id;
            NSArray<NSString *> *plans = presentation.plans;
            
            //display your own paywall
            
        }
    } completion:nil];
```
{% endtab %}

{% tab title="Kotlin" %}
```kotlin
Purchasely.fetchPresentationForPlacement(this, "onboarding") { presentation, error ->
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
            // Nothing to display
        }
        PLYPresentationType.CLIENT -> {
            val paywallId = presentation.id
            val planIds = presentation.plans
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
<pre class="language-java"><code class="lang-java"><strong>Purchasely.fetchPresentationForPlacement(
</strong>    this, 
    "onboarding", 
    null,
    (presentation, error) -> {
        if(error != null) {
            Log.d("Purchasely", "Error fetching paywall", error);
            return null;
        }
        
        if(presentation.getType() == PLYPresentationType.CLIENT) {
            String paywallId = presentation.getId();
            List&#x3C;String> planIds = presentation.getPlans();
            // Display your own paywall
        }
        
        return null;
<strong>    }
</strong><strong>);
</strong></code></pre>
{% endtab %}

{% tab title="React Native" %}
```typescript
try {
  // Fetch presentation to display
  const presentation = await Purchasely.fetchPresentation({
      placementId: 'onboarding'
  })

  if(presentation.type == PLYPresentationType.CLIENT) {
    // Display my own paywall
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

  if (presentation.type == PLYPresentationType.client) {
    // Display my own paywall
    return;
  }

  //Display Purchasely paywall

  var presentResult = await Purchasely.presentPresentation(presentation,
      isFullscreen: false);

  switch (presentResult.result) {
    case PLYPurchaseResult.cancelled:
      {
        print("User cancelled purchased");
      }
      break;
    case PLYPurchaseResult.purchased:
      {
        print("User purchased ${presentResult.plan?.name}");
      }
      break;
    case PLYPurchaseResult.restored:
      {
        print("User restored ${presentResult.plan?.name}");
      }
      break;
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



Then call `clientPresentationDisplayed(presentation)` when your paywall is displayed and `clientPresentationClosed(presentation)` when your paywall is closed.

These steps are mandatory for Purchasely to compute conversion on your paywall and measure the performance of A/B tests.&#x20;

{% tabs %}
{% tab title="Swift" %}
```swift
// Call when your paywall is displayed
// in ViewDidAppear for example
Purchasely.clientPresentationOpened(with: presentation)
            
// Call when your paywall has been closed
// in viewWillDisappear for example
Purchasely.clientPresentationClosed(with: presentation)

// Call clientPresentationClosed in Purchasely.syncPurchase() closure 
// if you are in paywallObserverMode
```
{% endtab %}

{% tab title="Objective-C" %}
```objectivec
// Call when your paywall is displayed
// in ViewDidAppear for example
[Purchasely clientPresentationOpenedWith:presentation];
            
// Call when your paywall has been closed
// in viewWillDisappear for example
[Purchasely clientPresentationClosedWith:presentation];
```
{% endtab %}

{% tab title="Kotlin" %}
```kotlin
// Call when your paywall is displayed
// For example in the onCreate() method of your Activity
Purchasely.clientPresentationDisplayed(presentation)

// Call when your paywall is closed
// For example in the onDestroy() method of your Activity
Purchasely.clientPresentationClosed(presentation)
```
{% endtab %}

{% tab title="Java" %}
```java
// Call when your paywall is displayed
// For example in the onCreate() method of your Activity
Purchasely.clientPresentationDisplayed(presentation);

// Call when your paywall is closed
// For example in the onDestroy() method of your Activity
Purchasely.clientPresentationClosed(presentation);
```
{% endtab %}

{% tab title="React Native" %}
<pre class="language-typescript"><code class="lang-typescript">// Call when your paywall is displayed
<strong>Purchasely.clientPresentationDisplayed(presentation);
</strong><strong>
</strong>// Call when your paywall is closed
Purchasely.clientPresentationClosed(presentation);

</code></pre>
{% endtab %}

{% tab title="Flutter" %}
```dart
// Call when your paywall is displayed
Purchasely.clientPresentationDisplayed(presentation);

// Call when your paywall is closed
Purchasely.clientPresentationClosed(presentation);
```
{% endtab %}

{% tab title="Cordova" %}
```javascript
```
{% endtab %}
{% endtabs %}

{% hint style="info" %}
You can of course do the purchase transaction from your own paywall with Purchasely by using `Purchasely.purchase(plan)`, more information [here](manually-trigger-purchases.md)
{% endhint %}



