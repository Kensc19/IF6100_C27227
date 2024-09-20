package ucr.ac.tarea_C27227.room.handlers.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ucr.ac.tarea_C27227.room.api.response.MessageResponse;
import ucr.ac.tarea_C27227.room.api.response.ReadMessagesResponse;
import ucr.ac.tarea_C27227.room.handlers.ReadMessageHandler;
import ucr.ac.tarea_C27227.room.jpa.entity.MessageEntity;
import ucr.ac.tarea_C27227.room.jpa.entity.RoomEntity;
import ucr.ac.tarea_C27227.room.jpa.repository.MessageRepository;
import ucr.ac.tarea_C27227.room.jpa.repository.RoomRepository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ReadMessagesHandlerImpl implements ReadMessageHandler {

    @Autowired
    private RoomRepository roomRepository;

    @Autowired
    private MessageRepository messageRepository;

    @Override
    public Result handle(Command command) {
        if (command.id() == null || command.id().isEmpty()) {
            return new Result.InvalidData("id");
        }

        Optional<RoomEntity> roomOpt = roomRepository.findByIdentifier(command.id());
        if (!roomOpt.isPresent()) {
            return new Result.RoomNotFound(command.id());
        }

        RoomEntity room = roomOpt.get();
        List<MessageEntity> messages = messageRepository.findByRoomOrderByCreatedOnAsc(room);

        List<MessageResponse> messageList = messages.stream()
                .map(msg -> new MessageResponse(msg.getUser().getAlias(), msg.getMessage(), msg.getCreatedOn()))
                .collect(Collectors.toList());

        ReadMessagesResponse response = new ReadMessagesResponse(room.getIdentifier(), room.getName(), messageList);
        return new Result.Success(response);
    }
}