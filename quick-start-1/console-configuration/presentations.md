# Design your Paywalls

## About _**Paywalls**_

In Purchasely Cloud Platform Console, you can directly configure your paywalls and integrate your own design & contents. This is achieved thanks to **Paywalls**.

Purchasely proposes a set of fully customisable templates to choose from. These templates are compliant with Apple App Store review guidelines to help you pass the App Review.

![](https://files.gitbook.com/v0/b/gitbook-legacy-files/o/assets%2F-MHAzdlUVqKyZvwTnNIE%2F-MHps5g37nfoUYymTFEG%2F-MHpwFvaaD9K5Oi9dD2g%2Fimage.png?alt=media\&token=daae9e30-d8ab-4e77-b56c-75d9ce8d89dd)

## Managing _Paywalls_

You can define as many presentations as you want.

To create a new **Paywall** click on the `+ Add new paywall` button

![](https://files.gitbook.com/v0/b/gitbook-x-prod.appspot.com/o/spaces%2FGgUdOzhqa07uh7nB2iZA%2Fuploads%2F5ZnuRWYsm49dUX5q3FVF%2Fimage.png?alt=media\&token=f6f074b5-86a8-4be1-9328-1de103420e02)

A Paywall can be **ACTIVE** or **INACTIVE**.

If you create multiple Paywalls, only one (and at least one), shall be set as the **DEFAULT** Paywall

## Configuring a _Paywall_

The Paywall configuration screen is composed of 4 thumbnails :

* General : allows you to choose the template you want to use and set the **Paywall** general parameters
* Featuring contents : allows you to integrate your own contents inside the **Paywall**
* Purchase buttons : allows you to create the Purchase buttons of the **Paywall** and map each button with the corresponding **Plan**
* Localization : allows you to translate your **Paywall** in as many languages as you want

![](https://files.gitbook.com/v0/b/gitbook-x-prod.appspot.com/o/spaces%2FGgUdOzhqa07uh7nB2iZA%2Fuploads%2FUqmNMj129bzwgfx9Q21x%2Fimage.png?alt=media\&token=70021728-2185-4d78-9401-1c340f325676)

### General properties

A **Presentation** has the 3 mandatory properties :

* **Name** : this is the name of the **Presentation** inside the Purchasely Console. This value is not displayed to the users.
* **Vendor ID** : this is the **Presentation** unique identifier and you can set it to the value you want. It will be used in the SDK to display a specific **Presentation**. To keep data and conversion analysis consistent, this value should not be changed once the App has been released in production.
* **Template type** : this parameter defines the general layout of the **Presentation**

Depending on the template chosen, you can then set general styles & contents properties for the presentation.

### Featuring Contents

Featuring contents help you integrate your own contents into the presentation. You can create as many featuring contents as you want and order them as desired (simply drag & drop them).

![](https://files.gitbook.com/v0/b/gitbook-x-prod.appspot.com/o/spaces%2FGgUdOzhqa07uh7nB2iZA%2Fuploads%2F1taDRn9sJTzCKsuJdlXK%2Fimage.png?alt=media\&token=1917b32a-5c1d-43fb-99f3-cf9d64f877b2)

Each featuring content is composed of :

* an **image**
* a **title** (with its own style)
* a **subtitle**

### Purchase buttons

You can create several Purchase Buttons on your presentation.

![](https://files.gitbook.com/v0/b/gitbook-x-prod.appspot.com/o/spaces%2FGgUdOzhqa07uh7nB2iZA%2Fuploads%2FjaEBqwCKXFwTAak9grg3%2Fimage.png?alt=media\&token=0e446ce4-8b28-46b8-8dc2-bb903d7a708c)

* Each Purchase Button has to be mapped with a **Plan**. Each Purchase Button has the following properties :
  * Background
  * Promotion label
  * Title
  * Subtitle
  * Intro price title
  * Intro price subtitle
  * Text style
  * Border styles\\
* Intro price title & subtitle are only displayed to the user if an intro price or free trial period has been defined in the App Store or in the Play Store for the corresponding product, and if the user is eligible.\\
* A set of pre-defined tags can be used in the fields **Title** & **Subtitle** and **Offer price title** & **subtitle**:

![](https://files.gitbook.com/v0/b/gitbook-x-prod.appspot.com/o/spaces%2FGgUdOzhqa07uh7nB2iZA%2Fuploads%2F0PjNYRvJ9BxNchale4Hu%2Fimage.png?alt=media\&token=e715f556-fcf2-45d9-8d28-4435e18e03e5)

* The tag helper appears when the focus is on one of the corresponding fields ⇒ Directly click on a tag to make it appear in the field.
