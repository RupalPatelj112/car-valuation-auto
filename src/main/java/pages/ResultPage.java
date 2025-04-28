package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ResultPage {
    WebDriver driver;

    private By resultDetails = By.id("vehicle-details");

    public ResultPage(WebDriver driver) {
        this.driver = driver;
    }

    public String getCarDetails() {
        return driver.findElement(resultDetails).getText();
    }
}
