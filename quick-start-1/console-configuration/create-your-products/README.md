---
description: >-
  This section describes how to manage your catalogue of items to sell (products
  & plans)
---

# Creating your Products

Purchasely offers the possibility to add new In-App Purchase to your catalogue in the app remotely, without needing any app submission.

This catalogue configuration is done partly directly in the Mobile Applications Stores and partly in the Purchasely Console.

In Purchasely, catalogue items use a 2-levels model : `Products` & `Plans`

![](<../../../.gitbook/assets/image (21) (1).png>)



* _**`Products`**_ are high level representation of what user can buy like a "Netflix subscription". A product can be distributed in various versions named _**`Plans`**_
* For a same _**`Plans`**_ can vary from one another regarding 2 dimensions :
  * _Multi-tiers products_ can propose different entitlements (i.e.: levels of access). e.g. : _bronze_, _silver_, _gold_
  * _Multi-periodicity products_ can have different renewing periodicity \
    e.g. : _daily_, _weekly_, _monthly_, _yearly_

{% hint style="info" %}
_**`Products`**_ are the equivalent of a **Subscription Group** in App Store Connect and _**`Plans`**_ are the equivalent of a Product in AppStore Connect.\
This means that subscribers won't be able to subscribe to 2 different _**`Plans`**_ in the same _**`Product`**_.
{% endhint %}

*   Each _**`Plan`**_ is distributed over various distribution _**`Platforms`**_

    e.g. : _Apple App Store_, _Google Play Store_, _Huawei App Gallery, …_

## Types of in-app purchases

Purchasely is compatible with all the type of in-app purchases managed on the stores:

* Renewing subscriptions
* Non renewing subscriptions
* Consumables
* Non consumables

Refer to [non-subscription products documentation](../../../advanced-features/non-subscription-products.md) for more information.

## General process

1. New **in-app purchases** must first be created in the Mobile Applications Stores (e.g.: App Store, Play Store, Huawei App Gallery)
2. **Products** & **Plans** are then created in the Purchasely Console
3. Product IDs shall finally be reported from the Mobile Applications Stores, to the Purchasely Console
