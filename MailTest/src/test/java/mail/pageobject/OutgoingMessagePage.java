package mail.pageobject;

import framework.BaseForm;
import framework.CommonFunctions;
import framework.elements.Label;
import mail.object.Message;
import org.openqa.selenium.By;

public class OutgoingMessagePage extends BaseForm {
    private static By outgoingMessageLocator = By.xpath("//span[contains(text(), 'Отправленные')]");
    private Label lblTitleLetter = new Label(By.xpath("//div[contains(@class, 'b-datalist__item__subj')]"));
    private String regexpForTitleLetter = "(.*?)-";
    private int matcherGroup = 1;

    public OutgoingMessagePage() {
        super(outgoingMessageLocator);
    }

    public Message getObjectLetter(){
        String textTitleLetter = CommonFunctions.getRegexMatch(lblTitleLetter.getTextElement(), regexpForTitleLetter , matcherGroup);
        return new Message(textTitleLetter);
    }
}
