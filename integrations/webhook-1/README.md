---
description: >-
  This section describes everything you need to know about the Webhook, which
  allows to connect your backend with the Purchasely Cloud Platform.
---

# Webhook

## About the Webhook

### What is the Webhook?

Purchasely Webhook is a unified interface that streams transaction & subscription **Events** to the Developer Backend.

This interface has 2 purposes :

1. Notifying the client backend each time an event occurs on a subscriber
2. Unifying the **Events** from each store into a common language, to simplify much the integration for the client backend

In other words, the main advantage of the Webhook is that it avoids to the client backend team, to develop and maintain a specific interface for each Mobile Application Store and to have to validate the native receipts.&#x20;

The Webhook is used in 2 main use-cases :

* when a new in-app purchase is performed by a user inside the mobile application.
* when any life-cycle event happens on a subscription&#x20;

### Acknowledging messages

When an endpoint URL has been configured in the Purchasely Console, the Purchasely Cloud Platform expects this endpoint to acknowledge the good reception of every event sent.

In the case an event is not properly acknowledged (for instance if the developer backend was down when the event was originally sent), the Purchasely Cloud Platform integrates a retry policy, until the event is acknowledge by the backend.

The acknowledgement consists in replying to the event posted with a HTTP 200 code. If any other HTTP code is sent (or no code at all in the case of a timeout), the Purchasely Cloud Platform will consider that the event must be sent again.

{% hint style="warning" %}
Please note that our webhooks enforce a 10-second read timeout. To avoid any disruptions or errors, ensure that your system responds with an HTTP 200 status code within this 10-second window.
{% endhint %}



### Possible architectures for managing entitlements and access control

Purchasely offers 2 ways for entitling users to access the premium contents or features unlocked by the purchase of their subscriptions. Entitlements can be managed:

1. By the Developer Backend (more secure)
2. Through the Purchasely SDK at the app level (less secure)

![Entitlements managed by the Developer Backend](<../../.gitbook/assets/anim 1.gif>) ![Entitlements managed through the SDK by the app](<../../.gitbook/assets/anim 2.gif>)



Unless your app is very small, we strongly advise you to manage the entitlements at the backend level.



## About the Transaction & Subscription events

### How is an Event composed?

An **Event** is a JSON payload which is posted by the Purchasely Cloud Platform, directly to the endpoint URL configured in the Console.

The **Events** always have the same structure. They have a [set of attributes that are described here](../../analytics/events/webhook-events/attributes.md)

### When are events sent on the Webhook?

There are 2 cases where an event is sent on the Webhook:

1. When a transaction occurs inside the app (in-app purchase or in-app subscription)
2. When a particular event happens in a subscription lifecycle. The main **Events** are:
   * &#x20;the renewing of a subscription
   * the cancellation of the auto-renewing a subscription
   * the expiration of a subscription
   * a refund
   * the billing failure of a subscription

Most of these **Events** are coming directly from the stores and rely on the Server-to-server notifications that Purchasely Cloud Platform receives.

The full list of events is available [here](../../analytics/events/webhook-events/subscription-events.md).

### Visualizing the messages sent on the Webhook

{% hint style="info" %}
At Purchasely, we often use the free service [webhook.site](https://webhook.site). This service allows you to generate an endpoint URL (which you can plug to the Purchasely Cloud Platform using the Purchasely Console), and offers a web interface matching that endpoint showing you all the messages received by the endpoint.
{% endhint %}

![Webhook.site screenshot](<../../.gitbook/assets/image (30) (1).png>)

