## Read mails from Gmail Inbox.
Receive and read mails in correct chronological order.<br>
The application takes four args:<br>
host, user (mail address), password and number of mails to read.


### Compile all source files:
In root:
javac -cp "lib/javax.mail.jar:lib/activation.jar" src/*.java

### Compile single file
In root:
javac -cp "lib/javax.mail.jar:lib/activation.jar" src/MailReader.java

### Run program:
For Google Mail server use gmail.com as arg[0] = smtp.gmail.com

- String host = args[0];         // smtp.gmail.com
- String username = args[2];     // inbox to read
- String password = args[3];     // Google app password (https://support.google.com/accounts/answer/185833?visit_id=638687467349409867-3639313399)
- int quantityToRead = args[5];  // number of mails to print


### args:
<span style="color:lightgreen">If javax.mail.jar and activation.jar in /lib/:</span><br>
🟢
```java -cp "src:lib/javax.mail.jar:lib/activation.jar" MailReader <host> <user> <password> <quantityToRead>```

mail.java:
```java MailReader.java <host> <user> <password> <quantityToRead>```

.jar:
```java -jar mailReader.jar <host> <user> <password> <quantityToRead>```



### API's/dependencies (in lib)
🟢 javax.mail.jar (/lib/javax.mail.jar)
<br> Java mail API - the API to create, send and read email.

🟢activation.jar (/lib/activationn.jar)<br>
JAF (JavaBeans Activation Framework) contains a library JavaMail
uses to handle MIME data and different data/content types
in messages/mail like text, HTML, images, attachment, …


### misc
IMAP - Internet Message Access Protocol:
Used as link between two different servers for receiving email.
Google's IMAP server is used to receive emails.