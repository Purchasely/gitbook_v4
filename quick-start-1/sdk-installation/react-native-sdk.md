---
description: Guide for integrating Purchasely SDK inside your React Native app
---

# React Native SDK

## Installation

### **NPM**

You can use [NPM](https://www.npmjs.com/package/react-native-purchasely) to install **Purchasely**

```bash
npm install react-native-purchasely --save
```

Don't forget to change the minimum OS versions to match Purchasely requirements (iOS 11 / Android 21)

{% hint style="warning" %}
For Android, no store is included by default, you have to add the ones you wish to use, please see below
{% endhint %}

{% tabs %}
{% tab title="iOS" %}
```bash
// Podfile

...

platform :ios, '11.0'

...
```
{% endtab %}

{% tab title="Android" %}
```bash
// Edit file android/build.gradle
buildscript {
    ext {
        minSdkVersion = 21 //min version must not be below 21
        compileSdkVersion = 33
        targetSdkVersion = 33
    }
}

allprojects {
    repositories {
        mavenCentral()
    }
}
```
{% endtab %}
{% endtabs %}

### Google Play Billing

Google is not provided by default as you have a choice on Android\
To add Google as a store, you can use our NPM dependency

```bash
npm install @purchasely/react-native-purchasely-google --save
```

{% hint style="warning" %}
This dependency version **must always match** the `react-native-purchasely` version\
Be very careful to always update both at the same time
{% endhint %}

### Android Video Player

If you have videos in your paywall, you must provide a video player to play them.\
Since version 3.1.0, Purchasely core dependency does not include a video player **for Android** to avoid dependency conflicts.\
\
We provide a new player dependency which will be detected automatically by our SDK.

```batch
npm install @purchasely/react-native-purchasely-android-player --save
```

You can also provide your own player view, more information in our [help center](https://help.purchasely.com/en/articles/5963004-display-a-video-on-android-devices)

### Huawei Mobile Services

To add Huawei as a store, you can use NPM

```bash
npm install @purchasely/react-native-purchasely-huawei --save
```

### Amazon In-App Purchases

To add Amazon as a store, you can use NPM

```bash
npm install @purchasely/react-native-purchasely-amazon --save
```
