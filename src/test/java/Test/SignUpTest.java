package Test;
import java.io.InputStream;
import java.io.InputStreamReader;

import java.util.List;
import java.util.Random;
import Pages.SignUpPage;
import com.opencsv.CSVReader;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class SignUpTest {
    private SignUpPage signUpPage;
    private WebDriver driver;  // Declare WebDriver instance


    String randomString = generateRandomString(6); // Adjust the length as needed



    @BeforeClass
    public void setUp() {
        driver = new ChromeDriver();
        // Navigate to the URL
        driver.get("https://automationexercise.com/login");
        signUpPage = new SignUpPage(driver);
    }


    @DataProvider(name = "userCredentials")
    public Object[][] getUserCredentials() {
        // Read CSV file from the project resources
        try (InputStream inputStream = getClass().getResourceAsStream("/user_data.csv");
             InputStreamReader reader = new InputStreamReader(inputStream)) {
            CSVReader csvReader = new CSVReader(reader);
            List<String[]> userCredentials = csvReader.readAll();

            Object[][] data = new Object[userCredentials.size()][10];

            // Populate the data array
            for (int i = 0; i < userCredentials.size(); i++) {
                data[i] = userCredentials.get(i);
            }

            return data;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @Test(dataProvider = "userCredentials" , priority = 0)
    public void testSignUp(String username, String mail ,String userPassword , String userFirstName , String userLastName
            , String userCompany, String userAddress1, String userAddress2,String userState , String userCity, String userZipCode,String userMobileNumber) throws InterruptedException {

        // Perform sign-up using the data from the CSV file
        signUpPage.registerNewUser( username,  randomString+mail , userPassword ,  userFirstName ,  userLastName
                ,  userCompany,  userAddress1,  userAddress2, userState ,
                 userCity,  userZipCode, userMobileNumber);

         signUpPage.LogOut();

    }

    // Function to generate a random alphanumeric string of a specified length
    private static String generateRandomString(int length) {
        String characters = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
        StringBuilder randomString = new StringBuilder();

        Random random = new Random();
        for (int i = 0; i < length; i++) {
            int index = random.nextInt(characters.length());
            randomString.append(characters.charAt(index));
        }

        return randomString.toString();
    }

    //  Close the browser
    @AfterClass
    public void tearDown() {
        driver.quit();
    }
}
