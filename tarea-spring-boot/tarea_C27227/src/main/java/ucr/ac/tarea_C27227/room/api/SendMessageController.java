package ucr.ac.tarea_C27227.room.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ucr.ac.tarea_C27227.room.handlers.SendMessageHandler;

@RestController
@RequestMapping("/api/C27227/room")
public class SendMessageController {

    @Autowired
    private SendMessageHandler sendMessageHandler;

    @PostMapping("/message")
    public SendMessageResponse sendMessage(@RequestBody SendMessageRequest request) {
        return sendMessageHandler.handle(request);
    }
}
