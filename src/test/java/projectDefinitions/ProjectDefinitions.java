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
    public void i_have_entered_my_email(String string) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "C:\\Program Files\\selenium\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("https://login.mailchimp.com/signup/");
        driver.manage().window().maximize();

        sendKeys(driver, By.id("email"), (randomInt + "@unemail.com"));

    }


    @Given("I have also entered a {string}")
    public void i_have_also_entered_a_username(String string) throws InterruptedException {
        if (string.equals("rand")) {
            sendKeys(driver, By.id("new_username"), (randomInt + "cat"));
        } else if (string.equals("longName")) {

            sendKeys(driver, By.id("new_username"), (string.repeat(14)));

        } else if (string.equals("randOld")) {
            sendKeys(driver, By.id("new_username"), (randomInt + "dog"));
        } else if (string.equals("noMail")) {
            sendKeys(driver, By.id("new_username"), (randomInt + "fish"));
        }


    }

    @Given("I have also selected a {string}")
    public void i_have_also_selected_a_password(String string) throws InterruptedException {
        sendKeys(driver, By.id("new_password"), (string));
        click(driver, By.id("onetrust-accept-btn-handler"));
    }

    @When("I press sign up")
    public void i_press_sign_up() throws InterruptedException {
        click(driver, By.id("create-account"));


    }

    @Then("the {string} should be on the screen for {string}")
    public void the_result_should_be_on_the_screen(String string, String string2) throws InterruptedException {
        if (string2.equals("rand")) {
            WebElement result = driver.findElement(By.cssSelector("#signup-content > div > div > div > h1"));
            assertEquals(string, result.getText());
        } else if (string2.equals("longName")) {
            WebElement wrong = driver.findElement(By.className("invalid-error"));
            assertEquals(string, wrong.getText());
        } else if (string2.equals("randOld")) {
            WebElement wrong = driver.findElement(By.className("invalid-error"));
            assertEquals(string, wrong.getText());
        } else if (string2.equals("noMail")) {
            WebElement wrong = driver.findElement(By.className("invalid-error"));
            assertEquals(string, wrong.getText());
        }

        driver.quit();
    }

    private void sendKeys(WebDriver driver, By by, String keys) {
        (new WebDriverWait(driver, 10)).until(ExpectedConditions.presenceOfElementLocated(by));
        driver.findElement(by).sendKeys(keys);

    }

    private void click(WebDriver driver, By by) {
        (new WebDriverWait(driver, 10)).until(ExpectedConditions.elementToBeClickable(by));
        driver.findElement(by).click();
    }
}

