package ucr.ac.tarea_C27227.room.jpa.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ucr.ac.tarea_C27227.room.jpa.entity.RoomEntity;

import java.util.Optional;

public interface RoomRepository extends JpaRepository<RoomEntity, Long> {
    Optional<RoomEntity> findByIdentifier(String identifier);
    Optional<RoomEntity> findByName(String name);
}
