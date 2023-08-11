---
description: Guide for integrating Purchasely SDK inside your Flutter application
---

# Flutter SDK

## Installation

### **Flutter Pub.Dev**

You can use [pub.dev](https://pub.dev/packages/purchasely\_flutter/install) to install **Purchasely** by running this command in your project:

```bash
flutter pub add purchasely_flutter
```

### Android Integration

#### Google Play Billing

To add Google as a store, you can use our plugin

```bash
flutter pub add purchasely_google
```

{% hint style="info" %}
Our SDK integrates Google Play Billing Client version 4.1.0, you must not use with your project another dependency with an older version.
{% endhint %}

#### Video Player

On Android devices we use [Google Exoplayer](https://github.com/google/ExoPlayer) to display videos but you may be also using a video sdk in your project that will have a dependency conflict with our version of Exoplayer. To avoid this, we do not provide a video player for Android in our core dependency. \
\
If you are concerned about a potential conflict, please refer to this [article](https://help.purchasely.io/en/articles/5963004-displaying-a-video-on-android-devices)\
If you are not concerned about such conflict, the simplest way to display videos on paywalls is to use our plugin

```bash
flutter pub add purchasely_android_player
```

#### Other Stores dependencies

Our Flutter SDK does not contains other stores to avoid unnecessary integrations. You have to specifically declare which stores you want. To add our stores dependencies to your project, you just need to add them to the `app/build.gradle` file of your android folder in your project.

{% tabs %}
{% tab title="build.gradle" %}
```bash
dependencies {
    //Amazon App Store
    implementation 'io.purchasely:amazon:3.7.2'
    
    //Huawei Mobile Services
    implementation 'io.purchasely:huawei-services:3.7.2'
}
```
{% endtab %}
{% endtabs %}

#### Huawei Integration

Huawei needs a little more configuration to work properly, to integrate Huawei Mobile Services, please refer to our Android documentation : [https://docs.purchasely.com/quick-start/sdk-installation/quick-start#huawei-mobile-services](https://docs.purchasely.com/quick-start/sdk-installation/quick-start#huawei-mobile-services)
