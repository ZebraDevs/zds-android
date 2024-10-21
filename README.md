# zds-android

Zebra Design System components for Android.

## Setup

> 🚧 **Note**: This has been verified with`compileSdkVersion 34`. Other sdk versions may require additional work.

### 1. Setup credentials

ZDS-Android is hosted in maven on Zebra's internal Artifactory repository. Credentials for this are required, and can be obtained by logging onto [Artifactory](https://artifactory-us.zebra.com).
To access the tokens through maven in Android Studio, you will need to provide credentials. The username will be your personal Zebra Core ID, and a password will need to be generated from [Artifactory](https://artifactory-us.zebra.com).
Once logged in with SSO, select your username in the top right corner, and select `Edit Profile`. Under Authentication Settings, select `Generate an Identity Token`. On the next screen, add a memorable description for the token that will be generated; select `Next`. This generated token is your password.

### 2. (Optional) Save credentials

These credentials will need to be passed into Gradle, but they should not be committed to source control. It is recommended for individuals to save their username and password in their global `gradle.properties` file in the `<USER_HOME>/.gradle` directory (This file may need to be created). The following format is only an example, and any names can be given.

```gradle
    artifactusername=XXX
    artifactpassword=YYY
```

These credentials should **_never_** be shared.

### 3. Add repository to settings file:

Your username(core id) and password(generated token) need to be provided into a settings.gradle file. THe following examples show how this would be done assuming the credentials have been saved as per step 2 for both `settings.gradle` and `settings.gradle.kts`.

<details>
<summary>
settings.gradle
</summary>

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

</details>

<details>
<summary>
settings.gradle.kts
</summary>

```gradle
import java.lang.System.getProperty
...

dependencyResolutionManagement {
    repositories {
        google()
        mavenCentral()
        maven{
            url = uri("https://artifactory-us.zebra.com/artifactory/dmo-mvn-rel/")
            credentials {
                username = getProperty("artifactoryusername")
                password = getProperty("artifactorypassword")
            }
        }
    }
}
```

</details>

### 4. Add dependency to app build file

This file should be located within the app directory of your project (not the root level); below are examples for both `build.gradle` and `build.gradle.kts`

<details>
<summary>`build.gradle`</summary>
<!-- x-release-please-start-version -->

```
dependencies {
    ...
    implementation 'com.zebra:zds:1.0.0'
}
```

<!-- x-release-please-end -->
</details>
<details>
<summary>build.gradle.kts</summary>

<!-- x-release-please-start-version -->

```
dependencies {
    ...
    implementation("com.zebra:zds:1.0.0")
}
```

<!-- x-release-please-end -->
</details>

### 5. Add theme to manifest

For the components to work and receive the correct theme values, we must add the theme in `AndroidManifest.xml`. Be sure to remove other themes which could override this and prevent the components from working.

```xml
<application
    ...
    android:theme="@style/Theme.ZdsBase"
    ...
/>
```

### 6. Use components

```xml
<com.zebra.zds.ZdsButton
    style="@style/Zds.Button.Primary"
    android:layout_width="wrap_content"
    android:layout_height="wrap_content"
    android:layout_gravity="center"
    android:text="Button"
    android:theme="@style/Zds.Button.Primary"/>
```

Ensure you read the [docs](./components/docs/components/index.md), as some components may have extra parameters.

---

## [Component Documentation](./components/docs/components/index.md)

## [Theme Documentation](./components/docs/theme/index.md)

### [License](./LICENSE)

### [Third party Licenses](./)
