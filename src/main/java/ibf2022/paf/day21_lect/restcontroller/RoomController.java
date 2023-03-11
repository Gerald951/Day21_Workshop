package ibf2022.paf.day21_lect.restcontroller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import ibf2022.paf.day21_lect.exception.ResourceNotFoundException;
import ibf2022.paf.day21_lect.model.Room;
import ibf2022.paf.day21_lect.service.RoomService;

@RestController
@RequestMapping("/api/rooms")
public class RoomController {

    @Autowired
    RoomService roomSvc;

    // http://localhost:8080/api/rooms/count
    @GetMapping("/count")
    public ResponseEntity<Integer> getRoomCount() {
        Integer roomCount = roomSvc.count();

        return ResponseEntity.ok().body(roomCount);
    }

    @GetMapping("/get")
    public ResponseEntity<List<Room>> getAllRooms() {
        List<Room> rooms = roomSvc.findAll();
        if (rooms.isEmpty()) 
            // return ResponseEntity.noContent().build();
            throw new ResourceNotFoundException("No room found");

        return ResponseEntity.ok().body(rooms);
        
    }

    @GetMapping(path="/{room-Id}")
    public ResponseEntity<Room> getRoomById(@PathVariable("room-Id") int roomId) {
        Room room = roomSvc.findById(roomId);

        if (null == room)
            throw new ResourceNotFoundException("No room is found");

        return ResponseEntity.ok().body(room);
    }

    @PostMapping(path = "/save")
    public ResponseEntity<Boolean> saveRooms(@RequestBody Room room) {
        Boolean saved = roomSvc.save(room);

        return ResponseEntity.ok().body(saved);
    }

    @PutMapping
    public ResponseEntity<Integer> updateRoom(@RequestBody Room room) {
        int updated = 0;

        updated = roomSvc.update(room);

        if (updated == 1) {
            return ResponseEntity.ok().body(updated);
        } else {
            return ResponseEntity.status(500).body(updated);
        }
    }

    @DeleteMapping(path = "/delete/{room-Id}")
    public ResponseEntity<Integer> deleteRoom(@PathVariable("room-Id") Integer id) {
        Integer deleted = 0;

        deleted = roomSvc.deleteById(id);

        if (deleted == 1) 
            return ResponseEntity.ok().body(deleted);

        return ResponseEntity.status(500).body(deleted);
    }
    
}
