---
description: Guide for integrating Purchasely SDK inside your Cordova app
---

# Cordova SDK

## Installation

### **NPM**

You can use [NPM](https://www.npmjs.com/package/@purchasely/cordova-plugin-purchasely) to install **Purchasely** by running this command in your project:

```bash
cordova plugin add @purchasely/cordova-plugin-purchasely
```

Don't forget to change the minimum OS versions to match Purchasely requirements (iOS 11 / Android 21)

### iOS Integration

You must have an iOS platform for your project. If it is not the case, you can simply add it with a cordova command :

```markup
cordova platform add ios
```

### Android Integration

#### 1. Enable AndroidX

AndroidX is mandatory to display our paywalls, it is [deactivated by default](https://cordova.apache.org/announcements/2020/06/29/cordova-android-9.0.0.html). You can enable it easily by editing your config.xml file.

```markup
<platform name="android">
    <allow-intent href="market:*" />
    <preference name="AndroidXEnabled" value="true" />
</platform>
```

#### 2. Add Android platform

You must have an Android platform for your project. If it is not the case, you can simply add it with a cordova command :

```markup
cordova platform add android
```

#### 3. Add Google dependency

To use Google for in-app purchases, you must install **Purchasely-Google** by running this command in your project:

```bash
cordova plugin add @purchasely/cordova-plugin-puchasely-google
```

#### Other Stores dependencies

Our Cordova SDK does not contains other stores to avoid unnecessary integrations. You have to specifically declare which stores you want. To add Android dependencies to your project, you need to create a file `platforms/android/app/build-extras.gradle`

Then you add the stores dependencies you wish to use.

{% tabs %}
{% tab title="build-extras.gradle" %}
```bash
dependencies {
    //Amazon App Store
    implementation 'io.purchasely:amazon:3.3.2'
    
    //Huawei Mobile Services
    implementation 'io.purchasely:huawei-services:3.3.2'
}
```
{% endtab %}
{% endtabs %}

#### Huawei Integration

Huawei needs a little more configuration to work properly, to integrate Huawei Mobile Services, please refer to our Android documentation : [https://docs.purchasely.com/quick-start/sdk-installation/quick-start#huawei-mobile-services](https://docs.purchasely.com/quick-start/sdk-installation/quick-start#huawei-mobile-services)
