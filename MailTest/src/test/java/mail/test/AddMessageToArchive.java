package mail.test;

import framework.BaseTest;
import mail.menu.Menu;
import mail.pageobject.ArchivePage;
import mail.pageobject.IncomingMessagePage;
import mail.steps.Steps;
import org.testng.Assert;

public class AddMessageToArchive extends BaseTest {
    private Steps steps;


    @Override
    public void test() {
        steps = new Steps();
        steps.authorization();
        steps.sendMailForTest();

        IncomingMessagePage incomingMessagePage = new IncomingMessagePage();
        incomingMessagePage.setObjectValue();
        incomingMessagePage.selectMail();
        incomingMessagePage.getMenu().navigateToMenu(Menu.MainMenu.Archive);
        incomingMessagePage.goToArchive();

        ArchivePage archivePage = new ArchivePage();
        archivePage.setObjectValue();

        Assert.assertEquals(incomingMessagePage.getObjectLetter().getTitle(), archivePage.getObjectLetter().getTitle());
        Assert.assertEquals(incomingMessagePage.getObjectLetter().getTime(), archivePage.getObjectLetter().getTime());

        steps.logOut();
    }
}
