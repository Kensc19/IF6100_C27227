package ucr.ac.tarea_C27227.room.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ucr.ac.tarea_C27227.room.handlers.ReadMessagesHandler;

@RestController
@RequestMapping("/api/C27227/room")
public class ReadMessagesController {

    @Autowired
    private ReadMessagesHandler readMessagesHandler;

    @GetMapping("/message")
    public ReadMessagesResponse readMessages(@RequestBody ReadMessagesRequest request) {
        return readMessagesHandler.handle(request);
    }
}
