# Close SDK (Android only)

When done with Purchasely, you should call `close()` to remove all references to your activities. This method must only be called when you won't be using our SDK in the current user session. If you need to use our SDK again after calling `close()` then you need to call `Purchasely.Builder()` and `Purchasely.start()`.

For example you can call this method in the `onDestroy()` method of your main activity



{% tabs %}
{% tab title="Kotlin" %}
```kotlin
override fun onDestroy() {
    super.onDestroy()
    Purchasely.close()
}
```
{% endtab %}

{% tab title="Java" %}
```java
@Override
protected void onDestroy() {
    super.onDestroy();
    Purchasely.close();
}
```
{% endtab %}

{% tab title="ReactNative" %}
```
Purchasely.close();
```
{% endtab %}

{% tab title="Cordova" %}
```
Purchasely.close();
```
{% endtab %}

{% tab title="Flutter" %}
```dart
Purchasely.close();
```
{% endtab %}
{% endtabs %}

\
