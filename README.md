# Covid Tracker App

###### Covid-19 Tracker app provides information about the corona-virus cases.

## Technologies
 * Kotlin
 * Retrofit
 * Room database
 * MVVM architecture

## Features

* User needs to register/login with e-mail address.
* App displays the data number of affected, serious, death, active and recovered corona cases.
* The data count of cases are provided as per yesterday, today and total number of corona virus cases.
* In case of emergency, user can contact through call or sms.

### Covid-19 Tracker App **[Video](https://user-images.githubusercontent.com/62066697/105625416-389a5d80-5e4f-11eb-9954-0d949fdbea05.mp4)**

## Screenshots with description

After opening application you will find the welcome screen that stays in for 3 seconds. Then you can see login screen where you can enter your e-mail address and password in order to access the app.


|**Welcome screen**| **Login Screen** |
|:---|:---|
|<img src=Images/covidtracer_splash.jpeg height="500px"/>  | <img src=Images/covidtracer_login.jpeg height="500px"/> |

<br/><br/>

After successful login, you can see the main features of the application. It contains bottom navigation tab with home screen and statistics fragments.
The home screen contains helpline options such as call and sms. The Statistics screen displays the corona cases data numbers.


|**Main Home Screen**| **Statistics Screen** |
|:---|:---|
|<img src=Images/covidtracker_home.png height="500px"/>  | <img src=Images/covidtracker_stats.png height="500px"/> |

<br/><br/>

On click of view states button, list of all states are displayed in the form recyclerview. On click of each states, it's respective data is displayed on the statistics screen.
The data is displayed as yesterday, today and total number of corona virus cases in the country as well as global accordingly.
On click of back button, the exit screen is displayed and app will be closed after 2 seconds.

 
|**States list data**| **Statistics data** |**Exit Screen**|
|:---|:---|:---|
|<img src=Images/covidtracker_state_list.jpeg height="500px"/>  | <img src=Images/covidtracer_graph.jpeg height="500px"/> | <img src=Images/covidtracker_exit.png height="500px"/>|
