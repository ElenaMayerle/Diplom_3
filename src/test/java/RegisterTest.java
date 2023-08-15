import io.qameta.allure.junit4.DisplayName;
import org.junit.After;
import org.junit.Assert;
import org.junit.Test;

public class RegisterTest extends BaseTest{
    @Test
    @DisplayName("Успешная регистрация")
    public void registerUserSuccess(){
        steps.myProfileButtonClick();
        steps.registerButtonClick();
        steps.registerUser();
        steps.loginPage.waitForLoad();
        steps.login();
        Assert.assertTrue(steps.mainPage.isCreateOrderDisplayed());
    }
    @Test
    @DisplayName("Ошибка для некорректного пароля")
    public void incorrectPasswordShowsError(){
        steps.myProfileButtonClick();
        steps.registerButtonClick();
        steps.user.setPassword("qwert");
        steps.registerUser();
        steps.registerPage.waitForLoadError();
        Assert.assertEquals("Неверная ошибка для пароля", "Некорректный пароль",steps.registerPage.getPasswordError());
    }
    @After
    public void tearDown(){
        try {steps.deleteUser();}
        catch (Exception exception){
            Exception e;
        }
    }
}
