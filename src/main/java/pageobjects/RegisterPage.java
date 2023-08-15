package pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class RegisterPage {
    private final WebDriver driver;
    public RegisterPage(WebDriver driver) {
        this.driver = driver;
    }
    private final By loginButton = By.xpath(".//a[text()='Войти']");
    private final By name = By.xpath(".//div[contains(*, 'Имя')]/input");
    private final By email = By.xpath(".//div[contains(*, 'Email')]/input");
    private final By password = By.xpath(".//div[contains(*, 'Пароль')]/input");
    private final By registerButton = By.xpath(".//button[text()='Зарегистрироваться']");
    private final By passwordError = By.xpath(".//p[text()='Некорректный пароль']");
    public void loginButtonClick() {
        driver.findElement(loginButton).click();
    }
    public void registerButtonClick() {
        driver.findElement(registerButton).click();
    }
    public void setName(String nameOfUser){
        driver.findElement(name).sendKeys(nameOfUser);
    }
    public void setEmail(String emailOfUser){
        driver.findElement(email).sendKeys(emailOfUser);
    }
    public void setPassword(String passwordOfUser){
        driver.findElement(password).sendKeys(passwordOfUser);
    }
    public void setCredentials(String nameOfUser, String emailOfUser,String passwordOfUser){
        setName(nameOfUser);
        setEmail(emailOfUser);
        setPassword(passwordOfUser);
    }
    public String getPasswordError(){
        return driver.findElement(passwordError).getText();
    }
    public void waitForLoadError(){
        new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.visibilityOfElementLocated(passwordError));
    }
}
