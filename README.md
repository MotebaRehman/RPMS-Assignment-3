Remote Patient Monitoring System

- Project Description

The Remote Patient Monitoring System (RPMS) is a console-based Java application designed to simulate a real-world healthcare alert and consultation platform.

- Prerequisites

Ensure you have the following installed on your system before running the project:

Java Development Kit (JDK) 8 or later  
Any Java-compatible IDE or a command-line interface (Terminal / Command Prompt)

- How to Run the Project

(i) Using an IDE:

1. Open your Java-compatible IDE.
2. Import or open the project folder containing the `.java` files.
3. Ensure all required classes (EmergencyAlert, ChatClient, VideoCall, etc.) are present.
4. Compile and run the `Main.java` file.
5. Follow the on-screen console prompts to interact with the system.

(ii) Using Command Line:

1. Open a terminal or command prompt.
2. Navigate to the directory containing the Java files.
3. Compile the program using:
javac RemoteHealthMonitoringSystem.java
4. Run the program using:
java RemoteHealthMonitoringSystem
5. Interact with the system using the console options.

- Features

(i) Emergency Alert System
EmergencyAlert: Detects critical health vitals and triggers alerts.
NotificationService: Sends alerts via email and SMS to doctors/emergency contacts.
PanicButton: Allows manual emergency alert by the patient.

(ii) Chat & Video Consultation
ChatClient / ChatServer: Basic chat simulation between doctor and patient.
VideoCall: Launches a simulated video consultation via a dummy link.

(iii) Notifications & Reminders
ReminderService: Sends reminders about appointments and medications.
EmailNotification / SMSNotification: Handle respective message types via a Notifiable interface.

- Expected Console Inputs & Outputs

Users will be prompted to press a panic button, enter chat messages, simulate launching a video call, choose between email or SMS for sending reminders.
Corresponding outputs are displayed in the console to simulate successful operation of each service.
