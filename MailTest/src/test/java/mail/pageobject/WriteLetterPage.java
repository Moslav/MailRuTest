package mail.pageobject;

import framework.BaseForm;
import framework.elements.Button;
import framework.elements.Label;
import mail.object.Message;
import mail.utils.JsonReader;
import org.openqa.selenium.By;

public class WriteLetterPage extends BaseForm {
    private static By writeLetterPageLocator = By.xpath("//div[contains(@class, 'compose-head')]");
    private Label lblAdressForMail = new Label(By.xpath("//textarea[@data-original-name = 'To']"));
    private Label lblWithTitleLetter = new Label(By.xpath("//input[@name = 'Subject']"));
    private Button btnSendLetter = new Button(By.xpath("//div[contains(@data-name, 'send')]"));
    private Label lblOutgoingPage = new Label(By.xpath("//span[contains(text(), 'Отправленные')]"));
    private Button btnConfirmLetter = new Button(By.xpath("//div[contains(@class, 'popup__controls')]/button/span[contains(text(), 'Продолжить')]"));
    private String userForSendLetter = "userForSendLetter";
    private String titleLetter = "HelloTest";

    public WriteLetterPage() {
        super(writeLetterPageLocator);
    }

    public void sendEmail(){
        lblAdressForMail.sendKeysBy(JsonReader.getJSONData(userForSendLetter));
        lblWithTitleLetter.sendKeysBy(titleLetter);
        btnSendLetter.clickOnElement();
        btnConfirmLetter.clickOnElement();
    }

    public Message getObjectLetter(){
        return new Message(titleLetter);
    }

    public void goToOutgoingMessage() {
        lblOutgoingPage.clickAndWAit();
    }

}
