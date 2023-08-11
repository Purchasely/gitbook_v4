# Design your Paywalls

## About _**Paywalls**_

In Purchasely Cloud Platform Console, you can directly configure your paywalls and integrate your own design & contents. This is achieved thanks to **Paywalls**.

Purchasely proposes a set of fully customisable templates to choose from. These templates are compliant with Apple App Store review guidelines to help you pass the App Review.

![](<../../.gitbook/assets/image (41) (1) (1).png>)



## Managing _Paywalls_

You can define as many presentations as you want.

To create a new **Paywall** click on the `+ Add new paywall` button

![](<../../.gitbook/assets/image (185).png>)

A Paywall can be **ACTIVE** or **INACTIVE**.

If you create multiple Paywalls, only one (and at least one), shall be set as the **DEFAULT** Paywall

## Configuring a _Paywall_

The Paywall configuration screen is composed of 4 thumbnails :

* General : allows you to choose the template you want to use and set the **Paywall** general parameters
* Featuring contents : allows you to integrate your own contents inside the **Paywall**
* Purchase buttons : allows you to create the Purchase buttons of the **Paywall** and map each button with the corresponding **Plan**
* Localization : allows you to translate your **Paywall** in as many languages as you want

![](<../../.gitbook/assets/image (152).png>)

### General properties

A **Presentation** has the 3 mandatory properties :

* **Name** : this is the name of the **Presentation** inside the Purchasely Console. This value is not displayed to the users.
* **Vendor ID** : this is the **Presentation** unique identifier and you can set it to the value you want. It will be used in the SDK to display a specific **Presentation**. To keep data and conversion analysis consistent, this value should not be changed once the App has been released in production.
* **Template type** : this parameter defines the general layout of the **Presentation**

Depending on the template chosen, you can then set general styles & contents properties for the presentation.

### Featuring Contents

Featuring contents help you integrate your own contents into the presentation. You can create as many featuring contents as you want and order them as desired (simply drag & drop them).

![](<../../.gitbook/assets/image (184).png>)



Each featuring content is composed of :

* an **image**
* a **title** (with its own style)
* a **subtitle**

### Purchase buttons

You can create several Purchase Buttons on your presentation.

![](<../../.gitbook/assets/image (204).png>)

* Each Purchase Button has to be mapped with a **Plan**. Each Purchase Button has the following properties :
  * Background
  * Promotion label
  * Title
  * Subtitle
  * Intro price title
  * Intro price subtitle
  * Text style
  * Border styles\

* Intro price title & subtitle are only displayed to the user if an intro price or free trial period has been defined in the App Store or in the Play Store for the corresponding product, and if the user is eligible.\

* A set of pre-defined tags can be used in the fields **Title** & **Subtitle** and **Offer price title** & **subtitle**:

![](<../../.gitbook/assets/image (201).png>)

* The tag helper appears when the focus is on one of the corresponding fields ⇒ Directly click on a tag to make it appear in the field.

