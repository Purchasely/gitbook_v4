# Migrate to SDK v3.2

## Introducing A/B tests

At Purchasely we believe that product and marketing teams should be able to iterate, test, learn and optimize without having to scatter the focus of developing teams.

We know how much important AB testing is when it comes to learn and mitigate risks of experiments. That why we have designed a built-in AB testing feature to allow you to better understand and optimize your subscription business.

To be able to use Ab testing with Purchasely the only pre-requisites are to update the SDK to 3.2 or above and to have setup at least one [Placement](migrate-to-sdk-v3.1.md).





## **Setup and start an AB test**



**Step 1**: In Purchasely Console, Click on _**A/B Test**_ --> you can either click on _**Start your first A/B test**_ or _**New A/B Test**_

![](https://downloads.intercomcdn.com/i/o/525724749/82c312d943335497f95aabc7/image.png)

**Step 2**: Provide the mandatory fields- Name, ID, and Placement. You can add a short description of the A/B test created.

Please note:

* _**Name & ID**_- have to be unique
* _**Description**_- a short phrase about the test
*   _**Placement**_- Only one placement can be selected per test. If the placement was already chosen by another test, it can be used in another test.

    Significance of the A/B test ID

![](https://downloads.intercomcdn.com/i/o/525732405/e9d4ed4edce7beaf8c20c124/image.png)

**Step 3**: Select the paywall for A/B/C test respectively

Please note:

* _**ID**_- is created by default
* _**Weight**_- is assigned by default
* _**Paywall**_- you can choose any paywall that you have already created
* _**Total weight**_- your total weightage for all the tests you have created should be equivalent to 100. You can click on equalize to make them=100

![](https://downloads.intercomcdn.com/i/o/526463656/bb23865916f0367fcf2ec9e3/image.png)

You can click on _**Save as a draft**_ if you haven't finalized the test yet.

**⚠️ Attention:**

* Once you have started the A/B test:
  * You can neither edit the **P**lacement nor the paywall

## Interpreting results through Data

You have created and started a new A/B test for your desired Placement. Once the test is started, it goes live without any further dependency.

### Data Table

![](https://downloads.intercomcdn.com/i/o/526514243/cbd027cba102c04edd590843/image.png)

1. _**Name-**_ of the paywall test variant
2. _**Repartition**_- Weightage of the test variant
3. _**Unique Viewers**_- the total number of the distinctive viewer of the paywall in the subject
4. _**Subscription Started**_- the total number of users who started their subscription with the regular price( Do not include the free trial or intro price)
5. _**Trial Started-**_ the total number of users who started their free trial or intro price or promo code
6. _**Trial Converted-**_ the total number of users who started their free trial/intro price/promo code and converted to the regular price subscription
7. _**Trial Ended-**_ the total number of users whose trial period ended(free trial/intro price/promo code)
8.  _**View to Paid-**_ the sum of the subscription started and the trial converted.

    The % of views to paid= (Subscription Started+Trial converted)/Unique Viewers
9. _**First Renewal-**_ the total number of users who renewed their subscription while they were in the regular price cycle

### Data Chart

You can choose your chart based on three dimension**s**

1. Plan- the plan displayed in the paywall monthly, yearly etc.
2. Platform- the mobile platform used by the user to subscribe like iOS, Android etc.
3. Country- the location of the user mobile store

**Reading  the chart**:

If you look at the chart below,

* The Test have achieved 9 monthly subscription
* Out of which 8 of them are started with regular price cycle and 1 was started as a trial cycle
* Both the trial and the regular price subscriptions were renewed after their first subscription period

![](https://downloads.intercomcdn.com/i/o/526528915/5b96cfb3645f0493399313c6/image.png)

## Tracking your AB tests

The A/B test involves two IDs that will allow you to track their performance using your own tools (internal or third party).&#x20;

They are:

1. The A/B test ID
2. The variant(A/B/C test) ID

These ID's are sent along with the [SDK events](../../../analytics/events/sdk-events/) and also associated with the User [subscription life cycle events](../../../analytics/events/webhook-events/subscription-events.md).
