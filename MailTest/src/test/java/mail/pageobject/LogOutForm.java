package mail.pageobject;

import framework.elements.Button;
import framework.elements.Label;
import org.openqa.selenium.By;

public class LogOutForm {
    private static By logOutFormLocator = By.xpath("//div[@id = 'PH_menuLogin']");
    private Button btnLogOut = new Button(By.xpath("//span[contains(text(), 'Выйти')]"));
    private Label lblLogOutMenu = new Label(By.xpath("//span[@id = 'PH_authMenu_button']"));

    public void logOut(){
        lblLogOutMenu.clickOnElement();
        btnLogOut.clickAndWAit();
    }
}
