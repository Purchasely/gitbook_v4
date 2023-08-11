# Play Store

## Creating a new Subscription in the Google Play Store Console

1. Connect to the [Google Play Console](https://play.google.com/console) :&#x20;
2. Navigate to the following section:\
   _Google Play Console > All apps > \[YOUR APP] > Monetize > Products > Subscriptions_
3. Click on _Create subscription_
4. Fill in the **Product ID** and details such as name and description which will be displayed to the user
5. Adjust the Subscription duration & the prices

![](../../../.gitbook/assets/Screenshot\_20210105\_181322.png)

The value of the **Product ID** parameter will be needed to be mapped with the corresponding plan in the Purchasely Console.

{% hint style="info" %}
These in-app purchases may take some times - a few hours - to be available for internal or public testing
{% endhint %}

## Creating a new In-App product in the Google Play Store Console

1. Connect to the [Google Play Console](https://play.google.com/console)
2. Navigate to the following section:\
   _Google Play Console > All apps > \[YOUR APP] > Monetize > Products > In-app products_
3. Click on the 3 dots near _Import_ and select _Create product_
4. Fill in the **Product ID** and details such as name and description which will be displayed to the user
5. Adjust the price

![](../../../.gitbook/assets/Screenshot\_20210105\_181745.png)

The value of the **Product ID** parameter will be needed to be mapped with the corresponding plan in the Purchasely Console.

{% hint style="info" %}
Google handles consumable and non consumables products but does not allow you to set it in their console. Use our dashboard to set your in-app product as consumable or non consumable and our SDK will handle the necessary process with Google Play.
{% endhint %}
