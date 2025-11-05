package project_z.demo.services;

import java.util.List;
import java.util.UUID;

import org.springframework.stereotype.Service;

import project_z.demo.entity.RoomEntity;

@Service
public interface RoomService {
RoomEntity save(RoomEntity roomEntity);
List<RoomEntity> getRoomsByUserId(UUID userId);
List<RoomEntity> findAll();
}
