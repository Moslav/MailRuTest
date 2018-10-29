package framework.elements;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;

public class ComboBox extends BaseElement{

    public ComboBox(By locator) {
        super(locator);
    }

    public void chooseElementFromSelectByValue(String value){
        Select select = new Select(getWebElement());
        select.selectByVisibleText(value);
    }

    public void chooseElementFromSelectByIndex(int index){
        Select select = new Select(getWebElement());
        select.selectByIndex(index);
    }

    public int getSizeSelect(){
        Select select = new Select(getWebElement());
        return select.getOptions().size();
    }

}
