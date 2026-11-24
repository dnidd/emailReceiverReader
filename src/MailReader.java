import javax.mail.MessagingException;
import java.io.IOException;

/**
 * Entry point.
 * Program takes four args: host, user (mail address), password and number of mails to read.
 */
public class MailReader {

    public static void main(String[] args) throws MessagingException, IOException {

        String host = args[0];                           // "imap.gmail.com";
        String user = args[1];                           // Gmail address to read
        String password = args[2];                       // Temporary Google app password
        int quantityToRead = Integer.parseInt(args[3]);  // number of mails to read

        MailConnector connector = new MailConnector(host, user, password);
        connector.connect(quantityToRead);
    }
}
