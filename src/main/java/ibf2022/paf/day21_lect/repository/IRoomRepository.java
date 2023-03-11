package ibf2022.paf.day21_lect.repository;

import java.util.List;

import ibf2022.paf.day21_lect.model.Room;



public interface IRoomRepository {
    
    int count();

    Boolean save(Room room);

    List<Room> findAll();

    Room findById(int Id);

    int update(Room room);
    
    int deleteById(int Id);

}
