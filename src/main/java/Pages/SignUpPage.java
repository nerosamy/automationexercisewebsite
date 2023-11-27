package Pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SignUpPage{

    private WebDriver driver;

    // Locate SignUp page elements
    @FindBy(xpath = "//a[text()=' Signup / Login']")
    WebElement navigateToSignupBtn;
    @FindBy(name = "name")
    WebElement userName;

    @FindBy(xpath = "//button[text()='Signup']")
    WebElement signUpBtn;
    @FindBy(xpath = "//input[@data-qa='signup-email']")
    WebElement userEmail;

    @FindBy(id="id_gender1")
    WebElement userGender;
    @FindBy(id="password")
    WebElement password;

    @FindBy(id="first_name")
    WebElement firstName;

    @FindBy(id="last_name")
    WebElement lastName;

    @FindBy(id="company")
    WebElement company;

    @FindBy(id="address1")
    WebElement address1;

    @FindBy(id="address2")
    WebElement address2;

 @FindBy(id="country")
 WebElement country;

 @FindBy (xpath = "//*[@id='country']/option[1]")
         WebElement countryOpition;

    @FindBy(id="state")
    WebElement state;

    @FindBy(id="city")
    WebElement city;

    @FindBy(id="zipcode")
    WebElement zipCode;
    @FindBy(id="mobile_number")
    WebElement mobileNumber;

    @FindBy(xpath="//a[text() ='Continue']")
    WebElement continueBtn;

    @FindBy(xpath = "//button[text() ='Create Account']")
    WebElement createAccount;

    @FindBy(xpath = "//a[text() =' Logout']")
    WebElement logoutBtn;
    // Constructor
    public SignUpPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);  // Initialize WebElements
    }

    public void registerNewUser(String username, String mail ,String userPassword , String userFirstName , String userLastName
            , String userCompany, String userAddress1, String userAddress2,String userState ,
                                String userCity, String userZipCode,String userMobileNumber) throws InterruptedException {
        userName.sendKeys(username);
        userEmail.sendKeys(mail);
        signUpBtn.click();
        userGender.click();
        password.sendKeys(userPassword);
        firstName.sendKeys(userFirstName);
        lastName.sendKeys(userLastName);
        company.sendKeys(userCompany);
        address1.sendKeys(userAddress1);
        address2.sendKeys(userAddress2);
        JavascriptExecutor jse = (JavascriptExecutor) driver;
        jse.executeScript("arguments[0].click()", country);
        countryOpition.click();
        state.sendKeys(userState);
        city.sendKeys(userCity);
        zipCode.sendKeys(userZipCode);
        mobileNumber.sendKeys(userMobileNumber);
        jse.executeScript("arguments[0].click()", createAccount);


        continueBtn.click();

    }
    public void LogOut()
    {
        logoutBtn.click();
    }

}
