package ucr.ac.tarea_C27227.room.api;

import java.time.LocalDateTime;

public class MessageResponse {
    private String alias;
    private String message;
    private LocalDateTime createdOn;

    public MessageResponse(String alias, String message, LocalDateTime createdOn) {
        this.alias = alias;
        this.message = message;
        this.createdOn = createdOn;
    }
}
