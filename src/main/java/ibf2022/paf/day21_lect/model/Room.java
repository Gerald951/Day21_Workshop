package ibf2022.paf.day21_lect.model;

public class Room {
    private Integer id;
    
    private String roomType;

    private float price;

    public Room() {}

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getRoomType() {
        return roomType;
    }

    public void setRoomType(String roomType) {
        this.roomType = roomType;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Room [Id=" + id + ", roomType=" + roomType + ", price=" + price + "]";
    }
    
    
    
}
