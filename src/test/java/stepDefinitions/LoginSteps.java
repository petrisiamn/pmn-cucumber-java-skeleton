package stepDefinitions;

import io.cucumber.java8.En;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class LoginSteps extends TestInstrument implements En {
    public LoginSteps() {
        And("^I redirected to login page$", () -> {
            String actualTitlePage = driver.findElement(By.xpath("/html/body/div[2]/div[1]/section/div/div[1]/div[1]/div/h3")).getText();
            Assert.assertEquals("Login", actualTitlePage);
        });

        And("^I input email \"([^\"]*)\"$", (String email) -> {
            driver.findElement(By.name("username")).sendKeys(email);
            System.out.println("email");
        });

        And("^I input password \"([^\"]*)\"$", (String pass) -> {
            driver.findElement(By.name("password")).sendKeys(pass);
            System.out.println("pass");
        });

        And("^I tap on login button from login page$", () -> {
            String buttonLogin = "//button[@class=\"btn btn-primary btn-lg btn-block loginbtn\"]";
            WebElement element = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(buttonLogin)));
            element.click();
            System.out.println("I tap on login button from login page");
        });

        And("^I can see my profile menu$", () -> {
            driver.findElement(By.xpath("//h3[@class=\"text-align-left\"]")).isDisplayed();
        });
    }
}
