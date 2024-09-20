package ucr.ac.tarea_C27227.room.jpa.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ucr.ac.tarea_C27227.room.jpa.entity.UserEntity;
import ucr.ac.tarea_C27227.room.jpa.entity.RoomEntity;

import java.util.Optional;

public interface UserRepository extends JpaRepository<UserEntity, Long> {
    Optional<UserEntity> findByAliasAndRoom(String alias, RoomEntity room);
}