package mail.utils;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Properties;

public class MailSenderServer {
    private final Properties properties = new Properties();
    private String subjectLetter = "TestLetter";
    private String textLetter = "Test Letter For Maks!";
    private String testUser = "login";
    private String password = "password";
    private String userForMail = "userForMail";
    private Session session;

    private void init() {
        properties.put("mail.smtp.host", "smtp.mail.ru");
        properties.put("mail.smtp.socketFactory.port", "465");
        properties.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
        properties.put("mail.smtp.auth", "true");
        properties.put("mail.smtp.port", "465");

        session = Session.getDefaultInstance(properties,
                new javax.mail.Authenticator() {
                    protected PasswordAuthentication getPasswordAuthentication() {
                        return new PasswordAuthentication(JsonReader.getJSONData(userForMail), JsonReader.getJSONData(password));
                    }
                });
    }

    public void sendEmail(){
        init();
        try {
            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress(JsonReader.getJSONData(userForMail)));
            message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(JsonReader.getJSONData(testUser)));
            message.setSubject(subjectLetter);
            message.setText(textLetter);
            Transport t = session.getTransport("smtp");
            t.connect("smtp.mail.ru", JsonReader.getJSONData(userForMail), JsonReader.getJSONData(password));
            t.sendMessage(message, message.getAllRecipients());

            System.out.println("Done");

        } catch (MessagingException e) {
            e.printStackTrace();
        }
    }
}
