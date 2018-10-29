package mail.steps;

import mail.pageobject.LogOutForm;
import mail.pageobject.LoginPage;
import mail.utils.JsonReader;
import mail.utils.MailSenderServer;

public class Steps {
    private String login = "login";
    private String password = "password";

    public void authorization() {
        LoginPage loginPage = new LoginPage();
        loginPage.authorization(JsonReader.getJSONData(login), JsonReader.getJSONData(password));
    }

    public void sendMailForTest() {
        MailSenderServer mailSenderServer = new MailSenderServer();
        mailSenderServer.sendEmail();
    }

    public void logOut() {
        LogOutForm logOutForm = new LogOutForm();
        logOutForm.logOut();
    }
}
