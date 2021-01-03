package stepDefinitions;

import io.cucumber.java8.En;
import org.openqa.selenium.By;

public class HomepageSteps extends TestInstrument implements En {
    public HomepageSteps(){
        And("^I tap on login button from homepage$", () -> {
            driver.findElement(By.xpath("/html/body/div[2]/header/div[1]/div/div/div[2]/div/ul/li[3]/div/div/div/a[1]")).click();
        });
    }
}
