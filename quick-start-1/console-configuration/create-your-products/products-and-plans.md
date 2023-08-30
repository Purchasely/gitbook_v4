# Products & Plans

## _`Products`_

<div data-full-width="true">

<figure><img src="../../../.gitbook/assets/image (206).png" alt=""><figcaption></figcaption></figure>

</div>

A _**`Product`**_ is composed of the following parameters :

* The `Product name` : this parameter is used to display the _**`Product`**_ in the Purchasely Console, but is also displayed to the user in the section "My Subscriptions" (which allows users to manage their subscription directly into the Mobile App).\\
* The `Product Vendor ID` : this parameters allows you to set your own identifier for the _**`Product`**_.\
  \
  This `Product Vendor ID` will be useful at the Webhook level, when receiving `Events` about a particular `Subscription`, the `Product Vendor ID` corresponding to the `Subscription` will always be present.

{% hint style="danger" %}
The Product Vendor ID cannot be changed after its creation, so choose it carefully
{% endhint %}

* The `Description` : this parameter is only used for your own internal purposes. It is a note that you can use for recording whatever information you want. It is not displayed in the Mobile App.\\
* The `Icon` : this icon is displayed in the Purchasely Console and in the section "My Subscriptions"

**Editing \_`Products`**\_\*\* in the Purchasely Console\*\*

To edit a _**`Product`**_, click on the **`Edit`** entry in the upper right corner

<div data-full-width="true">

<figure><img src="../../../.gitbook/assets/image (207).png" alt=""><figcaption></figcaption></figure>

</div>

Except the `Product Vendor ID`, all the other parameters can be modified when editing a _**`Product`**_

## _`Plans`_

In Purchasely model, _**`Plans`**_ correspond to items users can actually purchase. They correspond to :

* `in-app purchases` in the App Store Connect
* `in-app products` in the Play Store Console

{% hint style="info" %}
A _**`Plan`**_ must be understood as an item, granting a certain level of access (e.g.: Bronze, Silver, Gold or Platinium), associated to a set of entitlements (e.g.: HD, 4K, family - 4 simultaneous streams for a SVOD service). If the _**Plan**_ is a renewing subscription, it is associated to a renewal periodicity.\
\
The purpose of the _**`Plan`**_ is to aggregate a same in-app item, distributed over various Mobile Applications Store, into a same object, with a shared identifier, that you can define yourself. This contributes to simplify the follow-up of your subscribers.
{% endhint %}

In Purchasely Console, a _**`Product`**_, can be associated to several _**`Plans`**_.

## Creating _`Plans`_ in the Purchasely Console

To create a _**`Plan`**_, click on the button **`+ Add new plan`**

<div data-full-width="true">

<figure><img src="../../../.gitbook/assets/image (209).png" alt=""><figcaption></figcaption></figure>

</div>

A _**`Plan`**_ is composed of the following parameters :

*   `Plan name` : this parameter is used to display the _**`Plan`**_ in the Purchasely Console, but is also displayed to the user in the section "My Subscriptions" (which allows users to manage their subscription directly into the Mobile App).\\

    `Plan Vendor ID` : this parameter allows you to set your own identifier for the _**`Plan`**_.\
    When receiving _**`Events`**_ about a particular `Subscription`, the `Plan Vendor ID` corresponding the `Subscription` will always be present. It will inform you about the _**`Plan`**_ associated to the subscription and thus allow you to define the matching entitlements. The _**`Plan`**_ has a common identifier for all the _**`Platforms`**_ on which it is distributed.\\
* `Plan type` : this parameter allows you to define the type of in-app item corresponding to the Plan. If a plan is mapped with several in-app purchases from several stores, it should be consistent and have the same type on all the stores.\

* `Level` : this parameter allows you organise _**`Plans`**_ within the _**`Product`**_. Subscriptions should be arranged in descending order, starting with the option that offers the highest level of service. This order defines the migration policies (see [below](products-and-plans.md#ordering-plans-inside-a-product))\\

### Binding Store Product ID together

To bind the Plan with the Store Product ID, you must first ensure that the [Application has been correctly plugged with the stores](../../../quick-start/console-configuration/installation.md#2-plug-it-with-the-stores).

<div data-full-width="true">

<figure><img src="../../../.gitbook/assets/image (178).png" alt=""><figcaption></figcaption></figure>

</div>

* Check the Stores on which your Plan is distributed\\
* Report the `Product ID` from the corresponding in-app purchase retrieved from the App Store Connect Console in the field `App Store Product id`\
  _App Store Connect Console > My Apps > \[YOUR APP] > In-App Purchases > Manage > In-App Purchases > \[YOUR IN-APP PURCHASE]_

<div data-full-width="true">

<figure><img src="../../../.gitbook/assets/image (181).png" alt=""><figcaption><p>Plan mappings App Store Connect -> Purchasely</p></figcaption></figure>

</div>

* Report the `Product ID`, `Base Plan ID` and wether or not the plan is `Backwards Compatible` from the corresponding in-app product retrieved from the Play Store Console in the field `Play Store Product id`\
  _Play Store Console > \[YOUR APP] > Store presence > In-App products > Subscriptions > \[YOUR IN-APP SUBSCRIPTION]_

<div data-full-width="true">

<figure><img src="../../../.gitbook/assets/image (169).png" alt=""><figcaption><p>Plan Mappings Google Play Console -> Purchasely</p></figcaption></figure>

</div>

### Ordering Plans inside a Product

The `Level` parameter is used to rank _**`Plans`**_ inside a _**`Product`**_.

On iOS, the App Store Connect Console provides the `Subscription Groups`, that are the exact equivalent of `Products` in Purchasely. The order in which `Subscriptions` are organised inside a `Subscription Groups` defines the migration policies (up-sell | down-sell | cross-sell). The policies are managed directly by the App Store.

_**`Plans`**_ inside a _**`Product`**_ should be organised in the same order as Subscriptions inside a Subscription Group. If they are ordered differently, the Subscription Group ordering will prevail over the _**`Product`**_ ordering in the Purchasely Console.

<div align="right">

<img src="../../../.gitbook/assets/image (177).png" alt="">

 

<img src="../../../.gitbook/assets/image (140).png" alt="">

</div>

On the Play Store, `Subscription Groups` do not exist. Therefore, this is the order in which _**`Plans`**_ are organized inside a _**`Product`**_ in the Purchasely Console, which will define the migration policies between the _**`Plans`**_. The policies are thus managed by the Purchasely Cloud Platform.

### About migrations policies

When a subscriber change his subscription (A) to another one (B), a migration is applied. The migration results in the auto-cancellation of subscription A, when subscription B is purchased.

#### App Store

On iOS, the migration is directly applied by the App Store. The condition to meet is to have the 2 `in-app purchases` belong to the same `Subscription Group`

3 different policies can be applied by the App Store :

* **Downgrade** : if subscription A has a higher rank than subscription B in the `Subscription Group`, the migration will be considered as a downgrade. In this case, subscription A will remain active until the end of the current billing period, and subscription B (with its own price and periodicity), will replace it automatically and become active only for the next billing cycle. Subscription A will then be automatically resigned.\
  \
  _Example : migration from the Yearly plan to the Monthly plan (screenshot above 👆) or from the Gold plan to a Silver plan in a multi-tiers subscription group._\
  \
  Inside the app, the user flow looks like this :

![User flow on iOS](<../../../.gitbook/assets/image (38) (1) (1) (1).png>)

* **Upgrade** : if subscription A has a lower rank than subscription B in the `Subscription Group`, the migration will be considered as an upgrade. In this case, subscription B will immediately replace subscription A a new billing cycle will start right away. Subscription B will be refund _prorata temporis_ (for the time remaining before the end of the current billing period) to the user.\\
* **Crossgrade** : if subscription A has the same rank as subscription B in the Subscription Groups, the policy applied will depend on the duration of each subscription. If they have the same duration, the policy applied will be the same as an upgrade (effective immediately + pro-rata refund), and the user flow will be the one of an upgrade. If they have different durations, the policy applied will look like a dowgrade (subscription B will become effective at the next renewal date).

More information about the all this is accessible directly on [Apple Help Center](https://help.apple.com/app-store-connect/#/dev7f2d6b652)

#### Play Store

* On the Play Store, since Subscription Groups do not exist, and migration are directly managed by the Purchasely Cloud Platform. To achieve this, it relies on `Products` and `Plans`. If `Plans` A & B belong to the same Product, Purchasely will apply a migration.
* For simplicity towards users, the exact same rules as on iOS have been implemented (downgrade / upgrade & crossgrade). Purchasely Cloud Platform relies on the parameter `Level` to determine which Plan has the highest rank and apply the corresponding migration policy.

## Editing _`Plans`_ in the Purchasely Console

To edit a _**`Plan`**_, click on the **`Edit`** button in the upper right corner.

<div data-full-width="true">

<figure><img src="../../../.gitbook/assets/image (202).png" alt=""><figcaption></figcaption></figure>

</div>
