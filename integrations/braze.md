# Braze

Purchasely can send all your transactional events to Braze to enrich your users data. Use these events to trigger automatic campaigns, pushs...

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

## Associate users to events

There is nothing special to be done to associate Purchasely events to your logged in users in Braze. Just setup Braze SDK as you would normally, and use the `changeUser` method to set the user ID in Braze:

{% tabs %}
{% tab title="Swift" %}
```swift
Appboy.sharedInstance()?.changeUser("YOUR_USER_ID")
```
{% endtab %}

{% tab title="Objective-C" %}
```objectivec
[[Appboy sharedInstance] changeUser:@"YOUR_USER_ID"];
```
{% endtab %}

{% tab title="Kotlin" %}
```kotlin
Appboy.getInstance(context).changeUser("YOUR_USER_ID")
```
{% endtab %}

{% tab title="Java" %}
```java
Appboy.getInstance(context).changeUser("YOUR_USER_ID");
```
{% endtab %}

{% tab title="React Native" %}
```javascript
ReactAppboy.changeUser("YOUR_USER_ID");
```
{% endtab %}

{% tab title="Cordova" %}
```javascript
AppboyPlugin.changeUser("YOUR_USER_ID");
```
{% endtab %}
{% endtabs %}

{% hint style="info" %}
Make sure the User ID you give to Braze matches the**`vendor_id`** you give to Purchasely, as our servers refer to this ID when sending events for the user. Read Braze documentation on [Setting User IDs](https://www.braze.com/docs/developer\_guide/platform\_integration\_guides/ios/analytics/setting\_user\_ids/) for more information.
{% endhint %}

## Handle anonymous users

If you have [**anonymous users**](../advanced-features/anonymous-user.md) in your app, you will need to add their Purchasely `anonymous_id` as a user alias to Braze:

{% tabs %}
{% tab title="Swift" %}
```swift
Appboy.sharedInstance()?.user.addAlias(
    Purchasely.anonymousUserId, 
    withLabel: "purchasely_anonymous_id"
)
```
{% endtab %}

{% tab title="Objective-C" %}
```
 [[Appboy sharedInstance].user addAlias:[Purchasely anonymousUserId] withLabel:@"purchasely_anonymous_id"];
```
{% endtab %}

{% tab title="Kotlin" %}
```kotlin
Appboy.getInstance(applicationContext)?.currentUser?.addAlias(
    Purchasely.anonymousUserId,
    "purchasely_anonymous_id"
)
```
{% endtab %}

{% tab title="Java" %}
```java
Appboy.getInstance(getApplicationContext()).getCurrentUser().addAlias(
    Purchasely.getAnonymousUserId(),
    "purchasely_anonymous_id"
);
```
{% endtab %}

{% tab title="React Native" %}
```
ReactAppboy.addAlias(
    Purchasely.getAnonymousUserId(),
    "purchasely_anonymous_id"
);
```
{% endtab %}

{% tab title="Cordova" %}
```javascript
AppboyPlugin.addAlias(
    Purchasely.anonymousUserId, 
    withLabel: "purchasely_anonymous_id"
);
```
{% endtab %}
{% endtabs %}

{% hint style="warning" %}
The label **MUST** be set to **`"purchasely_anonymous_id"`**, as our servers refer to this label when sending events while the user is anonymous.
{% endhint %}

When the anonymous user later becomes logged in, Purchasely will automatically send following events using the provided **`vendor_id`**

## Configure the integration in the Purchasely Console

Go to the "External integrations" section, and open the edition form for Braze:

![](<../.gitbook/assets/image (61).png>)

![](<../.gitbook/assets/image (62).png>)

### Getting Braze API key

Go to your **Braze Developer Console**, and click on "_Create New API Key"_

![](<../.gitbook/assets/image (64).png>)

Give a relevant name to your API Key. In the _"User Data"_ permission area, check **`users.track`** as our servers need this permission to report backend events to Braze.

![](<../.gitbook/assets/image (63).png>)

Click _"Save API Key"_ at the bottom of the page.

![](<../.gitbook/assets/image (65).png>)

Finally, paste the API key Identifier value into Purchasely console.

### Selecting the correct REST Server

Refer to [Braze API Endpoints table](https://www.braze.com/docs/api/basics/#endpoints). You can use your Braze Dashboard URL find the correct server. E.g. if your dashboard is accessible at **https://dashboard-01.braze.eu**, then you should select the **`EU-01`** server.

## Customising Server Event Names

If you want to, you can rename events sent to Braze:

![](<../.gitbook/assets/image (66).png>)

{% hint style="info" %}
Please refer to Braze documentation on [Event Naming Conventions](https://www.braze.com/docs/user\_guide/data\_and\_analytics/custom\_data/event\_naming\_conventions/) to choose appropriate event names.
{% endhint %}

## Event properties

Each event sent to Braze carries a set of properties that you can use to further personalize your campaigns:

| Property                 | Description                                                                    |
| ------------------------ | ------------------------------------------------------------------------------ |
| `application_name`       | Name of the application as set in Purchasely Console, e.g. `"Purchasely Demo"` |
| `application_package_id` | Application package ID in the Store, e.g. `"com.purchasely.demo"`              |
| `application_platform`   | Platform of the application, e.g. `"ANDROID"`                                  |
| `plan_id`                | Plan Vendor ID, e.g. `"PURCHASELY_PLUS_MONTHLY"`                               |
| `plan_name`              | Plan name as set in Purchasely Console, e.g. `"Monthly"`                       |
| `plan_store_product_id`  | Store product identifier, e.g. `"com.purchasely.plus.monthly"`                 |
| `plan_type`              | Type of the plan, e.g. `"RENEWING_SUBSCRIPTION"`                               |
| `product_id`             |  Product Vendor ID, e.g. `"PURCHASELY_PLUS"`                                   |
| `product_name`           | Product name as set in Purchasely Console, e.g. `"Purchasely +"`               |
| `store`                  | Store associated with the event, e.g. `"GOOGLE_PLAY_STORE"`                    |

{% hint style="info" %}
Read Braze documentation on [Custom Event Properties](https://www.braze.com/docs/user\_guide/data\_and\_analytics/custom\_data/custom\_events/#custom-event-storage) for more details on how you can use the properties above.
{% endhint %}
