---
description: Display paywalls and manage in-app transactions
---

# Full mode

### When to use this mode?

In the Full mode, Purchasely handles transactions, analytics and paywall display as explained in default [SDK Configuration](config-appendices/).

Most of Purchasely customers use this mode because it allows to take benefit of all powerful features from Purchasely.

This mode is particularly relevant for teams starting their journey with in-app subscriptions as it will avoid developers to:

* code an in-house transaction processor, manage the subscribers lifecycle and produce store-specific code to plug with the app stores (3 to 6 months of work in average)
* waste time on developing the paywall(s)

Instead, teams can focus on developing their core product and features and use subscriptions as a convenience.

### What can you do in this mode?

You can do pretty much everything:

* Display paywalls and change them remotely
* Create as many paywalls as you want to multiply the touch points
* Process transactions and extract meaningful data from stores receipts
* Receive unified [subscription events](../../analytics/events/webhook-events/subscription-events.md) from our [Webhook](../../integrations/webhook-1/) to trigger your automations
* Connect this data with your marketing tools using our integrations
* Analyse your business with the [dashboards](../../analytics/dashboards/introduction.md) integrated in the Purchasely Console

## General overview

![](https://files.gitbook.com/v0/b/gitbook-x-prod.appspot.com/o/spaces%2FGgUdOzhqa07uh7nB2iZA%2Fuploads%2FQ9HnKR8on9VMAljYQ2qR%2Ffull%20animated.gif?alt=media\&token=87810d9c-d9a7-4875-aed8-76e1f66f2db5)

## Implementation

### 1- Start the SDK

The first thing you need to do is to call the `start` method passing the mode `paywallObserver` / `PLYRunningModePaywallObserver` .\
\
[View implementation details](config-appendices/start-the-sdk.md)

### 2- Set user identifier

We need to know whenever a user is logged in or logged out to:

* Hide the login button in the paywalls
* Check if the user already used a trial and display the correct price

[View implementation details](config-appendices/set-user-id.md)

### 3- Configure and present paywalls

To display a paywall, you need to can get a Controller / Fragment from Purchasely.

[View implementation details](config-appendices/present-paywalls.md)

### 4- Save/Verify user subscriptions

Purchases can be performed without any paywall involved. This is what happens for kids with ask-to-buy or with [PSD2](https://developer.apple.com/support/psd2/) flows.

In these cases your app is notified by the SDK and you must unlock the content / service.

[View implementation details](config-appendices/unlock-content-service.md)

After the initial purchase you will want to check the status. To do so you can use one of the following options:

* Using your backend (if you implemented [Webhook](../../integrations/webhook-1/))
* Using Firebase (if you have our [Firebase extension](https://github.com/Purchasely/Purchasely-Firebase-Extension))
* Using the SDK's [userSubscriptions](../../advanced-features/subscription-status.md) method

### 5- Configure deeplinks (optional)

Paywalls can be used in many othe ways that can be:

* [Promoted In-App Purchase](../../advanced-features/promoting-your-products/promoting-in-app-purchases.md)
* [Deeplinks](../../advanced-features/deeplinks-and-automations.md)
* Push notifications deeplinks

### 6- Migrate your existing subscriber base (optional)

If your app already has subscribers, you must migrate them to Purchasely to:

* Have complete dashboards including every subscriber acquired in the past
* Handle status using the `userSubscriptions`

Follow [this guide](../../faq/migration-guides/migrate-from-an-existing-setup.md) to import your subscribers to Purchasely.
