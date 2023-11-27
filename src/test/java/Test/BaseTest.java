package Test;

import Pages.SignUpPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

public class BaseTest {
    WebDriverWait wait;
    protected WebDriver driver;
    private SignUpPage signUpPage;
    // Launch the browser
    @BeforeClass
    public void setUp() {
        driver = new ChromeDriver();
        // Navigate to the URL
        driver.get("https://automationexercise.com/login");
        signUpPage = new SignUpPage(driver);
    }


   //  Close the browser
    @AfterClass
    public void tearDown() {
        driver.quit();
    }
}
