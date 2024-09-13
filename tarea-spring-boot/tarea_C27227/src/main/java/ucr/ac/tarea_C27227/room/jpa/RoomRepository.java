package ucr.ac.tarea_C27227.room.jpa;

import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface RoomRepository extends JpaRepository<RoomEntity, Long> {
    Optional<RoomEntity> findByIdentifier(String identifier);
}
