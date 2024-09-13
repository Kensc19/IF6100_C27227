package ucr.ac.tarea_C27227.room.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ucr.ac.tarea_C27227.room.handlers.CreateRoomHandler;

@RestController
@RequestMapping("/api/C27227/room")
public class CreateRoomController {

    @Autowired
    private CreateRoomHandler createRoomHandler;

    @PostMapping("/create")
    public String createRoom(@RequestBody CreateRoomRequest request) {
        return createRoomHandler.handle(request);
    }
}