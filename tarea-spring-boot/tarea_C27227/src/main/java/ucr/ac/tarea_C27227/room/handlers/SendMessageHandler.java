package ucr.ac.tarea_C27227.room.handlers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ucr.ac.tarea_C27227.room.api.SendMessageRequest;
import ucr.ac.tarea_C27227.room.api.SendMessageResponse;
import ucr.ac.tarea_C27227.room.jpa.*;

import java.time.LocalDateTime;
import java.util.Optional;

@Service
public class SendMessageHandler {

    @Autowired
    private RoomRepository roomRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private MessageRepository messageRepository;

    public SendMessageResponse handle(SendMessageRequest request) {
        Optional<RoomEntity> roomOpt = roomRepository.findByIdentifier(request.getId());
        if (!roomOpt.isPresent() || request.getAlias() == null || request.getAlias().isEmpty() || request.getMessage() == null || request.getMessage().isEmpty()) {
            return null;
        }

        RoomEntity room = roomOpt.get();
        Optional<UserEntity> userOpt = room.getUsers().stream().filter(user -> user.getAlias().equals(request.getAlias())).findFirst();
        if (!userOpt.isPresent()) {
            return null;
        }

        UserEntity user = userOpt.get();
        MessageEntity message = new MessageEntity();
        message.setMessage(request.getMessage());
        message.setCreatedOn(LocalDateTime.now());
        message.setUser(user);

        messageRepository.save(message);

        SendMessageResponse response = new SendMessageResponse();
        response.setId(message.getId());
        response.setCreatedOn(message.getCreatedOn());
        response.setMessage(message.getMessage());

        return response;
    }
}