import javax.mail.Folder;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Store;
import java.io.IOException;
import java.util.Properties;

/**
 * Class connects to mail service.
 * Gives access to mail inbox.
 */
public class MailConnector {

    private String host;
    private String userMail;
    private String password;
    Properties props;
    Store store = null;
    Folder inbox = null;
    FetchMails fetchMails;

    public MailConnector(String host, String userMail, String password) {
        this.host = host;
        this.userMail = userMail;
        this.password = password;
        props = new Properties();
    }


    /**
     *  Connects to host and access inbox.
     * @param quantityToRead = user input.
     */
    public void connect(int quantityToRead) {
        // Configure IMAP - Internet Message Access Protocol
        props.put("mail.store.protocol", "imaps");
        props.put("mail.imaps.host", host);
        props.put("mail.imaps.port", "993");
        props.put("mail.imaps.ssl.enable", "true");

        // Properties used to create session.
        Session session = Session.getInstance(props);

        // Create a Store with the Session.
        // Authenticate and connect to server (gmail).
        try {
            store = session.getStore();
            store.connect(userMail, password);

            // open mail inbox
            inbox = store.getFolder("INBOX");
            // READ_WRITE mode marks mail as read.
            inbox.open(Folder.READ_ONLY);

            // Fetch and print emails.
            fetchMails = new FetchMails(inbox);
            fetchMails.getAllMails(quantityToRead);

        } catch ( MessagingException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

}
