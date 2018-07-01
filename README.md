# Oculus TV Launcher

A simple launcher to start apps directly into Oculus TV on the Oculus Go - even while offline.

## Background
The Oculus TV app on the Oculus Go supports running normal Android apps via a virtual screen. Apps that have an existing Android TV UI (leanback) are displayed in the "Unknown Sources" list at the bottom of the UI.

Other Android applications can be run too, but they need to be launched from another application.

Unfortunately Oculus TV refuses to show the list of "Unknown Sources" when no network connection is available.

This application fakes being a real VR application so the Oculus Go launcher will show it in the "Unknown Sources" list under the main library.

## Usage

Install the apk on your Oculus Go via ADB.

Select the launcher from the "Unknown Sources" tab under Library.

## Modifying

To change which application is launched, change the the `target_package` value in `app/src/main/res/values/strings.xml`. This needs to match the package name of the installed application.

To get a list of installed packages:
```
adb shell pm list packages
```
