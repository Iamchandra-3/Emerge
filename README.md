# Emerge
We are from Fun-Tastic Four Team This project is for SRMAP ADD Club Conducted APPATHON_1.0 Hackathon

Along with me , CONTRIBUTED MEMBERS are: KRISHNA SAI GOPISETTY , username :Tesipog (Main lead of this Project) Thumma Sricharan , username : sricharan-thumma

OUR SOURCE CODES ARE IN MASTER BRANCH kindly open it and visit

chandra_s_application3
Built with AndroidX Support

Requires Android Studio Arctic Fox | 2020.3.1 or higher.

Current Kotlin Version 1.5.30

SDK Versions
compileSdkVersion 31

buildToolsVersion "30.0.1"

minSdkVersion 23

targetSdkVersion 31

Libraries
Retrofit- REST API Call https://square.github.io/retrofit/
Glide - Image Loading and caching. https://github.com/bumptech/glide
Material Design Components - Google's latest Material Components. https://material.io/develop/android
koin - Dependency Injection https://insert-koin.io/
Figma design guideline for better accuracy
Read our guidelines to increase the accuracy of design conversion to code by optimizing Figma designs. https://docs.dhiwise.com/knowledgehub/reference-guide-and-tools/figma.

App Navigation
Check your app's UI from the AppNavigation screens of your app.

Package Structure
├── appcomponents       
│ ├── di                 - Dependency Injection Components 
│ │ └── MyApp.kt
│ ├── network            - REST API Call setup
│ │ ├── ResponseCode.kt
│ │ └── RetrofitProvider.kt
│ └── ui                 - Data Binding Utilities
│     └── CustomBindingAdapter.kt
├── constants            - Constant Files
│ ├── IntegerConstants.kt
│ └── StringConstants.kt
├── extensions           - Kotlin Extension Function Files
│ └── Strings.kt
├── modules              - Application Specific code
│ └── example            - A module of Application 
│  ├── ui                - UI handling classes
│  └── data              - Data Handling classes
│    ├── viewmodel       - ViewModels for the UI
│    └── model           - Model for the UI
└── network              - REST API setup
  ├── models             - Request/Response Models
  ├── repository         - Network repository
  ├── resources          - Common classes for API
  └── RetrofitService.kt
Fonts
We were unable to find following Fonts, Please add manually to app/src/main/res/font and uncomment code in respective font family XML files.

robotorobotoromanregular400
opensansopensansromanregular400
