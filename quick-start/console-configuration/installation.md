# Creating a new application

## Log in to the console

Go to [Purchasely console](https://purchasely.io) with your credentials.

&#x20;                                              &#x20;

<figure><img src="../../.gitbook/assets/SCR-20230127-k46.png" alt=""><figcaption></figcaption></figure>

These credentials are provided to you by the Purchasely Team. If you want to have your credentials created, just contact us at [hello@purchasely.com](mailto:hello@purchasely.com)

## Creating a new App

To create a new app, click on the  **`Add new application`** in the drop-down menu in the top-left corner

<figure><img src="../../.gitbook/assets/SCR-20230127-kc7-2.png" alt=""><figcaption></figcaption></figure>

{% hint style="warning" %}
If you have 2 different environments (e.g.: staging & production), you should create 2 different **Applications** in the Purchasely Console and use 2 different **API keys**
{% endhint %}

{% hint style="info" %}
&#x20;We advise you to start creating a staging application first (i.e. a mobile application plugged into a staging environment) to perform your first tests.
{% endhint %}

This new application must be configured with a set of parameters among 3 different stages. All these parameters can be modified after the application has been created.

#### 1. Create a new application

<figure><img src="../../.gitbook/assets/SCR-20230127-kay.png" alt=""><figcaption></figcaption></figure>

The mandatory parameters are :

* **Name:** the name of the application as it will be displayed in the Purchasely Console.
* **The default language**:  this will define which language shall be used when the language on a user device is not supported by the application; ⚠️ This value can't be changed later.
* **Default Dashboard Currency**: this is the currency unit displayed in your Purchasely Dashboards.&#x20;
* **Default Integration Currency:** this currency unit is used to send price information to the Webhook and 3rd party integrations

#### 2. Plug it with the stores

<figure><img src="../../.gitbook/assets/image (48).png" alt=""><figcaption></figcaption></figure>

You can add up to 4 different stores. Step by step configuration of each store is explained below, in dedicated sections.

* [**Apple App Store**](installation.md#configuring-the-apple-app-store-parameters)
* [**Google Play Store**](installation.md#configuring-the-google-play-store-parameters)
* [**Huawei AppGallery**](installation.md#configuring-huawei-appgallery-parameters)
* [**Amazon App Store**](installation.md#configuring-amazon-app-store-parameters)

#### 3. Plug it with your backend

<figure><img src="../../.gitbook/assets/image (21).png" alt=""><figcaption></figcaption></figure>

In this section, you can plug the Purchasely Cloud Platform with your own backend through server-to-server integration. This will allow having your backend notified through a _webhook_ when a transaction event is received from the stores.

![Purchasely webhook illustration](<../../.gitbook/assets/webhook anim.gif>)

Fill in the `Client webhook URL` with the endpoint URL on your own backend where you want to receive the subscription events.



{% hint style="info" %}
If your `Client Webhook` is not ready when you make your configuration, we advise you to use the following value: [https://httpstat.us/200](https://httpstat.us/200)

This value will simulate a HTTP 200 response code allowing the Purchasely Cloud Platform to consider that the new subscription has been duly acknowledged by the Client Backend.
{% endhint %}

Every message send by Purchasely in the webhook is signed using a Client shared secret.&#x20;

Refer to [Webhook documentation](../../integrations/webhook-1/) to know more.



Receiving the transaction events allows to [manage user entitlements and access control.](../../integrations/webhook-1/managing-entitlements.md)

## Configuring the Apple App Store parameters

In order to connect your Apple App Store account with Purchasely, you have to provide the following parameters from the Apple App Store

1. [App bundle ID](installation.md#app-bundle-id)
2. [Apple ID](installation.md#apple-id)
3. [App Scheme](installation.md#app-scheme)
4. [Shared App Secret](installation.md#shared-app-secret)

<figure><img src="../../.gitbook/assets/image (69).png" alt=""><figcaption><p>Apple App Store Plug-in with Purchasely</p></figcaption></figure>

### App bundle id

{% hint style="info" %}
The Bundle ID is used by Purchasely Cloud Platform to validate that receipts are indeed coming from your app
{% endhint %}

**App Store:**

Get the value of the `Bundle ID` field in App Store Connect \
_App Store Connect > My Apps > \[YOUR APP] > General > App Information_

**Purchasely Console:**

The value of the `Bundle ID` should be reported in the field App Package in the Purchasely Console\
_Purchasely >  \[YOUR APPLICATION] > Settings > App Settings > Store Configuration >  Apple App Store_

<figure><img src="../../.gitbook/assets/image (43).png" alt=""><figcaption><p>Bundle ID and Apple ID</p></figcaption></figure>

### Apple ID

It is required for promo code deeplinks in the paywalls.

**App Store:**

Get the value of the `Apple ID` field in App Store Connect \
_App Store Connect > My Apps > \[YOUR APP] > General > App Information_

**Purchasely Console:**

The value of the `Apple ID` should be reported in the field App Package in the Purchasely Console\
_Purchasely > \[YOUR APPLICATION] > Settings > App Settings > Store Configuration >  Apple App Store_

### App Scheme

You can define the app scheme of your mobile application refer to these documents for instructions to do the same for [iOS](https://developer.apple.com/documentation/xcode/defining-a-custom-url-scheme-for-your-app) apps. It is a required value in order to use the paywall preview feature in Purchasely Console.

### Shared App Secret

{% hint style="info" %}
The Shared App Secret is used by Purchasely Cloud Platform and required to validate receipts for this specific app
{% endhint %}

<figure><img src="../../.gitbook/assets/SCR-20230127-kno.png" alt=""><figcaption></figcaption></figure>

**App Store:**

Get the value of the `Apple ID` field in App Store Connect \
_App Store Connect > My Apps > \[YOUR APP] > Subscriptions > App-Specific Shared Secret > Manage_

**Purchasely Console:**

The value of the `App-Specific Shared Secret` should be reported in the field App Package in the Purchasely Console\
_Purchasely > \[YOUR APPLICATION] > Settings > App Settings > Store Configuration >  Apple App Store_

### Server to Server notifications <a href="#server-to-server-notifications" id="server-to-server-notifications"></a>

The last field Server-to-server endpoint is not mandatory. It is used to activate the real-time server-to-server notifications coming from the App Store.&#x20;

Refer to [Server-to-server notifications documentation](../../stores-configuration/app-store.md) for more information.

## Configuring the Google Play Store parameters

In order to connect your Google Play Console account with Purchasely, you have to provide the following parameters from the Google Play Console&#x20;

1. [Android App Bundle ID](installation.md#android-app-bundle-id)
2. [App Scheme](installation.md#app-scheme-1)
3. [Access Key JSON](installation.md#acces-key-json)

<figure><img src="../../.gitbook/assets/image (8).png" alt=""><figcaption><p>Google Play Console Plug-in with Purchasely</p></figcaption></figure>

### Android App Bundle ID

{% hint style="info" %}
The Bundle ID is used by Purchasely Backend to validate that receipts are indeed coming from your app
{% endhint %}

<figure><img src="../../.gitbook/assets/image (2).png" alt=""><figcaption><p>Android App Bundle ID</p></figcaption></figure>

The value of the Package ID should be reported in the field `App bundle id` in your Purchasely console&#x20;

**Google Play Console :**

Get the value of the Package ID of your App in Googe Play Console\
_Google Play Console > All Apps > \[YOUR APP]_&#x20;

**Purchasely Console:**

The value of the `Apple ID` should be reported in the field App Package in the Purchasely Console\
_Purchasely > \[YOUR APPLICATION] > Settings > App Settings > Store Configuration > Play Store_

### App Scheme

You can define the app scheme of your mobile application refer to these documents for instructions to do the same for [Android](https://developer.android.com/training/app-links/deep-linking) apps. It is a required value in order to use the paywall preview feature in Purchasely Console.

### Access Key (JSON)

{% hint style="info" %}
This access key is mandatory to allow Purchasely Cloud Platform to decode Play Store receipts/token
{% endhint %}

This task involves two steps&#x20;

1. [**Creating Service Account**](installation.md#create-a-new-service-account)
2. [**Granting required access**](installation.md#grant-api-access-to-the-new-service-account)

#### Create a new Service Account

Create a dedicated Service Account under [Google Cloud Platform Console](https://console.cloud.google.com/) [https://console.cloud.google.com](https://console.cloud.google.com/) \
_Google Cloud Platform > IAM & admin > Service Account > Create a new Service Account_

{% hint style="danger" %}
Before creating the service account, make sure that the relevant Organisation is selected. The drop-down menu in the upper left corner of the screen shall match the Organisation in your Google Play Console
{% endhint %}

* Name your account `Purchasely` to be able to easily identify it later
* Give it the ID `purchasely`
* On the following screen, set the role to "Owner"
* On the following screen, create a key by clicking on the `+ Create a key` button
* Choose JSON format
* Fill the content of the field "Access key" with this JSON file

#### Grant API Access to the new Service Account

Grant access to the Service Account under the [Google Play Console](https://play.google.com/console/u/0/developers/api-access)\
_Google Play Console> API Access > \[PURCHASELY SERVICE ACCOUNT] > Grant authorization_

{% hint style="danger" %}
The Organisation should match the one you chose under the Google Cloud Platform console
{% endhint %}

**Complete those 3 steps**

Set "no expiration date"

**Tab: App permissions -** Select the application corresponding to the app bundle id

<figure><img src="../../.gitbook/assets/image (4).png" alt=""><figcaption><p>Service Account permission in Google Play Console</p></figcaption></figure>

**Tab: Account permissions -** Ensure the following permissions are selected :

* [x] View app information and download bulk reports
* [x] View financial data, orders, and cancellation survey responses
* [x] Manage orders and subscriptions

<figure><img src="../../.gitbook/assets/image (11).png" alt=""><figcaption><p>Service Account permission in Google Play Console</p></figcaption></figure>

### Server to Server notifications <a href="#server-to-server-notifications" id="server-to-server-notifications"></a>

We connect to Google Cloud Pub/Sub automatically for you by using your service account access. All you need to do is click on "Connect to Google" and follow the steps\


<figure><img src="https://561853519-files.gitbook.io/~/files/v0/b/gitbook-x-prod.appspot.com/o/spaces%2FGgUdOzhqa07uh7nB2iZA%2Fuploads%2FEUpNA3T0wR6ufAkYBDTZ%2FSCR-20220617-nee.png?alt=media&#x26;token=7c86522d-c2e3-4b5f-a398-7df567836305" alt=""><figcaption><p>Connect to Google from Purchasely</p></figcaption></figure>

## Configuring Huawei AppGallery parameters

<figure><img src="../../.gitbook/assets/image (5) (1).png" alt=""><figcaption></figcaption></figure>

### Huawei App Package ID

{% hint style="info" %}
The Package name is used by Purchasely Cloud Platform to validate the authenticity of the receipts.&#x20;
{% endhint %}

1. Open your [AppGallery Console](https://developer.huawei.com/consumer/en/console#/serviceCards/)
2. Go to: [_AppGallery Connect_](https://developer.huawei.com/consumer/en/service/josp/agc/index.html) _>_ [_My Apps_](https://developer.huawei.com/consumer/en/service/josp/agc/index.html#/myApp) _> \[YOUR APPLICATION]_
3. Get the value of the `Package name`

![](<../../.gitbook/assets/Screenshot 2021-01-05 at 11.40.26 copy.png>)

The value of the Package name should be reported in the field Huawei `App package id` in your Purchasely console&#x20;

### App ID

{% hint style="info" %}
The App ID is used by Purchasely Cloud Platform to validate the authenticity of the receipts.&#x20;
{% endhint %}

Same procedure as "App Package Id", with the `App ID` property which must be put under `App id` in the Purchasely Console (_Purchasely > Mobile Applications > \[YOUR APPLICATION] > Huawei configuration_)

![](<../../.gitbook/assets/Screenshot 2021-01-05 at 11.40.26 copy (1).png>)

### App secret

{% hint style="info" %}
The App secret is used by Purchasely Cloud Platform to validate the authenticity of the receipts.
{% endhint %}

Same procedure as "App Package Id", with the `App secret` property which must be put under `App secret` in the Purchasely Console (_Purchasely > Mobile Applications > \[YOUR APPLICATION] > Huawei configuration_)

![](<../../.gitbook/assets/Screenshot 2021-01-05 at 11.40.26 copy (2).png>)

### Public key

{% hint style="info" %}
The public key is used by Purchasely Cloud Platform to validate the authenticity of the receipts.
{% endhint %}

1. Open your [AppGallery Console](https://developer.huawei.com/consumer/en/console#/serviceCards/)
2. Go to: [_AppGallery Connect_](https://developer.huawei.com/consumer/en/service/josp/agc/index.html) _>_ [_My Apps_](https://developer.huawei.com/consumer/en/service/josp/agc/index.html#/myApp) _> \[YOUR APPLICATION]_
3. In the "All services" menu on top, search for "In-App Purchases" and click on it
4. Get the `Public key` property

![](<../../.gitbook/assets/Screenshot 2021-01-05 at 11.56.26 copy.png>)

1. Fill in this value under `"In-App Purchases" public key` in the Purchasely Console (_Purchasely > Mobile Applications > \[YOUR APPLICATION] > Huawei configuration_)

## Configuring Amazon App Store parameters



<figure><img src="../../.gitbook/assets/image (3) (2).png" alt=""><figcaption></figcaption></figure>

### App SKU&#x20;

{% hint style="info" %}
The Package name is used by Purchasely Cloud Platform to validate the authenticity of the receipts.&#x20;
{% endhint %}

1. Open the [Amazon App Store dashboard](https://developer.amazon.com/dashboard)
2. Select App List
3. Select your app
4. Get the value of the `App SKU`

![](<../../.gitbook/assets/Capture d’écran 2021-05-05 à 18.24.14 (1).png>)

The value of the `App SKU` should be reported in the field `Amazon App SKU` in your Purchasely console.

### Shared Key

You need to give us your Amazon App Store shared Key. You can find it [here](https://developer.amazon.com/settings/console/sdk/shared-key).
