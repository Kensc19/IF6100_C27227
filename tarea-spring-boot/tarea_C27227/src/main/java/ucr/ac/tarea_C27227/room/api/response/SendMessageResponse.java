package ucr.ac.tarea_C27227.room.api.response;

import java.io.Serializable;
import java.time.LocalDateTime;

public class SendMessageResponse implements Serializable {
    private Long id;
    private LocalDateTime createdOn;
    private String message;

    // Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDateTime getCreatedOn() {
        return createdOn;
    }

    public void setCreatedOn(LocalDateTime createdOn) {
        this.createdOn = createdOn;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}