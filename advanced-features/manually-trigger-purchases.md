# Purchase manually

Purchasely provides customizable presentation templates you but if you want to create your own and only use Purchasely for handling the purchase process you can. We offer methods to:

* Get a product
* Get a plan&#x20;
* Get a users subscriptions
* Purchase a product
* Restore all products

### Getting all products

{% tabs %}
{% tab title="Swift" %}
```swift
Purchasely.allProducts(success: { (products) in
	// Returns an array of products and its available plans
}, failure: { (error) in
	// Display error
})
```
{% endtab %}

{% tab title="Objective-C" %}
```objectivec
[Purchasely allProductsWithSuccess:^(NSArray<PLYProduct *> * _Nonnull products) {
	NSLog(@"%ld products available", products.count);
}
						   failure:^(NSError * _Nullable error) {
	NSLog(@"Error %@", error);
}];
```
{% endtab %}

{% tab title="Kotlin" %}
```kotlin
Purchasely.allProducts(
    onSuccess = { products ->
       // Returns an array of products and its available plans 
    },
    onError = {
       // display error
    }
)
```
{% endtab %}

{% tab title="Java" %}
```java
Purchasely.allProducts(new ProductsListener() {
    @Override
    public void onSuccess(@NonNull List<PLYProduct> list) {
        // Returns an array of products and its available plans 
    }

    @Override
    public void onFailure(@NonNull Throwable throwable) {
        // Display error
    }
});
```
{% endtab %}

{% tab title="React Native" %}
```javascript
const products = await Purchasely.allProducts();
console.log('Products', products);
```
{% endtab %}

{% tab title="Cordova" %}
```javascript
Purchasely.allProducts(products => {
       console.log("Products " + products);
		}, (error) => {
		   console.log(error);
		}
);
```
{% endtab %}

{% tab title="Flutter" %}
```dart
List<PLYProduct> products = await Purchasely.allProducts();
print('Products $products');
```
{% endtab %}

{% tab title="Unity" %}
```csharp
private PurchaselyRuntime.Purchasely _purchasely;

...
_purchasely.GetAllProducts(OnGetAllProductsSuccess, Log);
...

private void OnGetAllProductsSuccess(List<Product> products)
{
	Log($"Get All Products Success. Products fetched: {products.Count}.");
	foreach (var product in products)
	{
		LogProduct(product);
	}
}
```
{% endtab %}
{% endtabs %}

### Getting a product

{% tabs %}
{% tab title="Swift" %}
```swift
Purchasely.product(with: "PRODUCT_VENDOR_ID", success: { (product) in
	// Returns a product and its available plans
}, failure: { (error) in
	// Display error
})
```
{% endtab %}

{% tab title="Objective-C" %}
```objectivec
[Purchasely productWith:@"PRODUCT_VENDOR_ID" success:^(PLYProduct * _Nonnull) {
	// Display the product and its plans
} failure:^(NSError * _Nullable) {
	// Display error
}];
```
{% endtab %}

{% tab title="Kotlin" %}
```kotlin
Purchasely.product("PRODUCT_VENDOR_ID",
    onSuccess = { product ->
        // Returns a product and its available plans
    },
    onError = { throwable ->
        //display an error
    }
)
```
{% endtab %}

{% tab title="Java" %}
```java
Purchasely.product("PRODUCT_VENDOR_ID", new ProductListener() {
    @Override
    public void onSuccess(@Nullable PLYProduct product) {
        // Returns a product and its available plans
    }

    @Override
    public void onFailure(@NotNull Throwable throwable) {
        //display an error
    }
});
```
{% endtab %}

{% tab title="React Native" %}
```javascript
try {
  const product = await Purchasely.productWithIdentifier('PRODUCT_VENDOR_ID');
  console.log(' ==> Product');
  console.log(product.vendorId);
  console.log(product.name);
  console.log(product.plans);
} catch (e) {
  console.log(e);
}
```
{% endtab %}

{% tab title="Cordova" %}
```javascript
Purchasely.productWithIdentifier('PRODUCT_VENDOR_ID', (product) => {
	console.log(' ==> Product');
	console.log(product.vendorId);
	console.log(product.name);
	console.log(product.plans);
}, (error) => {
	console.log(error);
});
```
{% endtab %}

{% tab title="Flutter" %}
```dart
PLYProduct product =
          await Purchasely.productWithIdentifier("PRODUCT_VENDOR_ID");
print(product.name);
```
{% endtab %}

{% tab title="Unity" %}
```csharp
private PurchaselyRuntime.Purchasely _purchasely;

...
_purchasely.GetProduct("productId", LogProduct, Log);
...

private void LogProduct(Product product)
{
	Log($"Product name: {product.name}. ID: {product.vendorId}");
}
```
{% endtab %}
{% endtabs %}

### Getting a plan

{% tabs %}
{% tab title="Swift" %}
```swift
Purchasely.plan(with: "PLAN_VENDOR_ID", success: { (plan) in
	// Use the plan to display a price or start a purchase
}, failure: { (error) in
	// Display error
})
```
{% endtab %}

{% tab title="Objective-C" %}
```objectivec
[Purchasely planWith:@"PLAN_VENDOR_ID" success:^(PLYPlan * plan) {
	// Use the plan to display a price or start a purchase
} failure:^(NSError * error) {
	// Display error
}];
```
{% endtab %}

{% tab title="Kotlin" %}
```kotlin
Purchasely.plan("PLAN_VENDOR_ID",
    onSuccess = { plan ->
        // Use the plan to display a price or start a purchase
    },
    onError = { throwable ->
        //display an error
    }
)
```
{% endtab %}

{% tab title="Java" %}
```java
Purchasely.plan("PLAN_VENDOR_ID", new PlanListener() {
    @Override
    public void onSuccess(@Nullable PLYPlan plan) {
        // Use the plan to display a price or start a purchase
    }

    @Override
    public void onFailure(@NotNull Throwable throwable) {
        //display an error
    }
});
```
{% endtab %}

{% tab title="React Native" %}
```javascript
try {
  const plan = await Purchasely.planWithIdentifier('PLAN_VENDOR_ID');
  console.log(' ==> Plan');
  console.log(plan.vendorId);
  console.log(plan.name);
  console.log(plan.price);
  console.log(plan.amount);
  console.log(plan.period);
  console.log(plan.hasIntroductoryPrice);
  console.log(plan.introPrice);
  console.log(plan.introAmount);
  console.log(plan.introDuration);
} catch (e) {
  console.log(e);
}
```
{% endtab %}

{% tab title="Cordova" %}
```javascript
Purchasely.planWithIdentifier('PLAN_VENDOR_ID', (plan) => {
	console.log(' ==> Plan');
	console.log(plan.vendorId);
	console.log(plan.name);
	console.log(plan.price);
	console.log(plan.amount);
	console.log(plan.period);
	console.log(plan.hasIntroductoryPrice);
	console.log(plan.introPrice);
	console.log(plan.introAmount);
	console.log(plan.introDuration);
}, (error) => {
	console.log(error);
});
```
{% endtab %}

{% tab title="Flutter" %}
```dart
PLYPlan plan =
          await Purchasely.plantWithIdentifier("PLAN_VENDOR_ID");
print(plan.name);
```
{% endtab %}

{% tab title="Unity" %}
```csharp
private PurchaselyRuntime.Purchasely _purchasely;

...
_purchasely.GetPlan("planId", LogPlan, Log);
...

private void LogPlan(Plan plan)
{
    Log($"Plan name: {plan.name}. ID: {plan.vendorId}");
}
```
{% endtab %}
{% endtabs %}

### Purchasing a plan

{% tabs %}
{% tab title="Swift" %}
```swift
Purchasely.purchase(plan: plan, success: {
	// Unlock / reload content and display a success / thank you message to user
}, failure: { (error) in
	// Display error
})
```
{% endtab %}

{% tab title="Objective-C" %}
```objectivec
[Purchasely purchaseWithPlan:plan success:^{
	// Unlock / reload content and display a success / thank you message to user
} failure:^(NSError * error) {
	// Display error
}];
```
{% endtab %}

{% tab title="Kotlin" %}
```kotlin
Purchasely.purchase(this@MainActivity, plan, object: PurchaseListener {
    override fun onPurchaseStateChanged(state: State) {
        when(state) {
            is State.PurchaseComplete -> //Display success purchase
            is State.NotAvailable -> //Purchase is not available on this device
            is State.Error -> //An error happened, look at state.error
            is State.PurchaseDeferred -> //Purchase was made but verification did not happen yet
            else -> //look at all possible states for the one you may want to handle
        }
    }
})
```
{% endtab %}

{% tab title="Java" %}
```java
Purchasely.purchase(this, plan, (PurchaseListener) state -> {
    if(state instanceof State.PurchaseComplete) {
        //Display success purchase           
    } else if(state instanceof State.NotAvailable) {
        //Purchase is not available on this device
    } else if(state instanceof State.Error) {
        //An error happened, look at state.error
    } else if(state instanceof State.PurchaseDeferred) {
        //Purchase was made but verification did not happen yet
    } else {
        //look at all possible states for the one you may want to handle
    }
});
```
{% endtab %}

{% tab title="React Native" %}
```javascript
try {
  const plan = await Purchasely.purchaseWithPlanVendorId(
    'PLAN_VENDOR_ID'
  );
  console.log('Purchased ' + plan);
} catch (e) {
  console.log(e);
}
```
{% endtab %}

{% tab title="Cordova" %}
```javascript
Purchasely.purchaseWithPlanVendorId("PLAN_VENDOR_ID", (plan) => {
	console.log('Purchased ' + plan);
}, (error) => {
	console.log(error);
});
```
{% endtab %}

{% tab title="Flutter" %}
```dart
try {
    Map<dynamic, dynamic> plan =
        await Purchasely.purchaseWithPlanVendorId('PLAN_VENDOR_ID');
    print('Purchased $plan');
} catch (e) {
    print(e);
}
```
{% endtab %}

{% tab title="Unity" %}
```csharp
private PurchaselyRuntime.Purchasely _purchasely;

_purchasely.Purchase("planId", LogPlan, Log, "contentId");
```
{% endtab %}
{% endtabs %}

### Restoring all products

{% tabs %}
{% tab title="Swift" %}
```swift
Purchasely.restoreAllProducts(success: {
	// Reload content and display a success / thank you message to user
}, failure: { (error) in
	// Display error
})
```
{% endtab %}

{% tab title="Objective-C" %}
```objectivec
[Purchasely restoreAllProductsWithSuccess:^{
	// Reload content and display a success / thank you message to user
} failure:^(NSError * _Nonnull) {
	// Display error
}];
```
{% endtab %}

{% tab title="Kotlin" %}
```kotlin
Purchasely.restoreAllProducts(
    success = { plan ->
        //Restored PLYPlan succesfull
    },
    error = { error ->
        //Restored failed with PLYError
    }
)
```
{% endtab %}

{% tab title="Java" %}
```java
Purchasely.restoreAllProducts((PurchaseListener) state -> {
    if(state instanceof State.RestorationComplete) {
        //Display success restoration
    } else if(state instanceof State.RestorationNoProducts) {
        //No products to restore
    } else if(state instanceof State.RestorationFailed) {
        //An error happened, look at state.error
    } else {
        //look at all possible states for the one you may want to handle
    }
});
```
{% endtab %}

{% tab title="React Native" %}
```javascript
try {
  const restored = await Purchasely.restoreAllProducts();
  console.log('Restoration success ? ' + restored);
} catch (e) {
  console.log(e);
}
```
{% endtab %}

{% tab title="Cordova" %}
```javascript
Purchasely.restoreAllProducts(() => {
	console.log("Successfully restored");
}, (error) => {
	console.log("Restoration failed: " + error);
});
```
{% endtab %}

{% tab title="Flutter" %}
```dart
bool restored = await Purchasely.restoreAllProducts();
```
{% endtab %}

{% tab title="Unity" %}
```csharp
private PurchaselyRuntime.Purchasely _purchasely;

_purchasely.RestoreAllProducts(false, LogPlan, Log);
```
{% endtab %}
{% endtabs %}

### Getting user subscriptions

{% tabs %}
{% tab title="Swift" %}
```swift
Purchasely.userSubscriptions(success: { (subscriptions) in
	// Subscription object contains the plan purchased and the source it was purchased from (iOS or Android)
	// Calling unsubscribe() will either switch the user to its AppStore settings 
	// or display a procedure on how to unsubscribe on Android
}, failure: { (error) in
	// Display error
})
```
{% endtab %}

{% tab title="Objective-C" %}
```objectivec
[Purchasely userSubscriptionsWithSuccess:^(NSArray<PLYSubscription *> * _Nullable) {
	// Subscription object contains the plan purchased and the source it was purchased from (iOS or Android)
	// Calling unsubscribe() will either switch the user to its AppStore settings 
	// or display a procedure on how to unsubscribe on Android
} failure:^(NSError * _Nullable) {
	// Display error
}];
```
{% endtab %}

{% tab title="Kotlin" %}
```kotlin
Purchasely.userSubscriptions(
    onSuccess = { list ->
        // Subscription object contains the plan purchased and the source it was purchased from (iOS or Android)
        // Calling unsubscribe() will either switch the user to its Google Play settings
        // or display a procedure on how to unsubscribe on iOS
    },
    onError = { throwable ->
        //Display error
    }
)
```
{% endtab %}

{% tab title="Java" %}
```java
Purchasely.userSubscriptions(new SubscriptionsListener() {
    @Override
    public void onSuccess(@NotNull List<PLYSubscriptionData> list) {
        // Subscription object contains the plan purchased and the source it was purchased from (iOS or Android)
        // Calling unsubscribe() will either switch the user to its Google Play settings
        // or display a procedure on how to unsubscribe on iOS
    }

    @Override
    public void onFailure(@NotNull Throwable throwable) {
        //Display error
    }
});
```
{% endtab %}

{% tab title="React Native" %}
```javascript
try {
  const subscriptions = await Purchasely.userSubscriptions();
  console.log(' ==> Subscriptions');
  if (subscriptions[0] !== undefined) {
    console.log(subscriptions[0].plan);
    console.log(subscriptions[0].subscriptionSource);
    console.log(subscriptions[0].nextRenewalDate);
    console.log(subscriptions[0].cancelledDate);
  }
} catch (e) {
  console.log(e);
}
```
{% endtab %}

{% tab title="Cordova" %}
```javascript
Purchasely.userSubscriptions(subscriptions => {
       console.log("Subscriptions " + subscriptions);
		}, (error) => {
		   console.log(error);
		}
);
```
{% endtab %}

{% tab title="Flutter" %}
```dart
try {
  List<PLYSubscription> subscriptions =
      await Purchasely.userSubscriptions();
  print(' ==> Subscriptions');
  if (subscriptions.isNotEmpty) {
    print(subscriptions.first.plan);
    print(subscriptions.first.subscriptionSource);
    print(subscriptions.first.nextRenewalDate);
    print(subscriptions.first.cancelledDate);
  }
} catch (e) {
  print(e);
}
```
{% endtab %}

{% tab title="Unity" %}
```csharp
private PurchaselyRuntime.Purchasely _purchasely;

...
_purchasely.GetUserSubscriptions(OnGetSubscriptionsSuccess, Log);
...

private void OnGetSubscriptionsSuccess(List<SubscriptionData> subscriptionData)
{
	Log("Get Subscription Data Success.");

	foreach (var subscription in subscriptionData)
	{
		Log($"Subscription ID: {subscription.id}");

		var plan = subscription.plan;
		if (plan != null)
			LogPlan(plan);

		var product = subscription.product;
		if (product != null)
			LogProduct(product);
	}
}
```
{% endtab %}
{% endtabs %}

###
