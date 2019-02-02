# Java WebTests Automation Project

----
## Overview
* This is simple project to showcase Web Test Automation in Java.
* Project uses Selenium WebDriver
* **Skills:** UI Test Automation, Page Object Factory
* **Languages:** Java
* **SCM:** Git
* **Build/Dependency Management:** Maven
* **Testing:** Data-Driven
* **Assertion Lib:** Selenium, WebDriver
* **CI/CD:** CircleCI (To Be Added)

----
## Setup
- Download [JavaWebAutomation](https://github.com/irfanalinoor/JavaWebAutomation) Project from GitHub.
- Install latest [Java SDK](https://www.oracle.com/technetwork/java/javase/downloads/jdk8-downloads-2133151.html).
- Install latest [IntelliJ IDEA Community](https://www.jetbrains.com/idea/).
- Open Project **JavaWebAutomation**.
- Open Maven Project Tab on IntelliJ IDEA and click on LifeCycle > Package. This will install project dependencies.

>In case of dependency conflicts, **Press Ctrl key** (twice) and enter following commands.
    `mvn clean install -U` and `mvn dependency::tree`

- Go to **.\JavaWebAutomation\src\test\java\NSW\Tests\ServiceTests.java** *line 30*

>For Windows, set browser type to Chrome_Win
```
browserType type = browserType.CHROME_WIN;
```

>For Mac, set browser type to Chrome_Mac
```
browserType type = browserType.CHROME_MAC;
```

- Run Tests or Press **Alt+Shift+F10**.


----
## Concepts Used
- Java
- Selenium (WebDriver)
- JUnit
- PageObject
- Data-Driver (read input and expected data from Json)

----
## Sample Tests:
### Case 1
    Scenario:  Validate that search SHOULD display desired result and navigate to page
    Given      I have loaded Service NSW website
    When       I will search for "Apply for a number plate"
    Then       I will find that search on Service NSW website SHOULD display desired result
    And        I will find that result link SHOULD navigate to page

### Case 2
    Scenario:  Validate that Service Center page SHOULD display location of service centre for given Suburb
    Given      I have loaded Service Center - Locate US page
    When       I will search service center for a Suburb
    Then       I will find that Service Center page SHOULD display location of service centre for given Suburb
