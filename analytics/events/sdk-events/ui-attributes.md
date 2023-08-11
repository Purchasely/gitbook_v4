# UI attributes

## Attributes

All our UI events are broadcast with attributes, you will find here the full list of those attributes and their specifics.

<table><thead><tr><th></th><th width="282.3333333333333"></th><th></th></tr></thead><tbody><tr><td>Attribute</td><td>Description</td><td>Mandatory</td></tr><tr><td>sdk_version</td><td><p><strong>int</strong><br></p><p>Contains the SDK version.<br><br>That attribute will be filled for all events.</p></td><td>yes</td></tr><tr><td>event_name</td><td><p><strong>string</strong></p><p><br>Contains the name of the event. <a href="front-end-events.md">learn more</a><br><br>That attribute will be filled for all events.</p></td><td>yes</td></tr><tr><td>event_created_at_ms</td><td><p><strong>int</strong> <br>in milliseconds since the Epoch</p><p><br>Contains the date which the event was sent the first time. In case of retry that attribute will still be set with the time at the first try.<br><br>That attribute will be filled for all events.</p></td><td>yes</td></tr><tr><td>event_created_at</td><td><p><strong>string</strong> <br>in ISO 8601</p><p><br>Contains the date which the event was sent the first time. In case of retry that attribute will still be set with the time at the first try.<br><br>That attribute will be filled for all events.</p></td><td>yes</td></tr><tr><td>displayed_presentation</td><td><p><strong>string</strong></p><p><br>Contains the Presentation id that was displayed to the user. Reference to the Paywall vendor id you created in the Purchasely console. <br><br>That attribute will be filled for every <em>Paywall User Behavior</em> events.</p></td><td>no</td></tr><tr><td>placement_id</td><td><strong>string</strong><br><br>Contains the placement_id from where the presentation was triggerred. <br><br>That attribute will be filled for every <em>Paywall User Behavior</em> events.</td><td>no</td></tr><tr><td>ab_test_id</td><td><strong>string</strong><br><br>Contains the id ofthe AB test if there is an AB test currently running for that placement.<br><br>That attribute will be filled for every <em>Paywall User Behavior</em> events.</td><td>no</td></tr><tr><td>variant_id</td><td><strong>string</strong><br><br>Contains the variant_id in which the user is if an AB test is running.<br><br>That attribute will be filled for every <em>Paywall User Behavior</em> events.</td><td>no</td></tr><tr><td>user_id</td><td><p><strong>string</strong></p><p><br>Contains the user_id that holds the purchase.</p><p>That attribute will be filled with the user_id you provided us through the SDK.<br><br>That attribute will be filled for all events.</p></td><td>no</td></tr><tr><td>anonymous_user_id</td><td><p><strong>string</strong></p><p><br>Contains the anonymous_user_id that holds the purchase.</p><p>That attribute will be filled with a Purchasely generated anonymous_id if your app doesn't require the user to be logged in and/or you didn't specified to us a user_id.<br><br>That attribute will be filled for all events.</p></td><td>no</td></tr><tr><td>purchasable_plans</td><td><p><strong>Array of plan</strong> (object described <a href="ui-attributes.md#plan">here</a>)<br></p><p>Contains all attributes for all displayed plans in the presentation. <br><br>That attribute will be filled for every <em>Paywall User Behavior</em> events.</p></td><td>yes</td></tr><tr><td>deeplink_identifier</td><td><p><strong>string</strong><br></p><p>Contains the deeplink used to display the paywall. <br><br>That attribute will be filled for every <em>Paywall User Behavior</em> events.</p></td><td>no</td></tr><tr><td>selected_plan</td><td><p><strong>string</strong></p><p><br>Contains the Plan id that is selected. Reference to the Plan vendor id you created in the Purchasely console (see <a href="../../../quick-start-1/console-configuration/create-your-products/products-and-plans.md">Configuring Products &#x26; Plans</a>).<br><br>That attribute will be filled for every <em>Paywall User Behavior</em> events.</p></td><td>yes</td></tr><tr><td>previous_selected_plan</td><td><p><strong>string</strong><br></p><p>Contains the Plan id that was previously selected. Reference to the Plan vendor id you created in the Purchasely console (see <a href="../../../quick-start-1/console-configuration/create-your-products/products-and-plans.md">Configuring Products &#x26; Plans</a>). <br><br>That attribute will be filled for PLAN_SELECTED events.</p></td><td>no</td></tr><tr><td>link_identifier</td><td><p><strong>string</strong><br></p><p>Contains the url of the link the user just tapped on. <br><br>That attribute will be filled for LINK_OPENED events.</p></td><td>no</td></tr><tr><td>carousels</td><td><p><strong>Array of carousels</strong> (object described <a href="ui-attributes.md#carousels">here</a>)<br></p><p>Contains all attributes for all displayed carousels in the presentation.<br><br>That attribute will be filled for every <em>Paywall User Behavior</em> events if the presentation contains at least one carousel.</p></td><td>no</td></tr><tr><td>language</td><td><p><strong>string</strong> <br>in ISO 639-1</p><p><br>Contains the language used in the displayed presentation.<br><br>That attribute will be filled for every <em>Paywall User Behavior</em> events.</p></td><td>yes</td></tr><tr><td>device</td><td><p><strong>string</strong><br></p><p>Contains the device model used by the user.<br><br>That attribute will be filled for all events.</p></td><td>yes</td></tr><tr><td>os_version</td><td><p><strong>string</strong><br></p><p>Contains the OS version running on the user's device.<br><br>That attribute will be filled for all events.</p></td><td>yes</td></tr><tr><td>type</td><td><p><strong>string</strong></p><p><br>Contains the type of device used by the user.</p><p>Possible values:</p><ul><li>PHONE</li><li>TABLET</li><li>TV</li></ul><p>That attribute will be filled for all events.</p></td><td>yes</td></tr><tr><td>error_message</td><td><p><strong>string</strong></p><p><br>Contains the error message the store returned when trying the action. <br><br>That attribute will be filled for IN_APP_PURCHASE_FAILED / IN_APP_NOT_AVAILABLE / RESTORE_FAILED / RECEIPT_FAILED events.</p></td><td>no</td></tr><tr><td>plan</td><td><p><strong>string</strong><br></p><p>Contains the Plan id of the targetted plan for the action. Reference to the Plan vendor id you created in the Purchasely console (see <a href="../../../quick-start-1/console-configuration/create-your-products/products-and-plans.md">Configuring Products &#x26; Plans</a>). <br><br>That attribute will be filled for Payment / Restore purchase / Receipts / Cancellation / IN_APP_RENEWED / SUBSCRIPTION_CANCELLED_TAPPED / SUBSCRIPTION_PLAN_TAPPED events.</p></td><td>no</td></tr><tr><td>selected_presentation</td><td><p><strong>string</strong><br></p><p>Contains the Presentation id of the selected presentaion. Reference to the Paywall vendor id you created in the Purchasely console.<br><br>That attribute will be filled for every <em>Paywall User Behavior</em> events. That attribute will be filled for OPEN_PRESENTATION and SELECTED_PRESENTATION.</p></td><td>no</td></tr><tr><td>previous_selected_presentation</td><td><p><strong>string</strong><br></p><p>Contains the Presentation id that was previously selected. Reference to the Paywall vendor id you created in the Purchasely console.<br><br>That attribute will be filled for SELECTED_PRESENTATION events.</p></td><td>no</td></tr><tr><td>selected_product</td><td><p><strong>string</strong><br></p><p>Contains the Product id that is selected. Reference to the Product vendor id you created in the Purchasely console (see <a href="../../../quick-start-1/console-configuration/create-your-products/products-and-plans.md">Configuring Products &#x26; Plans</a>).<br><br>That attribute will be filled for SUBSCRIPTION_DETAILS_VIEWED events.</p></td><td>no</td></tr><tr><td>plan_change_type</td><td><p><strong>string</strong></p><p><br>Contains the type of plan change the user did.</p><p>Possible values:</p><ul><li>CROSSGRADE</li><li>DOWNGRADE</li><li>UPGRADE</li></ul><p>That attribute will be filled for SUBSCRIPTION_PLAN_TAPPED events.</p></td><td>no</td></tr><tr><td>running_subscriptions</td><td><p><strong>Array of string</strong><br></p><p>Contains pairs of Plan id and Product id for each active subscriptions the users has. Plan and Product ids are the ones you created in the Purchasely console (see <a href="../../../quick-start-1/console-configuration/create-your-products/products-and-plans.md">Configuring Products &#x26; Plans</a>). <br><br>That attribute will be filled for every <em>Phone Settings</em> events.</p></td><td>no</td></tr><tr><td>cancellation_reason_id</td><td><p><strong>string</strong><br></p><p>Contains the id of the reason the user answered through the cancellation survey triggered with Purchasely. <br><br>That attribute will be filled for CANCELLATION_REASON_PUBLISHED events.</p></td><td>no</td></tr><tr><td>cancellation_reason</td><td><p><strong>string</strong><br></p><p>Contains the reason the user answered through the cancellation survey triggered with Purchasely. That attribute will be filled for CANCELLATION_REASON_PUBLISHED events.</p></td><td>no</td></tr></tbody></table>

### Plan



|                                                |                                                                                                                                                                                                                                                                                                                                                                                                                                                                                    |
| ---------------------------------------------- | ---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------- |
| Attribute                                      | Description                                                                                                                                                                                                                                                                                                                                                                                                                                                                        |
| type                                           | <p><strong>string</strong></p><p><br>Contains the string representation of the type of plan of one of the available plan.</p><p>Possible values:</p><ul><li>CONSUMABLE</li><li>NON_CONSUMABLE</li><li>NON_CONSUMABLE</li><li>AUTO_RENEWING_SUBSCRIPTION</li><li>NON_RENEWING_SUBSCRIPTION</li></ul>                                                                                                                                                                                |
| purchasely\_plan\_id                           | <p>string</p><p><br>Contains the Plan id of one of the purchasable plans. Reference to the Plan vendor id you created in the Purchasely console (see <a href="../../../quick-start-1/console-configuration/create-your-products/products-and-plans.md">Configuring Products &#x26; Plans</a>). </p>                                                                                                                                                                                |
| store                                          | <p><strong>string</strong><br></p><p>Contains the store on which is available one of the available plan.</p>                                                                                                                                                                                                                                                                                                                                                                       |
| store\_country                                 | <p><strong>string</strong><br>in ISO 3166</p><p><br>Contains the store country on which the user is logged in.</p>                                                                                                                                                                                                                                                                                                                                                                 |
| store\_product\_id                             | <p><strong>string</strong></p><p>Contains the product_id you created in the store console of one of the available plan.</p>                                                                                                                                                                                                                                                                                                                                                        |
| price\_in\_customer\_currency                  | <p><strong>float</strong></p><p><br>Contains the standard price in the customer currency for one the available plan.</p>                                                                                                                                                                                                                                                                                                                                                           |
| customer\_currency                             | <p><strong>string</strong><br>in ISO 4217<br></p><p>Contains the customer currency code.</p>                                                                                                                                                                                                                                                                                                                                                                                       |
| period                                         | <p><strong>string</strong></p><p><br>Contains the string representation of the standard period of one of the available plan</p><p>Possible values:</p><ul><li>DAY</li><li>WEEK</li><li>MONTH</li><li>YEAR</li></ul><p>This attribute will be filled only if the "type" of the corresponding plan is AUTO_RENEWING_SUBSCRIPTION and NON_RENEWING_SUBSCRIPTION</p>                                                                                                                   |
| duration                                       | <p><strong>int</strong></p><p><br>Contains the string representation of the number "period" of the standard periodicity of one of the available plan. To get the standard periodicity of the plan you have to concatenate "duration" and "period".</p><p><br>This attribute will be filled only if the "type" of the corresponding plan is AUTO_RENEWING_SUBSCRIPTION and NON_RENEWING_SUBSCRIPTION</p>                                                                            |
| intro\_price\_in\_customer\_currency           | <p><strong>float</strong></p><p><br>Contains the introductory offer price in the customer currency for one the available plan.</p><p><br>That attribute will be filled only if the plan has a introductory offer available.</p>                                                                                                                                                                                                                                                    |
| intro\_period                                  | <p><strong>string</strong><br></p><p>Contains the string representation of the introductory offer period of one of the available plan</p><p><br>Possible values:</p><ul><li>DAY</li><li>WEEK</li><li>MONTH</li><li>YEAR</li></ul><p>This attribute will be filled only if the "type" of the corresponding plan is AUTO_RENEWING_SUBSCRIPTION and NON_RENEWING_SUBSCRIPTION only if the plan has an introductory offer available.</p>                                               |
| intro\_duration                                | <p><strong>int</strong></p><p><br>Contains the string representation of the number "period" of the introductory offer periodicity of one of the available plan. To get the introductory offer periodicity of the plan you have to concatenate "duration" and "period".<br></p><p>This attribute will be filled only if the "type" of the corresponding plan is AUTO_RENEWING_SUBSCRIPTION and NON_RENEWING_SUBSCRIPTION" only if the plan has an introductory offer available.</p> |
| has\_free\_trial                               | <p><strong>bool</strong></p><p><br>True if a free trial is available for the plan.</p>                                                                                                                                                                                                                                                                                                                                                                                             |
| free\_trial\_period                            | <p><strong>string</strong></p><p><br>Contains the string representation of the free trial offer period of one of the available plan</p><p>Possible values:</p><ul><li>DAY</li><li>WEEK</li><li>MONTH</li><li>YEAR</li></ul><p>This attribute will be filled only if the "type" of the corresponding plan is AUTO_RENEWING_SUBSCRIPTION and NON_RENEWING_SUBSCRIPTION only if the plan has an free trial offer available.</p>                                                       |
| free\_trial\_duration                          | <p><strong>int</strong><br></p><p>Contains the string representation of the number "period" of the free trial offer periodicity of one of the available plan. To get the free trial periodicity of the plan you have to concatenate "duration" and "period".<br><br></p><p>This attribute will be filled only if the "type" of the corresponding plan is AUTO_RENEWING_SUBSCRIPTION and NON_RENEWING_SUBSCRIPTION" only if the plan has an free trial offer available.</p>         |
| discount\_referent                             | <p><strong>string</strong><br></p><p>Contains the Plan id of the plan that is used on the presentation to make a pricing comparison.</p>                                                                                                                                                                                                                                                                                                                                           |
| discount\_percentage\_comparison\_to\_referent | <p><strong>string</strong><br></p><p>Contains the percentage of discount the plan offers in comparison to the referent.</p>                                                                                                                                                                                                                                                                                                                                                        |
| discount\_price\_comparison\_to\_referent      | <p><strong>float</strong><br></p><p>Contains the price difference betwee, the plan and the referent.</p>                                                                                                                                                                                                                                                                                                                                                                           |
| is\_default                                    | <p><strong>bool</strong><br></p><p>True if the plan is selected by default in the presentation.</p>                                                                                                                                                                                                                                                                                                                                                                                |

### Carousels



|                             |                                                                                                                                                                     |
| --------------------------- | ------------------------------------------------------------------------------------------------------------------------------------------------------------------- |
| Attribute                   | Description                                                                                                                                                         |
| selected\_slide             | <p><strong>int</strong><br></p><p>Contains the id of the current selected slide.</p>                                                                                |
| number\_of\_slides          | <p><strong>int</strong><br></p><p>Contains the total number of slides of the carousel.</p>                                                                          |
| is\_carousel\_auto\_playing | <p><strong>bool</strong><br></p><p>True if the carousel's slides switch automatically.</p>                                                                          |
| default\_slide              | <p><strong>int</strong><br></p><p>Contains the id of the default selected slide.</p>                                                                                |
| previous\_slide             | <p><strong>int</strong><br></p><p>Contains the id of the previously selected slide. <br><br>That attribute will only be filled for CAROUSEL_SLIDE_SWIPED event.</p> |

## JSON samples

{% tabs %}
{% tab title="PRESENTATION_VIEWED" %}
```javascript
{
  "language" : "en",
  "sdk_version" : "2.0.0",
  "anonymous_user_id" : "23DE2D20-7878-414C-B2EC-4B1E632995EB",
  "event_name" : "PRESENTATION_VIEWED",
  "displayed_presentation" : "YOUR_PAYWALL_ID",
  "carousels" : [
    {
      "default_slide" : 1,
      "is_carousel_auto_playing" : false,
      "number_of_slides" : 8,
      "selected_slide" : 1
    }
  ],
  "os_version" : "iOS 15.1.1",
  "device" : "iPhone13,4",
  "event_created_at" : "2021-12-08T16:49:20.343Z",
  "template" : "PRES_Y90FJV4M1ZZQF1C8PECVZC3WPMKYUP",
  "selected_plan" : "PURCHASELY_PLUS_MONTHLY",
  "type" : "PHONE",
  "purchasable_plans" : [
    {
      "store_country" : "FRA",
      "price_in_customer_currency" : 40.99,
      "duration" : 1,
      "period" : "YEAR",
      "has_free_trial" : true,
      "free_trial_duration" : 2,
      "free_trial_period" : "MONTH",
      "customer_currency" : "EUR",
      "is_default" : false,
      "type" : "AUTO_RENEWING_SUBSCRIPTION",
      "store" : "APPLE_APP_STORE",
      "purchasely_plan_id" : "PURCHASELY_PLUS_YEARLY",
      "store_product_id" : "com.purchasely.plus.yearly"
    },
    {
      "customer_currency" : "EUR",
      "has_free_trial" : false,
      "duration" : 6,
      "store" : "APPLE_APP_STORE",
      "purchasely_plan_id" : "PURCHASELY_PLUS_6MONTHS",
      "price_in_customer_currency" : 65.99,
      "type" : "AUTO_RENEWING_SUBSCRIPTION",
      "period" : "MONTH",
      "store_product_id" : "com.purchasely.plus.6months",
      "is_default" : false,
      "store_country" : "FRA"
    },
    {
      "is_default" : true,
      "intro_price_in_customer_currency" : 0.49,
      "price_in_customer_currency" : 9.49,
      "intro_period" : "MONTH",
      "type" : "AUTO_RENEWING_SUBSCRIPTION",
      "store_product_id" : "com.purchasely.plus.monthly",
      "intro_duration" : 3,
      "store_country" : "FRA",
      "customer_currency" : "EUR",
      "has_free_trial" : false,
      "period" : "MONTH",
      "purchasely_plan_id" : "PURCHASELY_PLUS_MONTHLY",
      "store" : "APPLE_APP_STORE",
      "duration" : 1
    }
  ],
  "event_created_at_ms" : 1638982160343
}
```
{% endtab %}

{% tab title="CAROUSEL_SLIDE_SWIPED" %}
```javascript
{
  "os_version" : "iOS 15.0",
  "language" : "en",
  "type" : "PHONE",
  "displayed_presentation" : "YOUR_PAYWALL_ID",
  "purchasable_plans" : [
    {
      "purchasely_plan_id" : "PURCHASELY_PLUS_YEARLY",
      "is_default" : false,
      "store" : "APPLE_APP_STORE",
      "period" : "YEAR",
      "has_free_trial" : true,
      "store_product_id" : "com.purchasely.plus.yearly",
      "price_in_customer_currency" : 43.99,
      "free_trial_period" : "MONTH",
      "customer_currency" : "USD",
      "store_country" : "USA",
      "free_trial_duration" : 2,
      "type" : "AUTO_RENEWING_SUBSCRIPTION",
      "duration" : 1
    },
    {
      "store_product_id" : "com.purchasely.plus.6months",
      "price_in_customer_currency" : 74.99,
      "store" : "APPLE_APP_STORE",
      "is_default" : false,
      "customer_currency" : "USD",
      "type" : "AUTO_RENEWING_SUBSCRIPTION",
      "duration" : 6,
      "purchasely_plan_id" : "PURCHASELY_PLUS_6MONTHS",
      "store_country" : "USA",
      "period" : "MONTH",
      "has_free_trial" : false
    },
    {
      "is_default" : true,
      "period" : "MONTH",
      "intro_price_in_customer_currency" : 0.49,
      "intro_duration" : 3,
      "duration" : 1,
      "store_product_id" : "com.purchasely.plus.monthly",
      "intro_period" : "MONTH",
      "store_country" : "USA",
      "has_free_trial" : false,
      "type" : "AUTO_RENEWING_SUBSCRIPTION",
      "store" : "APPLE_APP_STORE",
      "customer_currency" : "USD",
      "price_in_customer_currency" : 9.99,
      "purchasely_plan_id" : "PURCHASELY_PLUS_MONTHLY"
    }
  ],
  "carousels" : [
    {
      "previous_slide" : 2,
      "number_of_slides" : 8,
      "default_slide" : 1,
      "selected_slide" : 3,
      "is_carousel_auto_playing" : false
    }
  ],
  "event_created_at" : "2021-12-06T10:20:44.818Z",
  "event_created_at_ms" : 1638786044818,
  "device" : "arm64",
  "anonymous_user_id" : "67C77206-F279-4932-B322-69DC4319B517",
  "sdk_version" : "2.0.0",
  "selected_plan" : "PURCHASELY_PLUS_MONTHLY",
  "template" : "A6F9DC4D-6A90-42B6-BBE9-AA9BA3AFFEFC",
  "event_name" : "CAROUSEL_SLIDE_SWIPED"
}
```
{% endtab %}

{% tab title="SUBSCRIPTION_PLAN_TAPPED" %}
```javascript
{
  "device" : "iPhone13,4",
  "event_created_at_ms" : 1638787748990,
  "event_created_at" : "2021-12-06T10:49:08.990Z",
  "type" : "PHONE",
  "os_version" : "iOS 15.0.2",
  "event_name" : "SUBSCRIPTION_PLAN_TAPPED",
  "sdk_version" : "2.0.0",
  "plan" : "PURCHASELY_PLUS_YEARLY",
  "running_subscriptions" : [
    {
      "plan" : "PURCHASELY_PLUS_MONTHLY",
      "product" : "PURCHASELY_PLUS"
    }
  ],
  "plan_change_type" : "UPGRADE",
  "anonymous_user_id" : "23DE2D20-7878-414C-B2EC-4B1E632995EB"
}
```
{% endtab %}
{% endtabs %}
