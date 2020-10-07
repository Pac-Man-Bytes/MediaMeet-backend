# MediaMeet-backend


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

## Versioning

We use GitFlow for versioning. For the versions available, see the [tags on this repository](https://github.com/Pac-Man-Bytes/MediaMeet-backend/releases/)

## Author

[**Santiago Rubiano Fierro**](https://github.com/srubianof) Software Engineering Student

[**Alejandro Bohorquez Alzate**](https://github.com/alejandrobohal) Software Engineering Student

[**Davor Cortez Cardozo**](https://github.com/d4v0r) Software Engineering Student

## License

 This project is licensed under the MIT License - see the LICENSE.md file for details.
