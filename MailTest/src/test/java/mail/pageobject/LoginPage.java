package mail.pageobject;

import framework.BaseForm;
import framework.elements.Button;
import framework.elements.Label;
import org.openqa.selenium.By;

public class LoginPage extends BaseForm {
    private static By loginPageLocator = By.xpath("//a[contains(@class, 'logo__img')]");
    private Label lblInputLogin = new Label(By.xpath("//input[@name = 'login']"));
    private Label lblInputPassword = new Label(By.xpath("//input[@name = 'password']"));
    private Button btnForEnter = new Button(By.xpath("//div[@id = 'mailbox']//label"));

    public LoginPage() {
        super(loginPageLocator);
    }

    public void authorization(String username, String password){
        lblInputLogin.sendKeysBy(username);
        lblInputPassword.sendKeysBy(password);
        btnForEnter.clickAndWAit();
    }

}
