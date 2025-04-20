// VideoCall class

public class VideoCall {
    public void startCall(String platform, String meetingLink) {
        if (platform == null || platform.trim().isEmpty()) {
            System.err.println("Error: Platform cannot be empty.");
            return;
        }
        if (meetingLink == null || meetingLink.trim().isEmpty()) {
            System.err.println("Error: Meeting link cannot be empty.");
            return;
        }
        System.out.println("Opening " + platform + " call: " + meetingLink);
    }
}