package ucr.ac.tarea_C27227.room.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ucr.ac.tarea_C27227.room.api.request.SendMessageRequest;
import ucr.ac.tarea_C27227.room.api.response.SendMessageResponse;
import ucr.ac.tarea_C27227.room.handlers.SendMessageHandler;

@RestController
@RequestMapping("/api/C27227/room")
public class SendMessageController {

    private final SendMessageHandler sendMessageHandler;

    @Autowired
    public SendMessageController(SendMessageHandler sendMessageHandler) {
        this.sendMessageHandler = sendMessageHandler;
    }

    @PostMapping(value = "/message", produces = "application/json")
    public ResponseEntity<SendMessageResponse> sendMessage(@RequestBody SendMessageRequest request) {
        SendMessageHandler.Command command = new SendMessageHandler.Command(request.getId(), request.getAlias(), request.getMessage());
        SendMessageHandler.Result result = sendMessageHandler.handle(command);

        return switch (result) {
            case SendMessageHandler.Result.Success success -> ResponseEntity.ok(success.response());
            case SendMessageHandler.Result.InvalidData invalidData -> ResponseEntity.ok().body(null);
            case SendMessageHandler.Result.RoomNotFound roomNotFound -> ResponseEntity.ok().body(null);
            case SendMessageHandler.Result.AliasNotFound aliasNotFound -> ResponseEntity.ok().body(null);
            default -> ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        };
    }
}