## SETUP

* At least JDK 17 should be installed
* At least Gradle 7.4 should be installed
* If you are using IntelliJ, you should set Gradle JVM to JDK 17.

## PROJECT STRUCTURE

It is multi module gradle project.

Bigparserapi contains all the code necassary to call BigParser api. It contains unit tests also. Bigparserapi is library project, its output jar file will be uploaded to maven central repo later.

Bigparsersample is sample and test project to call BigParser api. It is a SpringBoot application. It contains integration tests.

## USED LIBRARIES

* SpringBoot
* Lombok
* Mockito
* DataFaker
* Awaitility
