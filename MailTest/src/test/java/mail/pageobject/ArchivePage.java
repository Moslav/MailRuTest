package mail.pageobject;

import framework.BaseForm;
import framework.CommonFunctions;
import framework.elements.Label;
import mail.object.Message;
import org.openqa.selenium.By;

public class ArchivePage extends BaseForm {
    private static By archivePageLocator = By.xpath("//div[contains(text(), 'Архив')]");
    private Label lblTitleLetter = new Label(By.xpath("//div[contains(@class, 'b-datalist__item__subj')]"));
    private Label lblTimeLetter = new Label(By.xpath("//div[contains(@class, 'b-datalist__item__date')]"));
    private String regexpForTitleLetter = ".(.*?)-";
    private int matcherGroup = 1;
    private Message archiveMessage = new Message();

    public ArchivePage() {
        super(archivePageLocator);
    }

    public void setObjectValue(){
        String textTitleLetter = CommonFunctions.getRegexMatch(lblTitleLetter.getTextElement(), regexpForTitleLetter , matcherGroup);
        String textTimeLetter = lblTimeLetter.getTextElement();
        archiveMessage.setTitle(textTitleLetter);
        archiveMessage.setTime(textTimeLetter);
    }

    public Message getObjectLetter() {
        return  archiveMessage;
    }
}
