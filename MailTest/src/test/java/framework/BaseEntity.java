package framework;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

public abstract class BaseEntity {

    protected static WebDriver driver;

    @BeforeClass
    public void setup(){
        driver = BrowserFactory.getDriver();
        new Wait(driver).implicitWait();
    }

    @AfterClass
    public void tearDown(){
        BrowserFactory.closeDriver();
    }
}
