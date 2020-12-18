NY Times Most Popular
=====================================

Introduction
-------------------------------------
Sample Application for project.

Requirements with comments in line :

● The app is using Kotlin as programming language.

● Added unit tests.

● App showing NYT Most popular API for different values for period

   ● click on Article Item will redirect the user to detail page.
    
   ● The app implement a local database to support offline mode.
   
   ● The app supports pull to refresh.
   
Steps to compile The project in android studio
-------------------------------------
   ● Download the source code as .zip
   
   ● Extract the downloaded folder.
   
   ● Open the project with android studio.
   
   ● It will automatically download all the required dependencies.
   
   ●  Invalidate cache and restart the IDE in case of any errors during compilation.
   

## Implemented Concepts
`MVVM(ViewModel, LiveData)` where separated app and data.where data module have all network and data base communication.
Dependency Injection is implemented using `hilt`
Caching is implemented using `Room Database`
Data can be refreshed using Pull to refresh
Data binding using `Two wey Data Binding`
Network communication `Retrofit`
Kotlin coroutines

## Unit Testing

 Unit testing is achieved using `Mockito`.

### Libraries
* [Android Support Library][support-lib]
* [Android Architecture Components][arch]
* [Android Data Binding][data-binding]
* [Binding Collection Adapter][collection-adapter] Easy way to bind collections to listviews and recyclerviews with the new Android Data Binding framework.
* [Hilt][Hilt] for dependency injection
* [Retrofit][retrofit] for REST api communication
* [Glide][glide] for image loading
* [Mockito][mockito] for evaluating app's logic using local unit tests
* [MockWebServer][mockwebserver] for testing HTTP clients




