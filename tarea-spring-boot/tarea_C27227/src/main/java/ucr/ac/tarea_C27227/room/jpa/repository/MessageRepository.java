package ucr.ac.tarea_C27227.room.jpa.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ucr.ac.tarea_C27227.room.jpa.entity.MessageEntity;
import ucr.ac.tarea_C27227.room.jpa.entity.RoomEntity;

import java.util.List;

public interface MessageRepository extends JpaRepository<MessageEntity, Long> {
    List<MessageEntity> findByRoomOrderByCreatedOnAsc(RoomEntity room);
}
