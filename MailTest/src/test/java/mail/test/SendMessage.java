package mail.test;

import framework.BaseTest;
import mail.menu.Menu;
import mail.pageobject.IncomingMessagePage;
import mail.pageobject.OutgoingMessagePage;
import mail.pageobject.WriteLetterPage;
import mail.steps.Steps;
import org.testng.Assert;

public class SendMessage extends BaseTest {
    private Steps steps;

    @Override
    public void test() {
        steps = new Steps();
        steps.authorization();

        IncomingMessagePage incomingMessagePage = new IncomingMessagePage();
        incomingMessagePage.getMenu().navigateToLeftMenu(Menu.LeftMenu.Message);

        WriteLetterPage writeLetterPage = new WriteLetterPage();
        writeLetterPage.sendEmail();
        writeLetterPage.goToOutgoingMessage();
        // иногда тест не успевает загрузить сообщение в отправленных
        OutgoingMessagePage outgoingMessage = new OutgoingMessagePage();
        Assert.assertEquals(writeLetterPage.getObjectLetter().getTitle(), outgoingMessage.getObjectLetter().getTitle());

        steps.logOut();
    }
}
