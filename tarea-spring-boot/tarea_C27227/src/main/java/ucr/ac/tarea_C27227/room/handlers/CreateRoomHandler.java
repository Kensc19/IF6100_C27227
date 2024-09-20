package ucr.ac.tarea_C27227.room.handlers;

public interface CreateRoomHandler {
    record Command(String name, String createdBy) {}

    sealed interface Result {
        record Success(String roomId) implements Result {}
        record InvalidData(String... fields) implements Result {}
        record UserRegistrationFailed(String message) implements Result {}
    }

    Result createRoom(Command command);
}