package framework;

import org.openqa.selenium.By;
import org.testng.Assert;


public abstract class BaseForm extends BaseEntity {
    private By locator;

    public BaseForm(By locator){
        this.locator = locator;
        assertIsOpen();
    }

   public void assertIsOpen() {
        Assert.assertTrue(driver.findElement(locator).isDisplayed());
   }

}
