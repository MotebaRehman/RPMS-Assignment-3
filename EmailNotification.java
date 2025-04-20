// EmailNotification class

public class EmailNotification implements Notifiable {
    public void sendNotification(String recipient, String message) {
        if (recipient == null || recipient.trim().isEmpty()) {
            System.err.println("Error: Recipient email cannot be empty.");
            return;
        }
        System.out.println("Email sent to " + recipient + ": " + message);
    }
}