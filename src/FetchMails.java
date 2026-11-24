import javax.mail.Folder;
import javax.mail.Message;
import javax.mail.MessagingException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Fetches all mails.
 * Prints the input quantity of mails.
 */
public class FetchMails {
    Folder inbox;
    List<Mail> mails = new ArrayList<>();


    /**
     * Constructor
     * @param inbox = Folder inbox
     * @throws MessagingException e
     * @throws IOException e
     */
    public FetchMails(Folder inbox) throws MessagingException, IOException {
        this.inbox = inbox;
    }


    /**
     * Fetch input amount of mails from start position
     * to end position (newest mail) of mail data structure.
     * Collect mail data, save Mail object and store in ArrayList.
     * @throws MessagingException e
     * @throws IOException e
     */
    public void getAllMails(int quantityToRead) throws MessagingException, IOException {

        int inboxQuantity = inbox.getMessageCount();

        // Latest mail in inbox is last in data structure.
        // Oldest mail in inbox is first in data structure.
        int countFrom = inboxQuantity - quantityToRead + 1;

        // both start and end inclusive.
        for (Message m : inbox.getMessages(countFrom, inboxQuantity)) {
            String subject = m.getSubject();
            String content = m.getContent().toString();
            String from = m.getFrom()[0].toString();
            String recipient = m.getRecipients(Message.RecipientType.TO)[0].toString();
            String receiveDate = m.getReceivedDate().toString();
            Mail mail = new Mail(subject, content, from, recipient, receiveDate);
            mails.add(mail);
        }
        printMails();
    }


    /**
     * Print fetched mails in reversed order to
     * present mails chronologically - newest to oldest.
     */
    public void printMails() {

        int c = 1;

        // Newest mail is last in data structure -> iterate in reverse order.
        for (int i = mails.size() - 1; i >= 0; i--) {
            System.out.format("Message %d:\n", c);
            System.out.format("From: %s\n", mails.get(i).getFrom());
            System.out.format("Subject: %s",  mails.get(i).getSubject());

            System.out.println("\n");
            c++;
        }
    }

}
