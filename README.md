## Flipkart Search Functionality Automation
# This repository contains a Java Selenium project with TestNG automation for verifying Flipkart search functionality. The project includes the following:
- Selenium WebDriver
- TestNG framework
- Gradle build tool
- Java 11
- Python 3 for platform assessment (not mandatory).

## Project Structure
# The project structure is as follows:
- src/test/java/demo/wrappers/Wrappers.java - contains the page object classes and utility classes
- src/test/java/demo/TestCases.java - contains the test classes
- build.gradle - contains the project dependencies and build configurations

## Getting Started
# To run the project locally, follow the instructions below:
1. Clone the repository to your local machine.
2. Open the project in your preferred IDE.
3. Install the required dependencies(java 11, python 3, git bash) and the executeable to PATH Environment Variable.
4. Execute the command in `chmod +x ./gradlew` in **Bash terminal**.
5. Build the project running command `./gradlew build` in **Bash terminal** or `.\gradlew.bat build` in **PowerShell** terminal.
6. Run the test script by running `./gradlew test` test in **Bash terminal** or `.\gradlew.bat test` in **PowerShell** terminal.

## Test Class
# The test class TestCases.java contains the following:
- Test annotations @Test for test methods :
  - testCase01() method
  - testCase02() method
  - testCase03() method
- @BeforeTest :
  - startBrowser() method
- @AfterTest :
  - endTest() method

## Dependencies
# The project dependencies are managed by Gradle and are defined in the build.gradle file. The following dependencies are included:
- Selenium
- TestNG framework

## Privacy Information
This project does not collect or store any personal information. The project uses Selenium WebDriver to automate web browsing and does not interact with any user data.

## Contact
For any questions or concerns, please contact [Your Name].
