// NotificationService class

public class NotificationService {
    private Notifiable emailNotifier = new EmailNotification();
    private Notifiable smsNotifier = new SMSNotification();

    public void sendEmergencyAlert(String doctorContact, String message) {
        if (doctorContact == null || doctorContact.trim().isEmpty()) {
            System.err.println("Error: Doctor contact cannot be empty.");
            return;
        }
        try {
            emailNotifier.sendNotification(doctorContact, message);
            smsNotifier.sendNotification(doctorContact, message);
        } catch (Exception e) {
            System.err.println("Failed to send emergency alert: " + e.getMessage());
        }
    }
}