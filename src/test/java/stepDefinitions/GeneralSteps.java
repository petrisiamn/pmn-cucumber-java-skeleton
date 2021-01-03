package stepDefinitions;

import io.cucumber.java8.En;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.concurrent.TimeUnit;

public class GeneralSteps extends TestInstrument implements En {
    public GeneralSteps(){
        And("^I open phptravel homepage$", () -> {
            driver.navigate().to("https://www.phptravels.net");
            driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
            System.out.println("Driver title : " + driver.getTitle());
        });

        Given("^I open phptravel login page$", () -> {
            driver.navigate().to("https://www.phptravels.net/login");
            System.out.println("Driver title : " + driver.getTitle());
        });

        And("^close the browser$", () -> {
            driver.close();
            System.out.println("close browser");
        });

        And("^I tap on \"([^\"]*)\" menu from account page$", (String menu) -> {
            String xpathMenu = "//a[@title=\""+menu.toLowerCase()+"\"]";
            WebElement element = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(xpathMenu)));
            element.click();
        });
    }
}
