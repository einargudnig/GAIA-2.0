# GAIA-2.0
New better version of GAIA
Mobile Application

## Technology

Built with Java in Android studio.
Connects to a RESTful API using retrofit.
The API is built with Java Spring, uses Spring Security and PostgresQL database

## How to try

You can download the poject as a ZIP file.
Open in android studio to see the code.
The RESTful API is running on http://gaiabakendi.herokuapp.com/. 
The repo for the API can be found here: https://github.com/einargudnig/GAIA - this is the project we did last year. We changed it to work as a RESTful API.

## Authentication

There are 4 pre made users already in the database. Feel free to use any of them to log in.
| Username    | Password    |
| ----------- | ----------- |
| Einar       | ranie       |
| Páll        | llap        |
| Ómar        | ramo        |
| Viktor      | rotkiv      |

NOTE: The registration does not work in the app. It does work on the RESTful API, has been tested multiple times in Postman. The reason is the for some strange reason un-authenticated users are not allowed to 'use' the register page. We have tried everything we can to fix this issue, as it is a part of Spring security in the APi. So if you try to register and nothing happens this is the reason why.

