package projectDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.Random;

import static org.junit.Assert.assertEquals;


public class ProjectDefinitions {
    private WebDriver driver;
    Random randomGenerator = new Random();
    int randomInt = randomGenerator.nextInt(100000);


    @Given("I have entered my {string}")
    public void i_have_entered_my_email(String email) {
        System.setProperty("webdriver.chrome.driver", "C:\\Program Files\\selenium\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("https://login.mailchimp.com/signup/");
        driver.manage().window().maximize();
switch (email) {
    case "email1" -> sendKeys(By.id("email"), (randomInt + "@unemail.com"));
    case "email2" -> sendKeys(By.id("email"), (" "));
}
    }


    @Given("I have also entered a {string}")
    public void i_have_also_entered_a_username(String username) {
        switch (username) {
            case "rand" -> sendKeys(By.id("new_username"), (randomInt + "cat"));
            case "longName" -> sendKeys(By.id("new_username"), (username.repeat(14)));
            case "existing" -> sendKeys(By.id("new_username"), ("Majsan123"));
            case "noMail" -> sendKeys(By.id("new_username"), (randomInt + "fish"));
        }


    }

    @Given("I have also selected a {string}")
    public void i_have_also_selected_a_password(String password) {
        sendKeys(By.id("new_password"), (password));
        click(By.id("onetrust-accept-btn-handler")); //accept cookies

    }

    @When("I press sign up")
    public void i_press_sign_up() {
        click(By.id("create-account"));

    }

    @Then("the {string} should be on the screen for {string}")
    public void the_result_should_be_on_the_screen(String result, String username) {
        switch (username) {
            case "rand" -> {
                WebElement value = driver.findElement(By.cssSelector("#signup-content > div > div > div > h1"));
                assertEquals(result, value.getText());
            }
            case "longName" -> {
                WebElement value = driver.findElement(By.className("invalid-error"));
                assertEquals(result, value.getText());
            }
            case "existing" -> {
                WebElement value = driver.findElement(By.className("invalid-error"));
                assertEquals(result, value.getText());
            }
            case "noMail" -> {
                WebElement value = driver.findElement(By.className("invalid-error"));
                assertEquals(result, value.getText());
            }
        }

        driver.quit();
    }

    private void sendKeys(By by, String keys) {
        (new WebDriverWait(driver, 10)).until(ExpectedConditions.presenceOfElementLocated(by));
        driver.findElement(by).sendKeys(keys);

    }

    private void click(By by) {
        (new WebDriverWait(driver, 10)).until(ExpectedConditions.elementToBeClickable(by));
        driver.findElement(by).click();
    }
}

