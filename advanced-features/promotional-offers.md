---
description: >-
  Use Apple promotional offers and Google developer determined offers to create
  win-back campaigns
---

# NEW: Promotional offers

{% hint style="success" %}
The feature described in this section is supported on the following versions and above:

* iOS: 4.0.1
* Android: 4.0.0
* ReactNative: 4.0.1
* Flutter: 4.0.0\


If you use a prior version of the SDK your users won’t see a discount and will purchase at the regular price.
{% endhint %}

In this article we are going to describe the process to create promotional offers on [AppStore Connect](https://appstoreconnect.apple.com/), [Google Play Console](https://play.google.com/console/) and [Purchasely Console](https://console.purchasely.io/)\
\
Promotional offers can be used to offer a specific discount to current or past subscribers. It is a great way to retain or win-back a customer. You will be able to set up as many as you want by creating specific paywalls with those offers.

{% hint style="warning" %}
**You are responsible for the eligibility** of those promotional offers, you must create a specific paywall and display it only for the users you want to target (see Purchasely console below for more details)
{% endhint %}

## Apple <a href="#h_7021308b80" id="h_7021308b80"></a>

### Console configuration

Purchasely **must have** an Apple certificate to sign promotional offers, the configuration is exactly the same than for [StoreKit 2](../quick-start-1/sdk-configuration/storekit-2.md), so if you already did it you can skip that part and move to [#appstore-connect-configuration](promotional-offers.md#appstore-connect-configuration "mention")

Allowing Purchasely to sign promotional offers requires a [few steps](https://developer.apple.com/documentation/appstoreserverapi/creating\_api\_keys\_to\_use\_with\_the\_app\_store\_server\_api). Once completed, you can update your application settings in Purchasely console.

#### **Enable App Store Connect API access**

* Sign in to [App Store Connect](https://appstoreconnect.apple.com/access/api/subs)
* Go to "Users and Access"
* Select "Keys" under the "In-App Purchase" section
* Click on the "+" button to generate a new API key
* Choose a name for the key and click "Generate"
* Download the API key file (`.p8`), and note the **Key ID** and **Issuer ID**. Keep the file secure, as you won't be able to download it again

<figure><img src="https://files.gitbook.com/v0/b/gitbook-x-prod.appspot.com/o/spaces%2FGgUdOzhqa07uh7nB2iZA%2Fuploads%2FuzmdiMgxXbvsSrj7F58m%2FSCR-20230403-nktk.png?alt=media&#x26;token=8e370356-52f1-4913-8a78-702d441ace65" alt=""><figcaption></figcaption></figure>

#### Setup on Purchasely Console

* Connect to [Purchasely Console](https://console.purchasely.io/)
* Go to "App Settings"
* Select Apple App Store" under the "Store configuration" section
* Fill in the **Private Key Id** from the key you generated
* Upload your Private Key File (`.p8`)
* Fill your **Issuer Id**
* Click on **Save** in the top right corner

<figure><img src="https://files.gitbook.com/v0/b/gitbook-x-prod.appspot.com/o/spaces%2FGgUdOzhqa07uh7nB2iZA%2Fuploads%2FGziQy6NPfXfCjK3doltM%2FSCR-20230403-nefu.png?alt=media&#x26;token=fa220406-60e9-4b51-bf9d-cd5e70535913" alt=""><figcaption></figcaption></figure>



{% hint style="warning" %}
Once this configuration is set, Purchasely SDK 4.0.0 and up will be configured to use StoreKit 2 as default.\
If you wish to remain with Store Kit 1, which also works with promotional offers, you need to force it in the [start()](../faq/migration-guides/sdk/migrate-to-sdk-v4.0.0.md#initialization-update) method of our SDK.
{% endhint %}

### AppStore Connect configuration

A promotional offer is only available for current and previous subscribers of the selected subscription. You can create it from [AppStore Connect](https://appstoreconnect.apple.com/) in the same page where you manage your subscription price and introductory offers

<figure><img src="https://downloads.intercomcdn.com/i/o/819175771/a281aad02742e7a8b69b17c9/SCR-20230830-rcuu.png" alt=""><figcaption></figcaption></figure>

From that page select Promotional Offers tab and then click on the + button to create a new one\


[![](https://downloads.intercomcdn.com/i/o/819175836/7bdf10ee941595cc465be7a3/SCR-20230830-rdey.png)](https://downloads.intercomcdn.com/i/o/819175836/7bdf10ee941595cc465be7a3/SCR-20230830-rdey.png)

Setup the discount you wish to offer, it can be a:\
\- free (example: 3 months free then $9,99/month)\
\- pay up front (example: $14,99 for 3 months then $9,99/month)\
\- pay as your go (example: $4,99/month for 3 months then $9,99/month)

<figure><img src="https://downloads.intercomcdn.com/i/o/819175900/33fd4fe7877457e76bdc3b02/SCR-20230830-rdmw.png" alt=""><figcaption></figcaption></figure>

Once created, copy the id you have set for this offer to paste in [Purchasely Console](promotional-offers.md#h\_81922e6fd5-1)

<figure><img src="https://downloads.intercomcdn.com/i/o/819175953/a974cb907d3ef86106883e87/SCR-20230830-rdrf.png" alt=""><figcaption></figcaption></figure>

## Google <a href="#h_81922e6fd5" id="h_81922e6fd5"></a>

Promotional offers for Google are Developer Determined Offer which can be set on your base plans for a subscription. It requires the usage of Google Play Billing v5 which is included in Purchasely SDK 4.0.0

{% hint style="warning" %}
**Developer determined offer are available for all your users all the time**. As the name suggest, it is up to you to decide when to make this offer available. Unfortunately Purchasely SDK cannot know the offer type, so by default this offer will be presented to all your users by our SDK. To avoid this, you can add the tag ignore-offer (see below for more details)
{% endhint %}

To create an offer, go to your [application subscription](https://play.google.com/console/u/0/developers/app/subscriptions) and select _Add offer_

<figure><img src="https://downloads.intercomcdn.com/i/o/819162832/85c092b9b3ca6be7200d8195/SCR-20230829-onpw.png" alt=""><figcaption></figcaption></figure>

Then chose the base plan to apply this offer to

<figure><img src="https://downloads.intercomcdn.com/i/o/819162702/508aa434f3503fa84db666a4/SCR-20230829-omvt.png" alt=""><figcaption></figcaption></figure>

Your offer must contain the following information:\
\- **Offer id**: you can chose anything, it will be the one you will fill in [Purchasely console](promotional-offers.md#h\_81922e6fd5-1)\
\- **Eligibility criteria**: Developer determined\
\- **Tags**: ignore-offer (see notice below)\
\- **Phases**: you can add up to 2 phases, one free trial and one price discount

<figure><img src="https://downloads.intercomcdn.com/i/o/819164184/6c875e91b58bfc916279e237/SCR-20230829-oofh.png" alt=""><figcaption></figcaption></figure>

<figure><img src="https://downloads.intercomcdn.com/i/o/819162963/586508617a2720f6294ad410/SCR-20230829-onvh.png" alt=""><figcaption></figcaption></figure>

{% hint style="info" %}
To avoid offering these offers to all your users, we strongly suggest to add the tag **ignore-offer** to all your developer determined offers so that Purchasely SDK won't display it to your users _unless_ explicitly defined in a paywall as a promotional offer
{% endhint %}

## Purchasely Console <a href="#h_81922e6fd5" id="h_81922e6fd5"></a>

When your promotional offer has been created on AppStore Connect and/or Google Play Console, the final step is to declare it in Purchasely Console to use it with your paywall\
\
First edit the plan where you want to declare you new promotional offer.\
The plan MUST be the App Store or Play Store product that you used to declare your offer\


<figure><img src="https://downloads.intercomcdn.com/i/o/823200285/476281eedf2889dab12094ff/SCR-20230905-mhxh.png" alt=""><figcaption></figcaption></figure>

Set a name, an identifier for Purchasely and the identifiers you have set in AppStore Connect and Google Play Console. Finally click Save to apply your changes\


<figure><img src="https://downloads.intercomcdn.com/i/o/823200166/e84fa163bca8add4596779d9/SCR-20230905-mifj.png" alt=""><figcaption></figcaption></figure>

\
Then you can create a paywall for your offer, we have created a new action button for that: **Purchase with promo**\
You need to select your plan and offer to be applied as the action for this button\
You can use the field "Offer" of the different labels to set offers [tags](https://help.purchasely.io/en/articles/6312888-different-types-of-paywall-tags-and-their-uses) like `OFFER_PRICE` and `OFFER_DURATION` (same principle than trial offer)\


<figure><img src="https://downloads.intercomcdn.com/i/o/823200888/3bb47be9ae92b294212e39f2/SCR-20230905-moqq.png" alt=""><figcaption></figcaption></figure>

\
\


You are responsible for displaying this paywall to users you want to target, so you should create a specific [placement](https://help.purchasely.io/en/articles/6344651) for them. You can also target them using [Audience](https://help.purchasely.io/en/articles/6502579)

We will send specific events to your [webhook](../integrations/webhook-1/) or external integration:\
`PROMOTIONAL_OFFER_STARTED`

`PROMOTIONAL_OFFER_CONVERTED`

`PROMOTIONAL_OFFER_NOT_CONVERTED`

The information about the promotional offer will also be in the payload of events like the one above and `ACTIVATE`

`offer_type: "PROMOTIONAL_OFFER"`

## Trigger the purchase of an offer

Purchasely handles automatically the purchase from a Purchasely paywall but if you are displaying your own paywall or purchase button, you may want to trigger the purchase with Purchasely. You can do it really easily by providing the PLYPlan and PLYOffer you want to use for the purchase

{% tabs %}
{% tab title="Swift" %}
<pre class="language-swift"><code class="lang-swift"><strong>// First get the plan you want to purchase
</strong><strong>Purchasely.plan(with: "planId") { plan in
</strong><strong>// Success completion
</strong>} failure: { error in 
// Failure completion
}

// Retrieve offer id
let promoOffer = plan.promoOffers.first(where: { $0.vendorId == promoOfferVendorId })

// Then purchase
Purchasely.purchaseWithPromotionalOffer(plan: plan,
                                        contentId: nil,
                                        storeOfferId: promoOffer.storeOfferId) {                    
// Success completion       
} failure: { error in
// Failure completion                    
}

...

// We also offer the possibility to sign your promotional offers 
// if you want to purchase with your own system
Purchasely.signPromotionalOffer(storeProductId: "storeProductId",
                                storeOfferId: "storeOfferId") { signature in            
// Success completion
} failure: { error in
// Failure completion
}
</code></pre>
{% endtab %}

{% tab title="Objective-C" %}
```objectivec
[Purchasely setPaywallActionsInterceptor:^(enum PLYPresentationAction action, PLYPresentationActionParameters *parameters, PLYPresentationInfo *presentationInfos, void (^ proceed)(BOOL)) {
        switch (action) {
            // Intercept the tap on purchase to display the terms and condition
            case PLYPresentationActionPurchase:{
                // Grab the apple product id to purchase
                NSString *appleProductId = parameters.plan.appleProductId;
                NSString *appleOfferId = parameters.offer.storeOfferId;
                
                // Sign the offer with signPromotionalOffer method from Purchasely
            
                // TODO purchase with product id and signature
                break;
            }
            default:
                proceed(true);
                break;
        }
    }];
```
{% endtab %}

{% tab title="Kotlin" %}
```kotlin
val plan = Purchasely.plan("plan_id on purchasely console")
val offer = plan?.promoOffers?.firstOrNull { it.vendorId == "offer_id on purchasely console" }

Purchasely.purchase(activity, plan, offer, onSuccess = { plan ->
  Log.d("Purchasely", "Purchase success with ${plan?.name}")
}, onError = {
  Log.e("Purchasely", "Purchase error", it)
})
```
{% endtab %}

{% tab title="Java" %}
```java
Purchasely.plan(
        "plan_id on purchasely console",
        plyPlan -> {
            List<PLYPromoOffer> offers = plyPlan.getPromoOffers();
            PLYPromoOffer offer = null;
            
            // retrieve PLYPromoOffer from plan if found
            if(offers != null && offers.size() > 0) {
                for(int i = 0; i < offers.size(); i++) {
                    if(plyPlan.getPromoOffers().get(i).getVendorId().equals("offer_id on purchasely console")) {
                        offer = plyPlan.getPromoOffers().get(i);
                        break;
                    }
                }
            }
            
            // Purchase plan with offer
            Purchasely.purchase(
                activity, 
                plyPlan, 
                offer, 
                null, // set a content id if needed
                (Function1<PLYPlan, Unit>) plyPlan1 -> null, 
                (Function1<PLYError, Unit>) plyError -> null
            );
            
            return null;
        },
        throwable -> null
);
```
{% endtab %}

{% tab title="ReactNative" %}
```typescript
// Available soon
```
{% endtab %}

{% tab title="Flutter" %}
```dart
// Available soon
```
{% endtab %}
{% endtabs %}

## Retrieve the offer to purchase in observer mode

When you are using Purchasely in [paywallObserver](../quick-start-1/sdk-configuration/paywall-observer-mode.md) mode, you can retrieve the offer from our [paywall action interceptor](paywall-action-interceptor.md), sign it (iOS only) and do the purchase with your system



{% hint style="warning" %}
On iOS, Purchasely **anonymous user in lowercase** is required as **applicationUsername** with StoreKit1 or **appAccountToken** with StoreKit2\
Please look at sample code below for more details
{% endhint %}

{% tabs %}
{% tab title="Swift" %}
```swift
Purchasely.setPaywallActionsInterceptor { [weak self] (action, parameters, presentationInfos, proceed) in
	switch action {
		// Intercept the tap on purchase to display the terms and condition
		case .purchase:		
			// Grab the plan to purchase
			guard let plan = parameters?.plan, let appleProductId = plan.appleProductId else {
				proceed(false)
				return
			}
			
			let offer = parameters?.promoOffer
	
			// sign the offer
        		Purchasely.signPromotionalOffer(storeProductId: appleProductId,
        						storeOfferId: offer?.storeOfferId) { signature in
            		// Success completion
       		 	} failure: { error in
            		// Failure completion
        		}
				
			// Purchase with signature
			
			// Using StoreKit1
			purchaseUsingStoreKit1(plan) 
			// Using StoreKit2
			purchaseUsingStoreKit2(plan)
			
			// Finally close the process with Purchasely
			proceed(false)
		default:
			proceed(true)
	}
}

func purchaseUsingStoreKit1(_ plan: PLYPlan) {

            // First step: Get SKProduct using your own service
            
            // Example
            let request = SKProductsRequest(productIdentifiers: Set<String>([plan.appleProductId ?? ""]))
            request.delegate = <Your delegate> // Get Product in the `productsRequest(_ request: SKProductsRequest, didReceive response: SKProductsResponse)` method
            request.start()
            
            // Second Request payment
            guard SKPaymentQueue.canMakePayments() else {
                return nil
            }
            
            let payment = SKMutablePayment(product: product)
            
            payment.applicationUsername = Purchasely.anonymousUserId.lowercased() // lowercase anonymous user id is mandatory
            
            if let signature = promotionalOfferSignature, #available(iOS 12.2, macOS 10.14.4, tvOS 12.2, *) {
                let paymentDiscount = SKPaymentDiscount(identifier: signature.identifier,
                                                        keyIdentifier: signature.keyIdentifier,
                                                        nonce: signature.nonce,
                                                        signature: signature.signature,
                                                        timestamp: NSNumber(value: signature.timestamp))
                payment.paymentDiscount = paymentDiscount
            }
            
            SKPaymentQueue.default().add(payment)
}

func purchaseUsingStoreKit2(_ plan: PLYPlan) {
    if #available(iOS 15.0, *) {
                Purchasely.signPromotionalOffer(storeProductId: plan.appleProductId,
                                                storeOfferId: plan.promoOffers.first?.storeOfferId,
                                                success: { promoOfferSignature in
    
                    Task {
    
                        do {
                            let products = try await Product.products(for: ["storeProductId"])
                            var options: Set<Product.PurchaseOption> = [.simulatesAskToBuyInSandbox(<Bool: true for testing>)]
    
                            let userId = Purchasely.anonymousUserId.lowercased()
                            options.insert(.appAccountToken(userId))
    
                            if let decodedSignature = Data(base64Encoded: promoOfferSignature.signature) {
                                let offerOption:Product.PurchaseOption = .promotionalOffer(offerID: promoOfferSignature.identifier,
                                                                                           keyID: promoOfferSignature.keyIdentifier,
                                                                                           nonce: promoOfferSignature.nonce,
                                                                                           signature: decodedSignature,
                                                                                           timestamp: Int(promoOfferSignature.timestamp))
                                options.insert(offerOption)
                            }
    
                            if let product = products.first {
                                let purchaseResult = try await product.purchase(options: options)
                            }                        
                        }
                    }
                }, failure: { error in
    
                })
            } else {
                // Fallback on earlier versions
            }
    }
}
```
{% endtab %}

{% tab title="Objective-C" %}
```objectivec
[Purchasely setPaywallActionsInterceptor:^(enum PLYPresentationAction action, PLYPresentationActionParameters *parameters, PLYPresentationInfo *presentationInfos, void (^ proceed)(BOOL)) {
        switch (action) {
            // Intercept the tap on purchase to display the terms and condition
            case PLYPresentationActionPurchase:{
                // Grab the apple product id to purchase
                NSString *appleProductId = parameters.plan.appleProductId;
                NSString *appleOfferId = parameters.offer.storeOfferId;
                
                // Sign the offer with signPromotionalOffer method from Purchasely
            
                // TODO purchase with product id and signature
                break;
            }
            default:
                proceed(true);
                break;
        }
    }];
```
{% endtab %}

{% tab title="Kotlin" %}
```kotlin
Purchasely.setPaywallActionsInterceptor { info, action, parameters, processAction ->
    when(action) {
        PLYPresentationAction.PURCHASE -> {
            val plan = parameters?.plan
            val sku = plan?.store_product_id
            val offer = parameters?.offer
            val offerId = offer?.storeOfferId

            // TODO purchase with SKU and offer id
            
            // Finally close the process with Purchasely
            processAction(false)
        }
        else -> processAction(true)
    }
}
```
{% endtab %}

{% tab title="Java" %}
```java
Purchasely.setPaywallActionsInterceptor((info, action, parameters, listener) -> {
    switch (action) {
        case PURCHASE:
            if(parameters == null || parameters.plan == null) return
            
            String sku = parameters.plan.getStore_product_id();
            
            PLYPLan plan = parameters.plan
            String sku = plan.getStore_product_id();
            PLYOffer offer = parameters.offer
            String offerId = offer.getStore_offer_id();

            // TODO purchase with SKU and offer id
            
            // Finally close the process with Purchasely
            listener.processAction(false);
            break;
        default:
            listener.processAction(true);
    }
});
```
{% endtab %}

{% tab title="ReactNative" %}
```typescript
// Available soon
```
{% endtab %}

{% tab title="Flutter" %}
```dart
// Available soon
```
{% endtab %}
{% endtabs %}
