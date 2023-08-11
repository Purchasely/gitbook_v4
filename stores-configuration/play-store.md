# Google Play Store

## Connecting the Purchasely Cloud Platform with the App Store

### Getting the endpoint URL from the Purchasely Console

1. Connect to the Purchasely Console
2. Access the settings of the application you want to connect
3. Get the value of the parameter `Google S 2 S Notifications Endpoint` \
   _Purchasely > Mobile Applications > \[YOUR APPLICATION] > Application settings_

![](<../.gitbook/assets/image (147).png>)

### Creating a new Pub/Sub Topic

1. Connect to the [Google Cloud Platform Console](https://cloud.google.com/pubsub)&#x20;
2. Create new Pub/Sub topic\
   _Google Cloud Platform > PubSub > Topics > `+ Create new topic`_
3. Suggested name for the topic `Playstore-S2S-notifications`
4. Leave the encryption set on `Key managed by Google`

{% hint style="info" %}
If you have multiple applications under the same Google Project, create one topic and one subscription per application.
{% endhint %}

### Creating a subscription on the topic

1. Access the topic you just created
2. Click on `+ Create a subscription`
3. Set the `Type of distribution` to `Push`
4. In the URL field, enter the value of the field Google Play S2S Notifications Endpoint retrieved from the Purchasely Console
5. Set `no expiration date`
6. Set the `confirmation delay` to `60 seconds`
7. Set `Messages conservation` to `7 days`

{% hint style="info" %}
To receive S2S notifications on mutiple endpoints, you can create another subscription linked to the same topic.
{% endhint %}

### Adding a publisher to the topic

1. Add a new Pub/Sub Editor to the topic in the [Google Cloud Platform Console](https://cloud.google.com/pubsub) \
   _Google Cloud Platform > PubSub > Topics > \[Playstore-S2S-Notifications] > `+ Add principal`_
2. Copy & paste the following value `google-play-developer-notifications@system.gserviceaccount.com` in the `member` field
3. Set the `role` to `Pub/Sub Publisher`

### Play Store configuration

1. Connect to the [Google Play Console](https://play.google.com/apps/publish) and go to the following section\
   _Google Play Console > \[YOUR APPLICATION] > Monetization > Setup_
2. Type the full name of the topic. It shall have the shape `projects/[YOUR PROJECTS]/topics/Playstore-S2S-Notifications`
3. Click on the button Send test notification.\
   You can send several notifications at the same time
4. Click on **Save changes**
5.  Check the good reception of the test notification at the `topic` level&#x20;

    in the [Google Cloud Platform Console](https://cloud.google.com)\
    _Google Cloud Platform > Topics > Googleplay-S2S-Notifications_
6.  Check the good reception of the test notification at the `subscription` level&#x20;

    in the [Google Cloud Platform Console](https://cloud.google.com)\
    _Google Cloud Platform > Subscriptions > Purchasely-Subscriptions_

