# MediaMeet-backend

## Logo

![](https://cdn.discordapp.com/attachments/748398289514397717/763456425099132978/Screen_Shot_2020-10-07_at_12.41.11_PM.png)


## Architecture

+ Component Diagram
![](https://cdn.discordapp.com/attachments/749330138407370856/763404991800410152/unknown.png)

+ Packages Diagram
![](https://cdn.discordapp.com/attachments/749330138407370856/763411410792218654/package.png)

+ Model
![](https://cdn.discordapp.com/attachments/749330138407370856/763405674520510475/model.png)



## Getting Started
The following steps are required in order to get a copy of the project, be able to run it and perform tests.
### Prerequisites
You need to have installed the next software to successfully run the project:

* Java recommended Java 8
* Maven
* Git


## Test execution
 In order to run the test you have to keep in mind that you must have downloaded the repository and have opened a new terminal in the project folder.
 
 To execute the tests you have to type the following command:
 
 ```
mvn test
```
## Program execution
Before you run the program please keep in mind that this program needs the name of the file where the set of numbers are located including the extension.

For a proper execution of the project type in the terminal the following command:

```
mvn spring-boot:run
```

## Built With
* Java 8
* Git - Version-control system
* [Maven](https://maven.apache.org) - Dependency Management
* MongoDB
## Javadoc


In order to generate the documentation type the following commands in the terminal:
* This generates a html with the javadoc
```
mvn javadoc:javadoc
```
* This generates a site for the project where the project's reports are included.
```
mvn site
```
* This opens the site where the documentation is located
```
mvn site:run
```

## CI/CD Badges

For the continous integration, the project has CI with Circle Ci
 [![CircleCI](https://circleci.com/gh/circleci/circleci-docs.svg?style=svg)](https://app.circleci.com/pipelines/github/Pac-Man-Bytes/MediaMeet-backend?branch=develop)

For the continous deployment, the project has CD with Heroku
[![Deploy](https://www.herokucdn.com/deploy/button.svg)](https://mediameet-backend.herokuapp.com)

For the code quality
[![Codacy Badge](https://app.codacy.com/project/badge/Grade/5b3828c51c27438a87988630ad2bbe96)](https://www.codacy.com/gh/Pac-Man-Bytes/MediaMeet-backend/dashboard?utm_source=github.com&amp;utm_medium=referral&amp;utm_content=Pac-Man-Bytes/MediaMeet-backend&amp;utm_campaign=Badge_Grade)

## Versioning

We use GitFlow for versioning. For the versions available, see the [tags on this repository](https://github.com/Pac-Man-Bytes/MediaMeet-backend/releases/)

## Author

[**Santiago Rubiano Fierro**](https://github.com/srubianof) Software Engineering Student

[**Alejandro Bohorquez Alzate**](https://github.com/alejandrobohal) Software Engineering Student

[**Davor Cortez Cardozo**](https://github.com/d4v0r) Software Engineering Student

## License

 This project is licensed under the MIT License - see the LICENSE.md file for details.
