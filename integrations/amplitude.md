# Amplitude

Purchasely can send all your transactional events to Amplitude to enrich your users data.

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

## Associate users and devices to events

{% tabs %}
{% tab title="Swift" %}
```swift
let amplitudeUserId = Amplitude.instance().getUserId()
Purchasely.setAttribute(.amplitudeUserId, value: String(amplitudeUserId))

let amplitudeDeviceId = Amplitude.instance().getDeviceId()
Purchasely.setAttribute(.amplitudeDeviceId, value: String(amplitudeDeviceId))
```
{% endtab %}

{% tab title="Kotlin" %}
```kotlin
Purchasely.setAttribute(
    Attribute.AMPLITUDE_USER_ID,
    Amplitude.getInstance().userId.toString()
)

Purchasely.setAttribute(
    Attribute.AMPLITUDE_DEVICE_ID,
    Amplitude.getInstance().deviceId.toString()
)
```
{% endtab %}

{% tab title="Java" %}
```java
Purchasely.setAttribute(
    Attribute.AMPLITUDE_USER_ID,
    String.valueOf(Amplitude.getInstance().getUserId())
);

Purchasely.setAttribute(
    Attribute.AMPLITUDE_DEVICE_ID,
    String.valueOf(Amplitude.getInstance().getDeviceId())
);
```
{% endtab %}

{% tab title="React Native" %}
```javascript
Purchasely.setAttribute(Attributes.AMPLITUDE_USER_ID, Amplitude.getInstance().getUserId());
Purchasely.setAttribute(Attributes.AMPLITUDE_DEVICE_ID, Amplitude.getInstance().getDeviceId());
```
{% endtab %}

{% tab title="Cordova" %}
```javascript
Purchasely.setAttribute(Purchasely.Attribute.AMPLITUDE_USER_ID, Amplitude.getInstance().getUserId());
Purchasely.setAttribute(Purchasely.Attribute.AMPLITUDE_DEVICE_ID, Amplitude.getInstance().getDeviceId());
```
{% endtab %}
{% endtabs %}

