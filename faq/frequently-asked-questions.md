# Frequently Asked Questions

## 🍏 Why do I have some receipts coming up on app launch?

Each time a subscription is renewed, Apple presents the renewal receipts to the app. As our servers are linked to Apple by Server-to-Server notifications, we will already know about that renewal but in some cases that receipt is necessary:

* Ask-to-buy confirmation
* PDS2 confirmation&#x20;

In these cases Apple presents the original receipt validated outside of the app while the app starts (or immidiately if the app was in background). We use it to associate the purchase to the user.

## 🍏 I receive the following errors in the console "Couldn't fetch products.  No App Store product could be found. You will not be able to perform purchases. Error: productNotFound."

This error means the the application couldn't grab the products from Apple's servers. This error might occur on iOS14 simulator but shouldn't on your device. Here are some elements to check to solve that issue:

* In App Store Connect, check that your "Paid Applications contract" was signed and didn't expire
* Check that the requested product has the same id in App Store Connect and Purchasely
* Check that you defined a price for the product and that this product was made available in the storefront / country where your user is.
* Check that your app bundle identifier is the one you associated your In-App Purchases to in App Store Connect
* Check that you associated the In-App Purchase capability in Xcode

## 🤖 When I try to purchase on my android I get an error "**The item you were attempting to purchase could not be found"**

Some questions and things to test:

* Is your app published?
* Are you a registered tester of your app in Google Play Store?
* Is the product available in the country of the user?

If your app is not published, only testers will be able to make purchases.

## 🍏 What should I do to make sure PSD2 regulation changes will work?

Apple announced the [deployment of PSD2](https://developer.apple.com/support/psd2/) regulation to In-App Purchases and Subscriptions. The impact can be massive and lead to purchases not beaing handled

\
The good news is that **if you use Purchasely you already are supporting PSD2**. If you [initialize the SDK correctly](../quick-start-1/sdk-installation/ios-sdk.md#initialising-the-sdk) in the `didFinishLaunchingWithOptions` you are ready. Easy right?\
If you need to refresh anything in your app when the purchase is made, listen to the events `inAppRenewed` and `inAppPurchased` to get notified when the transaction was processed.

You might need to see it to believe it, in that case you can test the same kind of workflow by doing a ask-to-buy purchase on your app. This is the same kind of workflow with a purchase being validated from outside the app.

## Is it possible to have double purchases of the same product?

If your customer purchased a product on another system (like your own Web site), we won't be able to do anything. You should remove the purchase buttons and inhibit the presentation of paywalls.

For every purchase made on mobile with Purchasely we protect you from unwanted double purchase.

If you attempt to purchase the **same plan** (monthly) of the same product on the **same** **platform** (App Store, Play Store …) the store will notify you that you already purchased and you won't be charged.

If you try to purchase a **different plan** of the same product on the **same platform**, you will be upgraded or downgraded to the new plan as long as your products are in the same [Subscription group](../quick-start-1/console-configuration/create-your-products/app-store.md#about-subscription-groups). Subscription groups don't exist on the Google Play Store but Purchasely SDK will be cancelling the previous one and starting the new one respecting the [migration policies](../quick-start-1/console-configuration/create-your-products/products-and-plans.md#about-migrations-policies).

If you try to purchase a plan of the **same product** on a **different platform** our SDK will protect unwanted double purchase by displaying an alert to validate the purchase. If the user validates, he will have the same subscription twice so when the purchase is validated we explain him how to cancel the subscription.

![This is how Purchasely protects your users from unwanted double subscriptions.](<../.gitbook/assets/Capture d’écran 2021-01-05 à 22.52.39.png>)

## What happens when an anonymous user signs in?

When an anonymous user signs in (when you call the `setUserId` method in the SDK), all the purchases and history are transfered to the provided user.

If priori to the authentication, the provided user already had subscriptions he will gather the new ones even if this causes duplicates.

If the users disconnects, the device will be anonymous again and the anonymous user won't have any active subscriptions as they were transfered. The user can get them back by making a restore of its transactions.

## 🍏 How can I cancel a sandbox subscription on iOS ?

If you want to cancel a subscription in the sandbox environment you can do thta from the App Store settings.

![](<../.gitbook/assets/image\_d\_\_\_ios (1).png>)

