# Piano analytics(ex AT Internet)

## Why combine AT Internet and Purchasely?

### Pre-requisites

The minimal version of the Purchasely SDK supporting this integration is 3.3.0. If the Purchasely SDK integrated with your app is under the minimal version, please update it.

The AT Internet SDK also needs to be integrated inside the app.

### Subscription events

### General overview

[AT Internet](https://developers.atinternet-solutions.com/home/) is a is a leading product analytics software company, they work to gives product ans marketing teams the ability to gain insights into how to best acquire, convert, and retain their users across web and mobile platforms.

This integration will allow you to get all the available Purchasely events to AT Internet and get a better and deeper understanding of your subscription business and customer behavior.

Purchasely provides a unified dataset to track the subscription events for all stores. These events are generated by the Purchasely Backend and can be sent to AT Internet.

![](https://files.gitbook.com/v0/b/gitbook-x-prod.appspot.com/o/spaces%2FGgUdOzhqa07uh7nB2iZA%2Fuploads%2FIGbKOcnjyMtg3BD1xWwD%2Fimage.png?alt=media\&token=bfe861aa-ee54-4bbf-8e89-c12b1e89fb27)

Subscription events generated by Purchasely will be sent to AT Internet using a server-to-server integration.

#### Events

The following events are the main ones that can be sent to AT Internet by Purchasely. See the full list [here](../analytics/events/webhook-events/subscription-events.md).

| Event                           | Description                                                                                                              |
| ------------------------------- | ------------------------------------------------------------------------------------------------------------------------ |
| SUBSCRIPTION\_STARTED           | Sent when the user purchased a product wether it is the start of a trial or a regular purchase of a consumable product.  |
| SUBSCRIPTION\_RENEWED           | Sent when a subscription renews                                                                                          |
| SUBSCRIPTION\_EXPIRED           | Sent when the subscription actually ends                                                                                 |
| SUBSCRIPTION\_REACTIVATED       | Sent when an expired subscription is reactivated. This event is particularly useful for win-back & retargeting campaigns |
| SUBSCRIPTION\_REFUNDED\_REVOKED | Sent when the subscription actually ends                                                                                 |
| RENEWAL\_DISABLED               | Sent when the user deactivates the renewal of a subscription wether it is in trial period or not.                        |
| RENEWAL\_ENABLED                | Sent when the user reactivates                                                                                           |
| TRIAL\_STARTED                  | Sent when a trial starts                                                                                                 |
| TRIAL\_CONVERTED                | Sent when a user converts from a free trial to a normal paid-period                                                      |
| TRIAL\_NOT\_CONVERTED           | Sent when a user finishes it's trial period without renewing to a paid-period                                            |

The names of events sent to AT Internet can be overriden when setting up the integration.

## **Integrating Purchasely with AT Internet**

The integration requires 2 steps:

1. Associate the user to events by providing the `AT Internet Client id` to the Purchasely SDK
2. Activate the AT Internet integration in the Purchasely Console

### 1. Associating users to events

See the [AT Internet Documentation](https://developers.atinternet-solutions.com/piano-analytics/) for more information

{% tabs %}
{% tab title="Swift" %}
```swift
Purchasely.setAttribute(.atInternetIdClient, value: ATInternet.sharedInstance.defaultTracker.getUserId())
```
{% endtab %}

{% tab title="Kotlin" %}
```kotlin
ATInternet.getInstance().defaultTracker.getUserId {
    if(it != null) Purchasely.setAttribute(Attribute.AT_INTERNET_ID_CLIENT, it)
}
```
{% endtab %}

{% tab title="Java" %}
```java
String atInternetUserId = ATInternet.getInstance().getDefaultTracker().getUserId();
if(atInternetUserId != null) {
  Purchasely.setAttribute(Attribute.AT_INTERNET_ID_CLIENT, atInternetUserId);
}
```
{% endtab %}

{% tab title="React Native" %}
```jsx
Purchasely.setAttribute(Attributes.AT_INTERNET_ID_CLIENT, atInternetUserId);
```
{% endtab %}
{% endtabs %}

***

### 2. Activating the AT Internet integration

The activation requires 6 steps:

1. Retrieving your `Site ID` from the AT Internet Dashboard
2. Setting up a new Javascript Tag Composer Configuration in the AT Internet Dashboard
3. Retrieving your `Collect Server` from the AT Internet Dashboard
4. Picking a `Collect Path` (ie "_subscription_")
5. Configuring the AT Internet to accept the event names you will be using
6. Enabling the AT Internet integration in the Purchasely Console

#### a. Retrieve your `Site ID` from the AT Internet Dashboard

1. Log into your [AT Internet Dashboard](https://apps.atinternet-solutions.com/login/)
2. You will find your `Site ID` next to your site's name

![](https://files.gitbook.com/v0/b/gitbook-x-prod.appspot.com/o/spaces%2FGgUdOzhqa07uh7nB2iZA%2Fuploads%2Fgit-blob-10feb3861051ef4f44742a81952d24ac03080942%2FScreenshot%202022-07-14%20at%2000.26.02.png?alt=media)

#### b. Set up a new Javascript Tag Composer Configuration in the AT Internet Dashboard

1. Access the [Tag Composer](https://collection.atinternet-solutions.com/#/tagcomposer/configurations/list) section of your AT Internet Dashboard
2. Create a new Configuration
3. Pick a name
4. On the next screen, choose the "Websites" environment
5. On the next screen, deselect all plugins
6. On the next screen, deselect all options and create your Configuration

#### c. Retrieving your `Collect Server` from the AT Internet Dashboard

1. Access the [Tag Composer](https://collection.atinternet-solutions.com/#/tagcomposer/configurations/list) section of your AT Internet Dashboard
2. Open your newly created configuration
3. On the next screen, click on the button to deploy your Configuration
4. On the sites list, select your website and continue
5. On the settings screen, retrieve and write down your Configuration's SSL Collect Server

![](../.gitbook/assets/Screenshot%202022-07-14%20at%2000.41.59.png.png)

#### d. Pick a collect path to later use when configuration your AT Internet integration in the Purchasely Console

#### e. Configure the AT Internet to accept the event names you will be using

1. Access the [Data Models Events](https://management.atinternet-solutions.com/#/data-model/events/list) configuration section of your AT Internet Dashboard
2. Create and configure your custom events

{% hint style="info" %}
Events using any other name than AT Internet's default ones or the ones set up here will be ignored by AT Internet.
{% endhint %}

#### f. Enable the AT Internet integration in the Purchasely Console

1. Go in the "External integrations" section, and open the edition form for AT Internet:

![](https://files.gitbook.com/v0/b/gitbook-x-prod.appspot.com/o/spaces%2FGgUdOzhqa07uh7nB2iZA%2Fuploads%2Fgit-blob-2a0124de182f9469878b194a53d8e7d4ece23ce1%2FScreenshot%202022-07-08%20at%2000.10.34.png?alt=media)

2\. Enable the integration

3\. Set your AT Internet Collection Domains

4\. Set your AT Internet Collect Path

5\. Set your AT Internet Site Id

![](https://files.gitbook.com/v0/b/gitbook-x-prod.appspot.com/o/spaces%2FGgUdOzhqa07uh7nB2iZA%2Fuploads%2Fgit-blob-eb3e152574aef1b66cbf1e5a70718d98ab985d2c%2FScreenshot%202022-07-14%20at%2000.50.00.png?alt=media)

6\. Enable the events you want to be sent to AT Internet

7\. (Optional) Override the names of the events that will be sent to AT Internet

8\. Save

![](https://files.gitbook.com/v0/b/gitbook-x-prod.appspot.com/o/spaces%2FGgUdOzhqa07uh7nB2iZA%2Fuploads%2Fgit-blob-1b5a19836dcb78a0fd3090a6186d156da2a621d9%2FScreenshot%202022-07-14%20at%2000.50.24.png?alt=media)

{% hint style="info" %}
Events using any other name than AT Internet's default ones or the ones set up here will be ignored by AT Internet.
{% endhint %}

### Testing your integration

To test your integration, you can perform a set of in-app purchases in a Sandbox environment (eg: TestFlight for the App Store) and verify your events are received in the [AT Internet dashboard](https://auth.piano.io/u/login).
