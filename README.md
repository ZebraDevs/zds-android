# zds-android

Zebra Design System components for Android.

## Setup

> 🚧 **Note**: This has been verified with`compileSdkVersion 34`. Other sdk versions may require additional work.

1. ZDS-Android is hosted on Zebra's internal Artifactory repository. Credentials for this are required, and can be obtained by logging onto [Artifactory](https://artifactory-us.zebra.com). Once logged in with SSO, select your username in the top right corner, and select set me up. Select `Maven`, then `Generate Token & Create Instructions`. This generated token is your password.

2. It is recommended for individuals to save their username and password in their global `gradle.properties` file:

```gradle
    artifactusername=XXX
    artifactpassword=YYY
```

These credentials should **_never_** be shared.

2. Add Zebra Maven repository to `settings.gradle`:

```gradle
dependencyResolutionManagement {
    repositories {
        maven{
            url "https://artifactory-us.zebra.com/artifactory/dmo-mvn-rel/"
            credentials {
                username = "${artifactusername}"
                password = "${artifactpassword}"
            }
        }
    }
}
```

2. Add dependency to **app-level** `build.gradle`

<!-- x-release-please-start-version -->

```
dependencies {
    implementation 'com.zebra:zds:1.0.0'
}
```

<!-- x-release-please-end -->

Once this is added, your IDE should

3. For the components to work and receive the correct theme values, we must add the theme n `AndroidManifest.xml`. Be sure to remove other themes which could override this and prevent the components from working.

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

# [Component Documentation](./components/docs/components/index.md)

# [Theme Documentation](./components/docs/theme/index.md)

---

## [License](./LICENSE)

## [Third party Licenses](./)
