# App Store

## Connecting the Purchasely Cloud Platform with the App Store

### Getting the endpoint URL from the Purchasely Console

1. Connect to the Purchasely Console
2. Access the settings of the application you want to connect
3. Inside the block Apple App Store, get the value of the parameter `Server to server endpoint`&#x20;

![](https://lh3.googleusercontent.com/cWXtxTsgamMYNT2oPHEM0YBOnIRM1FhHFnmLb11EDt6FF5-M4CxrvWoPbXv1ndFitL2VsexJHMPu46fQn91Iss7P8VRjxWDbc5Z0nYuNhUrr2JKnlZLy-qZH3OjQRMG3i8c6nHRv1GHO)

### Reporting the endpoint URL in App Store Connect

1. Connect to the App Store Connect Console
2. Report the value of the parameter `Apple S 2 S Notifications Endpoint` into the field `URL for App Store Server Notifications`\
   _App Store Connect > My Apps > \[YOUR APP] > App Store > App Information_

![](<../.gitbook/assets/image (18).png>)

{% hint style="warning" %}
&#x20;To allow Purchasely Console to decrypt messages, you also need to have the App Specific Shared Secret parameter properly configured.\
\
👉  See section related to [App Installation](../quick-start/console-configuration/installation.md#app-specific-shared-secret) for more information
{% endhint %}



