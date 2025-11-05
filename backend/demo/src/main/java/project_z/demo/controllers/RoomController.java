package project_z.demo.controllers;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import project_z.demo.Mappers.Mapper;
import project_z.demo.dto.RoomDto;
import project_z.demo.entity.RoomEntity;
import project_z.demo.repositories.RoomRepository;
import project_z.demo.services.RoomService;
import project_z.demo.services.UserService;




@RestController
public class RoomController {
    @Autowired
    private RoomService roomService;
    @Autowired
    private UserService userService;
    @Autowired
    private RoomRepository roomRepository;
    @Autowired
    private Mapper<RoomEntity,RoomDto> roomMapper;
    @GetMapping("/Rooms/{id}")
    public List<RoomEntity> getRoomsByUser(@PathVariable("id") UUID id) {
        List<RoomEntity> response = roomService.getRoomsByUserId(id);
        return response;
    }
    @GetMapping(path = "/Rooms")
    public List<RoomEntity> getAllRooms() {
       List<RoomEntity> response = roomService.findAll();
       return response;
    }
    @PostMapping(path = "/Rooms")
    public ResponseEntity<RoomDto> createRoom(@RequestBody RoomDto roomDto) {
        System.out.println(roomDto);
        RoomEntity roomEntity = roomMapper.mapFrom(roomDto);
        RoomEntity savedRoom = roomService.save(roomEntity);
        RoomDto savedRoomDto = roomMapper.mapTo(savedRoom);
        return new ResponseEntity<>(savedRoomDto, HttpStatus.CREATED);
        
    }
    
}
