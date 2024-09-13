package ucr.ac.tarea_C27227.room.handlers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ucr.ac.tarea_C27227.room.api.MessageResponse;
import ucr.ac.tarea_C27227.room.api.ReadMessagesRequest;
import ucr.ac.tarea_C27227.room.api.ReadMessagesResponse;
import ucr.ac.tarea_C27227.room.jpa.RoomEntity;
import ucr.ac.tarea_C27227.room.jpa.RoomRepository;

import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ReadMessagesHandler {

    @Autowired
    private RoomRepository roomRepository;

    public ReadMessagesResponse handle(ReadMessagesRequest request) {
        Optional<RoomEntity> roomOpt = roomRepository.findByIdentifier(request.getId());
        if (!roomOpt.isPresent()) {
            return null;
        }

        RoomEntity room = roomOpt.get();
        ReadMessagesResponse response = new ReadMessagesResponse();
        response.setId(room.getIdentifier());
        response.setName(room.getName());
        response.setMessages(room.getUsers().stream()
                .flatMap(user -> user.getMessages().stream())
                .map(message -> new MessageResponse(message.getUser().getAlias(), message.getMessage(), message.getCreatedOn()))
                .collect(Collectors.toList()));

        return response;
    }
}
