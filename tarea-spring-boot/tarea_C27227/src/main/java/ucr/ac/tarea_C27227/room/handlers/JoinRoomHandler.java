package ucr.ac.tarea_C27227.room.handlers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ucr.ac.tarea_C27227.room.api.JoinRoomRequest;
import ucr.ac.tarea_C27227.room.api.JoinRoomResponse;
import ucr.ac.tarea_C27227.room.jpa.RoomEntity;
import ucr.ac.tarea_C27227.room.jpa.RoomRepository;
import ucr.ac.tarea_C27227.room.jpa.UserEntity;
import ucr.ac.tarea_C27227.room.jpa.UserRepository;

import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class JoinRoomHandler {

    @Autowired
    private RoomRepository roomRepository;

    @Autowired
    private UserRepository userRepository;

    public JoinRoomResponse handle(JoinRoomRequest request) {
        Optional<RoomEntity> roomOpt = roomRepository.findByIdentifier(request.getId());
        if (!roomOpt.isPresent() || request.getAlias() == null || request.getAlias().isEmpty()) {
            return null;
        }

        RoomEntity room = roomOpt.get();
        UserEntity user = new UserEntity();
        user.setAlias(request.getAlias());
        user.setRoom(room);

        userRepository.save(user);

        JoinRoomResponse response = new JoinRoomResponse();
        response.setId(room.getIdentifier());
        response.setName(room.getName());
        response.setUsers(room.getUsers().stream().map(UserEntity::getAlias).collect(Collectors.toList()));

        return response;
    }
}
