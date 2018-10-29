package framework.elements;

import framework.BaseEntity;
import framework.Wait;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import java.util.List;

public abstract class BaseElement extends BaseEntity {

    private By locator;
    private WebElement webElement;
    private List<WebElement> elems;

    public BaseElement(By locator) {
        this.locator = locator;
    }

    public WebElement findWebElementBy () {
        waitClicableElement();
        webElement = driver.findElement(locator);
        return webElement;
    }

    public void moveToElement(){
        findWebElementBy();
        Actions actions = new Actions(driver);
        actions.moveToElement(webElement).build().perform();
    }

    public void clickOnElement(){
        findWebElementBy().click();
    }

    public void clickAndWAit(){
        waitForLoadElement();
        findWebElementBy();
        webElement.click();
        new Wait(driver).waitPageLoad();
    }

    private void waitForIsElementPresent(){
        new Wait(driver).explicitWait(locator);
    }

    private void waitClicableElement(){
        new Wait(driver).waitClicableElement(locator);
    }

    private void waitForLoadElement() {
        new Wait(driver).imlicitWaitForFind();
    }

    private void waitForImplicityWait(){
        new Wait(driver).implicitWait();
    }

    protected List<WebElement> findElementsBy(){
        elems = driver.findElements(locator);
        return elems;
    }

    public void sendKeysBy(String input){
        findWebElementBy();
        webElement.sendKeys(input);
    }

    public String getAttributeBy(String attrname){
        return findWebElementBy().getAttribute(attrname);
    }

    public String getTextElement(){
        return findWebElementBy().getText();
    }

    protected WebElement getWebElement(){
        return webElement;
    }

    protected List<WebElement> getElems(){
        return elems;
    }

    public boolean checkVisibleElement() {
        try {
            webElement = driver.findElement(locator);
            return webElement.isDisplayed();
        }catch (NoSuchElementException e){
            return false;
        }
    }

}
