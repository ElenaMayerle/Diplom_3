import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import pageobjects.*;

public class Steps {
    User user = new User();
    ChromeOptions options = new ChromeOptions();
    public WebDriver driver = getWebDriver("chrome");
    MainPage mainPage = new MainPage(driver);
    LoginPage loginPage = new LoginPage(driver);
    RegisterPage registerPage = new RegisterPage(driver);
    RestorePasswordPage restorePasswordPage = new RestorePasswordPage(driver);
    MyProfilePage myProfilePage = new MyProfilePage(driver);
    WebDriver getWebDriver(String browserName){
        switch (browserName){
            case "chrome":
                return new ChromeDriver();
            case "yandex":
                return new ChromeDriver(options.setBinary("C:\\Users\\user\\AppData\\Local\\Yandex\\YandexBrowser\\Application\\browser.exe"));
            default:
                throw new RuntimeException("Incorrect BrowserName");
        }
    }
    @Step("Создание пользователя")
    public void createUser(){
        user.createUser();
    }
    @Step("Удаление пользователя")
    public void deleteUser(){
        user.deleteUser();
    }
    @Step("Клик по кнопке «Войти в аккаунт» на главной")
    public void enterAccountButtonClick(){
        mainPage.enterAccountButtonClick();
    }
    @Step("Вход в аккаунт")
    public void login() {
        loginPage.setCredentials(user.getEmail(), user.getPassword());
        loginPage.loginButtonClick();
        mainPage.waitForLoad();
    }
    @Step("Регистрация пользователя")
    public void registerUser() {
        registerPage.setCredentials(user.getName(),user.getEmail(), user.getPassword());
        registerPage.registerButtonClick();
    }
    @Step("Клик по кнопке «Личный кабинет»")
    public void myProfileButtonClick(){
        mainPage.myProfileButtonClick();
    }
    @Step("Клик по кнопке «Зарегистрироваться»")
    public void registerButtonClick(){
        loginPage.registerButtonClick();
    }
    @Step("Клик по кнопке «Войти» на странице регистрации")
    public void loginButtonClick(){
        registerPage.loginButtonClick();
    }
    @Step("Клик по кнопке «Восстановить пароль»")
    public void restorePasswordButtonClick(){
        loginPage.restorePasswordButtonClick();
    }
    @Step("Клик по кнопке «Войти» на странице восстановления пароля")
    public void loginButtonOnRestorePasswordClick(){
        restorePasswordPage.loginButtonClick();
    }
    @Step("Клик по кнопке «Конструктор»")
    public void constructorButtonClick(){
        myProfilePage.constructorButtonClick();
    }
    @Step("Клик на логотип бургеров")
    public void logoButtonClick(){
        myProfilePage.logoButtonClick();
    }
    @Step("Выход из аккаунта")
    public void logout(){
        myProfilePage.logoutButtonClick();
        loginPage.waitForLoad();
    }
    @Step("Переход к разделу «Соусы»")
    public void sauceSelection(){
        mainPage.saucesButtonClick();
    }
    @Step("Переход к разделу «Начинки»")
    public void fillingSelection(){
        mainPage.fillingsButtonClick();
    }
    @Step("Переход к разделу «Булки»")
    public void bunSelection(){
        mainPage.bunsButtonClick();
    }

}
