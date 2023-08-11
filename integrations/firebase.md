# Firebase

Purchasely can send all your transactional events to Firebase through Google Analytics to enrich your users data. These events can then be used in Google Analytics, Firebase, Big Query...

{% hint style="info" %}
Read through [Google Analytics for Firebase documentation](https://firebase.google.com/docs/analytics) to setup your Firebase project with Google Analytics. **Google Analytics integration needs to be enabled** before continuing**.**
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

![](<../.gitbook/assets/image (68).png>)

![](<../.gitbook/assets/image (69) (1).png>)

For each platform, you will find your Firebase App ID in your Firebase Project settings:

![](<../.gitbook/assets/image (70) (1).png>)

### Retrieving API secrets

Go to your Firebase project _**Settings > Integration >** (Google Analytics) **Manage:**_

![](<../.gitbook/assets/image (71).png>)

Click on your linked Google Analytics account, to open Google Analytics settings:

![](<../.gitbook/assets/image (76).png>)

In the Google Analytics Admin section, make sure you have selected the correct project. Then click on _**Data Streams:**_

![](<../.gitbook/assets/image (75).png>)

Click on one of your apps (make sure they match the apps that you are configuring in Purchasely!):

![](<../.gitbook/assets/image (77).png>)

Go to the _**Additional settings**_ section, then click on _**Measurement Protocol API secrets**_ section:

![](<../.gitbook/assets/image (78).png>)

_**Review terms**_, then click on _**Create:**_

![](<../.gitbook/assets/image (79).png>)

Give an appropriate nickname to the API secret (e.g. "_Purchasely Platform_"), then click _**Create**_:

![](<../.gitbook/assets/image (80).png>)

You can finally copy the obtained _**Secret value**_ into Purchasely _**API Secret**_ for the relevant platform.

{% hint style="info" %}
You will need to repeat the procedure for each platform.
{% endhint %}

Don't forget to toggle the _**Integration Enabled**_ switch on the _**Account Parameters**_ page.

## Customising Server Event Names

If you want to, you can rename events sent to Google Analytics:

![](<../.gitbook/assets/image (81).png>)

{% hint style="info" %}
Event names must be 40 characters or fewer, may only contain alphanumeric characters and underscores, and must start with an alphabetic character. See Google Analytics documentation on [Limitations](https://developers.google.com/analytics/devguides/collection/protocol/ga4/sending-events?client\_type=firebase#limitations) for more info.
{% endhint %}
