# Server-to-server notifications ?

Server-to-server notifications are available on each Applications Store, to get real-time notifications of purchases, renewing…

## What are server-to-server notifications ?

They consist in messages, sent by the Applications Stores, every time an event occurs on a subscription. For instance, a message is sent when a subscription :

* is purchased
* is renewed
* is cancelled (auto-renewing cancelled by user for the following billing period)
* is refund&#x20;
* gets expired
* encounters a billing issue
* …

The server-to-server notifications are not mandatory for making subscriptions work, but they are very valuable in the sense that they bring a real-time and comprehensive vision for the app editor.&#x20;

![](<../.gitbook/assets/image (15) (1).png>)

## What's the challenge in implementing them ?

The difficult part in integrating server-to-server notifications is the following :

1. it is quite (in fact very !) complex. There are lots of different messages, edge cases that need to be implemented
2. it has a totally different behaviour between the App Store and the Play Store, which brings even more complexity

When developing their IAP solution in-house, most app makers do not implement these server-to-server notifications, which prevent them from :

* Having a real time vision of their subscribers base
* Leverage on this to mitigate churn and optimise revenues
* Avoid user fraud consisting in getting a yearly subscription and getting refund quickly for it

## How does it work with Purchasely ?

Purchasely Cloud Platform works as a middleware between the Mobile Applications Stores and your own platform :

* It is connected to the stores and is the recipient of the S2S notifications
* It translates these store specific notifications into a common simple language
* It forwards every notification received directly on the Webhook to your own backend

The benefits for you is that, instead of having several notifications systems to implement, you can focus on one single and simpler interface. More over, as more stores are integrated into Purchasely product, there notifications are translated into the same common language, which means that you have nothing to do on your side !

## How do I activate server-to-server notifications using Purchasely ?

In order to activate server-to-server on Purchasely, you need to connect each of your stores to the Purchasely Cloud Platform.

Here are the guides to connect each store :

{% content-ref url="app-store.md" %}
[app-store.md](app-store.md)
{% endcontent-ref %}

{% content-ref url="play-store.md" %}
[play-store.md](play-store.md)
{% endcontent-ref %}

{% content-ref url="huawei-app-gallery.md" %}
[huawei-app-gallery.md](huawei-app-gallery.md)
{% endcontent-ref %}

