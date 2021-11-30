# Test Automation Framework project
This project is a test framework which aim to organize *data, methods and results* to test **Rozetka** site. 

It is a **TestNG** based test automation framework focusing on giving easy background for Test Automation engineers, those can focus on writing the test cases instead of focusing on how to do data driven things, how to deal with user readable reports etc. 

## Websites
|   URL |   Purpose |
|   --- |   --- |
|   https://rozetka.com.ua/ua/  |   Rozetka landing page    |
|   https://rozetka.com.ua/ua/premium/  |   Rozetka Premium page    |

## Required to run tests locally:

#### Requirements
* Java JDK 8.
* Maven 3.8.2

#### Advised working environment
* IntelliJ Idea

## Execution
Download the project. Open a command line from project directory and type ```mvn clean test```.

If everything goes ok, the test execution will start and results will be printed in console. If tests will fail, the screenshot with captured error will be saved in ```<project_directory>/screen``` folder.

## Features
Project has several modules, the main modules are:
* core layer
* test layer
* business layer

Project supports:
* powerful logging facility
* data-driven tests
* easy way of selecting desired testcase sets to run
* generates screenshots in case of failures
* maven support for compiling and running tests

#### Core layer
Core layer consist of:
* Configurations (Environment config property file reader, Constants)
* Initialization helpers (WebDriver initialization, Driver Wait provider)
* Logger (Logger implementation)
* Listener
* Utilities (for Screenshot making)

To change configuration you can go to resource/config.properties file. There you can change browser type, by changing browser property; change time waits; expected data.

Wait class provides excplicit waits on some elements to be clicked or displayed.

### Business layer
Consist of:
* Page objects (Home and Premium page)
* Business logic layer (Steps, Business logic)

Page objects are extend from Base Page and are initalized through Factory Method pattern, with lazy initialization, the fields of Page object will be initialized and found in DOM tree only after they will be called. Page objects have only logic to get page elements, take their attribute alues, click.

Main test logic is present is BO implementation classes. It initialized with Guice and call methods from Page objects to work with page.

## Test layer
Tests are extend from BaseTest class, which has AfterClass annotation to quit web driver after test execution.

Tests don't have test logic itself, they only trigger login from businness objects

Test suite is written in testng.xml file, so it's easy to configure and run any suite.
