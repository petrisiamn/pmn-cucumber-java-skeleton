package stepDefinitions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.Random;

public class TestInstrument {
    protected static WebDriver driver= new ChromeDriver();
    WebDriverWait wait = new WebDriverWait(driver, 5);
    Random random = new Random();

    protected String generateFullName() {
        String[] firstNameList = {"Adi", "Budi", "Caca", "Darto", "Elsa", "Fani"};
        String[] lastNameList = {"Gani", "Hadi", "Intan", "Jamal", "Karyo"};
        String firstName = firstNameList[random.nextInt(firstNameList.length)];
        String lastName = lastNameList[random.nextInt(lastNameList.length)];
        return firstName + " " + lastName;
    }

    protected String generatePassporNo() {
        final String alphabet = "0123456789ABCDE";
        final int N = alphabet.length();
        StringBuilder passportNo = new StringBuilder();
        while (passportNo.length() < 7) { // length of the random string.
            passportNo.append(alphabet.charAt(random.nextInt(N)));
        }
        System.out.println("random pass no : "+passportNo.toString());
        return passportNo.toString();
    }
}
