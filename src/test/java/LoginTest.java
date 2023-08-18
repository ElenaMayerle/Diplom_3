import io.qameta.allure.junit4.DisplayName;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class LoginTest extends BaseTest{
    @Before
    public void setUp(){
        steps.createUser();
    }
    @Test
    @DisplayName("Вход по кнопке «Войти в аккаунт» на главной")
    public void loginWithLoginButtonSuccess(){
        steps.enterAccountButtonClick();
        steps.login();
        Assert.assertTrue(steps.mainPage.isCreateOrderDisplayed());
    }
    @Test
    @DisplayName("Вход через кнопку «Личный кабинет»")
    public void loginWithMyProfileButtonSuccess(){
        steps.myProfileButtonClick();
        steps.login();
        Assert.assertTrue(steps.mainPage.isCreateOrderDisplayed());
    }
    @Test
    @DisplayName("Вход через кнопку в форме регистрации")
    public void loginWithRegisterPageSuccess(){
        steps.myProfileButtonClick();
        steps.registerButtonClick();
        steps.loginButtonClick();
        steps.login();
        Assert.assertTrue(steps.mainPage.isCreateOrderDisplayed());
    }
    @Test
    @DisplayName("Вход через кнопку в форме восстановления пароля")
    public void loginWithRestorePasswordButtonSuccess(){
        steps.myProfileButtonClick();
        steps.restorePasswordButtonClick();
        steps.loginButtonOnRestorePasswordClick();
        steps.login();
        Assert.assertTrue(steps.mainPage.isCreateOrderDisplayed());
    }
    @After
    public void tearDown(){
        steps.deleteUser();
    }
}
