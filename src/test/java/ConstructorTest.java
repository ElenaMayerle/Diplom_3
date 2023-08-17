import io.qameta.allure.junit4.DisplayName;
import org.junit.Assert;
import org.junit.Test;

public class ConstructorTest extends BaseTest{
    @Test
    @DisplayName("Переход к разделу «Соусы»")
    public void sauceSelectionSuccess(){
        steps.sauceSelection();
        Assert.assertEquals("Соусы", steps.mainPage.getSelected());
    }
    @Test
    @DisplayName("Переход к разделу «Начинки»")
    public void fillingSelectionSuccess(){
        steps.fillingSelection();
        Assert.assertEquals("Начинки", steps.mainPage.getSelected());
    }
    @Test
    @DisplayName("Переход к разделу «Булки»")
    public void bunSelectionSuccess(){
        steps.fillingSelection();
        steps.bunSelection();
        Assert.assertEquals("Булки", steps.mainPage.getSelected());
    }

}
