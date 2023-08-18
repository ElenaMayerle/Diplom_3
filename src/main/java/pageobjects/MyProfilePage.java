package pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class MyProfilePage {
    private final WebDriver driver;
    public MyProfilePage(WebDriver driver) {
        this.driver = driver;
    }
    private final By profileText = By.xpath(".//a[text()='Профиль']");
    private final By logoutButton = By.xpath(".//button[text()='Выход']");
    private final By constructorButton = By.xpath(".//p[text()='Конструктор']");
    private final By logoButton = By.xpath(".//div[@class='AppHeader_header__logo__2D0X2']");
    public void logoutButtonClick() {
        driver.findElement(logoutButton).click();
    }
    public void constructorButtonClick() {
        driver.findElement(constructorButton).click();
    }
    public void logoButtonClick() {
        driver.findElement(logoButton).click();
    }
    public boolean profileTextDisplayed(){
        return driver.findElement(profileText).isDisplayed();
    }
    public void waitForLoad(){
        new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.visibilityOfElementLocated(profileText));
    }
}
