For running tests:

1. For running "cloudNativeAndroidTNG" and "cloudWebAndroidTNG" tests need to set environment variables for username,
email and password fields (for IOS tests it needs to be unique values)

2. In cloudTest.properties it needs to add API key that is generated in mobitru website
3. In cloudTest.properties in email field it needs to add your EPAM login in name_surname format

4. Enter "udid" value in .xml file with the actual value of a launched devuce on mobitru.

5. When you run device on mobitru it needs to install EPAMTestApp.apk for Android device, and EPAMTestApp.ipa for
iOS device.

6. For running tests right click on xml file and click on run, or run the command mvn clean test.