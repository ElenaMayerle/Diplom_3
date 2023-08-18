package pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class RestorePasswordPage {
    private final WebDriver driver;
    public RestorePasswordPage(WebDriver driver) {
        this.driver = driver;
    }
    private final By loginButton = By.xpath(".//a[text()='Войти']");
    public void loginButtonClick() {
        driver.findElement(loginButton).click();
    }
}
