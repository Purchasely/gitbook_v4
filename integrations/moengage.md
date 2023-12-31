# MoEngage

## Why combine MoEngage and Purchasely?

### Pre-requisites

The minimal version of the Purchasely SDK supporting this integration is 3.6.0. If the Purchasely SDK integrated in your app is under the minimal version, please update it.

The MoEngage SDK also needs to be integrated inside the app.

### Subscription events

### General overview

[MoEngage](https://www.moengage.com) is a leading Customer Engagement Platform.

This integration will allow you to get all the available Purchasely events to MoEngage and get a better and deeper understanding of your subscription business and customer behavior.

Purchasely provides a unified dataset to track the subscription events for all stores. These events are generated by the Purchasely Backend and can be sent to MoEngage.

![](<../.gitbook/assets/image (150) (1).png>)

Subscription events generated by Purchasely will be sent to MoEngage using a server-to-server integration. As a result, you will be able to see all the subscription events in your MoEngage Dashboard and map them with your acquisition campaigns.

#### Events

The following events are the main ones that can be sent to MoEngage by Purchasely. See the full list [here](onesignal.md#subscription-events).

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

The names of events sent to MoEngage can be overriden when setting up the integration.

## **Integrating Purchasely with MoEngage**

The integration requires 2 steps:

1 - **Associate the user to events** by providing the `MoEngage Unique Id` to the Purchasely SDK

Swift

{% code overflow="wrap" fullWidth="true" %}
```swift
Purchasely.setAttribute(.moEngageUnqueId, value: "your moEngage Unique Id")
```
{% endcode %}

Kotlin

```kotlin
Purchasely.setAttribute(Attribute.MOENGAGE_UNIQUE_ID, "Your unique id")
```

2 - **Activate the MoEngage integration** in the Purchasely Console

### 1. Associating users to events

See the [MoEngage Documentation](https://developers.moengage.com) for more information

### 2. Activating the MoEngage integration

The activation requires ${integration\_setup\_activation\_steps\_count} steps:

1. Retrieving your MoEngage APP\_ID from MoEngage's dashboard
2. Retrieving your MoEngage DATA API ID from MoEngage's dashboard
3. Retrieving your MoEngage DATA API KEY from MoEngage's dashboard
4. Enabling the MoEngage integration in the Purchasely Console

#### a. Retrieve your MoEngage APP ID from MoEngage's dashboard

1. The APP\_ID for your MoEngage account is available on the MoEngage Dashboard in Settings > App Settings > General Settings > Account Settings > APP ID.
2. Write down your APP ID

#### b. Retrieve your MoEngage DATA API ID from MoEngage's dashboard

1. The APP\_ID for your MoEngage account is available on the MoEngage Dashboard in Settings > App Settings > General Settings > Data API settings > DATA API ID
2. Write down your DATA API ID

#### c. Retrieve your MoEngage DATA API ID from MoEngage's dashboard

1. The APP\_ID for your MoEngage account is available on the MoEngage Dashboard inSettings > App Settings > General Settings > Data API settings > DATA API KEY
2. Write down your DATA API KEY

#### d. Enabling the MoEngage integration in the Purchasely Console

1. Go in the "External integrations" section, and open the edition form for MoEngage:

![](<../.gitbook/assets/Screenshot 2023-05-25 at 16.12.48.png>)

2\. Enable the integration

3\. Set your MoEngage APP\_ID

4\. Set your MoEngage DATA API ID

5\. Set your MoEngage DATA API KEY

![](<../.gitbook/assets/Screenshot 2023-05-25 at 16.13.10.png>)

5\. Enable the events you want to be sent to MoEngage

6\. (Optional) Override the names of the events that will be sent to MoEngage

![](<../.gitbook/assets/Screenshot 2023-05-25 at 16.13.32.png>)

7\. Enable the user properties you want to be sent to MoEngage

8\. (Optional) Override the names of the user properties that will be sent to MoEngage

![](<../.gitbook/assets/Screenshot 2023-05-25 at 16.15.18.png>)

9\. Save

### Testing your integration

To test your integration, you can perform a set of in-app purchases in a Sandbox environment (eg: TestFlight for the App Store) and verify your events are received in the MoEngage dashboard [https://www.moengage.com](https://www.moengage.com).&#x20;
