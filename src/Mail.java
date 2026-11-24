
/**
 * Mail entity.
 */
public final class Mail {
    private final String subject;
    private final String content;
    private final String from;
    private final String recipient;
    private final String receiveDate;

    public Mail(String subject, String content, String from, String recipient, String receiveDate) {
        this.subject = subject;
        this.content = content;
        this.from = from;
        this.recipient = recipient;
        this.receiveDate = receiveDate;
    }

    public String getSubject() {
        return subject;
    }

    public String getContent() {
        return content;
    }

    public String getFrom() {
        return from;
    }

    public String getRecipient() {
        return recipient;
    }

    public String getReceiveDate() {
        return receiveDate;
    }
}