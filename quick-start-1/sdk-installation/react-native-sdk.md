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
        compileSdkVersion = 31
        targetSdkVersion = 31
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

To add Google as a store, you can use NPM

```bash
npm install @purchasely/react-native-purchasely-google --save
```

{% hint style="info" %}
Our SDK integrates Google Play Billing Client version 4.1.0, you must not use with your project another dependency with an older version.
{% endhint %}

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

