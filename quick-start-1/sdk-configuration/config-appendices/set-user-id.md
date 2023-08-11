# Set User Id

Once your user is logged in and you can send us a userId, please do it otherwise the purchase will be tied to the device and your user won't be able to enjoy from another device. Setting it will allow you to tie a purchase to a user to use it on other devices.

This ID will be passed to the Webhook so that your backend can identify the user and unlock the access. \
If our backend made a migration of user purchases and notified your backend, we will set the refresh variable in the callback to true.

{% tabs %}
{% tab title="Swift" %}
```swift
Purchasely.userLogin(with: "123456789")
```
{% endtab %}

{% tab title="Objective-C" %}
```objectivec
[Purchasely userLoginWith:@"123456789"];
```
{% endtab %}

{% tab title="Kotlin" %}
```kotlin
Purchasely.userLogin("123456789") { refresh ->
    if (refresh) {
        //you can call your backend to refresh user information
    }
}
```
{% endtab %}

{% tab title="Java" %}
```java
Purchasely.userLogin("123456789", refresh -> {
    if(refresh) {
        //you can call your backend to refresh user information
    }
    return null;
});
```
{% endtab %}

{% tab title="React Native" %}
```javascript
Purchasely.userLogin('123456789').then((refresh) => {
  if (refresh) {
    //call your backend to refresh user information
  }
});
```
{% endtab %}

{% tab title="Cordova" %}
```javascript
Purchasely.userLogin('user_id', refresh => { 
    if(refresh) {
        // You can call your back-end to refresh user information
    }  
});
```
{% endtab %}

{% tab title="Flutter" %}
```dart
Purchasely.userLogin('123456789').then((refresh) => {
  if (refresh) {
    //call your backend to refresh user information
  }
});
```
{% endtab %}

{% tab title="Unity" %}
```csharp
private PurchaselyRuntime.Purchasely _purchasely;

_purchasely.UserLogin("userId", OnUserLoginCompleted);
```
{% endtab %}
{% endtabs %}

To remove the user (logged out) you can perform a :

{% tabs %}
{% tab title="Swift" %}
```swift
Purchasely.userLogout()
```
{% endtab %}

{% tab title="Objective-C" %}
```objectivec
[Purchasely userLogout];
```
{% endtab %}

{% tab title="Kotlin" %}
```kotlin
Purchasely.userLogout()
```
{% endtab %}

{% tab title="Java" %}
```java
Purchasely.userLogout();
```
{% endtab %}

{% tab title="React Native" %}
```javascript
Purchasely.userLogout();
```
{% endtab %}

{% tab title="Cordova" %}
```javascript
Purchasely.userLogout()
```
{% endtab %}

{% tab title="Flutter" %}
```dart
Purchasely.userLogout();
```
{% endtab %}

{% tab title="Unity" %}
```csharp
private PurchaselyRuntime.Purchasely _purchasely;

_purchasely.UserLogout();
```
{% endtab %}
{% endtabs %}



{% hint style="warning" %}
If you allow logged out / anonymous users to make purchases, please [follow these steps](../../../advanced-features/anonymous-user.md)
{% endhint %}
