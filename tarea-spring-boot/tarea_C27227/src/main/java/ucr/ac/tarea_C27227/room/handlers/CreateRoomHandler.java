package ucr.ac.tarea_C27227.room.handlers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ucr.ac.tarea_C27227.room.api.CreateRoomRequest;
import ucr.ac.tarea_C27227.room.jpa.RoomEntity;
import ucr.ac.tarea_C27227.room.jpa.RoomRepository;

import java.util.UUID;

@Service
public class CreateRoomHandler {

    @Autowired
    private RoomRepository roomRepository;

    public String handle(CreateRoomRequest request) {
        if (request.getName() == null || request.getName().isEmpty() || request.getCreatedBy() == null || request.getCreatedBy().isEmpty()) {
            throw new IllegalArgumentException("Invalid request data");
        }

        RoomEntity room = new RoomEntity();
        room.setName(request.getName());
        room.setIdentifier(UUID.randomUUID().toString());

        roomRepository.save(room);
        return room.getIdentifier();
    }
}