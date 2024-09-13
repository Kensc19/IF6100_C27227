package ucr.ac.tarea_C27227.room.api;

import java.time.LocalDateTime;

public class SendMessageResponse {
    private Long id;
    private LocalDateTime createdOn;
    private String message;

    public void setId(Long id) {
        this.id = id;
    }

    public void setCreatedOn(LocalDateTime createdOn) {
        this.createdOn = createdOn;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
