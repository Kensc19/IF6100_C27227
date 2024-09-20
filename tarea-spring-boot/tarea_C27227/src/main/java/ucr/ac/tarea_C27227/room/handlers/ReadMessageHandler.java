package ucr.ac.tarea_C27227.room.handlers;

import ucr.ac.tarea_C27227.room.api.request.ReadMessagesRequest;
import ucr.ac.tarea_C27227.room.api.response.ReadMessagesResponse;

import java.util.List;

public interface ReadMessageHandler {
    record Command(String id) {}

    sealed interface Result {
        record Success(ReadMessagesResponse response) implements Result {}
        record InvalidData(String... fields) implements Result {}
        record RoomNotFound(String roomId) implements Result {}
    }

    Result handle(Command command);
}