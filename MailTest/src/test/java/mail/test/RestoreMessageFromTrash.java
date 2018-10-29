package mail.test;

import framework.BaseTest;
import mail.menu.Menu;
import mail.pageobject.IncomingMessagePage;
import mail.pageobject.TrashPage;
import mail.steps.Steps;

public class RestoreMessageFromTrash extends BaseTest {
    private Steps steps;

    @Override
    public void test() {
        steps = new Steps();
        steps.authorization();
        steps.sendMailForTest();

        IncomingMessagePage incomingMessagePage = new IncomingMessagePage();
        incomingMessagePage.selectMail();
        incomingMessagePage.getMenu().navigateToMenu(Menu.MainMenu.Delete);
        incomingMessagePage.goToTrash();

        TrashPage trashPage = new TrashPage();
        trashPage.selectMail();
        // не видит локатор меню совершенно
        trashPage.getMenu().navigateToSubMenu(Menu.MainMenu.Transfer, Menu.SubMenu.Income);
        trashPage.goToIncomeMessage();

        steps.logOut();

    }
}
