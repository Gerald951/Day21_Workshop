package ibf2022.paf.day21_lect.repository;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCallback;
import org.springframework.jdbc.core.PreparedStatementSetter;

import ibf2022.paf.day21_lect.model.Room;

public class RoomRepo implements IRoomRepo {

    @Autowired
    JdbcTemplate jdbcTemplate;

    private final String countSQL = "select count(*) from room";

    private final String findAllSQL = "select * from room";

    private final String findByIdSQL = "select * from room where id = ?";

    private final String deleteByIdSQL= "delete from room where id = ?";

    private final String insertSQL = "insert into room (room_type, price) values (?, ?)";

    private final String updateSQL = "update room set price = ? where id = ?";

    @Override
    public int count() {
        Integer result = 0;
        result = jdbcTemplate.queryForObject(countSQL, Integer.class);

        if (result == null) {
            return 0;
        } else {
            return result;
        }
    }

    @Override
    public int deleteById(int Id) {
        Integer deleted = 0;

        PreparedStatementSetter pss = new PreparedStatementSetter() {
            
            @Override
            public void setValues(PreparedStatement ps) throws SQLException {
                ps.setInt(1, Id);
            }
        };

        deleted = jdbcTemplate.update(deleteByIdSQL, pss);
        return deleted;
    }

    @Override
    public List<Room> findAll() {
        List<Room> rooms = new ArrayList<>();
        // query is for no arguments
        rooms = jdbcTemplate.query(findAllSQL, BeanPropertyRowMapper.newInstance(Room.class));

        return rooms;
    }

    @Override
    public Room findById(Integer id) {
        // queryForObject is for arguments
        return jdbcTemplate.queryForObject(findByIdSQL, BeanPropertyRowMapper.newInstance(Room.class), id);
    }

    //Create new room
    @Override
    public Boolean save(Room room) {
        Boolean saved = false;

        //execute function can be used to update, delete
        saved = jdbcTemplate.execute(insertSQL, new PreparedStatementCallback<Boolean>() {
            
            @Override
            public Boolean doInPreparedStatement(PreparedStatement ps) throws SQLException {
                ps.setString(1, room.getRoomType());
                ps.setFloat(2, room.getPrice());
                Boolean rslt = ps.execute();

                return rslt;
            }
        });
        return saved;
    }

    @Override
    public int update(Room room) {
       Integer updated = 0;

       updated = jdbcTemplate.update(updateSQL, new PreparedStatementSetter() {

        @Override
        public void setValues(PreparedStatement ps) throws SQLException {
            ps.setFloat(1, room.getPrice());
            ps.setInt(2, room.getId());
        }
       });

       return updated;
    }
    

    
}
