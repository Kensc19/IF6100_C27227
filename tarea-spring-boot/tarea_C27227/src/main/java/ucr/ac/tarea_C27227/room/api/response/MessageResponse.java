package ucr.ac.tarea_C27227.room.api.response;

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

    public String getAlias() {
        return alias;
    }

    public void setAlias(String alias) {
        this.alias = alias;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public LocalDateTime getCreatedOn() {
        return createdOn;
    }

    public void setCreatedOn(LocalDateTime createdOn) {
        this.createdOn = createdOn;
    }
}
