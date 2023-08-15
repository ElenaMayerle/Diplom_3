import io.qameta.allure.junit4.DisplayName;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class MyProfileTest extends BaseTest{
    @Before
    public void setUp(){
        steps.createUser();
        steps.myProfileButtonClick();
        steps.login();
    }
    @Test
    @DisplayName("Переход в личный кабинет")
    public void transitionToMyProfileSuccess(){
        steps.myProfileButtonClick();
        steps.myProfilePage.waitForLoad();
        Assert.assertTrue(steps.myProfilePage.profileTextDisplayed());
    }
    @Test
    @DisplayName("Переход из личного кабинета по клику на «Конструктор»")
    public void transitionFromMyProfileClickConstructorSuccess(){
        steps.myProfileButtonClick();
        steps.myProfilePage.waitForLoad();
        steps.constructorButtonClick();
        steps.mainPage.waitForLoad();
        Assert.assertTrue(steps.mainPage.isCreateOrderDisplayed());
    }
    @Test
    @DisplayName("Переход из личного кабинета по клику на логотип")
    public void transitionFromMyProfileClickLogoSuccess(){
        steps.myProfileButtonClick();
        steps.myProfilePage.waitForLoad();
        steps.logoButtonClick();
        steps.mainPage.waitForLoad();
        Assert.assertTrue(steps.mainPage.isCreateOrderDisplayed());
    }
    @Test
    @DisplayName("Выход по кнопке «Выйти» в личном кабинете")
    public void logoutFromMyProfileSuccess(){
        steps.myProfileButtonClick();
        steps.myProfilePage.waitForLoad();
        steps.logout();
        Assert.assertTrue(steps.loginPage.isLoginButtonDisplayed());
    }
    @After
    public void tearDown(){
        steps.deleteUser();
    }
}
