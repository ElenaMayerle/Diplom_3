package pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LoginPage {
    private final WebDriver driver;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }
    private final By email = By.xpath(".//input[@class='text input__textfield text_type_main-default']");
    private final By password = By.xpath(".//input[@name='Пароль']");
    private final By loginButton = By.xpath(".//button[text()='Войти']");
    private final By registerButton = By.xpath(".//a[text()='Зарегистрироваться']");
    private final By restorePasswordButton = By.xpath(".//a[text()='Восстановить пароль']");
    public void setEmail(String emailOfUser){
    driver.findElement(email).sendKeys(emailOfUser);
    }
    public void setPassword(String passwordOfUser){
        driver.findElement(password).sendKeys(passwordOfUser);
    }
    public void setCredentials(String emailOfUser,String passwordOfUser){
        setEmail(emailOfUser);
        setPassword(passwordOfUser);
    }
    public void loginButtonClick(){
        driver.findElement(loginButton).click();
    }
    public void registerButtonClick(){
        driver.findElement(registerButton).click();
    }
    public void restorePasswordButtonClick(){
        driver.findElement(restorePasswordButton).click();
    }
    public void waitForLoad(){
        new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.visibilityOfElementLocated(loginButton));
    }
    public boolean isLoginButtonDisplayed(){
        return driver.findElement(loginButton).isDisplayed();
    }
}
