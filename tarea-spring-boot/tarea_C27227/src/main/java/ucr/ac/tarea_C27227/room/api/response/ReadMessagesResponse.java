package ucr.ac.tarea_C27227.room.api.response;

import java.util.List;

public class ReadMessagesResponse {
    private String id;
    private String name;
    private List<MessageResponse> messages;

    public ReadMessagesResponse(String id, String name, List<MessageResponse> messages) {
        this.id = id;
        this.name = name;
        this.messages = messages;
    }

    // Getters and Setters
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<MessageResponse> getMessages() {
        return messages;
    }

    public void setMessages(List<MessageResponse> messages) {
        this.messages = messages;
    }
}