# Airship

## Events

The following events will be sent. You can set the event name of your choice in the console.

You can find the full list of events [here](../analytics/events/webhook-events/subscription-events.md).

| Event                     | Description                                                                                                             |
| ------------------------- | ----------------------------------------------------------------------------------------------------------------------- |
| `SUBSCRIPTION_STARTED`    | Sent when the user purchased a product wether it is the start of a trial or a regular purchase of a consumable product. |
| `RENEWAL_DISABLED`        | Sent when the user deactivates the renewal of a subscription wether it is in trial period or not.                       |
| `RENEWAL_ENABLED`         | Sent when the user reactivates                                                                                          |
| `SUBSCRIPTION_TERMINATED` | Sent when the subscription actually ends                                                                                |
| `SUBSCRIPTION_RENEWED`    | Sent when a subscription renews                                                                                         |
| `TRIAL_STARTED`           | Sent when a trial starts                                                                                                |
| `TRIAL_CONVERTED`         | Sent when a user converts from a free trial to a normal paid-period                                                     |
| `TRIAL_NOT_CONVERTED`     | Sent when a user finishes it's trial period without renewing to a paid-period                                           |

## Associate your users

Naming your users allows our servers to send purchase events on your behalf to Airship. You have 2 ways of doing it:

1. [From within the app](broken-reference/)
2. [From your server](broken-reference/)

### From within your app

In the Airship console, enable or disable **Named Users**[ ](https://support.airship.com/hc/en-us/articles/360012434371-Step-7-Named-User)in "_Settings" APIs & Integrations » Named Users_".

In your app, when a user sign-in, associate their id in Airship.&#x20;

If the Airship UserId differs from the Purchasely UserId, you can also pass the value you gave to Airship to Purchasely SDK (see second code block):

{% tabs %}
{% tab title="Swift" %}
```swift
UAirship.namedUser().identifier = "theUserId"
```

```swift
Purchasely.setAttribute(.airshipUserId, value: "theUserId")
```
{% endtab %}

{% tab title="Objective-C" %}
```objectivec
```
{% endtab %}

{% tab title="Kotlin" %}
```kotlin
UAirship.shared().namedUser.id = "YOUR_USER_ID"
```

```kotlin
Purchasely.setAttribute(
    Attribute.AIRSHIP_USER_ID,
    "YOUR_USER_ID"
)
```
{% endtab %}

{% tab title="Java" %}
```java
UAirship.shared().getNamedUser().setId("YOUR_USER_ID");
```

```java
Purchasely.setAttribute(
    Attribute.AIRSHIP_USER_ID,
    "YOUR_USER_ID"
);
```
{% endtab %}

{% tab title="React Native" %}
```jsx
UAirship.setNamedUser("YOUR_USER_ID")
```

```jsx
Purchasely.setAttribute(Attributes.AIRSHIP_USER_ID, "YOUR_USER_ID");
```
{% endtab %}

{% tab title="Cordova" %}
```javascript
UAirship.setNamedUser("YOUR_USER_ID")
```

```javascript
Purchasely.setAttribute(AIRSHIP_USER_ID, value: "YOUR_USER_ID");
```
{% endtab %}
{% endtabs %}

{% hint style="info" %}
More information on "named users" can be found [here](https://support.airship.com/hc/en-us/articles/360012434371-Step-7-Named-User)
{% endhint %}

### From your server

By restricting association to server-side calls only, you have the added security of requiring your master secret to be verified after each call. While increasing security, you also lose the convenience of having your application automatically associate named users on login. Most apps do not require this additional security. But, if your app deals with extremely sensitive data, you may want to leave this setting disabled and associate named users exclusively through the API.

Use the Airship API to associate your users [here](https://docs.airship.com/api/ua/#operation-api-named\_users-associate-post)

{% tabs %}
{% tab title="Ruby" %}
```ruby
require 'urbanairship'

UA = Urbanairship
airship = UA::Client.new(key: '<app key>', secret: '<master secret>')

named_user = UA::NamedUser.new(client: airship)
named_user.named_user_id = 'user-id-1234'
named_user.associate(
    channel_id: 'df6a6b50-9843-0304-d5a5-743f246a4946',
    device_type: 'ios'
  )
```
{% endtab %}

{% tab title="Python" %}
```python
import urbanairship as ua

airship = ua.Airship('<app key>', '<master secret>')
named_user = ua.NamedUser(airship, 'user-id-1234')
resp = named_user.associate('df6a6b50-9843-0304-d5a5-743f246a4946', 'ios')
```
{% endtab %}

{% tab title="Java" %}
```java
UrbanAirshipClient client = UrbanAirshipClient.newBuilder()
        .setKey("<app key>")
        .setSecret("<master secret>")
        .build();

NamedUserRequest request = NamedUserRequest.newAssociationRequest()
        .setChannel("df6a6b50-9843-0304-d5a5-743f246a4946", ChannelType.IOS)
        .setNamedUserId("user-id-1234");

Response<String> response = client.execute(request);
```
{% endtab %}
{% endtabs %}

## Handle anonymous users

If you have [**anonymous users**](../advanced-features/anonymous-user.md) in your app, we'll need the Airship channel to send purchase events to Airship on your behalf.

{% tabs %}
{% tab title="Swift" %}
```swift
if let channelId = UAirship.channel()?.identifier {
	Purchasely.setAttribute(.airshipChannelId, value: channelId)
}
```
{% endtab %}

{% tab title="Objective-C" %}
```objectivec
if ([[UAirship channel] identifier] != nil) {
		[Purchasely setAttribute:PLYAttributeAirshipChannelId value: [[UAirship channel] identifier]];
	}
```
{% endtab %}

{% tab title="Kotlin" %}
```kotlin
UAirship.shared().channel.id?.let {
    Purchasely.setAttribute(
        Attribute.AIRSHIP_CHANNEL_ID,
        it
    )
}
```
{% endtab %}

{% tab title="Java" %}
```java
String channelId = UAirship.shared().getChannel().getId();
if(UAirship.shared().getChannel().getId() != null) {
    Purchasely.setAttribute(
            Attribute.AIRSHIP_CHANNEL_ID,
            channelId
    );
}
```
{% endtab %}

{% tab title="React Native" %}
```javascript
var channelId = UrbanAirship.getChannelId().then(channelId => {
  Purchasely.setAttribute(Attributes.AIRSHIP_CHANNEL_ID, channelId);
}));
```
{% endtab %}

{% tab title="Cordova" %}
```javascript
UAirship.getChannelID(function (channelID) {
    Purchasely.setAttribute(AIRSHIP_CHANNEL_ID, value: channelId);
})
```
{% endtab %}
{% endtabs %}

## Configure the integration in the Purchasely Console

Go in the "External integrations" section, and open the edition form for Airship:

<figure><img src="../.gitbook/assets/image (1).png" alt=""><figcaption></figcaption></figure>

<figure><img src="../.gitbook/assets/image (2).png" alt=""><figcaption></figcaption></figure>

You'll find your "**Airship API key**" in your Airship console, section "_Settings » APIs & Integrations_":

![](https://files.gitbook.com/v0/b/gitbook-legacy-files/o/assets%2F-MHAzdlUVqKyZvwTnNIE%2F-MWa1QDakqUp\_C\_YDzM5%2F-MWaB4TF0Bqo2o6PuAxk%2FScreenshot%202021-03-24%20at%2022.41.10%402x.jpg?alt=media\&token=7c0db479-c812-4524-ae29-746d1772abe8)

You need to generate the "**Airship API token**" in your Airship console, section "_Settings » APIs & Integrations » Tokens_", with the "**Audience Modification**" role:

![](https://files.gitbook.com/v0/b/gitbook-legacy-files/o/assets%2F-MHAzdlUVqKyZvwTnNIE%2F-MWa1QDakqUp\_C\_YDzM5%2F-MWaBe7hjX0SFT\_k\_w8s%2FScreenshot%202021-03-24%20at%2022.43.21%402x.jpg?alt=media\&token=844c8000-594a-4649-9f50-1b9336a33e16)

Finally, the "**Server**" to use depends on your app.

* If your Airship console is on the "go.airship.com" domain, then you'll need to choose the "**go.urbanairship.com**" server.
* If your Airship console is on the "go.airship.eu" domain, then you'll need to choose the "**go.airship.eu**" server.

If you want to, you can rename the events sent to Airship:

<figure><img src="../.gitbook/assets/image (3).png" alt=""><figcaption></figcaption></figure>

And also choose to update user properties:

<figure><img src="../.gitbook/assets/image (4).png" alt=""><figcaption></figcaption></figure>

{% hint style="info" %}
The overridden name must only contain **alphanumeric lowercase characters**, **underscores and dashes**, as [specified in the Airship documentation](https://docs.airship.com/api/ua/#schemas-customeventobject-body-name).
{% endhint %}

## Event example

```javascript
{
  "body": {
    "name": "purchase_validated_server",
    "properties": {
      "application_name": "Purchasely",
      "application_package_id": "com.purchasely",
      "application_platform": "IOS",
      "plan_id": "PURCHASELY_PLUS_MONTHLY",
      "plan_name": "Monthly",
      "plan_store_product_id": "com.purchasely.plus.monthly",
      "plan_type": "RENEWING_SUBSCRIPTION",
      "product_id": "PURCHASELY_PLUS",
      "product_name": "Purchasely +",
      "store": "APPLE_APP_STORE"
    }
  },
  "occurred":"2021-03-24T17:15:01",
  "user":{
    "named_user_id": "jg"
  }
}
```

## Create your automation!

And that's all!

From now on, you'll be able to create as many automations as you want based on Purchasely's events with Airship!
