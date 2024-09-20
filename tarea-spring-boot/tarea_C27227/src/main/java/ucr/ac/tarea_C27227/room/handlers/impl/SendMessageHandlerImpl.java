package ucr.ac.tarea_C27227.room.handlers.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ucr.ac.tarea_C27227.room.api.response.SendMessageResponse;
import ucr.ac.tarea_C27227.room.handlers.SendMessageHandler;
import ucr.ac.tarea_C27227.room.jpa.entity.MessageEntity;
import ucr.ac.tarea_C27227.room.jpa.entity.RoomEntity;
import ucr.ac.tarea_C27227.room.jpa.entity.UserEntity;
import ucr.ac.tarea_C27227.room.jpa.repository.MessageRepository;
import ucr.ac.tarea_C27227.room.jpa.repository.RoomRepository;
import ucr.ac.tarea_C27227.room.jpa.repository.UserRepository;

import java.time.LocalDateTime;
import java.util.Optional;

@Service
public class SendMessageHandlerImpl implements SendMessageHandler {

    @Autowired
    private RoomRepository roomRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private MessageRepository messageRepository;

    @Override
    public Result handle(Command command) {
        if (command.id() == null || command.id().isEmpty() ||
                command.alias() == null || command.alias().isEmpty() ||
                command.message() == null || command.message().isEmpty()) {
            return new Result.InvalidData();
        }

        Optional<RoomEntity> roomOpt = roomRepository.findByIdentifier(command.id());
        if (!roomOpt.isPresent()) {
            return new Result.RoomNotFound();
        }

        RoomEntity room = roomOpt.get();
        Optional<UserEntity> userOpt = userRepository.findByAliasAndRoom(command.alias(), room);
        if (!userOpt.isPresent()) {
            return new Result.AliasNotFound();
        }

        UserEntity user = userOpt.get();
        MessageEntity message = new MessageEntity();
        message.setUser(user);
        message.setRoom(room);
        message.setMessage(command.message());
        message.setCreatedOn(LocalDateTime.now());
        messageRepository.save(message);

        SendMessageResponse response = new SendMessageResponse();
        response.setId(message.getId());
        response.setCreatedOn(message.getCreatedOn());
        response.setMessage(message.getMessage());

        return new Result.Success(response);
    }
}