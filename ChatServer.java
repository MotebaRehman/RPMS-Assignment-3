// ChatServer class

public class ChatServer {
    public void sendMessage(String toUser, String message) {
        if (toUser == null || toUser.trim().isEmpty()) {
            System.err.println("Error: Recipient username cannot be empty.");
            return;
        }
        if (message == null || message.trim().isEmpty()) {
            System.err.println("Error: Message cannot be empty.");
            return;
        }
        System.out.println("Sending message to " + toUser + ": " + message);
    }

    public void receiveMessage(String fromUser, String message) {
        if (fromUser == null || fromUser.trim().isEmpty()) {
            System.err.println("Error: Sender username cannot be empty.");
            return;
        }
        if (message == null || message.trim().isEmpty()) {
            System.err.println("Error: Message cannot be empty.");
            return;
        }
        System.out.println("Message from [" + fromUser + "]: " + message);
    }
}