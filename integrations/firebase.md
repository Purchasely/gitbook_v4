# Firebase

Purchasely can send all your transactional events to Firebase through Google Analytics to enrich your users data. These events can then be used in Google Analytics, Firebase, Big Query...

{% hint style="info" %}
Read through [Google Analytics for Firebase documentation](https://firebase.google.com/docs/analytics) to setup your Firebase project with Google Analytics. **Google Analytics integration needs to be enabled** before continuing\*\*.\*\*
{% endhint %}

{% hint style="warning" %}
This integration is to be considered as Beta because Google's API Measurement Protocol, used to push events from our servers, is not yet finalised.
{% endhint %}

## Events

The following events are an example of what will be sent. You can find the full list of events [here](../analytics/events/webhook-events/subscription-events.md).\
You can set the event name of your choice in the console.

| Event                     | Description                                                                                                             |
| ------------------------- | ----------------------------------------------------------------------------------------------------------------------- |
| `SUBSCRIPTION_STARTED`    | Sent when the user purchased a product wether it is the start of a trial or a regular purchase of a consumable product. |
| `RENEWAL_DISABLED`        | Sent when the user deactivates the renewal of a subscription wether it is in trial period or not.                       |
| `RENEWAL_ENABLED`         | Sent when the user reactivates                                                                                          |
| `SUBSCRIPTION_TERMINATED` | Sent when the subscription actually ends                                                                                |
| `SUBSCRIPTION_RENEWED`    | Sent when a subscription renews                                                                                         |
| `TRIAL_STARTED`           | Sent when a trial starts                                                                                                |
| `TRIAL_CONVERTED`         | Sent when a user converts from a free trial to a normal paid-period                                                     |
| `TRIAL_NOT_CONVERTED`     | Sent when a user finishes it's trial period without renewing to a paid-period                                           |

## Associate your users

In order to associate those events back to your users, you will need to configure the Purchasely SDK to give us the `firebaseAppInstanceId` value:

{% tabs %}
{% tab title="Swift" %}
```swift

if let firebaseAppInstanceId = Analytics.appInstanceID() {
	Purchasely.setAttribute(.firebaseAppInstanceId, value: firebaseAppInstanceId)
}
```
{% endtab %}

{% tab title="Kotlin" %}
```kotlin
FirebaseAnalytics.getInstance(applicationContext).appInstanceId.addOnSuccessListener {
    Purchasely.setAttribute(Attribute.FIREBASE_APP_INSTANCE_ID, it)
}
```
{% endtab %}

{% tab title="Java" %}
```java
FirebaseAnalytics.getInstance(getApplicationContext()).getAppInstanceId().addOnSuccessListener(id -> Purchasely.setAttribute(Attribute.FIREBASE_APP_INSTANCE_ID, id));
```
{% endtab %}

{% tab title="React Native" %}
```javascript
/*
 Reference : https://rnfirebase.io/analytics/usage#app-instance-id
*/

import analytics from '@react-native-firebase/analytics';

async function getInstanceId() {
  const id = await analytics().getAppInstanceId();
  id && Purchasely.setAttribute(Attributes.FIREBASE_APP_INSTANCE_ID, id);
}
```
{% endtab %}

{% tab title="Cordova" %}
```javascript
// Add plugin firebase-x to your project
// https://ionicframework.com/docs/native/firebase-x

//Retrieve the Firebase App Instance Id and forward it to Purchasely
FirebasePlugin.getId(function(appInstanceId) {
    Purchasely.setAttribute(Purchasely.Attribute.FIREBASE_APP_INSTANCE_ID, appInstanceId);
}, function(error) {
    console.error(error);
});
```
{% endtab %}
{% endtabs %}

{% hint style="info" %}
You can always give your custom User ID to Analytics if you need more detailed metrics, as detailed in [Set a User ID](https://firebase.google.com/docs/analytics/userid) documentation. But make sure it matches the **`vendor_id`** you give to Purchasely to avoid discrepancies.
{% endhint %}

## Configure the integration in the Purchasely Console

Go in the "External integrations" section, and open the edition form for Firebase:

![](https://files.gitbook.com/v0/b/gitbook-legacy-files/o/assets%2F-MHAzdlUVqKyZvwTnNIE%2F-MX7ErI23u2HnavK6KyA%2F-MX7GgM91-R8mWsRhV1D%2Fimage.png?alt=media\&token=02973993-e4ab-4fb4-8312-c90072cca4b3)

![](https://files.gitbook.com/v0/b/gitbook-legacy-files/o/assets%2F-MHAzdlUVqKyZvwTnNIE%2F-MX7ErI23u2HnavK6KyA%2F-MX7GxCqk5Ux8yITYopB%2Fimage.png?alt=media\&token=0d925314-6b23-4a3a-889c-4a6b1d662fb0)

For each platform, you will find your Firebase App ID in your Firebase Project settings:

![](https://files.gitbook.com/v0/b/gitbook-legacy-files/o/assets%2F-MHAzdlUVqKyZvwTnNIE%2F-MX7ErI23u2HnavK6KyA%2F-MX7Hqr\_smhS9lIGbBnr%2Fimage.png?alt=media\&token=3190ff02-1db7-4a7c-b194-6538c9699d03)

### Retrieving API secrets

Go to your Firebase project _**Settings > Integration >** (Google Analytics) **Manage:**_

![](https://files.gitbook.com/v0/b/gitbook-legacy-files/o/assets%2F-MHAzdlUVqKyZvwTnNIE%2F-MX7MfsJFFoGUP\_BoEm1%2F-MX7OjfDxlpX0\_nSitBK%2Fimage.png?alt=media\&token=48a2d3cf-1ea4-4ddb-80f1-f66a1c77c5f4)

Click on your linked Google Analytics account, to open Google Analytics settings:

![](https://files.gitbook.com/v0/b/gitbook-legacy-files/o/assets%2F-MHAzdlUVqKyZvwTnNIE%2F-MX7MfsJFFoGUP\_BoEm1%2F-MX7QRSo6TKIwMFrPMKV%2Fimage.png?alt=media\&token=4b4328a5-0f8c-45dd-aabe-0b108ee9fb1c)

In the Google Analytics Admin section, make sure you have selected the correct project. Then click on _**Data Streams:**_

![](https://files.gitbook.com/v0/b/gitbook-legacy-files/o/assets%2F-MHAzdlUVqKyZvwTnNIE%2F-MX7MfsJFFoGUP\_BoEm1%2F-MX7QGQ7hgVm0IISeSAs%2Fimage.png?alt=media\&token=c088f09f-3358-4bd2-93e8-ffd0eefc398a)

Click on one of your apps (make sure they match the apps that you are configuring in Purchasely!):

![](https://files.gitbook.com/v0/b/gitbook-legacy-files/o/assets%2F-MHAzdlUVqKyZvwTnNIE%2F-MX7MfsJFFoGUP\_BoEm1%2F-MX7RY\_xJzk9GzIgRpV3%2Fimage.png?alt=media\&token=e6734a5e-07b6-4e76-9be9-5947c0e256dd)

Go to the _**Additional settings**_ section, then click on _**Measurement Protocol API secrets**_ section:

![](https://files.gitbook.com/v0/b/gitbook-legacy-files/o/assets%2F-MHAzdlUVqKyZvwTnNIE%2F-MX7RvPkewJBbO4jTA\_N%2F-MX7SP0bDaUiwBT5gq99%2Fimage.png?alt=media\&token=99636a5d-ecee-4ff5-9cdc-1b62afdacccc)

_**Review terms**_, then click on _**Create:**_

![](https://files.gitbook.com/v0/b/gitbook-legacy-files/o/assets%2F-MHAzdlUVqKyZvwTnNIE%2F-MX7RvPkewJBbO4jTA\_N%2F-MX7Skay6yMXVwTnIn7u%2Fimage.png?alt=media\&token=0cb3869b-c742-4136-9906-e2b8cd28693b)

Give an appropriate nickname to the API secret (e.g. "_Purchasely Platform_"), then click _**Create**_:

![](https://files.gitbook.com/v0/b/gitbook-legacy-files/o/assets%2F-MHAzdlUVqKyZvwTnNIE%2F-MX7RvPkewJBbO4jTA\_N%2F-MX7TFHTQPKIKfausdA6%2Fimage.png?alt=media\&token=323ab2c9-86d9-45b2-bc3e-7df5ea11ba68)

You can finally copy the obtained _**Secret value**_ into Purchasely _**API Secret**_ for the relevant platform.

{% hint style="info" %}
You will need to repeat the procedure for each platform.
{% endhint %}

Don't forget to toggle the _**Integration Enabled**_ switch on the _**Account Parameters**_ page.

## Customising Server Event Names

If you want to, you can rename events sent to Google Analytics:

![](https://files.gitbook.com/v0/b/gitbook-legacy-files/o/assets%2F-MHAzdlUVqKyZvwTnNIE%2F-MX7UU66c8Wg7s5y1ldD%2F-MX7Wi98HXpC37Kcqek4%2Fimage.png?alt=media\&token=8b34ca8d-f619-41ce-9856-2239f69cfe20)

{% hint style="info" %}
Event names must be 40 characters or fewer, may only contain alphanumeric characters and underscores, and must start with an alphabetic character. See Google Analytics documentation on [Limitations](https://developers.google.com/analytics/devguides/collection/protocol/ga4/sending-events?client\_type=firebase#limitations) for more info.
{% endhint %}
