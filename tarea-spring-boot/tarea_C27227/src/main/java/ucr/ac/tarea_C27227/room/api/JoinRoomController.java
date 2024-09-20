package ucr.ac.tarea_C27227.room.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ucr.ac.tarea_C27227.room.api.request.JoinRoomRequest;
import ucr.ac.tarea_C27227.room.api.response.JoinRoomResponse;
import ucr.ac.tarea_C27227.room.handlers.JoinRoomHandler;

@RestController
@RequestMapping("/api/C27227/room")
public class JoinRoomController {

    @Autowired
    private JoinRoomHandler joinRoomHandler;

    @PostMapping("/join")
    public JoinRoomResponse joinRoom(@RequestBody JoinRoomRequest request) {
        JoinRoomHandler.Command command = new JoinRoomHandler.Command(request.getId(), request.getAlias());
        JoinRoomHandler.Result result = joinRoomHandler.joinRoom(command);

        return switch (result) {
            case JoinRoomHandler.Result.Success success ->
                    new JoinRoomResponse(success.roomId(), success.roomName(), success.users());
            case JoinRoomHandler.Result.InvalidData invalidData -> null;
            case JoinRoomHandler.Result.RoomNotFound roomNotFound -> null;
            case JoinRoomHandler.Result.AliasAlreadyExists aliasAlreadyExists -> null;
        };
    }
}