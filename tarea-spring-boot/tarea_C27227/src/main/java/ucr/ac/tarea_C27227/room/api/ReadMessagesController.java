package ucr.ac.tarea_C27227.room.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ucr.ac.tarea_C27227.room.api.request.ReadMessagesRequest;
import ucr.ac.tarea_C27227.room.api.response.ReadMessagesResponse;
import ucr.ac.tarea_C27227.room.handlers.ReadMessageHandler;

@RestController
@RequestMapping("/api/C27227/room")
public class ReadMessagesController {

    @Autowired
    private ReadMessageHandler readMessageHandler;

    @GetMapping("/message")
    public ReadMessagesResponse readMessages(@RequestBody ReadMessagesRequest request) {
        ReadMessageHandler.Command command = new ReadMessageHandler.Command(request.getId());
        ReadMessageHandler.Result result = readMessageHandler.handle(command);

        return switch (result) {
            case ReadMessageHandler.Result.Success success -> success.response();
            case ReadMessageHandler.Result.InvalidData invalidData -> null;
            case ReadMessageHandler.Result.RoomNotFound roomNotFound -> null;
        };
    }
}