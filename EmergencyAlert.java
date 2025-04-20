// EmergencyAlert class

public class EmergencyAlert {
    private double heartRate;
    private double bloodPressure;
    private double temperature;
    private NotificationService notifier;

    public EmergencyAlert(double heartRate, double bloodPressure, double temperature) {
        if (heartRate <= 0 || heartRate > 200) {
            throw new IllegalArgumentException("Invalid heart rate (must be 1-200).");
        }
        if (bloodPressure <= 0 || bloodPressure > 300) {
            throw new IllegalArgumentException("Invalid blood pressure (must be 1-300).");
        }
        if (temperature <= 0 || temperature > 110) {
            throw new IllegalArgumentException("Invalid temperature (must be 1-110°F).");
        }
        this.heartRate = heartRate;
        this.bloodPressure = bloodPressure;
        this.temperature = temperature;
        this.notifier = new NotificationService();
    }

    public void checkVitals(String doctorContact) {
        if (doctorContact == null || doctorContact.trim().isEmpty()) {
            System.err.println("Error: Doctor contact cannot be empty.");
            return;
        }
        try {
            if (heartRate > 120 || bloodPressure > 140 || temperature > 102) {
                notifier.sendEmergencyAlert(doctorContact, "Critical vitals detected!");
            } else {
                System.out.println("Vitals are within normal range.");
            }
        } catch (Exception e) {
            System.err.println("Failed to send alert: " + e.getMessage());
        }
    }
}