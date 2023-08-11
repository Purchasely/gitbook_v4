# App Store

## Creating a new in-app purchase in the App Store Connect Console

1. Connect to the App Store Connect Console
2. Navigate to the following section:\
   _App Store Connect > My Apps > \[YOUR APP] > In-App Purchase > Manage_
3. Select the in-app Purchase you want to create
4. Fill in the **Reference Name** and the **Product ID**
5. For a renewing subscription, adjust the subscription duration&#x20;
6. Adjust the prices

![](<../../../.gitbook/assets/image (23) (1).png>)

The value of the **Product ID** parameter will be needed to be mapped with the corresponding plan in the Purchasely Console.

{% hint style="info" %}
These in-app purchases will need to be submitted for review & validated by Apple in order to be purchasable in the iTunes Production Store. As long as the in-app purchase is not validated, it can only be used in the Sandbox environment for testing purposes.
{% endhint %}

## About Subscription Groups

**Subscription groups** are an artefact provided by the App Store for grouping subscriptions. They have a set of specific properties :

* **A free trial or introductory price can only be used once per group, per user**. \
  \
  In other words, if a subscriber has already taken advantage of a free trial or introductory offer, he will not be able to take benefit of another free trial or introductory offer if it purchases a subscription (the same one after cancelling it or another one) in the same subscription group.\

* **A subscriber can only have one active subscription inside a subscription group**. \
  \
  This means that when a subscriber that has an active subscription (let's call it Subscription A), purchases another subscription (Subscription B) within the same Subscription Group, its previous Subscription (A) will automatically be cancelled. \

* **Inside a subscription group, in-app purchases items are ordered**. \
  \
  In this case of a subscription migration (A → B) , the upgrade/downgrade/crossgrade policy will be applied depending on the order in which Subscriptions have been ordered inside the Subscriptions Groups.\

* Subscription groups are associated to localised data that determine how the subscription will appear in the phone settings

{% hint style="danger" %}
Once an in-app purchase item has been attached to a particular Subscription Group, it cannot be changed anymore. When designing your subscription groups, you should be very careful. The only thing you should ask yourself, is whether or not the end-user should be able to cumulate 2 active subscriptions. If the end-user is not supposed to be able to cumulate 2 subscriptions, then, they should be attached to the same subscription group. \
\
**In any case, keep you offers structure as simple as possible.**\
Do not use subscription groups to reflect the geography of your offers, this is already done by the stores themselves. One unique subscription group should be enough in most of the cases.
{% endhint %}

## Attaching an in-app subscription to a Subscription Group

In the App Store Connect Console, navigate to the following location :\
_App Store Connect > My Apps > \[YOUR APP] > In-App Purchases > Subscription Group_

From their, you can either create a new `subscription group` or attach you new in-app subscription to an existing subscription group.&#x20;

![](<../../../.gitbook/assets/image (25) (1).png>)

