package mail.pageobject;

import framework.BaseForm;
import framework.CommonFunctions;
import framework.elements.Button;
import framework.elements.Label;
import mail.menu.Menu;
import mail.object.Message;
import org.openqa.selenium.By;

public class TrashPage extends BaseForm {
    private static By trashPageLocator = By.xpath("//span[contains(text(), 'Корзина')]");
    private By locatorForMenu = By.xpath("//span[contains(text(), 'Корзина')]");
    private Label lblNavigationToIncomeMessage = new Label(By.xpath("//span[contains(text(), 'Входящие')]"));
    private Button btnSelectMail = new Button(By.xpath("(//div[contains(@class, 'b-checkbox__box')])[2]"));
    private Button btnEmptyTrash = new Button(By.xpath("//button[@data-name = 'clearFolder']"));
    private Button btnConfirmationEmpty = new Button(By.xpath("//span[contains(text(), 'Да')]"));
    private Menu menu = new Menu(locatorForMenu);
    private Label lblTitleLetter = new Label(By.xpath("//div[contains(@class, 'b-datalist__item__subj')]"));
    private Label lblTimeLetter = new Label(By.xpath("//div[contains(@class, 'b-datalist__item__date')]"));
    private Label lbltextEmptyTrash = new Label(By.xpath("//span[contains(text(), 'В Корзине пусто.')]"));
    private String regexpForTitleLetter = ".(.*?)-";
    private int matcherGroup = 1;
    private Message trashMessage = new Message();


    public TrashPage() {
        super(trashPageLocator);
    }

    public void emptyTrash() {
        btnEmptyTrash.clickOnElement();
        btnConfirmationEmpty.clickOnElement();
    }

    public boolean checkDisplayedTextEmpty() {
        return lbltextEmptyTrash.checkVisibleElement();
    }

    public void setObjectValue(){
        String textTitleLetter = CommonFunctions.getRegexMatch(lblTitleLetter.getTextElement(), regexpForTitleLetter , matcherGroup);
        String textTimeLetter = lblTimeLetter.getTextElement();
        trashMessage.setTitle(textTitleLetter);
        trashMessage.setTime(textTimeLetter);
    }

    public Message getObjectLetter() {
        return  trashMessage;
    }

    public void selectMail(){
        btnSelectMail.clickAndWAit();
    }

    public void goToIncomeMessage(){
        lblNavigationToIncomeMessage.clickOnElement();
    }

    public Menu getMenu() {
        return menu;
    }
}
