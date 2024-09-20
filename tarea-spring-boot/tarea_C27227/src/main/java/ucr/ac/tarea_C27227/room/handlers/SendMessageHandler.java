package ucr.ac.tarea_C27227.room.handlers;

import ucr.ac.tarea_C27227.room.api.response.SendMessageResponse;

public interface SendMessageHandler {
    record Command(String id, String alias, String message) {}

    sealed interface Result {
        record Success(SendMessageResponse response) implements Result {}
        record InvalidData() implements Result {}
        record RoomNotFound() implements Result {}
        record AliasNotFound() implements Result {}
    }

    Result handle(Command command);
}