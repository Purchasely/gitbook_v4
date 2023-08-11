---
description: Pre-fetch and customize paywalls display
---

# Asynchronous paywalls

{% hint style="warning" %}
The feature described in this section is supported on the following versions and above:

* iOS: 3.5.0
* Android: 3.5.0
* ReactNative: 2.5.0
* Cordova: 2.5.0
* Flutter: 1.5.0
{% endhint %}

Purchasely, by default, [shows the paywall screen](../quick-start-1/sdk-configuration/config-appendices/present-paywalls.md) with a loading indicator while fetching the paywall from the network and preparing it for display.

Using `Purchasely.fetchPresentation()` method, you can pre-fetch the paywall from the network before displaying it. This provides the following benefits:

* Display the paywall only after it has been loaded from the network
* Handle network errors gracefully
* Show a custom loading screen
* Pre-load the paywall while users navigate through your app, such as during onboarding screens
* Choose [not to display a paywall](disable-placements.md) for a specific placement
* Display [your own paywall](use-your-own-paywall.md)

## Implementation

Call `Purchasely.fetchPresentation` **for** a placement or **with** a presentation id

1. An error may be returned if the presentation could not be fetched from the network.
2. If successful, you will have a `PLYPresentation` instance containing the following properties

```javascript
class PLYPresentation(
    id: String?
    placementId: String?
    audienceId: String?
    abTestId: String?
    abTestVariantId: String?
    language: String?
    type: PLYPresentationType
    plans: [String] // get PLYPlan instance with Purchasely.plan("planId")

    // Android SDK only (Kotlin or Java)
    view: PLYTemplateView?
    
    // iOS SDK only (Swift or Objective-C)
    controller: UIViewController?
}
```

A presentation can be one of the following types:

* **Normal**: The default behavior, a Purchasely paywall created from our console.
* **Fallback**: A Purchasely paywall, but not the one you requested, as it could not be found.
* **Deactivated**: No [paywall associated](disable-placements.md) with that placement, possibly for a specific A/B test or [audience](https://help.purchasely.io/en/articles/6940943-disable-a-paywall-for-a-placement).
* **Client**: You declared [your own paywall in our console](https://help.purchasely.io/en/articles/6940803-your-own-paywall-in-the-purchasely-console) and should [display it](use-your-own-paywall.md). Use the list of plans to determine which offers to display to your users.\


{% tabs %}
{% tab title="Swift" %}
```swift
// fetch presentation with id
Purchasely.fetchPresentation(with: "presentationId", fetchCompletion: { presentation, error in
})

// fetch presentation for placement
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
        
        if(presentation.getType() == PLYPresentationType.NORMAL
            || presentation.getType() == PLYPresentationType.FALLBACK) {
            // display Purchasely paywall
            PLYTemplateView paywallView = presentation.view
        }
        
        if(presentation.getType() == PLYPresentationType.DEACTIVATED) {
            // nothing to display
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
<pre class="language-typescript"><code class="lang-typescript">try {
  // Fetch presentation to display
  const presentation = await Purchasely.fetchPresentation({
      placementId: 'onboarding'
  })

<strong>  if(presentation.type == PLYPresentationType.DEACTIVATED) {
</strong>    // No paywall to display
    return
  }

  if(presentation.type == PLYPresentationType.CLIENT) {
    // Display my own paywall
    return
  }

  //Display Purchasely paywall
  const result = await Purchasely.presentPresentation({
    presentation: presentation
  })
  
  switch (result.result) {
    case ProductResult.PRODUCT_RESULT_PURCHASED:
    case ProductResult.PRODUCT_RESULT_RESTORED:
      if (result.plan != null) {
        console.log('User purchased ' + result.plan.name);
      }

      break;
    case ProductResult.PRODUCT_RESULT_CANCELLED:
      console.log('User cancelled');
      break;
  }

} catch (e) {
  console.error(e);
}
</code></pre>
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





