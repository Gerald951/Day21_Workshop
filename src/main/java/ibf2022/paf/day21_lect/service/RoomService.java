package ibf2022.paf.day21_lect.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ibf2022.paf.day21_lect.model.Room;
import ibf2022.paf.day21_lect.repository.IRoomRepository;



@Service
public class RoomService{
   
    @Autowired
    IRoomRepository roomRepo;

    public int count() {
        return roomRepo.count();
    }

    public Boolean save(Room room){
        return roomRepo.save(room);
    }

    public List<Room> findAll(){
        return roomRepo.findAll();
    }

    public Room findById(int Id){
        return roomRepo.findById(Id);
    }

    public int update(Room room){
        return roomRepo.update(room);
    }

    public int deleteById(int Id){
        return roomRepo.deleteById(Id);
    }

}
