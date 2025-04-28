package tests;

import org.testng.annotations.*;
import pages.HomePage;
import pages.ResultPage;
import utils.DriverFactory;
import utils.FileUtils;
import org.openqa.selenium.WebDriver;

import java.io.IOException;
import java.util.List;

import static org.testng.Assert.assertTrue;


public class CarValuationTest {
    WebDriver driver;
    HomePage homePage;
    ResultPage resultPage;

    @BeforeMethod
    public void setup() {
        driver = DriverFactory.getDriver();
        driver.manage().window().maximize();
    }

    @Test
    public void validateCarRegistrations() throws IOException {
        List<String> registrations = FileUtils.extractCarRegistrations("src/resources/car_input.txt");

        for (String reg : registrations) {
            driver.get("https://car-checking.com");
            homePage = new HomePage(driver);
            resultPage = new ResultPage(driver);

            homePage.searchCar(reg);
            String details = resultPage.getCarDetails();

            System.out.println("Registration: " + reg + " Details: " + details);
            assertTrue(details != null && !details.isEmpty(), "Details not found for registration: " + reg);
        }
    }

    @AfterMethod
    public void tearDown() {
        DriverFactory.quitDriver();
    }
}
