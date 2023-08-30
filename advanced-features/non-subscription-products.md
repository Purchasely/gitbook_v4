# Non-subscription products

In-App Purchases are not only just subscriptions. Subscriptions are the hardest to handle but you can also sell consumables, non-consumables and non-renewing subscriptions and they are also handled by Purchasely.

### Consumables ? Non-consumables ? Non-renewing subscriptions ?

They are simpler products to handle but as you have Purchasely in place you might want to handle everything in one place and that's a good thing to keep it in one place.

* **Consumables – available once** This is a product that needs to be bought again after use. For example coins in games, swipes or loves in dating apps.
* **Non-consumable – always available** This is a product with no expiry date that will remain available in your app. That can be an unlocked feature, level or item in a game (golf club in a golf game, new car, engine, paint in a car game).
* **Non-renewing subscriptions – available a fixed amount of time** This item will only give you the access during a certain amount of time (usually long) but you will have to manually renew if you want to. Non renewing can be helpful if you sell a content in education that covers a special degree that most user will pass next year.

## Implementation

{% hint style="danger" %}
Purchasely will verify the purchase but **won't keep track** of it. This must be done outside of Purchasely.\
\
So if you unlock a level with a non-consumable product, add coins to you game wallet with consumables… you will have to save the unlocked feature or increment the number of coins in the users wallet on your server or app.

**We recommend you to do it server side using the Webhook notifications.**
{% endhint %}

Consumables, non-consumables and non-renewing subscriptions can be declared just like a regular plans.

You can either choose them to be inside a new product (for example coins offerings will be inside a "Coins" product and you will have several plans like "100 coins", "200 coins", …).

You can also add a non-consumable alongside subscriptions in the same product. It can be a **lifetime access to a feature** next to a monthly and yearly subscription. _This is a pretty common behaviour and we will take that example._

### Setup the plan

First you need to add a plan to a product (newly created or not).

![Create a new plan for a non subscription product](https://files.gitbook.com/v0/b/gitbook-legacy-files/o/assets%2F-MHAzdlUVqKyZvwTnNIE%2F-MPqJawNT7Kqgz2OoZzC%2F-MPqMZwJOykHEAks63Rd%2FCapture%20d%E2%80%99e%CC%81cran%202020-12-31%20a%CC%80%2002.13.25.png?alt=media\&token=30f4bcc0-2a06-4ba3-9dc5-90fb12a14a1c)

{% hint style="info" %}
Recommendations:

* Be sure to select the appopriate type of product (Step 1)
* Use a **Plan Vendor ID** that your can easily identify as this will be the identifier sent to your server to increment the items to your users account or unlock the content (Step 3)
* If you build a lifetime purchase, set a **plan level higher** than any other subscription (Step 4)
* If you are inside a game coin product, the more coins are contained, the higher plan level should be (Step 4)
{% endhint %}

### Add the plan to a presentation

![Exemple of the addition of a purchase button for a lifetime purchase](https://files.gitbook.com/v0/b/gitbook-legacy-files/o/assets%2F-MHAzdlUVqKyZvwTnNIE%2F-MK0Z4T2jaOq4tdtf85Y%2F-MK0dsNvHKtloA13kzVd%2FCapture%20d%E2%80%99e%CC%81cran%202020-10-19%20a%CC%80%2018.12.47.png?alt=media\&token=0403f7c8-a9de-4cb6-9c49-0ebff0113822)

### Handle the purchase on your server

Once the purchase is done, the [Webhook](../integrations/webhook-1/) will send the `PURCHASE_VALIDATED` event.

If the user asks Apple, Google, … for a refund (and gets it) you will receive a `PURCHASE_REFUND` event. In that case you should make the appropriate action like:

* Substract the coins purchased
* Block access to the game level

You should also handle the `USER_IDENTIFIED` and `PURCHASE_TRANSFERRED` events to change the user owner.

### Handle restoration

While regular restoration works for non-consumables, it won't work for consumables or non-renewing subscriptions. For these types of products, your app must have its own restoring function. That restoration can be made using an account creation and linking the purchase to that account.
