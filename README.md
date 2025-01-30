## Flipkart Search Functionality Automation
This repository contains a Java Selenium project with TestNG automation for verifying Flipkart search functionality. The project includes the following:
- Selenium WebDriver
- TestNG framework
- Gradle build tool
- Java 11

## Project Structure
The project structure is as follows:
- src/main/java - contains the page object classes and utility classes
- src/test/java - contains the test classes
- build.gradle - contains the project dependencies and build configurations

## Getting Started
To run the project locally, follow the instructions below:
Clone the repository to your local machine.
Open the project in your preferred IDE.
Install the required dependencies .
Run the test class FlipkartSearchTest in your IDE or by running mvn test in the terminal.

## Test Class
The test class FlipkartSearchTest contains the following:

Test annotations - @BeforeTest, @Test, and @AfterTest
Assertions - assertEquals
Page Object Class
The page object class FlipkartSearchPage contains the following:

Web elements - searchBox, searchButton
Methods - enterSearchKeywords, clickSearchButton, verifySearchResults
Utility Class
The utility class DriverFactory contains the following:

Methods - createDriver, closeDriver
Dependencies
The project dependencies are managed by Gradlw and are defined in the build.gradle file. The following dependencies are included:

Selenium WebDriver
TestNG framework


## Privacy Information
This project does not collect or store any personal information. The project uses Selenium WebDriver to automate web browsing and does not interact with any user data.

License
This project is licensed under the MIT License. See the LICENSE file for details.

Contact
For any questions or concerns, please contact [Your Name].
