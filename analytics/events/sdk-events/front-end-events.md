# UI events

Purchasley controls a part of your UI and flows but we offer you the ability to track everything that the user is doing within our flows.

## Event list

Every front end event is available through the `eventDelegate`/`eventListener`

### Paywall user behavior

| Event name              | Description                                                           | iOS value             | Android value        |
| ----------------------- | --------------------------------------------------------------------- | --------------------- | -------------------- |
| Event Name              | Description                                                           | iOS value             | Android Value        |
| DEEPLINK\_OPENED        | The user opened a deeplink                                            | .deeplinkOpened       | DeepLinkOpened       |
| PRESENTATION\_VIEWED    | The presentation was opened                                           | .presentationViewed   | PresentationViewed   |
| PRESENTATION\_CLOSED    | The presentation was closed                                           | .presentationClosed   | PresentationClosed   |
| LOGIN\_TAPPED           | The user tapped on the login button                                   | .loginTapped          | LoginTapped          |
| RESTORE\_TAPPED         | The user has tapped on the restore button                             | .restoreTapped        | RestoreTapped        |
| PROMO\_CODE\_TAPPED     | The user has tapped on the promo code button                          | .promoCodeTapped      | PromoCodeTapped      |
| LINK\_OPENED            | The user tapped a link (Terms and conditions, …)                      | .linkOpened           | LinkOpened           |
| PLAN\_SELECTED          | The user selected a plan in the presentation                          | .planSelected         | PlanSelected         |
| PURCHASE\_TAPPED        | The user tapped on purchase                                           | .purchaseTapped       | PurchaseTapped       |
| PURCHASE\_CANCELLED     | The user cancelled the purchase action                                | .purchaseCancelled    | PurchaseCancelled    |
| CAROUSEL\_SLIDE\_SWIPED | The user has swipe on the carousel to see the next slide.             | .carouselSlideSwiped  | CarouselSlideSwiped  |
| PRESENTATION\_OPENED    | The user tapped to open another presentation (FLOWS)                  | .presentationOpened   | PresentationOpened   |
| PRESENTATION\_SELECTED  | The user selected a presentation in the current  presentation (FLOWS) | .presentationSelected | PresentationSelected |
| PRESENTATION\_LOADED    | The presentation was loaded and is ready to be displayed              | .presentationLoaded   | PresentationLoaded   |

### Payment

| Event name                   | Description                                                          | iOS value               | Android value          |
| ---------------------------- | -------------------------------------------------------------------- | ----------------------- | ---------------------- |
| Event Name                   | Description                                                          | iOS value               | Android Value          |
| IN\_APP\_PURCHASING          | The purchase started                                                 | .inAppPurchasing        | InAppPurchasing        |
| IN\_APP\_PURCHASED           | The purchased succeeded                                              | .inAppPurchased         | InAppPurchased         |
| IN\_APP\_PURCHASE\_FAILED    | The purchase failed                                                  | .inAppPurchaseFailed    | InAppPurchaseFailed    |
| IN\_APP\_DEFERRED            | The user started a deferred payment (i.e. Ask to buy, PSD2 approval) | .inAppDeferred          | InAppDeferred          |
| IN\_APP\_NOT\_AVAILABLE      | The in-app purchase is not available to purchase.                    | n/a                     | InAppNotAvailable      |
| PURCHASE\_CANCELLED\_BY\_APP | The app cancelled the purchase process                               | .purchaseCancelledByApp | PurchaseCancelledByApp |

### SDK event

| Event name                            | Description                                                  | iOS value          | Android value     |
| ------------------------------------- | ------------------------------------------------------------ | ------------------ | ----------------- |
| Event Name                            | Description                                                  | iOS value          | Android Value     |
| APP\_INSTALLED                        | First installation of the SDK                                | .appInstalled      | AppInstalled      |
| APP\_CONFIGURED                       | The SDK is ready to make purchases                           | .appConfigured     | AppConfigured     |
| APP\_STARTED                          | The app was launched                                         | .appStarted        | AppStarted        |
| APP\_UPDATED                          | The application version changed since last launch            | .appUpdated        | AppUpdated        |
| <p>STORE_PRODUCT<br>_FETCH_FAILED</p> | The Purchasely SDK couldn't fetch the product from the store | .productFetchError | ProductFetchError |

### Receipts

| Event              | Description                               | iOS value         | Android value    |
| ------------------ | ----------------------------------------- | ----------------- | ---------------- |
| RECEIPT\_CREATED   | The purchase was registered at Purchasely | .receiptCreated   | ReceiptCreated   |
| RECEIPT\_FAILED    | The purchase was rejected                 | .receiptFailed    | ReceiptFailed    |
| RECEIPT\_VALIDATED | The purchase was validated                | .receiptValidated | ReceiptValidated |

### Restore purchase

| Event name         | Description                                                                             | iOS value         | Android value    |
| ------------------ | --------------------------------------------------------------------------------------- | ----------------- | ---------------- |
| Event Name         | Description                                                                             | iOS value         | Android Value    |
| IN\_APP\_RESTORED  | The user restored its purchases after attempting to purchase a product he already owned | .inAppRestored    | InAppRestored    |
| RESTORE\_FAILED    | The restoration failed                                                                  | .restoreFailed    | RestoreFailed    |
| RESTORE\_STARTED   | The restoration started                                                                 | .restoreStarted   | RestoreStarted   |
| RESTORE\_SUCCEEDED | The restoration succeeded                                                               | .restoreSucceeded | RestoreSucceeded |
|                    |                                                                                         |                   |                  |

### Subscription transfer

| Event name                 | Description                                                         | iOS value                 | Android value            |
| -------------------------- | ------------------------------------------------------------------- | ------------------------- | ------------------------ |
| Event Name                 | Description                                                         | iOS value                 | Android Value            |
| SUBSCRIPTIONS\_TRANSFERRED | The anonymous user signed in and its subscriptions were transferred | .subscriptionsTransferred | SubscriptionsTransferred |

### Login

| Event name        | Description       | iOS value      | Android value |
| ----------------- | ----------------- | -------------- | ------------- |
| Event Name        | Description       | iOS value      | Android Value |
| USER\_LOGGED\_IN  | A user logged in  | .userLoggedIn  | UserLoggedIn  |
| USER\_LOGGED\_OUT | A user logged out | .userLoggedOut | UserLoggedOut |

### Cancellation

| Event name                               | Description                                 | iOS value                    | Android value               |
| ---------------------------------------- | ------------------------------------------- | ---------------------------- | --------------------------- |
| Event Name                               | Description                                 | iOS value                    | Android Value               |
| <p>CANCELLATION_REASON<br>_PUBLISHED</p> | The user replied to the cancellation survey | .cancellationReasonPublished | CancellationReasonPublished |

### Phone settings

Some events are specific to the [User subscriptions screen](../../../advanced-features/display-users-subscriptions.md)

| Event Name                            | Description                                             | iOS value                  | Android Value             |
| ------------------------------------- | ------------------------------------------------------- | -------------------------- | ------------------------- |
| SUBSCRIPTION\_CANCEL\_TAPPED          | The user tapped Cancel subscription                     | .subscriptionCancelTapped  | SubscriptionCancelTapped  |
| SUBSCRIPTION\_DETAILS\_VIEWED         | Detail page of a subscription viewed                    | .subscriptionDetailsViewed | SubscriptionDetailsViewed |
| SUBSCRIPTION\_PLAN\_TAPPED            | Tapped to change plan                                   | .subscriptionPlanTapped    | SubscriptionPlanTapped    |
| SUBSCRIPTIONS\_LIST\_VIEWED           | Subscriptions list viewed                               | .subscriptionsListViewed   | SubscriptionListViewed    |
| <p>PURCHASE_FROM<br>_STORE_TAPPED</p> | The user opened the app from a Promoted In-App Purchase | .purchaseFromStoreTapped   | n/a                       |
| IN\_APP\_RENEWED                      | The subscription renewed (usually occurs on launch)     | .inAppRenewed              | n/a                       |

## Listen to the events

Purchasely tracks every action perfomed and you can insert these events into your own tracking system. To receive these events (`PLYEvent`) by setting yourself as a delegate (`PLYEventDelegate/PLYEventListener`), either from the `start` method:

{% tabs %}
{% tab title="Swift" %}
```swift
 Purchasely.start(withAPIKey: "API_KEY", eventDelegate: self)
```
{% endtab %}

{% tab title="Objective-C" %}
```objectivec
[Purchasely startWithAPIKey:@"API_KEY"
					  appUserId:@"USER_ID"
				  eventDelegate:self
					 uiDelegate:nil
					   logLevel: LogLevelInfo];
```
{% endtab %}

{% tab title="Kotlin" %}
```kotlin
Purchasely.Builder(applicationContext)
            .apiKey("API_KEY")
            .eventListener(eventListener)
            .stores(listOf(GoogleStore(), HuaweiStore(), AmazonStore()))
            .build()
            .start()
```
{% endtab %}

{% tab title="Java" %}
```java
new Purchasely.Builder(applicationContext)
            .apiKey("API_KEY")
            .eventListener(eventListener)
            .stores(listOf(GoogleStore(), HuaweiStore(), AmazonStore()))
            .build()
            .start();
```
{% endtab %}

{% tab title="React Native" %}
```javascript
// Nothing special to setup, just go to "Receiving events" below
```
{% endtab %}

{% tab title="Cordova" %}
```javascript
// Nothing special to setup, just go to "Receiving events" below
```
{% endtab %}
{% endtabs %}

or later

{% tabs %}
{% tab title="Swift" %}
```swift
 Purchasely.setEventDelegate(self)
```
{% endtab %}

{% tab title="Objective-C" %}
```objectivec
[Purchasely setEventDelegate:self];
```
{% endtab %}

{% tab title="Kotlin" %}
```kotlin
Purchasely.eventListener = eventListener
```
{% endtab %}

{% tab title="Java" %}
```java
Purchasely.setEventListener(eventListener);
```
{% endtab %}

{% tab title="React Native" %}
```javascript
// Nothing special to setup, just go to "Receiving events" below
```
{% endtab %}

{% tab title="Cordova" %}
```javascript
// Nothing special to setup, just go to "Receiving events" below
```
{% endtab %}
{% endtabs %}

## Receiving events

You will receive the events like this :

{% tabs %}
{% tab title="Swift" %}
```swift
	func eventTriggered(_ event: PLYEvent, properties: [String : Any]?) {
		switch event {
		case .linkOpened:
			print("Link opened")
		default:
			print("Ignored")
		}
	}
```
{% endtab %}

{% tab title="Objective-C" %}
```objectivec
- (void)eventTriggered:(enum PLYEvent)event properties:(NSDictionary<NSString *,id> * _Nullable)properties {
	switch (event) {
		case PLYEventLinkOpened:
			NSLog(@"Link opened");
		default:
			NSLog(@"Ignored");
	}
}
```
{% endtab %}

{% tab title="Kotlin" %}
```kotlin
private val eventListener = object : io.purchasely.ext.EventListener {
    override fun onEvent(event: PLYEvent) {
        when (event) {
            PLYEvent.LoginTapped -> Log.d("Purchasely", "Login tapped, we should open login page")
        }
    }
}
```
{% endtab %}

{% tab title="Java" %}
```java
private EventListener eventListener = new EventListener() {
    @Override
    public void onEvent(@NotNull PLYEvent event) {
        if(event instanceof PLYEvent.LoginTapped) {
            Log.d("Purchasely", "Login tapped, we should open login page");
        }
    }
};
```
{% endtab %}

{% tab title="React Native" %}
```javascript
Purchasely.addEventListener((event) => {
    console.log('Event Name ' + event.name);
    console.log(event.properties);
    console.log(event);
});

//When you do not want to listen to events anymore
Purchasely.removeEventListener();
```
{% endtab %}

{% tab title="Cordova" %}
```javascript
Purchasely.addEventsListener((event) => {
       console.log("Event Name " + event.name);
       console.log(event.properties);
       console.log(event);
});
```
{% endtab %}
{% endtabs %}
