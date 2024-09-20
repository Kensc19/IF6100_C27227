package ucr.ac.tarea_C27227.room.handlers.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ucr.ac.tarea_C27227.room.handlers.CreateRoomHandler;
import ucr.ac.tarea_C27227.room.jpa.entity.RoomEntity;
import ucr.ac.tarea_C27227.room.jpa.entity.UserEntity;
import ucr.ac.tarea_C27227.room.jpa.repository.RoomRepository;
import ucr.ac.tarea_C27227.room.jpa.repository.UserRepository;

import java.util.Optional;
import java.util.UUID;

@Service
public class CreateRoomHandlerImpl implements CreateRoomHandler {

    @Autowired
    private RoomRepository roomRepository;

    @Autowired
    private UserRepository userRepository;

    @Override
    public Result createRoom(Command command) {
        if (command.name() == null || command.name().isEmpty() || command.createdBy() == null || command.createdBy().isEmpty()) {
            return new Result.InvalidData("name", "createdBy");
        }

        Optional<RoomEntity> existingRoom = roomRepository.findByName(command.name());
        if (existingRoom.isPresent()) {
            return new Result.Success(null);
        }

        RoomEntity room = new RoomEntity();
        room.setName(command.name());
        room.setIdentifier(UUID.randomUUID().toString());
        roomRepository.save(room);

        UserEntity user = new UserEntity();
        user.setAlias(command.createdBy());
        user.setRoom(room);
        userRepository.save(user);

        return new Result.Success(room.getIdentifier());
    }
}