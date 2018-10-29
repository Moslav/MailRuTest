package framework.elements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

public class Label extends BaseElement{

    public Label(By locator){
        super(locator);
    }

    public ArrayList<String> getArrayStringFromLabels(){
        ArrayList<String> listWithText = new ArrayList<>();
        List<WebElement> listWebElement= super.getElems();

        for (WebElement stweb: listWebElement
             ) {
            listWithText.add(stweb.getText());
        }
        return listWithText;
    }
}
