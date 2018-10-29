package mail.test;

import framework.BaseTest;
import mail.menu.Menu;
import mail.pageobject.IncomingMessagePage;
import mail.pageobject.TrashPage;
import mail.steps.Steps;
import org.testng.Assert;

public class EmptyTrash extends BaseTest {
    private Steps steps;

    @Override
    public void test() {
        steps = new Steps();
        steps.authorization();
        steps.sendMailForTest();

        IncomingMessagePage incomingMessagePage = new IncomingMessagePage();
        incomingMessagePage.setObjectValue();
        incomingMessagePage.selectMail();
        incomingMessagePage.getMenu().navigateToMenu(Menu.MainMenu.Delete);
        incomingMessagePage.goToTrash();
        // Stale element !!!!!!!!!!!!!!!!
        TrashPage trashPage = new TrashPage();
        trashPage.setObjectValue();

        Assert.assertEquals(incomingMessagePage.getObjectLetter().getTitle(), trashPage.getObjectLetter().getTitle());
        Assert.assertEquals(incomingMessagePage.getObjectLetter().getTime(), trashPage.getObjectLetter().getTime());

        trashPage.emptyTrash();

        Assert.assertTrue(trashPage.checkDisplayedTextEmpty());

        steps.logOut();
    }
}
