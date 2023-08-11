---
description: How to make Lottie animations work on your paywalls
---

# Lottie animations

Lightweight, vectorial with a huge community, [Lottie](https://lottiefiles.com) has become the leading technology to create animations in applications.

From now on you can add Lottie animations in Purchasely paywalls but it requires a little setup from your mobile developers.

{% hint style="info" %}
This Lottie option is being added template by template. Don't hesitate to contact support to request a specific addition where you need it.
{% endhint %}

### Why is there any setup?

At Purchasely we value having a lightweight SDK (< 2Mb) with no external dependencies.

Thus, when we wanted to offer Lottie animations we didn't want to add it as a direct dependency of our SDK. This would have multiplied by 5 the weight of our SDK and users who didn't use it would have had to have to pay that extra cost.

This is how we ended up doing a weak dependency.

### How does it work?

At runtime, our SDKs will be looking at Lottie's presence and will add the view to its paywall. It will be able to configure the aspect (fill / fit) and wether or not the animation repeats.

As Purchasely SDK will be calling methods it needed a stable interface to avoid calling a method that wouldn't exist (and crash). This is why we created an interface to Lottie that will remain stable and will embed calls to Lottie framework so that we don't need to rely on them.

You will need to add this interface to your code and Lottie SDK in your dependencies.

## Configuration

### iOS

1. First you need to [add the Lottie dependency](https://github.com/airbnb/lottie-ios#installing-lottie) (if not already in your app)
2. Then add the following Swift class to your code

{% file src="../.gitbook/assets/PLYLottieBridge.swift" %}

**🎉 You are all set!**

### Android

{% hint style="warning" %}
Lottie integration requires our SDK version 3.6.0 minimum
{% endhint %}

* First you need to [add the Lottie dependency](http://airbnb.io/lottie/#/android) (if not already in your app)
* Then implements `PLYLottieInterface`, you can copy the following sample `AnimationView` class
*   Finally add it to Purchasely with&#x20;

    ```
    Purchasely.lottieView = { AnimationView(context) }
    ```

{% file src="../.gitbook/assets/AnimationView.kt" %}
