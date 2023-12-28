---
description: Installing Stripe in Purchasely
---

# Stripe (beta)

Installation of Stripe in Purchase is performed in 4 steps

## I. Installing the Stripe App

Go to the Purchasely's app listing on [Stripe apps marketplace](https://marketplace.stripe.com/apps/purchasely)

<figure><img src="https://files.gitbook.com/v0/b/gitbook-x-prod.appspot.com/o/spaces%2FGgUdOzhqa07uh7nB2iZA%2Fuploads%2F9OB0hfejoh9qNlfL9kW2%2FStripe-app-listing-img1.png?alt=media&#x26;token=6f5f53e5-3684-4ac3-ae1c-592d3a6d1208" alt=""><figcaption><p>Stripe app market place listing</p></figcaption></figure>

If you have more than one Stripe account (for each application) then connect the account you want to associate with the application.

{% hint style="danger" %}
A Stripe application combines a Stripe account with only one Purchasely Application. If your Stripe account works with more than one Purchasely Application, please contact our support team via Intercom.

Read below on how to handle both Stripe "test" and "production" environments.
{% endhint %}



Click on install app.\
The list of authorizations required for the proper functioning of our application is then displayed.

<figure><img src="https://files.gitbook.com/v0/b/gitbook-x-prod.appspot.com/o/spaces%2FGgUdOzhqa07uh7nB2iZA%2Fuploads%2FaqmcfLds8WDfZNbJnQRV%2FStripe-app-listing-img2.png?alt=media&#x26;token=8fa35b14-7c4e-428b-977d-043378de97d0" alt=""><figcaption><p>Authorisation validation</p></figcaption></figure>

{% hint style="info" %}
If you have a question about the use of an authorization, contact our support team via Intercom.
{% endhint %}

Validate the authorizations requested

<figure><img src="https://files.gitbook.com/v0/b/gitbook-x-prod.appspot.com/o/spaces%2FGgUdOzhqa07uh7nB2iZA%2Fuploads%2FDTUTu7emWhyXa0UkMq1Y%2Fimage.png?alt=media&#x26;token=b6d0481a-f897-47dd-8517-1e372e1a8f54" alt=""><figcaption><p>Permission samples</p></figcaption></figure>

The installation is complete, you can proceed with the configuration.

<figure><img src="https://files.gitbook.com/v0/b/gitbook-x-prod.appspot.com/o/spaces%2FGgUdOzhqa07uh7nB2iZA%2Fuploads%2FBRnqdLHnzzBZ6EfjSF5Y%2FStripe-app-listing-img3.png?alt=media&#x26;token=f71bd7c3-eb3e-4991-b3bb-c1c65b0b1b88" alt=""><figcaption><p>Successful installation</p></figcaption></figure>

## II. Configuration of the Stripe app

Once the Stripe Purchasely app is installed you need to configure it.\
Go to the Stripe console in **Settings > installed apps > Purchasely**.

<figure><img src="https://files.gitbook.com/v0/b/gitbook-x-prod.appspot.com/o/spaces%2FGgUdOzhqa07uh7nB2iZA%2Fuploads%2Fgo605DOz4IGaUqjhpEBq%2Fimage.png?alt=media&#x26;token=1d0f94cf-2a9e-4c31-8fcd-5277c21c8515" alt=""><figcaption><p>Settings</p></figcaption></figure>

<figure><img src="https://files.gitbook.com/v0/b/gitbook-x-prod.appspot.com/o/spaces%2FGgUdOzhqa07uh7nB2iZA%2Fuploads%2FCRydkSiypIOIezQsszLP%2FStripe-app-settings-img2.png?alt=media&#x26;token=3b6f079e-dfb8-4314-8970-6cfb3379c081" alt=""><figcaption><p>Settings > installed apps</p></figcaption></figure>

### II.1. Associate with Purchasely

Once on the app configuration you need to associate it with your Purchasely account and app. To do this, start by clicking on "SIGN IN".

<figure><img src="https://files.gitbook.com/v0/b/gitbook-x-prod.appspot.com/o/spaces%2FGgUdOzhqa07uh7nB2iZA%2Fuploads%2F5bJa1ZMXy7hcDil2O8VX%2FStripe-app-settings-img3.png?alt=media&#x26;token=7eda314a-993e-4842-abfc-322044cb039d" alt=""><figcaption><p>Settings > installed apps > Purchasely</p></figcaption></figure>

Select the Purchasely app you wish to link your Stripe account to.

Click on "NEXT".

{% hint style="info" %}
Once the app is installed, it needs to be configured both in the "test" and "production" Stripe environments for purchases to be tracked in those environments accordingly.



The following configurations are supported :

* 2 Purchasely applications
  * My Purchasely App (staging) <-> Stripe Account (test mode)
  * My Purchasely App (production) <-> Stripe Account (production mode)
* 1 Purchasely application
  * My Purchasely App <-> Stripe Account (test + production mode)
{% endhint %}

<div align="left">

<figure><img src="https://files.gitbook.com/v0/b/gitbook-x-prod.appspot.com/o/spaces%2FGgUdOzhqa07uh7nB2iZA%2Fuploads%2FAXw02wzHnZXVq0w4JEKA%2FStripe-app-app-selection1.png?alt=media&#x26;token=cd11f6d6-0d36-44fb-ab9e-72cc2757508b" alt=""><figcaption><p>App Selection</p></figcaption></figure>

 

<figure><img src="https://files.gitbook.com/v0/b/gitbook-x-prod.appspot.com/o/spaces%2FGgUdOzhqa07uh7nB2iZA%2Fuploads%2FtCkec64T0eTi3Cj6t2MZ%2FStripe-app-app-selection2.png?alt=media&#x26;token=4b98e8ab-59eb-4d19-8c45-7a36a9159665" alt=""><figcaption><p>App Selected</p></figcaption></figure>

</div>

### II.2 Confirm Stripe app link with your mobile application

Once you have selected the application, you will be redirected to Stripe to finalise the configuration by clicking on "CONFIRM".

<figure><img src="https://files.gitbook.com/v0/b/gitbook-x-prod.appspot.com/o/spaces%2FGgUdOzhqa07uh7nB2iZA%2Fuploads%2FlkNm7AMP1oFSmFdoqcz4%2FStripe-app-confirmation-screen.png?alt=media&#x26;token=c1dc2acd-e3d5-4499-aa60-f33c19a35f84" alt=""><figcaption><p>confirmation screen</p></figcaption></figure>

The app will appear as below when properly configured in Purchasely and Stripe.

<figure><img src="https://files.gitbook.com/v0/b/gitbook-x-prod.appspot.com/o/spaces%2FGgUdOzhqa07uh7nB2iZA%2Fuploads%2FxFBdiKp9rPdcdcBSBqD1%2FStripe-app-confirmed2.png?alt=media&#x26;token=63433cbd-7d62-41e2-8ccb-191172ea6346" alt=""><figcaption><p>Purchasely App Settings</p></figcaption></figure>

<figure><img src="https://files.gitbook.com/v0/b/gitbook-x-prod.appspot.com/o/spaces%2FGgUdOzhqa07uh7nB2iZA%2Fuploads%2FEcznI1NdCo7HT08PQWFC%2FStripe-app-confirmed1.png?alt=media&#x26;token=47540579-9587-4002-b516-646c0634314b" alt=""><figcaption><p>Stripe App settings - configured</p></figcaption></figure>

## III. Configuration of plans

In order for Purchasely to associate Stripe products, they must be defined in the plans. Also you must associate each **Pricing** Stripe to a Purchasely Plan otherwise the purchase will not be taken into account by Purchasely.

From the Stripe console, copy the API ID (price) ...

<figure><img src="https://files.gitbook.com/v0/b/gitbook-x-prod.appspot.com/o/spaces%2FGgUdOzhqa07uh7nB2iZA%2Fuploads%2FoVKtKulziIHeXDlnHjtO%2Fimage.png?alt=media&#x26;token=2a216b47-21ce-44d3-884d-dbf87255328c" alt=""><figcaption></figcaption></figure>

Then paste this ID into the corresponding plan:

<figure><img src="../.gitbook/assets/image (2).png" alt=""><figcaption></figcaption></figure>

{% hint style="info" %}
Purchasely allows you to associate more than one Stripe Price to one given Purchasely plan, to handle cases where there exists several Stripe Prices tied to the same "plan" but with a different currency.
{% endhint %}

{% hint style="warning" %}
Do not associate more than one Stripe Price to one given Purchasely plan if the Stripe Prices have different periodicicy, or different level of entitlement.

For such use cases, create another plan.
{% endhint %}

## IV. Associating Stripe subscriptions to Purchasely

This last step allows Purchasely to retrieve and associate a purchase with a user.

[The principle is the same as for the migration of an existing subscriber](https://docs.purchasely.com/faq/migration-guides/migrate-from-an-existing-setup#2.-send-us-every-new-subscription-created-on-you-side-with-a-call-on-our-api)

To send us this information, simply call our API and provide it with

* `stripe_object_id`: the Stripe subscription ID
* `stripe_price_id`: the Stripe Price Id for this subscription (ON STRIPE)
* `user_id`: the user\_id associated with the purchase, the same as you enter in [the SDK during configuration.](https://docs.purchasely.com/quick-start-1/sdk-configuration/config-appendices/set-user-id)
* `stripe_object_type`: the type of Stripe object sent, currently we only accept `subscription`

```bash
curl \
  --request POST \
  -i \
  -H "Content-Type: application/json" \
  -H "X-API-KEY:{{YOUR_API_KEY}}" \
  -H "X-PLATFORM-TYPE:STRIPE" \
  --data '{"stripe_object_id":"{{STRIPE_SUBSCRIPTION_ID}}","stripe_price_id":"{{STRIPE_PRICE_ID_FOR_THIS_SUBSCRIPTION}}", "user_id":"{{SAME_ID_AS_IN_SDK_CONFIGURATION}}", "stripe_object_type":"subscription"}' \
  https://s2s.purchasely.io/receipts
```

Example request:

```bash
curl \
  --request POST \
  -i \
  -H "Content-Type: application/json" \
  -H "X-API-KEY:AAAAAAAA-BBBB-CCCC-DDDD-EEEEEEEEEEEE" \
  -H "X-PLATFORM-TYPE:STRIPE" \
  --data '{"stripe_object_id":"sub_1MluxqJaEiB9UwXB34gmtzCB","stripe_price_id":"price_1MbKJHJaEiB9UwXBPt0fFq4O", "user_id":"jdo-cus_Msq9YfCiFkFzVx", "stripe_object_type":"subscription"}' \
  https://s2s.purchasely.io/receipts
```

{% hint style="info" %}
You can export a list of your Stripe's subscriptions with their associated prices from your Stripe Stripe dashboard.\
On Stripe go under:\
Billing > Subscription > Export\
Select: Custom and keep only "ID" and "Plan"
{% endhint %}

<figure><img src="https://files.gitbook.com/v0/b/gitbook-x-prod.appspot.com/o/spaces%2FGgUdOzhqa07uh7nB2iZA%2Fuploads%2FSFsiBLJ1eEBvxgMeQ3iS%2FStripe%20export.png?alt=media&#x26;token=e637dfd5-c508-4c64-aaca-22c5983e2441" alt=""><figcaption></figcaption></figure>
