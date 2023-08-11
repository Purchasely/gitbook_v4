# SDK configurations

With SDK v3, Purchasely moves from a monolith to a modular system composed of 3 modules:

* Transaction processor: Cross-platform management of subscriptions and one-time purchases
* Subscriber Data Hub: Real-time subscription lifecycle events used to fuel our dashboards and integrations like [Firebase analytics](https://firebase.google.com/docs/analytics), [Amplitude](https://amplitude.com), [Airship](https://www.airship.com/fr?), [Braze](https://www.braze.com), [Batch](https://batch.com), [Segment](https://segment.com), …
* User Journey Optimizer: Our Paywall CMS to create and optimize native subscription screens



That way Purchasely can be used in many ways to:

* Perform purchases
* Analyse purchases that were made with your own IAP system (aka _observer mode_)
* Display paywalls
* Use everything offered by Purchasely without changing your own transactional system

And of course everything listed above.



To reflect these compositions, you have to select a `runningMode` when you initialize Purchasely:

* `transactionOnly`
* `observer`
* `paywallObserver`
* `full`



### Running modes comparison

{% tabs %}
{% tab title="paywallObserver" %}
![](<../../.gitbook/assets/paywall + observer mode.png>)
{% endtab %}

{% tab title="Full" %}
![](<../../.gitbook/assets/full mode.png>)
{% endtab %}
{% endtabs %}

### Running modes

<table><thead><tr><th width="213.63814712584755"></th><th width="298.93536682393926">Description</th><th>Modules</th></tr></thead><tbody><tr><td><code>paywallObserver</code></td><td><p>Same as <code>paywallOnly</code> but Purchasely also observes transactions made by your system to fuel its dashboards and Webhook.</p><p></p><p><a href="paywall-observer-mode.md">Details</a>.</p></td><td><p>Paywall Builder</p><p>Subscriber Data Hub</p></td></tr><tr><td><code>full</code> <em>(default)</em></td><td><p>Purchasely handles everything from paywall to transactions including data and Webhooks.</p><p></p><p><a href="full-mode.md">Details</a>.</p></td><td>Transaction Processor<br>Subscriber Data Hub<br>Paywall Builder</td></tr></tbody></table>

