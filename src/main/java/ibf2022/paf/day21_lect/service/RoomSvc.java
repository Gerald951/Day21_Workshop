package ibf2022.paf.day21_lect.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ibf2022.paf.day21_lect.model.Room;
import ibf2022.paf.day21_lect.repository.IRoomRepo;

@Service
public class RoomSvc {

    @Autowired
    IRoomRepo roomRepo;

    public int count() {
        return roomRepo.count();
    }

    public Boolean save(Room room) {
        return roomRepo.save(room);
    }

    public List<Room> findAll() {
        return roomRepo.findAll();
    }

    public Room findById(Integer id) {
        return roomRepo.findById(id);
    }

    public int update(Room room) {
        return roomRepo.update(room);
    }

    public int deleteById(int Id) {
        return roomRepo.deleteById(Id);
    }

    
    
}
