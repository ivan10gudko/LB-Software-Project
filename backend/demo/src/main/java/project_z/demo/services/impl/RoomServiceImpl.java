package project_z.demo.services.impl;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import project_z.demo.entity.RoomEntity;
import project_z.demo.repositories.RoomRepository;
import project_z.demo.services.RoomService;

@Service
public class RoomServiceImpl implements RoomService {
    @Autowired
    private RoomRepository roomRepository;
    @Override
    public RoomEntity save(RoomEntity roomEntity){
        return roomRepository.save(roomEntity);
    }
    @Override
    public List<RoomEntity> getRoomsByUserId(UUID userId) {
        return roomRepository.findAllByMembers_UserId(userId);
    }
    @Override
    public List<RoomEntity> findAll(){
        return  StreamSupport.stream( 
        roomRepository.findAll().spliterator(),
        false)
        .collect(Collectors.toList());
    }

}
