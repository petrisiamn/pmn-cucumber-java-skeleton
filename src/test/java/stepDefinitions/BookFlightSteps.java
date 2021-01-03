package stepDefinitions;

import io.cucumber.java8.En;
import org.junit.Assert;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class BookFlightSteps extends TestInstrument implements En {
    public BookFlightSteps(){
        And("^I tap on Flight menu$", () -> {
            driver.findElement(By.cssSelector(".flights")).click();
        });
        And("^I choose one way trip$", () -> {
            driver.findElement(By.cssSelector("div.custom-control:nth-child(1)")).click();
        });

        And("^I select \"([^\"]*)\" class$", (String flightClass) -> {
            driver.findElement(By.cssSelector("div.form-icon-left:nth-child(1) > div:nth-child(3)")).click();
            switch (flightClass){
                case "First":
                    driver.findElement(By.cssSelector("li.active-result:nth-child(1)")).click();
                    break;
                case "Business":
                    driver.findElement(By.cssSelector("li.active-result:nth-child(2)")).click();
                    break;
                case "Economy":
                    driver.findElement(By.cssSelector("li.active-result:nth-child(3)")).click();
                    break;
                default:
                    //default is economy
                    driver.findElement(By.cssSelector("li.active-result:nth-child(3)")).click();
                    break;
            }
        });

        And("^I select \"([^\"]*)\" as Departure Airport$", (String departFrom) -> {
            driver.findElement(By.id("s2id_location_from")).click();
            driver.findElement(By.id("location_from")).sendKeys(departFrom);
            String xpathFlightSearchResult="(//span[contains(@class, \"select2-match\") and text() = \"" +departFrom+"\"])[1]";
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpathFlightSearchResult)));
            driver.findElement(By.xpath(xpathFlightSearchResult)).click();
        });

        And("^I select \"([^\"]*)\" as Destination Airport$", (String departTo) -> {
            driver.findElement(By.id("s2id_location_to")).click();
            driver.findElement(By.id("location_to")).sendKeys(departTo);
            String xpathResult="(//span[contains(@class, \"select2-match\") and text() = \"" +departTo+"\"])[1]";
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpathResult)));
            driver.findElement(By.xpath(xpathResult)).click();
        });

        And("^I choose \"([^\"]*)\" adults and \"([^\"]*)\" child and \"([^\"]*)\" infant$", (Integer nAdult, Integer nChild, Integer nInfant) -> {
            String xpathAddAdult = "(//button[@class=\"btn btn-white bootstrap-touchspin-up \"])[3]";
            String xpathAddChild = "(//button[@class=\"btn btn-white bootstrap-touchspin-up \"])[4]";
            String xpathAddInfant = "(//button[@class=\"btn btn-white bootstrap-touchspin-up \"])[5]";

            while (nAdult!=1){
                //Number of adult default is 1
                driver.findElement(By.xpath(xpathAddAdult)).click();
                nAdult--;
            }
            while (nChild !=0){
                driver.findElement(By.xpath(xpathAddChild)).click();
                nChild--;
            }
            while (nInfant !=0){
                driver.findElement(By.xpath(xpathAddInfant)).click();
                nInfant--;
            }
        });

        And("^I tap on search flight button$", () -> {
            driver.findElement(By.cssSelector(".col-lg-1 > button:nth-child(1)")).click();
        });

        And("^I will see flight search result$", () -> {
            String actualTitle = driver.getTitle();
            Assert.assertEquals("Flights List", actualTitle);
        });
        And("^I tap on book button from first result flight$", () -> {
            String xpathFirstFlight = "(//div[@class=\"theme-search-results-item-book\"]/button)[1]";
            driver.findElement(By.xpath(xpathFirstFlight)).click();
        });
        And("^I tap Sign In from book flight page$", () -> {
            driver.findElement(By.id("signintab")).click();
        });

        And("^I fills passenger form$", () -> {
            driver.findElement(By.id("passenger_name_0")).sendKeys(generateFullName());
            driver.findElement(By.id("passenger_age_0")).sendKeys(String.valueOf(random.nextInt(99)));
            driver.findElement(By.id("passenger_passport_0")).sendKeys(generatePassporNo());
        });

        And("^I will see booking summary for flight from \"([^\"]*)\" to \"([^\"]*)\"$", (String departure, String arraival) -> {
            String xpathDepart= "//*[contains(text(),\"Departure date From "+departure+"\")]";
            String xpathArraival= "//*[contains(text(),\"Arrival date at "+arraival+"\")]";
            Assert.assertTrue(driver.findElement(By.xpath(xpathDepart)).isDisplayed());
            Assert.assertTrue(driver.findElement(By.xpath(xpathArraival)).isDisplayed());
            //Assert total amount text
            Assert.assertTrue(driver.findElement(By.cssSelector("td.booking-deposit-font")).isDisplayed());
        });

        And("^I tap on confirm flight booking$", () -> {
            driver.findElement(By.name("login")).sendKeys(Keys.ENTER);
        });

        And("^I tap on pay arraival$", () -> {
            String xpathPayOnArraival= "//button[text()=\"Pay on Arrival\"]";
            wait.until(ExpectedConditions.elementToBeClickable(By.xpath(xpathPayOnArraival)));
            driver.findElement(By.xpath(xpathPayOnArraival)).click();
            try {
                Alert alert = driver.switchTo().alert();
                String alertText = alert.getText();
                System.out.println("Alert data: " + alertText);
                alert.accept();
            } catch (NoAlertPresentException noAlertPresentException) {
                noAlertPresentException.printStackTrace();
            }
        });

        And("^I will see info \"([^\"]*)\"$", (String successInfo) -> {
            driver.findElement(By.cssSelector("div.success-box.reserved"));
            String actualText = driver.findElement(By.xpath("//div[@class=\"content\"]/h4")).getText();
            Assert.assertEquals(successInfo.toLowerCase(), actualText.toLowerCase());
        });
    }
}
