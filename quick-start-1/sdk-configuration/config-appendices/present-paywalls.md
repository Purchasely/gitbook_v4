# Present paywalls

Paywalls are displayed by calling a Placement.

A Placement represents a specific location in your user journey inside your app (e.g. Onboarding, Settings, Home page, Article). A placement is linked to a paywall and a single paywall can be used for different Placements. You can create as many Placements as you want, and this is the only thing that ties the app developer to the marketer.&#x20;

Once the placements are defined and called from the app, you can change the displayed paywall remotely without any developer action.

## What Placements should you create ?

Let's take the example of the New Yorker app who has many triggers to display paywalls.

![](<../../../.gitbook/assets/image (163).png>)

![](<../../../.gitbook/assets/image (203).png>)

For this specific case the New Yorker should create 4 Placements:

* ![](<../../../.gitbook/assets/App launch (1).png>)
* ![](<../../../.gitbook/assets/Nav bar.png>)
* ![](../../../.gitbook/assets/Toaster.png)
* ![](<../../../.gitbook/assets/Magazine issue.png>)
* ![](../../../.gitbook/assets/Settings.png)

Once these Placements created the displayed paywalls for each Placement can be changed remotely, instantly and independently.

## How to define placements in the Purchasely console

First of all you will find in the main menu a new entry dedicated to manage your Placements.

![](<../../../.gitbook/assets/image (122).png>)

Once you are on the Placements page you will be able to create as much Placement as you want to fit your app and user journey. For example let's say that in your user journey you display a paywall right at the end of a new user onboarding. Want you want to do is Create a new Placement dedicated to that situation and name it _Onboarding_.

Clic on the top right corner of the Placements page on "New placement".

![](<../../../.gitbook/assets/image (166).png>)

Then you will have to fill different text fields.

* `NAME` : the name is only used in the Purchasely console&#x20;
* `ID` : the id is what the developer will need to call in the app
* `DESCRIPTION` : the description is only used in the Purchasely console and is meant to help for collaborative work.
* `PAYWALL` : the paywall is the paywall that will be displayed when the Placement will be called in the app. This is where the magic is, you will be able to change the displayed Paywall for that Placement whenever you want without any further developer action.

![](<../../../.gitbook/assets/image (144).png>)

Once it's created you can manage all your Placements at the same place and edit them whenever you see fit.

![](<../../../.gitbook/assets/image (182).png>)

## How to implement a Placement in your app



Once the placement has been define in the Purchasely Console you have to call it in your app.

You can do it using an almost identical method than the one you already used for a `presentationController`with an id.



{% tabs %}
{% tab title="Swift" %}
```swift
let placementId = "ONBOARDING"
paywallCtrl = Purchasely.presentationController(for: placementId, contentId: contentId, loaded: { _, _, _ in
            }, completion: completion)
```
{% endtab %}

{% tab title="Objective-C" %}
```objectivec
UIViewController *paywallCtrl = [Purchasely presentationControllerFor:@"my_placement_id"
						            contentId:@"my_content_id"
                                                            completion:^(enum PLYProductViewControllerResult result, PLYPlan * _Nullable plan) {
}];

```
{% endtab %}

{% tab title="Kotlin" %}
```kotlin
val placementId = "onboarding"
val contentId = "my_content_id" //or null
Purchasely.presentationFragmentForPlacement(placementId, contentId) { result, plan ->
      Log.d("Purchasely", "Result is $result with plan $plan")
}
```
{% endtab %}

{% tab title="Java" %}
```java
String placementId = "onboarding"
String contentId = "my_content_id" //or null
Purchasely.presentationFragmentForPlacement(placementId, contentId);
```
{% endtab %}

{% tab title="React Native" %}
```jsx
await Purchasely.presentPresentationForPlacement({
    placementVendorId: 'onboarding',
    contentId: 'my_content_id',
    isFullscreen: true,
});
```
{% endtab %}

{% tab title="Cordova" %}
```jsx
Purchasely.presentPresentationForPlacement('onboarding');
```
{% endtab %}

{% tab title="Flutter" %}
```jsx
await Purchasely.presentPresentationForPlacement('onboarding');
```
{% endtab %}
{% endtabs %}

{% hint style="info" %}
The callback `PLYProductViewControllerResult`(iOS) / `ProductViewResultListener` (Android) is optional, you can set to null if you do not need it.
{% endhint %}

{% hint style="info" %}
You can be alerted if the purchase was made by listening to the [Notifications](https://github.com/Purchasely/Purchasely-iOS#notifications) or by implementing the optional completion block
{% endhint %}



