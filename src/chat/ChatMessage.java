package chat;

import java.io.Serializable;
import java.time.LocalDateTime;

public class ChatMessage implements Serializable {
    private String senderEmail;
    private String message;
    private LocalDateTime timestamp;

    public ChatMessage() {
    }

    public ChatMessage(String senderEmail, String message) {
        this.senderEmail = senderEmail;
        this.message = message;
        this.timestamp = LocalDateTime.now();
    }

    public String getSenderEmail() {
        return senderEmail;
    }

    public void setSenderEmail(String senderEmail) {
        this.senderEmail = senderEmail;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(LocalDateTime timestamp) {
        this.timestamp = timestamp;
    }

    @Override
    public String toString() {
        return "From: " + senderEmail + " [" + timestamp + "]: " + message;
    }
}
