# Migrate to SDK v3.0

Purchasely SDK v3.0 brings a lot of new amazing features:

* New [running modes](../../../../quick-start-1/sdk-configuration/)
* [Paywall actions interceptor](../../../../advanced-features/paywall-action-interceptor.md) to intercept and override every paywall action
* New event properties to provide you with even more contexts

It also removes the following:

* Purchase interceptor and login handler are removed and replaced by the [paywall actions interceptor](../../../../advanced-features/paywall-action-interceptor.md)
* UI Events properties changed



## Update `start` method

The start method changes:

* the `observerMode` parameter is replaced by a more comprehensive `runningMode`
* the `confirmPurchaseHandler` parameter is replaced by `paywallActionsInterceptor`

## Grab new events and properties



## Expect `null` controllers / fragments

{% hint style="warning" %}
Even if you don't use observer mode or new modes you will have to adapt your code
{% endhint %}

Some of the [new modes](../../../../quick-start-1/sdk-configuration/) block the display of the paywall. In that case the paywall is not returned.\
This is the reason why the following methods are not returning optionals:

* productController
* planController
* presentationController



## Migrate the Purchase interceptor&#x20;

Purchase interceptor was used to trigger app specific code before triggering the purchase using Purchasely.

It could be used to display specific terms and conditions, present a parental gate or perform a purchase using your own code or a third party subscription tool.



If you are using Purchase interceptor you probably have some code like that:

{% tabs %}
{% tab title="Swift" %}
```swift
Purchasely.setConfimPurchaseHandler { [weak self](paywallController, processToPayment) in
	// Display the terms of use to your user
	self?.presentTermsAndConditions(above: paywallController) { (userAcceptedTerms) in
		// Don't forget to notify the SDK by calling `processToPayment`
		processToPayment(userAcceptedTerms)
	}
}
```
{% endtab %}

{% tab title="Objective-C" %}
```objectivec
[Purchasely setConfimPurchaseHandler:^(UIViewController * paywallController, void (^ processToPayment)(BOOL)) {
                    [self presentTermsAndConditionsAbove:paywallController completion:^(BOOL userAcceptedTerms) {
                                        processToPayment(userAcceptedTerms);
                    }];
}];
```
{% endtab %}

{% tab title="Kotlin" %}
```kotlin
Purchasely.setConfirmPurchaseHandler { activity, processToPayment ->
        //if there is no activity then there is nothing to display
        if (activity == null) return@setConfirmPurchaseHandler
        
        //call your method to display your view 
        //and return boolean result to processToPayment
        presentTermsAndConditions(activity) { userAcceptedTerms ->
        		// Don't forget to notify the SDK by calling `processToPayment`
        		processToPayment(userAcceptedTerms)
        }
}
```
{% endtab %}

{% tab title="Java" %}
```java
Purchasely.setConfirmPurchaseHandler((activity, listener) -> {
    //if there is no activity then there is nothing to display
    if (activity == null) return;

    /*  call your method to display your view
        and return boolean result to processToPayment
        listener.processToPayment(userAcceptedTerms);
     */
    presentTermsAndConditions(activity, listener);
});

//You can also use the method for kotlin with Function interface
```
{% endtab %}

{% tab title="React Native" %}
```javascript
Purchasely.setPurchaseCompletionCallback(() => {
    //Present your own screen before purchase
    console.log('Received callback from user tapped on purchase button');
    
    //Call this method to continue to payment flow when you close your screen
    Purchasely.processToPayment(true);
});
```
{% endtab %}

{% tab title="Cordova" %}
```javascript
Purchasely.setConfirmPurchaseHandler(onPurchaseTapped => {
    //Present your own screen before purchase
    
    //Call this method to continue to payment flow when you close your screen
    Purchasely.processToPayment(true);
})java
```
{% endtab %}
{% endtabs %}



it should be changed to something like that:

{% tabs %}
{% tab title="Swift" %}
```swift
Purchasely.setPaywallActionsInterceptor { [weak self] (action, parameters, presentationInfo, proceed) in

	switch action {

	// Intercept the tap on purchase to display the terms and condition
	case .purchase:
		self?.presentTermsAndConditions(above: presentationInfo?.controller) { (userAcceptedTerms) in
			proceed(userAcceptedTerms)
		}
	default:
		proceed(true)
		break
	}
}
```
{% endtab %}

{% tab title="Objective-C" %}
```objectivec
[Purchasely setPaywallActionsInterceptor:^(enum PLYPresentationAction action, PLYPresentationActionParameters *parameters, PLYPresentationInfo *info, void (^ proceed)(BOOL)) {
        switch (action) {
            // Intercept the tap on purchase to display the terms and condition
            case PLYPresentationActionPurchase:{
                [self presentTermsAndConditionsAbove:info.controller completion:^(BOOL userAcceptedTerms) {
                    proceed(userAcceptedTerms);
                }];
                break;
            }
            default:
                proceed(YES);
                break;
        }
    }];
```
{% endtab %}

{% tab title="Kotlin" %}
```kotlin
Purchasely.setPaywallActionsInterceptor { info, action, parameters, processAction ->
    if (info?.activity == null) return@setPaywallActionsInterceptor

    when(action) {
        PLYPresentationAction.PURCHASE -> {
            presentTermsAndConditions(info.activity) { userAcceptedTerms ->
    		// Don't forget to notify the SDK by calling `processAction`
    		processAction(userAcceptedTerms)
        }
        else -> {
            Log.d("PLYActionInterceptor", action.value + " " + parameters)
            processAction(true)
        }
    }
}
```
{% endtab %}

{% tab title="Java" %}
```java
Purchasely.setPaywallActionsInterceptor((info, action, parameters, listener) -> {
    //if there is no activity then there is nothing to display
    if (info == null || info.getActivity() == null) return;

    switch (action) {
        case PURCHASE:
            //present your terms and call 
            //listener.processAction(true) if accepted
            //or listener.processAction(false) if not to cancel purchase
            presentTermsAndConditions(info.getActivity(), listener);
            break;
        default:
            listener.processAction(true);
    }
});
```
{% endtab %}

{% tab title="React Native" %}
```typescript
Purchasely.setPaywallActionInterceptorCallback((result) => {
    console.log('Received action from paywall ' + result.info.presentationId);

    if (result.action === PLYPaywallAction.PURCHASE) {
      console.log('User wants to purchase');
      //If you want to intercept it, close paywall and display your screen
      Purchasely.closePaywall();
    } else {
      console.log('Action unknown ' + result.action);
      Purchasely.onProcessAction(true);
    }
  });
```
{% endtab %}

{% tab title="Cordova" %}
```javascript
Purchasely.setPaywallActionInterceptor((result) => {
	console.log('Received action from paywall' + result.info.presentationId);
	
	if (result.action === Purchasely.PaywallAction.purchase) {
		console.log('User wants to purchase');
		//If you want to intercept it, close paywall and display your screen
		Purchasely.closePaywall();
	} else {
		console.log('Action unknown ' + result.action);
		Purchasely.onProcessAction(true);
	}
});
```
{% endtab %}
{% endtabs %}

{% hint style="danger" %}
If your are intercepting several actions (purchase, login, …) you must add a `case` and should only have one call to `Purchasely.setPaywallActionsInterceptor`
{% endhint %}

## Migrate the Login interceptor&#x20;

Every presentation, has an _Already subscribed? Sign-in_ button to let your customers connect to unlock a feature / access a content.&#x20;

\
To intercept the tap on this button you had to use the `loginTappedHandler` interceptor

{% tabs %}
{% tab title="Swift" %}
```swift
Purchasely.setLoginTappedHandler { (paywallController, isLoggedIn) in
	// Get your login controller
	loginCtrl = LoginViewController()
	
	// Configure the response to notify Purchasely that it needs to reload (if needed)
	loginCtrl.configure(with: isLoggedIn)
	
	paywallController.present(loginCtrl, animated: true, completion: nil)
}
```
{% endtab %}

{% tab title="Objective-C" %}
```objectivec
[Purchasely setLoginTappedHandler:^(UIViewController * paywallController, void (^ isLoggedIn)(BOOL)) {
	// Get your login controller
	LoginViewController *loginCtrl = LoginViewController()

	// Configure the response to notify Purchasely that it needs to reload (if needed)
	[loginCtrl configureWith: isLoggedIn];
	
	[paywallController presentViewController:loginCtrl animated:YES completion:nil];
}];
```
{% endtab %}

{% tab title="Kotlin" %}
```kotlin
Purchasely.setLoginTappedHandler { activity, isLoggedIn ->
    // If there is no activity then there is nothing to display
    if (activity == null) return@setLoginTappedHandler

    // Call your method to display your view 
    // and return boolean result to userLoggedIn
    presentLogin(activity) { userLoggedIn ->
    		// Don't forget to notify the SDK by calling `isLoggedIn`
    		isLoggedIn(userLoggedIn)
    }
}
```
{% endtab %}

{% tab title="Java" %}
```java
Purchasely.setLoginTappedHandler((activity, listener) -> {
    //if there is no activity then there is nothing to display
    if (activity == null) return;
    
    /*  call your method to display your view
        and return boolean result to listener
        listener.userLoggedIn(userLoggedIn);
     */
    presentLogin(activity, listener);
});

//You can also use the method for kotlin with Function interface
```
{% endtab %}

{% tab title="ReactNative" %}
```typescript
Purchasely.setLoginTappedCallback(() => {
    //Present your own screen for user to log in
    console.log('Received callback from user tapped on sign in button');
    
    //Call this method with true to update Purchasely Paywall if user logged in
    Purchasely.onUserLoggedIn(true);
});
```
{% endtab %}

{% tab title="Cordova" %}
```javascript
Purchasely.setLoginTappedHandler(onLoginTapped => {
    //Present your own screen for user to log in
    
    //Call this method with true to update Purchasely Paywall if user logged in
    Purchasely.onUserLoggedIn(true);
});

```
{% endtab %}
{% endtabs %}



With SDK v3 this feature is moved to the [paywall actions interceptor](../../../../advanced-features/paywall-action-interceptor.md) and your code should change  to something like that:

{% tabs %}
{% tab title="Swift" %}
```swift
Purchasely.setPaywallActionsInterceptor { [weak self] (action, parameters, presentationInfo, proceed) in

	switch action {

	// Intercept the tap on login
	case .login:
		// When the user has completed the process
		// Pass true to reload the paywall or dismiss the paywall if the user already has an active subscription
		self?.presentLogin(above: presentationInfo?.controller) { (loggedIn) in
			proceed(loggedIn)
		}
	default:
		proceed(true)
		break
	}
}
```
{% endtab %}

{% tab title="Objective-C" %}
```objectivec
[Purchasely setPaywallActionsInterceptor:^(enum PLYPresentationAction action, PLYPresentationActionParameters *parameters, PLYPresentationInfo *info, void (^ proceed)(BOOL)) {
        switch (action) {
            // Intercept the tap on purchase to display the terms and condition
            case PLYPresentationActionPurchase:{
                [self presentTermsAndConditionsAbove:info.controller completion:^(BOOL userAcceptedTerms) {
                    proceed(userAcceptedTerms);
                }];
                break;
            }
            default:
                proceed(YES);
                break;
        }
    }];
```
{% endtab %}

{% tab title="Kotlin" %}
```kotlin
Purchasely.setPaywallActionsInterceptor { info, action, parameters, processAction ->
    if (info?.activity == null) return@setPaywallActionsInterceptor

    when(action) {
        PLYPresentationAction.LOGIN -> {
            // Call your method to display your view 
            // and return boolean result to userLoggedIn
            presentLogin(info.activity) { userLoggedIn ->
    		// Don't forget to notify the SDK by calling `processAction`
    		processAction(userLoggedIn)
            }
        }
        else -> {
            Log.d("PLYActionInterceptor", action.value + " " + parameters)
            processAction(true)
        }
    }
}
```
{% endtab %}

{% tab title="Java" %}
```java
Purchasely.setPaywallActionsInterceptor((info, action, parameters, listener) -> {
    //if there is no activity then there is nothing to display
    if (info == null || info.getActivity() == null) return;

    switch (action) {
        case LOGIN:
            // call your method to display your view
            // and return boolean result to listener
            // listener.processAction(true);
            presentLogin(info.getActivity(), listener);
            break;
        default:
            listener.processAction(true);
    }
});
```
{% endtab %}

{% tab title="React Native" %}
```javascript
Purchasely.setPaywallActionInterceptorCallback((result) => {
    if (result.action === PLYPaywallAction.LOGIN) {
      console.log('User wants to login');
      //Present your own screen for user to log in
      Purchasely.closePaywall();
      Purchasely.userLogin('MY_USER_ID');
      //Call this method to update Purchasely Paywall
      Purchasely.onProcessAction(true);
    } else {
      Purchasely.onProcessAction(true);
    }
});
```
{% endtab %}

{% tab title="Cordova" %}
```javascript
Purchasely.setPaywallActionInterceptorCallback((result) => {
   if (result.action === PLYPaywallAction.LOGIN) {
      console.log('User wants to login');
      //Present your own screen for user to log in
      Purchasely.closePaywall();
      Purchasely.userLogin('MY_USER_ID');
      //Call this method to update Purchasely Paywall
      Purchasely.onProcessAction(true);
    } else {
      Purchasely.onProcessAction(true);
    }
  });
```
{% endtab %}
{% endtabs %}

{% hint style="danger" %}
If your are intercepting several action (purchase, login, …) you must add a `case` and should only have one call to `Purchasely.setPaywallActionsInterceptor`
{% endhint %}

##
