---
description: Guide for integrating Purchasely SDK inside your Android app
---

# Android SDK

{% hint style="info" %}
Our SDK is compiled with Java 17. You can still use Java 8 for your project but your gradle deamon must use Java 17 to compile your project.

You can use Android Studio to change the default java version of gradle by going to Preferences -> Build, Execution, Deployment -> Build Tools -> Gradle and select Java 17 as Gradle JDK
{% endhint %}

## **Maven**

Make sure you are fetching your dependencies from Maven Central.

```bash
allprojects {
    repositories {
        google()
        mavenCentral()
    }
}
```

{% hint style="info" %}
jcenter() is also a valid repository but will be discontinued February 1st 2022.\
[https://developer.android.com/studio/build/jcenter-migration](https://developer.android.com/studio/build/jcenter-migration)
{% endhint %}

Add the core sdk to your dependencies

```bash
implementation 'io.purchasely:core:4.1.0'
```

The core SDK does not contains a billing store, you need to add the ones you want to use as a dependency otherwise your users won't be able to make purchases.

### Google Play Billing

```bash
implementation 'io.purchasely:google-play:4.1.0'
```

{% hint style="info" %}
Our SDK integrates Google Play Billing Client version 5.2.1, you must not use with your project another dependency with an older version.
{% endhint %}

### Huawei Mobile Services

Huawei requires you to provide the SHA-1 of your certificate and add their configuration file to your project (agconnect-services.json). Please refer to their documentation : [https://developer.huawei.com/consumer/en/doc/development/HMSCore-Guides-V5/config-agc-0000001050033072-V5](https://developer.huawei.com)

To integrate Huawei Mobile Services, you need to add dependencies to huawei repository and plug-in as referred in their documentation : [https://developer.huawei.com/consumer/en/doc/development/HMSCore-Guides-V5/integrating-sdk-0000001050035023-V5](https://developer.huawei.com/consumer/en/doc/development/HMSCore-Guides-V5/integrating-sdk-0000001050035023-V5)

{% tabs %}
{% tab title="project/build.gradle" %}
```bash
// Edit file android/build.gradle
buildscript {
    repositories {
        maven {url 'https://developer.huawei.com/repo/'}
    }
    dependencies {
        classpath 'com.huawei.agconnect:agcp:1.6.0.300'
    }
}

allprojects {
    repositories {
        //Huawei only
        maven {url 'https://developer.huawei.com/repo/'}
    }
}
```
{% endtab %}
{% endtabs %}

{% tabs %}
{% tab title="project/app/build.gradle" %}
```bash
//Add this line after android plugin
apply plugin: 'com.huawei.agconnect'

dependencies {
    //Add this line to integrate Huawei Mobile Services with Purchasely
    implementation 'io.purchasely:huawei-services:4.0.0'
}

```
{% endtab %}
{% endtabs %}

### Amazon App Store

```bash
implementation 'io.purchasely:amazon:4.1.0'
```

### Video Player

If you have videos in your paywall, you must provide a video player to play them.\
Since version 3.1.0, Purchasely core dependency does not include a video player to avoid dependency conflicts.

\
We provide a new player dependency which will be detected automatically by our SDK.\
`implementation 'io.purchasely:player:4.1.0'`\
\
You can also provide your own player view, more information in our [help center](https://help.purchasely.com/en/articles/5963004-display-a-video-on-android-devices)
