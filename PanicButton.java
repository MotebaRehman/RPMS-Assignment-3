// PanicButton class

public class PanicButton {
    private Notifiable notifiable;

    public PanicButton(Notifiable notifiable) {
        if (notifiable == null) {
            throw new IllegalArgumentException("Notifiable service cannot be null.");
        }
        this.notifiable = notifiable;
    }

    public void press(String contact) {
        if (contact == null || contact.trim().isEmpty()) {
            System.err.println("Error: Emergency contact cannot be empty.");
            return;
        }
        try {
            notifiable.sendNotification(contact, "Emergency! Panic button triggered.");
        } catch (Exception e) {
            System.err.println("Failed to send panic alert: " + e.getMessage());
        }
    }
}