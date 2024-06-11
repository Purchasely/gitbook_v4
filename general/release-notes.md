---
description: Updates about our SDK
---

# Release notes

You can also find changelog specific to SDK technology in their GitHub repository

* [iOS](https://github.com/Purchasely/Purchasely-iOS/releases)
* [Android](https://github.com/Purchasely/Purchasely-Android/releases)
* [React Native](https://github.com/Purchasely/Purchasely-ReactNative/releases)
* [Flutter](https://github.com/Purchasely/Purchasely-Flutter/releases)
* [Unity](https://github.com/Purchasely/Unity-Package)
* [Cordova](https://github.com/Purchasely/Purchasely-Cordova/releases)

## 4.4

:warning: Only available with our iOS and Android SDK.\
React Native, Flutter, Cordova and Unity will be updated by the end of June 2024

**Use** [**version 4.4.1**](https://github.com/Purchasely/Purchasely-iOS/releases/tag/4.4.1) **with iOS** for a fix with the new close button

## Audience Targeting

Enhanced audience segmentation capabilities with the addition of purchase history-based targeting.

## UI Enhancements

* Introduced a customizable header button, offering an alternative to the standard close button.
* Replaced the outdated PLYUIListener with the new PLYUIHandler for improved UI event management.

## Subscription Management

Introduced the `userSubscriptionsHistory` method to enable access to users' expired subscription data.\
**Note**: This feature relies on the Purchasely platform and will provide accurate results only if Purchasely has records of the user account's subscription history.

## Android Specific Updates

### Google Play Billing v6

Updated to Google Play Billing version 6.2.1. This version is mandatory to release your Android application on Google Play Store starting September 1st for new apps and November 1st for existing applications.

### Google Store Country

The upgrade to version 6 now allows the inclusion of the Google account store country as a selectable attribute for audience targeting. The `Store Country` attribute now works seamlessly with both Apple and Google accounts as long as your application includes this version of Purchasely SDK.

## 4.3

### 🕒 User Centric Countdowns

Countdowns tailored to individual users have been implemented, enabling personalized timers based on user attributes.\
Example: users may have 24 hours to subscribe to an offer following their initial subscription.

### Improvements and Optimizations

Numerous enhancements and optimizations are being implemented to elevate the user experience.

## 4.2

:warning: Important: To avoid issues specially in paywallObserver mode, we now require to set explicitely the StoreKit version you want to use\
[Purchasely.start(storekitSettings: .storeKit1)](https://docs.purchasely.com/faq/migration-guides/sdk/migrate-to-sdk-v4.0.0#initialization-update)

🌙 Native Dark Mode Support for Presentations

Dark mode support has been implemented for screens & paywalls, automatically adapting to the user’s system settings for an improved viewing comfort. In the Console, you can now define 2 color sets (light & dark) for the same paywall.

Developers can override the default setting with `Purchasely.setThemeMode(.dark)` or `Purchasely.setThemeMode(.light)`, enabling more control over the app’s appearance and accommodating user preferences

#### 🔍 Augmented Session User Attributes

Additional attributes have been added to track user session activity.

These attributes provide detailed insights into user engagement with the app, like session frequency, interaction with paywalls, and purchase activities.

This level of detail aids in fine-tuning user engagement strategies and understanding user behavior patterns more accurately

#### 🏷 Tags System Extended to All Labels

The tags system has been expanded to include all label types, allowing for dynamic display of pricing, introductory offers or promotional offers for any plan any where in the paywalls (an not only in the buttons). This update gives more flexibility in UI customization and dynamic content presentation.

### Improvements and Optimizations

**🔄 New `BATCH_CUSTOM_USER_ID` Attribute for External Integrations**: Enhances data syncing with external systems.

### iOS

🔧 **Setting a StoreKit version is now mandatory** You must know explicitly set a StoreKit setting on SDK initialization `Purchasely.start(withAPIKey: "API_KEY", storekitSettings: .storeKit2)` or `Purchasely.start(withAPIKey: "API_KEY", storekitSettings: .storeKit1)`

### Android

* **🛠️ Refined Purchasely View Lifecycle**: Optimized for use in tabbed Fragment navigation, ensuring smoother transitions and better user experience.-
* **🖋️ Custom Font Error Handling**: Eliminated error messages related to missing custom fonts in the `res/resources` folder, streamlining the setup process.
* **👁 Enhanced `UIListener` Interface**: The addition of `getActivity()` method facilitates easier view creation by providing the necessary activity context.

## 4.1.0

🚨 Important: This SDK version uses StoreKit 2 by default. [Read the documentation](https://docs.purchasely.com/quick-start-1/sdk-configuration/storekit-2) for more information. You can still use StoreKit 1 by changing the configuration with [Purchasely.start(storekitSettings: .storeKit1)](https://docs.purchasely.com/faq/migration-guides/sdk/migrate-to-sdk-v4.0.0#initialization-update)

**This version includes the following features and improvements:**

1. **Timer Tags:** Timer tags have been added to all fields of the paywall with a specific date. This feature allows you to set timers in various formats throughout your paywalls, promoting specific offers for a limited time. For instance, you can set a countdown to the end of Black Friday, and the timer will continuously display the time remaining until that date.
2. **Metadata for Your Own Paywall:** Utilizing the "Your Own Paywall" template feature, you can now customize your paywalls with _Purchasely_ technology, including tags. This customization feature enables you to update your paywalls dynamically using variables, known as metadata. This flexibility allows for the seamless integration of client-specific paywalls and _Purchasely_ paywalls within the same application, providing similar benefits.
3. **Minor Improvements:** Additionally, this version includes numerous minor enhancements and refinements to enhance the overall user experience.

### Android

**Kotlin**: Downgraded to 1.7.21 to be compatible with Kotlin 1.6.21

## 4.0.3

### iOS

**🚨 Important**: This SDK version uses StoreKit 2 by default. You **MUST** send the credentials for us to access Apple's API. [Read the documentation here](https://docs.purchasely.com/quick-start-1/sdk-configuration/storekit-2).

**🚧 Important**: Documentation for this release is in progress and will be available in early September. Some methods and properties have undergone changes. Detailed information will follow soon.

**New public methods**

* New method allowing integrators to ask our SDK to sign a promotional offer for them.
* New method to directly purchase a product with a promotional offer

**StoreKit**

* Added fallback to StoreKit1 in case StoreKit2 is not properly initialized in our console
* Improved StoreKit 2 introductory offers eligibility check
* Added StoreKit 2 promotional offers specific errors

**Minor fixes**

* Added missing gesture handling preventing presentationClosed event to be triggered
* Improved network errors handling
* We have resolved an issue where an alert would erroneously appear when an error occurred during the fetchPresentation process
* We have addressed a bug affecting the purchase action while using the SDK in Observer mode

## 4.0.0

### iOS

{% hint style="danger" %}
Please use version 4.0.3 on iOS, see release notes above
{% endhint %}

**🚨 Important**: This SDK version uses StoreKit 2 by default. You **MUST** send the credentials for us to access Apple's API. [Read the documentation here](https://docs.purchasely.com/quick-start-1/sdk-configuration/storekit-2).

**🚧 Important**: Documentation for this release is in progress and will be available in early September. Some methods and properties have undergone changes. Detailed information will follow soon.

In this release, we’ve introduced a more efficient, asynchronous method for fetching the eligibility status of plans. Optimizations

**Promo Offers**

* New Feature: Excitingly, we’re introducing support for [promotional offers](../advanced-features/promotional-offers.md)

**Eligibility Management**

* Streamlined and restructured for products, providing a more coherent and optimized experience.

**Public Interface Updates**

* Cleaned up by removing any outdated methods.
* Several methods have been renamed and refactored for clarity and better usage.

### Android

**🚧 Important**: Please look at our [migration guide](https://docs.purchasely.com/v/4.0.0/faq/migration-guides/sdk/migrate-to-sdk-v4.0.0) to use version 4 of our SDK. We have made a few changes in our public interface, the most important one being the removal of Fragment to display a Purchasely paywall

#### Google Play Billing v5 Integration

* **Version**: Purchasely SDK 4.0.0 now integrates with Google Play Billing v5 (5.2.1). This ensures you have access to the comprehensive features introduced in the latest version of Google's in-app subscriptions.
* **Action Required**: Review your plans on the Purchasely console to confirm the presence of a `basePlan` identifier.

#### Promo Offers (Google only)

* **New Feature**: Excitingly, we're introducing support for [promotional offers](../advanced-features/promotional-offers.md), known as `developer determined offers`, on the Google Play Console.
* **Action Required**: When setting up your `developer determined offers` in the Google Play Console, make sure to tag them as "**ignore-offer**". This ensures that the Purchasely SDK doesn't automatically apply them to all your paywalls. Instead, they'll be used exclusively where you've specified.

#### Build Configuration Update

* **Android Gradle Plugin**: Updated to 8.1.0
* **Kotlin**: Upgraded to 1.8.10
* **Compile SDK**: Now on version 33
