package mail.menu;

import framework.BaseForm;
import framework.elements.Label;
import org.openqa.selenium.By;

public class Menu extends BaseForm {

    public Menu(By locator) {
        super(locator);
    }

    public enum LeftMenu {
        Message("compose");

        private String locatorLeftMenu;
        private String commonLocatorLeftMenu = "//a[contains(@data-name, '%s')]";

        LeftMenu(String locator){ this.locatorLeftMenu = locator; }

        public By getWebElementLeftMenu() { return By.xpath(String.format(commonLocatorLeftMenu, locatorLeftMenu)); }
    }

    public enum MainMenu {
        Delete("remove"),
        Archive("archive"),
        Spam("spam"),
        Transfer("moveTo");

        private String locatorMenu;
        private String commonLocatorMenu = "//div[contains(@data-name, '%s')]";

        MainMenu(String locator) {
            this.locatorMenu = locator;
        }

        public By getWebElementMenu(){
            return By.xpath(String.format(commonLocatorMenu, locatorMenu));
        }
    }

    public enum SubMenu {
        Income("Входящие"),
        Send("Отправленные"),
        Archive("Архив");

        private String locatorSubMenu;
        private String commonLocatorSubMenu = "//a[contains(@data-text,'%s')]";

        SubMenu(String locator){
            this.locatorSubMenu = locator;
        }

        public By getWebElementSubMenu(){
            return By.xpath(String.format(commonLocatorSubMenu, locatorSubMenu));
        }
    }

    public void navigateToLeftMenu(LeftMenu leftMenu){
        Label lblMenu = new Label(leftMenu.getWebElementLeftMenu());
        lblMenu.clickOnElement();
    }

    public void navigateToMenu(MainMenu mainMenu){
        Label lblMenu = new Label(mainMenu.getWebElementMenu());
        lblMenu.clickOnElement();
    }

    public void navigateToSubMenu(MainMenu mainMenu,SubMenu subMenu){
        Label lbllMenu = new Label(mainMenu.getWebElementMenu());
        lbllMenu.clickOnElement();
        Label lblSubMenu = new Label(subMenu.getWebElementSubMenu());
        lblSubMenu.clickOnElement();
    }
}
