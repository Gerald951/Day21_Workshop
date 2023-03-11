package ibf2022.paf.day21_lect.model;

public class Room {
    
    private int Id;
    private String roomType;
    private float price;


    public int getId() {
        return Id;
    }
    public void setId(int id) {
        Id = id;
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
    public String toString(){
        return "ID: %d, Room Type: %s, Price: %f.".formatted(Id, roomType, price);
    }





}
