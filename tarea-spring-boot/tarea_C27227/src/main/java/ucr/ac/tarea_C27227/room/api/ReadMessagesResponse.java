package ucr.ac.tarea_C27227.room.api;

import java.util.List;

public class ReadMessagesResponse {
   private String id;
   private String name;
   private List<MessageResponse> messages;

    public void setId(String id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setMessages(List<MessageResponse> messages) {
        this.messages = messages;
    }
}
