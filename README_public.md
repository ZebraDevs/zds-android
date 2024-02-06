# zds-android

Zebra Design System components for Android.

## Setup

This has been tested with `compileSdkVersion 34`. Other sdk versions may require additional work.

1. Add Zebra Maven repository to `settings.gradle`:

```
dependencyResolutionManagement {
    repositories {
        maven {
            ...
            url "https://zebratech.jfrog.io/artifactory/zds-android/"
        }
    }
}
```

2. Add dependency to **app-level** `build.gradle`

```
dependencies {
    ...
    implementation 'com.zebra:zds:1.0.0'
    ...
}
```

3. To use and style the components in `AndroidManifest.xml` place in the application tag the base Zebra theme, and be sure to remove other styles if they could override this incorrectly.

```xml
<application
    ...
    android:theme="@style/Theme.ZdsBase"
    ...
/>
```

4. Use components. Example:

```xml
<com.zebra.zds.ZdsButton
    style="@style/Zds.Button.Primary"
    android:layout_width="wrap_content"
    android:layout_height="wrap_content"
    android:layout_gravity="center"
    android:text="Button"
    android:theme="@style/Zds.Button.Primary"/>
```

---

# [Component Documentation](./components/docs/index.md)

---

## [License](./LICENSE)
