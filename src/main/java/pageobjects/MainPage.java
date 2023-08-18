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
    private final By createOrderButton = By.xpath(".//*[text()='Оформить заказ']");
    private final By selected = By.xpath(".//div[@class='tab_tab__1SPyG tab_tab_type_current__2BEPc pt-4 pr-10 pb-4 pl-10 noselect']");
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
    public String getSelected(){
        return driver.findElement(selected).getText();
    }
}
