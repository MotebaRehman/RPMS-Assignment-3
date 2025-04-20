// RemoteHealthMonitoringSystem class

import java.util.InputMismatchException;
import java.util.Scanner;

public class RemoteHealthMonitoringSystem {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        try {
            System.out.println("Remote Patient Monitoring System");

            // Emergency Alert System
            System.out.println("\nEmergency Alert System");
            int heartRate = 0, bloodPressure = 0, temperature = 0;

            // Input validation for vitals
            while (true) {
                try {
                    System.out.print("Enter heart rate: ");
                    heartRate = scanner.nextInt();
                    if (heartRate <= 0 || heartRate > 200) {
                        System.err.println("Error: Heart rate must be between 1 and 200.");
                        continue;
                    }
                    break;
                } catch (InputMismatchException e) {
                    System.err.println("Error: Please enter a valid number.");
                    scanner.nextLine();
                }
            }

            while (true) {
                try {
                    System.out.print("Enter blood pressure: ");
                    bloodPressure = scanner.nextInt();
                    if (bloodPressure <= 0 || bloodPressure > 300) {
                        System.err.println("Error: Blood pressure must be between 1 and 300.");
                        continue;
                    }
                    break;
                } catch (InputMismatchException e) {
                    System.err.println("Error: Please enter a valid number.");
                    scanner.nextLine();
                }
            }

            while (true) {
                try {
                    System.out.print("Enter temperature: ");
                    temperature = scanner.nextInt();
                    if (temperature <= 0 || temperature > 110) {
                        System.err.println("Error: Temperature must be between 1 and 110.");
                        continue;
                    }
                    break;
                } catch (InputMismatchException e) {
                    System.err.println("Error: Please enter a valid number.");
                    scanner.nextLine();
                }
            }

            EmergencyAlert alert = new EmergencyAlert(heartRate, bloodPressure, temperature);
            String doctorEmail;
            while (true) {
                System.out.print("\nEnter doctor email for alert: ");
                doctorEmail = scanner.nextLine().trim();
                if (doctorEmail.isEmpty()) {
                    System.err.println("Error: Doctor email cannot be empty.");
                } else {
                    break;
                }
            }
            alert.checkVitals(doctorEmail);

            // Panic Button
            System.out.print("Do you want to press the panic button? (yes/no): ");
            String panic = scanner.nextLine().trim();
            if (panic.equalsIgnoreCase("yes")) {
                PanicButton panicButton = new PanicButton(new EmailNotification());
                String emergencyEmail;
                while (true) {
                    System.out.print("Enter emergency contact email: ");
                    emergencyEmail = scanner.nextLine().trim();
                    if (emergencyEmail.isEmpty()) {
                        System.err.println("Error: Emergency contact cannot be empty.");
                    } else {
                        break;
                    }
                }
                panicButton.press(emergencyEmail);
            }

            // Chat & Video Consultation
            System.out.println("\nChat & Video Consultation");
            String doctorUser;
            while (true) {
                System.out.print("Enter doctor username: ");
                doctorUser = scanner.nextLine().trim();
                if (doctorUser.isEmpty()) {
                    System.err.println("Error: Doctor username cannot be empty.");
                } else {
                    break;
                }
            }

            String patientUser;
            while (true) {
                System.out.print("Enter patient username: ");
                patientUser = scanner.nextLine().trim();
                if (patientUser.isEmpty()) {
                    System.err.println("Error: Patient username cannot be empty.");
                } else {
                    break;
                }
            }

            ChatServer server = new ChatServer();
            ChatClient doctor = new ChatClient(doctorUser, server);
            ChatClient patient = new ChatClient(patientUser, server);

            String msgToPatient;
            while (true) {
                System.out.print(doctorUser + ", enter message to patient: ");
                msgToPatient = scanner.nextLine().trim();
                if (msgToPatient.isEmpty()) {
                    System.err.println("Error: Message cannot be empty.");
                } else {
                    break;
                }
            }
            doctor.sendMessage(msgToPatient, patientUser);

            String msgToDoctor;
            while (true) {
                System.out.print(patientUser + ", enter message to doctor: ");
                msgToDoctor = scanner.nextLine().trim();
                if (msgToDoctor.isEmpty()) {
                    System.err.println("Error: Message cannot be empty.");
                } else {
                    break;
                }
            }
            patient.sendMessage(msgToDoctor, doctorUser);

            // Video Call
            System.out.print("Do you want to start a video call? (yes/no): ");
            String startCall = scanner.nextLine().trim();
            if (startCall.equalsIgnoreCase("yes")) {
                String platform;
                while (true) {
                    System.out.print("Enter platform (Zoom/Meet): ");
                    platform = scanner.nextLine().trim();
                    if (platform.isEmpty()) {
                        System.err.println("Error: Platform cannot be empty.");
                    } else {
                        break;
                    }
                }

                String link;
                while (true) {
                    System.out.print("Enter meeting link: ");
                    link = scanner.nextLine().trim();
                    if (link.isEmpty()) {
                        System.err.println("Error: Meeting link cannot be empty.");
                    } else {
                        break;
                    }
                }

                VideoCall call = new VideoCall();
                call.startCall(platform, link);
            }

            // Notifications & Reminders
            System.out.println("\nNotifications & Reminders");
            ReminderService reminderService = new ReminderService();

            String recipient;
            while (true) {
                System.out.print("Enter recipient (email or phone): ");
                recipient = scanner.nextLine().trim();
                if (recipient.isEmpty()) {
                    System.err.println("Error: Recipient cannot be empty.");
                } else {
                    break;
                }
            }

            String reminderMsg;
            while (true) {
                System.out.print("Enter reminder message: ");
                reminderMsg = scanner.nextLine().trim();
                if (reminderMsg.isEmpty()) {
                    System.err.println("Error: Reminder message cannot be empty.");
                } else {
                    break;
                }
            }

            reminderService.sendReminder(recipient, reminderMsg);

        } catch (Exception e) {
            System.err.println("An unexpected error occurred: " + e.getMessage());
            e.printStackTrace();
        } finally {
            scanner.close();
            System.out.println("\nProgram ended.");
        }
    }
}