# Self-promotion

Once everything is ready, you will want to advertise your In-App Purchases from within your app to convert your users. You migh want to create banners, splash screens, … but doing it right is complex:

* Your product is delivered in more than **150 countries** and several currencies
* **Prices can change** from store to store, this is not an equivalent, you can set different prices by country (cheaper in 🇫🇷, more expensive in 🇬🇧) and Apple changes its price grid regularly to fit rate or taxes changes
* You must take into account the Locale of the user to place the **currency** at the right spot so that the user feels safe …
* A phone with a `en-US` Locale doesn't mean the user has a US App Store account. You need to interrogate the App Store to get the user price, currency, …
* You must take into account **introductory price** information and display the promotion correctly ($10 / month during 3 months ). Remember periods can be weeks, months, … but even 3 days, 2 weeks and more when your intro pricing is free.

We already did that job to display your products and plans and we know it is tough, so please don't try to hardcode the pricings, periods, … Instead you can use the services we have exposed to display the pricing.

First you need to select which Plan of a product you want to expose (cheapest one ? most used ?), then you can proceed as following:

{% tabs %}
{% tab title="Swift" %}
```swift
Purchasely.plan(with: "PLAN_ID",
				success: { (plan) in
					// Get the regular price like "$1.99 / month"
					guard let price = plan.localizedFullPrice else { return }

					// In case there is an active promotion we display it followed by the regular price
					// for example: "$0.99 / week during 2 weeks then $1.99 / month"
					if plan.hasIntroductoryPrice,
						let introPrice = plan.localizedFullIntroductoryPrice,
						let introDuration = plan.localizedIntroductoryDuration {
						self.priceLabel.text = "\(introPrice) during \(introDuration) then \(price)"
					} else {
						self.priceLabel.text = price
					}
},
				failure: { (error) in
					// Hide advertising
})
```
{% endtab %}

{% tab title="Objective-C" %}
```objectivec
[Purchasely planWith:@"PLAN_ID"
			 success:^(PLYPlan * _Nonnull plan) {
	// Get the regular price like "$1.99 / month"
	NSString *price = [plan localizedFullPriceWithLanguage:nil];

	// In case there is an active promotion we display it followed by the regular price
	// for example: "$0.99 / week during 2 weeks then $1.99 / month"
	if ([plan hasIntroductoryPrice]) {
		NSString *introPrice = [plan localizedIntroductoryPriceWithLanguage:nil];
		NSString *introDuration = [plan localizedIntroductoryDurationWithLanguage:nil];
		NSString *introText = [NSString stringWithFormat:@"%@ during %@ then %@", introPrice, introDuration, price];
		[priceLabel setText:introText];
	} else {
		[priceLabel setText:price];
	}
} failure:^(NSError * _Nullable error) {
	// Hide advertising
}];
```
{% endtab %}

{% tab title="Kotlin" %}
```kotlin
Purchasely.plan(
    "PLAN_VENDOR_ID",
    onSuccess = { plan -> 
        // Get the regular price like "$1.99 / month"
        val price = plan?.localizedFullPrice() ?: return@getPlan

        // In case there is an active promotion we display it followed by the regular price
        // for example: "$0.99 / week during 2 weeks then $1.99 / month"
        if(plan.hasIntroductoryPrice()) {
            val introPrice = plan.localizedFullIntroductoryPrice()
            val introDuration = plan.localizedIntroductoryDuration()
            val test = "$introPrice during $introDuration then $price"
            //display introductory price text in your view
        } else {
            //display price in your view
        }
    },
    onError = { throwable -> 
        // Hide advertising
    }
)
```
{% endtab %}

{% tab title="Java" %}
```java
Purchasely.plan("PLAN_VENDOR_ID", new PlanListener() {
    @Override
    public void onSuccess(@Nullable PLYPlan plan) {
        if(plan == null) return;
        
        // Get the regular price like "$1.99 / month"
        String price = plan.localizedFullPrice();

        // In case there is an active promotion we display it followed by the regular price
        // for example: "$0.99 / week during 2 weeks then $1.99 / month"
        if(plan.hasIntroductoryPrice()) {
            String introPrice = plan.localizedFullIntroductoryPrice();
            String introDuration = plan.localizedIntroductoryDuration();
            String test = String.format("%s during %s then %s", introPrice, introDuration, price);
            //display introductory price text in your view
        } else {
            //display price in your view
        }
    }

    @Override
    public void onFailure(@NotNull Throwable throwable) {
        // Hide advertising
    }
});
```
{% endtab %}

{% tab title="React Native" %}
```javascript
try {
  const plan = await Purchasely.planWithIdentifier('PLAN_VENDOR_ID');
  console.log(' ==> Plan');
  console.log(plan.vendorId);
  console.log(plan.name);
  console.log(plan.price);
  console.log(plan.amount);
  console.log(plan.period);
  console.log(plan.hasIntroductoryPrice);
  console.log(plan.introPrice);
  console.log(plan.introAmount);
  console.log(plan.introDuration);
} catch (e) {
  console.log(e);
}
```
{% endtab %}

{% tab title="Cordova" %}
```javascript
Purchasely.planWithIdentifier('PURCHASELY_PLUS_MONTHLY', (plan) => {
	console.log(' ==> Plan');
	console.log(plan.vendorId);
	console.log(plan.name);
	console.log(plan.price);
	console.log(plan.amount);
	console.log(plan.period);
	console.log(plan.hasIntroductoryPrice);
	console.log(plan.introPrice);
	console.log(plan.introAmount);
	console.log(plan.introDuration);
}, (error) => {
	console.log(error);
});

```
{% endtab %}

{% tab title="Flutter" %}
```dart
try {
    PLYPlan? plan = await Purchasely.planWithIdentifier('PLAN_VENDOR_ID');
    print(plan?.name?.toString());
    print(plan?.vendorId?.toString());
    print(plan?.price?.toString());
} catch (e) {
    print(e);
}
```
{% endtab %}
{% endtabs %}
