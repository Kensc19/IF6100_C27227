package ucr.ac.tarea_C27227.room.handlers;

import java.util.List;

public interface JoinRoomHandler {
    record Command(String roomId, String alias) {}

    sealed interface Result {
        record Success(String roomId, String roomName, List<String> users) implements Result {}
        record InvalidData(String... fields) implements Result {}
        record RoomNotFound(String roomId) implements Result {}
        record AliasAlreadyExists(String alias) implements Result {}
    }

    Result joinRoom(Command command);
}