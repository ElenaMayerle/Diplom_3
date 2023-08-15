package pageobjects;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class MainPage {
    private final WebDriver driver;

    private final By enterAccountButton = By.xpath(".//button[text()='Войти в аккаунт']");
    private final By myProfileButton = By.xpath(".//nav[@class='AppHeader_header__nav__g5hnF']/a[@class='AppHeader_header__link__3D_hX']");
    private final By bunsButton = By.xpath(".//span[text()='Булки']");
    private final By saucesButton = By.xpath(".//span[text()='Соусы']");
    private final By fillingsButton = By.xpath(".//span[text()='Начинки']");
    private final By someSauce = By.xpath(".//p[text()='Соус Spicy-X']");
    private final By someBun = By.xpath(".//p[text()='Флюоресцентная булка R2-D3']");
    private final By someFilling = By.xpath(".//p[text()='Мясо бессмертных моллюсков Protostomia']");
    private final By createOrderButton = By.xpath(".//*[text()='Оформить заказ']");

    public MainPage(WebDriver driver) {
        this.driver = driver;
    }
    public void saucesButtonClick() {
        driver.findElement(saucesButton).click();
    }
    public void fillingsButtonClick() {
        driver.findElement(fillingsButton).click();
    }
    public void bunsButtonClick() {
        driver.findElement(bunsButton).click();
    }
    public void enterAccountButtonClick() {
        driver.findElement(enterAccountButton).click();
    }
    public boolean isSauceDisplayed(){
        return driver.findElement(someSauce).isDisplayed();
    }
    public boolean isBunDisplayed(){
        return driver.findElement(someBun).isDisplayed();
    }
    public boolean isFillingDisplayed(){
        return driver.findElement(someFilling).isDisplayed();
    }
    public void myProfileButtonClick() {
        driver.findElement(myProfileButton).click();
    }
    public boolean isCreateOrderDisplayed(){
        return driver.findElement(createOrderButton).isDisplayed();
    }
    public void waitForLoad(){
        new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.visibilityOfElementLocated(createOrderButton));
    }

}
