# Localization

The SDK displays some text directly to the user (error messages, restore or login button text, …). These texts are translated in 18 languages:

* English
* French
* German
* Spanish
* Portuguese
* Italian
* Czech
* Polish
* Greek
* Chinese (Simplifed and traditional)
* Japanese
* Russian
* Turkish
* Swedish
* Korean
* Indonesian
* Arab

That means that every error message and UI element will automatically translated in the user device language (if matching).

### Manually set the language

By default, Purchasely uses the device / app language set by the OS.\
If your app has an internal language selector, you will want to set that language to your Paywalls. You can force the SDK to be working in a specific language by calling the following method.

Your language code must be [ISO 639-1](https://fr.wikipedia.org/wiki/Liste\_des\_codes\_ISO\_639-1) or [ISO 639-2](https://fr.wikipedia.org/wiki/Liste\_des\_codes\_ISO\_639-2).

{% tabs %}
{% tab title="Swift" %}
```swift
// Force language in french
let locale = Locale(identifier: "fr")
Purchasely.setLanguage(from: locale)
```
{% endtab %}

{% tab title="Objective-C" %}
```objectivec
// Force language in french
NSLocale *locale = [NSLocale localeWithLocaleIdentifier: @"es"];
[Purchasely setLanguageFrom: locale];
```
{% endtab %}

{% tab title="Kotlin" %}
```kotlin
// Force language to spanish
Purchasely.language = Locale("es")

// Force language to italian
Purchasely.language = Locale.ITALY
```
{% endtab %}

{% tab title="Java" %}
```java
// Force language to spanish
Purchasely.setLanguage(new Locale("es"));

// Force language to italian
Purchasely.setLanguage(Locale.ITALY);
```
{% endtab %}

{% tab title="React Native" %}
```typescript
// Force language to spanish
Purchasely.setLanguage("es");
```
{% endtab %}

{% tab title="Cordova" %}
```javascript
// Force language to spanish
Purchasely.setLanguage("es");
```
{% endtab %}

{% tab title="Flutter" %}
```dart
Purchasely.setLanguage('es');
```
{% endtab %}

{% tab title="Unity" %}
```csharp
private PurchaselyRuntime.Purchasely _purchasely;

_purchasely.SetLanguage("en");
```
{% endtab %}
{% endtabs %}

{% hint style="warning" %}
If your paywall is not available in the language you have set, Purchasely will display text inside the paywall in the language of the paywall set in Purchasely console and not the language you have enforced for consistency.
{% endhint %}

### Override default localizations

If you want to change the tone of the messages, you can override our translations and set yours. To do so, you just need to set the key and value corresponding to the message you want to change in your own `Localizable.strings` file (iOS) or `strings.xml` (Android) file.

The keys that can be overriden are in the following files with the default translations in English.

{% file src="../.gitbook/assets/Localizable (1).strings" %}
iOS Localizable.strings - English version
{% endfile %}

{% file src="../.gitbook/assets/strings (1).xml" %}
Android strings - English version
{% endfile %}

