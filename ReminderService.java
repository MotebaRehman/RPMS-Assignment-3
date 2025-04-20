// ReminderService class

public class ReminderService {
    private Notifiable emailNotifier;
    private Notifiable smsNotifier;

    public ReminderService() {
        this.emailNotifier = new EmailNotification();
        this.smsNotifier = new SMSNotification();
    }

    public void sendReminder(String recipient, String message) {
        if (recipient == null || recipient.trim().isEmpty()) {
            System.err.println("Error: Recipient cannot be empty.");
            return;
        }
        try {
            if (recipient.contains("@")) {
                emailNotifier.sendNotification(recipient, message);
            } else {
                smsNotifier.sendNotification(recipient, message);
            }
        } catch (Exception e) {
            System.err.println("Failed to send reminder: " + e.getMessage());
        }
    }
}