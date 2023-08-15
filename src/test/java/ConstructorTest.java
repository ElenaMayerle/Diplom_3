import io.qameta.allure.junit4.DisplayName;
import org.junit.Assert;
import org.junit.Test;

public class ConstructorTest extends BaseTest{
    @Test
    @DisplayName("Переход к разделу «Соусы»")
    public void sauceSelectionSuccess(){
        steps.sauceSelection();
        Assert.assertTrue(steps.mainPage.isSauceDisplayed());
    }
    @Test
    @DisplayName("Переход к разделу «Начинки»")
    public void fillingSelectionSuccess(){
        steps.fillingSelection();
        Assert.assertTrue(steps.mainPage.isFillingDisplayed());
    }
    @Test
    @DisplayName("Переход к разделу «Булки»")
    public void bunSelectionSuccess(){
        steps.fillingSelection();
        steps.bunSelection();
        Assert.assertTrue(steps.mainPage.isBunDisplayed());
    }

}
