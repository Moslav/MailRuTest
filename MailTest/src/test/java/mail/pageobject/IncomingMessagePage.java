package mail.pageobject;

import framework.BaseForm;
import framework.CommonFunctions;
import framework.Wait;
import framework.elements.Button;
import framework.elements.Label;
import mail.menu.Menu;
import mail.object.Message;
import org.openqa.selenium.By;

public class IncomingMessagePage extends BaseForm {
    private static By incomingMessagePageLocator = By.xpath("//span[contains(text(), 'Входящие')]");
    private Button btnSelectMail = new Button(By.xpath("//div[contains(@class, 'b-checkbox__box')]"));
    private By locatorForMenu = By.xpath("//div[@data-group = 'selectAll']");
    private Label lblNavigateToTrash = new Label(By.xpath("//span[contains(text(), 'Корзина')]"));
    private Label lblNavigateToArchive = new Label(By.xpath("//div[contains(text(), 'Архив')]"));
    private Menu menu = new Menu(locatorForMenu);
    private Label lblTitleLetter = new Label(By.xpath("//div[contains(@class, 'b-datalist__item__subj')]"));
    private Label lblTimeLetter = new Label(By.xpath("//div[contains(@class, 'b-datalist__item__date')]"));
    private String regexpForTitleLetter = ".(.*?)-";
    private int matcherGroup = 1;
    private Message incomeMessage = new Message();

    public IncomingMessagePage() {
        super(incomingMessagePageLocator);
    }

    public Menu getMenu() {
        return menu;
    }

    public void selectMail() {
        btnSelectMail.clickOnElement();
    }

    public void goToTrash() {
        lblNavigateToTrash.clickAndWAit();
        new Wait(driver).imlicitWaitForFind();
    }

    public void setObjectValue(){
        String textTitleLetter = CommonFunctions.getRegexMatch(lblTitleLetter.getTextElement(), regexpForTitleLetter , matcherGroup);
        String textTimeLetter = lblTimeLetter.getTextElement();
        incomeMessage.setTitle(textTitleLetter);
        incomeMessage.setTime(textTimeLetter);
    }

    public Message getObjectLetter() {
        return  incomeMessage;
    }

    public void goToArchive() {
        lblNavigateToArchive.clickAndWAit();
    }
}
