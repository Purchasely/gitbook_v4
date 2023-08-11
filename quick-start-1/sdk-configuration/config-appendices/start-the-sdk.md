# Start the SDK

The `start` must be done **as soon as possible** to catch every purchase / renewal.\
On iOS, initialise the SDK in your `AppDelegate` method `didFinishLaunchingWithOptions` to allow promoted In-App Purchase and support PSD2.\
This initialisation will allow tyou to access products prices instantly later in the app.&#x20;

{% hint style="info" %}
You will need an API Key that you can find in your App settings in the [Purchasely Console](https://purchasely.io).&#x20;
{% endhint %}

<figure><img src="../../../.gitbook/assets/image (10) (2).png" alt=""><figcaption></figcaption></figure>

{% tabs %}
{% tab title="Swift" %}
```swift
import Purchasely

func application(_ application: UIApplication, didFinishLaunchingWithOptions launchOptions: [UIApplicationLaunchOptionsKey: Any]?) -> Bool {
    Purchasely.start(withAPIKey: "API_KEY", appUserId: "USER_ID")
	return true
}
```
{% endtab %}

{% tab title="Objective-C" %}
```objectivec
#import <Purchasely/Purchasely-Swift.h>

- (BOOL)application:(UIApplication *)application didFinishLaunchingWithOptions:(NSDictionary *)launchOptions {
	// Override point for customization after application launch.

	[Purchasely startWithAPIKey:@"API_KEY"
			  appUserId:@"USER_ID"
			runningMode: PLYRunningModeFull
	              eventDelegate:nil
			 uiDelegate:nil
	  paywallActionsInterceptor:nil
		           logLevel: LogLevelInfo
			initialized: nil];
	return YES;
}
```
{% endtab %}

{% tab title="Kotlin" %}
```kotlin
import io.purchasely.ext.Purchasely

Purchasely.Builder(applicationContext)
    .apiKey("API_KEY")
    .logLevel(LogLevel.DEBUG) // set to warning or error for release
    .userId("USER_ID")
    .eventListener(eventListener)
    .runningMode(PLYRunningMode.Full)
    .stores(listOf(GoogleStore(), HuaweiStore()))
    .build()

// When you are ready for Purchasely to initialize,
// you must call start() method that will grab configuration and products
// from the selected stores.
Purchasely.start { isConfigured ->
}
```
{% endtab %}

{% tab title="Java" %}
```java
List<Store> stores = new ArrayList();
stores.add(new GoogleStore(), new HuaweiStore());

new Purchasely.Builder(getApplicationContext())
    .apiKey("API_KEY")
    .logLevel(LogLevel.DEBUG) // set to warning or error for release
    .userId("USER_ID")
    .eventListener(this)
    .runningMode(PLYRunningMode.Full.INSTANCE)
    .stores(stores)
    .build();

// When you are ready for Purchasely to initialize,
// you must call start() method that will grab configuration and products
// from the selected stores.
Purchasely.start(isConfigured -> {
    null;
});
```
{% endtab %}

{% tab title="React Native" %}
```javascript
import Purchasely from 'react-native-purchasely';

/**
* @params String apiKey
* @params StringArray stores : may be Google, Amazon and Huawei
* @params String userId
* @params Purchasley.LogLevel logLevel
* @params RunningMode runningMode
**/
Purchasely.startWithAPIKey(
  'API_KEY',
  ['Google'],
  'USER_ID',
  Purchasely.logLevelDebug,
  RunningMode.FULL
);

```
{% endtab %}

{% tab title="Cordova" %}
```javascript
/**
* @params String apiKey
* @params StringArray stores : may be Google, Amazon and Huawei
* @params String userId
* @params Purchasley.LogLevel logLevel
* @params Purchasely.RunningMode runningMode
**/
Purchasely.startWithAPIKey(
    'API_KEY', 
    ['Google'], 
    null, 
    Purchasely.LogLevel.DEBUG, 
    Purchasely.RunningMode.full
);
```
{% endtab %}

{% tab title="Flutter" %}
```dart
/**
* @params String apiKey
* @params StringArray stores : may be Google, Amazon and Huawei
* @params String userId
* @params PLYLogLevel logLevel
* @params PLYRunningMode runningMode
**/
bool configured = await Purchasely.startWithApiKey(
        'API_KEY',
        ['Google'],
        null,
        PLYLogLevel.debug,
        PLYRunningMode.full
    );
    
if (!configured) {
        print('Purchasely SDK not configured');
        return;
}
```
{% endtab %}
{% endtabs %}

The `userID` parameter is optional and allows you to associate the purchase to a user instead of a device.

The `eventDelegate`/`eventListener` parameter is optional and allows you to listen to all purchases events. You should implement it at least to know when the purchase is successfull.

The `uiDelegate` / `uiListener` parameter is optional and allows you to override UI dialog presented to user in case of error or success.

The `logLevel` parameter is optional and will display logs from the SDK according to the level set. We advise you to set it to warning or error for production

The `stores` parameter (for Android apps) is optional but purchase won't work without it. You need to pass a list of stores that are enabled for your application. The first store available in the user device will be the store used to make a purchase. In this sample, Google Play Billing will be used if available in user device, Huawei Mobile Services will be used otherwise.

The `runningMode` parameter is optional and allows you to use Purchasely with another In-App purchase system to prepare a migration. More details in our dedicated [section](../).
