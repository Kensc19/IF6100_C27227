package ucr.ac.tarea_C27227.room.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ucr.ac.tarea_C27227.room.handlers.JoinRoomHandler;


@RestController
@RequestMapping("/api/C27227/room")
public class JoinRoomController {

    @Autowired
    private JoinRoomHandler joinRoomHandler;

    @PostMapping("/join")
    public JoinRoomResponse joinRoom(@RequestBody JoinRoomRequest request) {
        return joinRoomHandler.handle(request);
    }
}