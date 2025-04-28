package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage {
    WebDriver driver;

    private By regInput = By.id("subForm1");
    private By searchButton = By.xpath("//*[@type='submit']");

    public HomePage(WebDriver driver) {
        this.driver = driver;
    }

    public void searchCar(String registration) {
        driver.findElement(regInput).sendKeys(registration);
        driver.findElement(searchButton).click();
    }
}
