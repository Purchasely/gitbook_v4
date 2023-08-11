---
description: >-
  Batch is a Customer Engagement Platform that allows marketers to communicate
  with their users and engage with them by creating powerful engagement journeys
  and workflows.
---

# Batch

## Why combine Batch and Purchasely?

[Batch](https://batch.com) rests on 3 pillars:

* A comprehensive and real-time end user view
* A set of multi-channel communication and engagement tools
* The possibility to measure and analyse the results of the engagement campaigns

Plugging Purchasely and Batch has 3 advantages:

* [Purchasely transactional events](../analytics/events/webhook-events/) can be sent to Batch to complete the end user view with all the transactional data generated by the app stores
* Communication and engagement automations can then be configured based on these transactional events.
* Engagement messages can be linked to Purchasely paywalls using [deeplink automations](../advanced-features/deeplinks-and-automations.md) to close the loop and manage conversion, upsell or retention campaigns.



### General overview

![](<../.gitbook/assets/batch animated.gif>)

### Sample automation

![](<../.gitbook/assets/Archi diagrams.001.jpeg>)

## Integrating Purchasely with Batch

{% hint style="warning" %}
The integration of Purchasely and Batch requires the activation of the [Trigger Events API](https://doc.batch.com/api/trigger-events-api/track-events) on Batch side. Please contact directly your Batch account manager to activate the access to this feature.
{% endhint %}

The integration requires 4 steps:

1. Activate the Batch integration in the Purchasely Console
2. Enable the events forwarded to Batch in the Purchasely Console
3. Enable the events in the Batch Dashboard
4. Associate Batch Installation Ids to events



#### 1. Activate the Batch integration in the Purchasely Console

In the Purchasely Console, go to Integration > Batch and enable the integration.

![](<../.gitbook/assets/image (172).png>)

Then carry the Android / iOS Live / Rest API keys forward from your Batch Dashboard to the Purchasely Console.

These parameters can be found in your Batch Dashboard in the following location:\
Batch Dashboard > You \[iOS / Android] app > Settings > General > API Keys

![Screenshot of the Batch Dashboard (January 2022)](<../.gitbook/assets/image (195).png>)

#### 2. Enable the events forwarded to Batch in the Purchasely Console

In the Purchasely Console, under the Server Events thumbnail, you can choose with subscription events must be forwarded to Batch.

![](<../.gitbook/assets/image (154).png>)

(Optional) Events names can be override to match with your tacking plan.

{% hint style="info" %}
Front events triggered by the Purchasely SDK cannot be forwarded to Batch directly from the Purchasely Console. This has to be done at the app level by intercepting the [SDK events](../analytics/events/sdk-events/) and forwarding them to the Batch SDK.&#x20;
{% endhint %}

#### 3. Enable the events in the Batch Dashboard

Once events have been enabled on Purchasely's side, they must also be enabled on Batch's side as well.

To do so, navigate to the following location:\
Batch Dashboard > You \[iOS / Android] app > Settings > Custom Data > User events

![](<../.gitbook/assets/image (114).png>)

{% hint style="info" %}
Note: Purchasely events must have been received at least once on Batch's side to appear in this list of User events
{% endhint %}

### 4. Associate Batch Installation Ids to events

{% tabs %}
{% tab title="Swift" %}
```swift
if let installationId = BatchUser.installationID() {
			Purchasely.setAttribute(.batchInstallationId, value: installationId)
}
```
{% endtab %}

{% tab title="Kotlin" %}
```kotlin
Purchasely.setAttribute(Attribute.BATCH_INSTALLATION_ID, Batch.User.getInstallationID())
```
{% endtab %}

{% tab title="Java" %}
```java
Purchasely.setAttribute(Attribute.BATCH_INSTALLATION_ID, Batch.User.getInstallationID());
```
{% endtab %}

{% tab title="React Native" %}
```javascript
Purchasely.setAttribute(Attributes.BATCH_INSTALLATION_ID,  BatchUser.getInstallationID());
```
{% endtab %}

{% tab title="Cordova" %}
```javascript
Purchasely.setAttribute(Purchasely.Attribute.BATCH_INSTALLATION_ID, batch.user.getInstallationID());
```
{% endtab %}

{% tab title="Flutter" %}
```dart
Purchasely.setAttribute(PLYAttribute.batch_installation_id, BatchUser.instance.installationID());
```
{% endtab %}
{% endtabs %}

## Setting-up your first automation

To configure your automations navigate to the following location in Batch:

Batch > Campaigns

![](<../.gitbook/assets/image (130).png>)

To create an automation triggered by a Purchasely event, choose Trigger in the block When.&#x20;

![](<../.gitbook/assets/image (110).png>)

All the events that have already been received at least once by Batch will appear in the list.

You can even add a filter (set of condition) on the [event attributes](../analytics/events/webhook-events/attributes.md).

![](<../.gitbook/assets/image (146).png>)

You can then define the message that will be sent and the deeplink associated to it.

![](<../.gitbook/assets/image (116).png>)

If the deeplink matches a pattern handled by Purchasely, it will allow you to:

* display a specific paywall (for upsell and retention flow)
* display a cancellation survey
* notify users that their credit card has expired and send them to their devices settings

More information in the section [deeplinks automations](../advanced-features/deeplinks-and-automations.md).



For more information about Batch Dashboard and campaigns configuration, please refer directly to [Batch Documentation](https://doc.batch.com/).