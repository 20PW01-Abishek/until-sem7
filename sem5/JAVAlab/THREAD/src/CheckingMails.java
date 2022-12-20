import java.util.Properties;

import javax.mail.Folder;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.NoSuchProviderException;
import javax.mail.Session;
import javax.mail.Store;

public class CheckingMails {
    public static void check(String host, String storeType, String user, String password)
    {
        try {
            //create properties field
            Properties properties = new Properties();
            properties.put("mail.pop3.host", host);
            properties.put("mail.pop3.port", "995");
            properties.put("mail.pop3.starttls.enable", "true");
            Session emailSession = Session.getDefaultInstance(properties);

            //create the POP3 store object and connect with the pop server
            Store store = emailSession.getStore("pop3s");

            store.connect(host, user, password);

            //create the folder object and open it
            Folder emailFolder = store.getFolder("INBOX");
            emailFolder.open(Folder.READ_ONLY);

            // retrieve the messages from the folder in an array and print it
            Message[] messages = emailFolder.getMessages();
            for (int i = messages.length-1, n = messages.length-11 ; i > n; i--) {
                Message message = messages[i];
                String[] data =message.getFrom()[0].toString().split(" ");
                System.out.print("From:");
                for(int j=0;j< data.length-2;j++)
                    System.out.print(" "+data[j]);
                System.out.println("Id: "+data[data.length-1]);
                if(message.getSubject().isEmpty())
                    System.out.println("Subject: No subject");
                else
                    System.out.println("Subject: " + message.getSubject());
            }

            //close the store and folder objects
            emailFolder.close(false);
            store.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {

        String host = "pop.gmail.com";// change accordingly
        String mailStoreType = "pop3";
        String username = "20pw01@psgtech.ac.in";// change accordingly
        String password = "Abishek@24thmarch";// change accordingly

        check(host, mailStoreType, username, password);

    }

}