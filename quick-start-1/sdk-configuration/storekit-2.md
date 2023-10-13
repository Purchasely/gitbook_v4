---
description: You can opt-in to use StoreKit2 for Apple In-App Purchases
---

# StoreKit 2

Purchasely, by default, uses StoreKit 2 to initiate and process purchases on iOS 15+. However, if you wish to only use StoreKit 1, you can set that parameter with Purchasely.start() and our SDK will use StoreKit 1 only\
\
Our team will assist you in enabling StoreKit 2 for your application, ensuring a seamless purchasing experience for your users on the latest iOS devices.\
Users with devices below minimum requirements will continue to uses StoreKit 1 under the hood.

## Configuration

Configuring StoreKit 2 with App Store Connect to allow Purchasely to verify transactions requires a [few steps](https://developer.apple.com/documentation/appstoreserverapi/creating\_api\_keys\_to\_use\_with\_the\_app\_store\_server\_api). Once completed, you can update your application settings in Purchasely console. This configuration is essential for using StoreKit 2 with Purchasely SDK.

#### **Enable App Store Connect API access**

* Sign in to [App Store Connect](https://appstoreconnect.apple.com/access/api/subs)
* Go to "Users and Access"
* Select "Keys" under the "In-App Purchase" section
* Click on the "+" button to generate a new API key
* Choose a name for the key and click "Generate"
* Download the API key file (`.p8`), and note the **Key ID** and **Issuer ID**. Keep the file secure, as you won't be able to download it again

<figure><img src="https://files.gitbook.com/v0/b/gitbook-x-prod.appspot.com/o/spaces%2FGgUdOzhqa07uh7nB2iZA%2Fuploads%2FuzmdiMgxXbvsSrj7F58m%2FSCR-20230403-nktk.png?alt=media&#x26;token=8e370356-52f1-4913-8a78-702d441ace65" alt=""><figcaption></figcaption></figure>

#### Setup StoreKit2 on Purchasely Console

* Connect to [Purchasely Console](https://console.purchasely.io/)
* Go to "App Settings"
* Select Apple App Store" under the "Store configuration" section
* Fill in the **Private Key Id** from the key you generated
* Upload your Private Key File (`.p8`)
* Fill your **Issuer Id**
* Click on **Save** in the top right corner

<figure><img src="https://files.gitbook.com/v0/b/gitbook-x-prod.appspot.com/o/spaces%2FGgUdOzhqa07uh7nB2iZA%2Fuploads%2FGziQy6NPfXfCjK3doltM%2FSCR-20230403-nefu.png?alt=media&#x26;token=fa220406-60e9-4b51-bf9d-cd5e70535913" alt=""><figcaption></figcaption></figure>

## Implementation

The only change you need to make is if you are in observer mode, if you are in full mode you're all set!

**Handling purchases and restorations (Paywall Observer mode)**

If you are using the Purchasely SDK in [Paywall Observer mode](paywall-observer-mode.md), it is essential to call `Purchasely.syncPurchase()` once a purchase or restoration has been processed. This allows the SDK to be aware of new transactions and ensures accurate data reporting for A/B tests and paywall conversion.

After processing a purchase or restoration, call

**Swift**

```swift
try await Purchasely.syncPurchase(for: "apple product id")
```

**Objective-C**

```objectivec
[Purchasely syncPurchaseFor:@"apple-product-id" completionHandler:^(NSError * _Nullable error) {
    // Handle Error.    
}];
```

## Requirements

#### Purchasely SDK

* iOS: 4.0.1
* Flutter: 4.0.1
* React Native: 4.0.1
* Unity: 4.1.0
* Cordova: 4.1.0

#### **OS version** (built with Xcode 14 or later)

* iOS 15
* iPadOS 15
* macOS 12
* tvOS 15
* watchOS 8
