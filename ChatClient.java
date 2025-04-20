// ChatClient class

public class ChatClient {
    private String userName;
    private ChatServer server;

    public ChatClient(String userName, ChatServer server) {
        if (userName == null || userName.trim().isEmpty()) {
            throw new IllegalArgumentException("Username cannot be null or empty.");
        }
        if (server == null) {
            throw new IllegalArgumentException("ChatServer cannot be null.");
        }
        this.userName = userName;
        this.server = server;
    }

    public void sendMessage(String message, String toUser) {
        if (message == null || message.trim().isEmpty()) {
            System.err.println("Error: Message cannot be empty.");
            return;
        }
        if (toUser == null || toUser.trim().isEmpty()) {
            System.err.println("Error: Recipient username cannot be empty.");
            return;
        }
        server.receiveMessage(userName, message);
    }

    public void receiveMessage(String message, String fromUser) {
        if (message == null || fromUser == null) {
            System.err.println("Error: Invalid message received.");
            return;
        }
        System.out.println("[" + userName + "] received: " + message);
    }
}