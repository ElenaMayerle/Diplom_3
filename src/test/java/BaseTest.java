import org.junit.After;
import org.junit.Before;

public class BaseTest {
    Steps steps = new Steps();
    @Before
    public void initDriver() {
        steps.driver.get(Const.BURGERS_URL);
        steps.driver.manage().window().maximize();
    }

    @After
    public void quitDriver(){
        steps.driver.quit();
    }
}
