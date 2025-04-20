// SMSNotification class

public class SMSNotification implements Notifiable {
    public void sendNotification(String recipient, String message) {
        if (recipient == null || recipient.trim().isEmpty()) {
            System.err.println("Error: Recipient phone cannot be empty.");
            return;
        }
        System.out.println("SMS sent to " + recipient + ": " + message);
    }
}