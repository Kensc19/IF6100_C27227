package ucr.ac.tarea_C27227.room.handlers.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ucr.ac.tarea_C27227.room.handlers.JoinRoomHandler;
import ucr.ac.tarea_C27227.room.jpa.entity.RoomEntity;
import ucr.ac.tarea_C27227.room.jpa.entity.UserEntity;
import ucr.ac.tarea_C27227.room.jpa.repository.RoomRepository;
import ucr.ac.tarea_C27227.room.jpa.repository.UserRepository;

import java.util.stream.Collectors;

@Service
public class JoinRoomHandlerImpl implements JoinRoomHandler {

    @Autowired
    private RoomRepository roomRepository;

    @Autowired
    private UserRepository userRepository;

    @Override
    public Result joinRoom(Command command) {
        if (command.roomId() == null || command.roomId().isEmpty() || command.alias() == null || command.alias().isEmpty()) {
            return new Result.InvalidData("roomId", "alias");
        }

        RoomEntity room = roomRepository.findByIdentifier(command.roomId()).orElse(null);
        if (room == null) {
            return new Result.RoomNotFound(command.roomId());
        }

        if (userRepository.findByAliasAndRoom(command.alias(), room).isPresent()) {
            return new Result.AliasAlreadyExists(command.alias());
        }

        UserEntity user = new UserEntity();
        user.setAlias(command.alias());
        user.setRoom(room);
        userRepository.save(user);

        return new Result.Success(
                room.getIdentifier(),
                room.getName(),
                room.getUsers().stream().map(UserEntity::getAlias).collect(Collectors.toList())
        );
    }
}