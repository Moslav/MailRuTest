package mail.test;

import framework.BaseTest;
import mail.menu.Menu;
import mail.pageobject.IncomingMessagePage;
import mail.steps.Steps;

public class AddMessageToSpam extends BaseTest {
    private Steps steps;

    @Override
    public void test() {
        steps = new Steps();
        steps.authorization();
        steps.sendMailForTest();
        IncomingMessagePage incomingMessagePage = new IncomingMessagePage();
        incomingMessagePage.selectMail();
        incomingMessagePage.getMenu().navigateToMenu(Menu.MainMenu.Spam);

        steps.logOut();

    }
}

