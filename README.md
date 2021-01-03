# Automated test in Java with Cucumber and Selenium WebDriver ##
https://www.phptravels.net for booking train ticket and flight ticket

## workaround ##

- platfom desktop web
- Scenario:  
 1. Open the web application
  2. On the home screen, select Flights and Select Oneway Trip Flight
  3. Select Business class
  4. Enter LAX as a Departure Airport and MXP as the Destination Airport
  5. Select any date for the date as well as the returned date
  6. Click on Search
  7. Scroll down to the bottom of the result and Select the last result, click on Book Now
  8. Fill in all the details
  9. Click on Confirm This Booking
  10. On the Payment page click on Pay On Arrival
  
## Installation ##
You need to have [Java 8 JDK](https://www.oracle.com/technetwork/java/javase/downloads/jdk8-downloads-2133151.html) installed along with [maven](https://maven.apache.org/download.cgi).

To run the tests locally with Chrome, install ChromeDriver from [here](http://chromedriver.chromium.org), add its location to your system PATH and add webdriver.chrome.driver=path/to/the/driver to your local variables.

To install all dependencies, run ```$ mvn clean install```

If anything dependencies you want to add please write in ```pom.xml``` then run ```$ mvn clean install``` 

To show the report, uncomment this code from cucumber.properties
```cucumber.publish.enabled=true```

                  
## Running Test ##                       
```console
$ mvn test -Dcucumber.options="tags @ScenarioTag"
```
or 

right click from scenario title then choose "  Run Scenario:'scenarioTitle'  "            

