# Migrate to SDK v3.1

## Introducing Placements

At Purchasely we believe that product and marketing teams should be able to iterate, test, learn and optimize without having to scatter the focus of developing teams.

Placements were designed to allow product and marketing teams to override the displayed paywall at a specific location in the app or at a specific time in the user journey. Using placement such teams will be able to change a paywall remotely, instantly, without any developer action or app release.

Placements are available from SDK version 3.1.0. Prior to that version product and marketing teams were able to change remotely and instantly details on a paywall (images, wording, plans, ...). But when it came to changing the structure of the paywall, use a background video instead of a image carousel, add a tab to offer another product in the same paywall... basically change from a paywall to another and not just edit the current one, a developer action was needed to edit in the code the `paywall_id` that was called and so an app release had to be made.

Following the 3.1.0 SDK version using Placement the developers will have to call for a `placement_id`  instead of a `paywall_id`. Doing so will allow you to change the paywall used for each Placement inside your app.

All the marketing/product team will have to do is to define Placements in the Purchasely console and define a default paywall for each. Placements are meant to represent a specific location or time in your user journey of your app (e.g. Onboarding, Settings, Home page, Article). You can create as much Placement as you want and add new ones at any time, for each new Placement your developer has to call the corresponding `placement_id` where it fits in the app just once and for all.&#x20;

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

Once you are on the Placements page you will be able to create as much Placement as you see fit for you app and user journey. For the example let's say that in your user journey you display a paywall right at the end of the onboarding of a new user. Want you want to do is Create a new Placement dedicated to that situation and name it _Onboarding_.

Clic on the top right corner of the Placements page on "New placement".

![](<../../../.gitbook/assets/image (166).png>)

Then you will have to fill different text fields.

* `NAME` : the name is only used in the Purchasely console&#x20;
* `ID` : the id is what the developer will need to implement that Placement into your app
* `DESCRIPTION` : the description is only used in the Purchasely console and is meant to help for collaborative work.
* `PAYWALL` : the paywall is the paywall that will be displayed when the Placement will be called in the app. This is where the magic is, you will be able the change the displayed Paywall for that Placement whenever you want wihtout any further developer action.

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
            }, completion: defaultHandlerEnabled ? nil : completion)
```
{% endtab %}

{% tab title="Objective-C" %}
```objectivec
UIViewController *paywallCtrl = [Purchasely presentationControllerFor:@"my_placement_id"
						            contentId:@"my_content_id"
                                                            completion:^(enum PLYProductViewControllerResult result, PLYPlan * _Nullable plan) {
}];objec

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



