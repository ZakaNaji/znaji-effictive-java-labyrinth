import java.util.HashMap;
import java.util.Map;

public class Room {
    private Map<Room,Door> nextRooms;
    private String name ;

    public Room(String name){
        nextRooms = new HashMap<Room, Door>();
        this.name = name;
    }

    public String getRoomName(){
        return name;
    }

    public void addNeighbor(Room secondRoom, Door door) {
        nextRooms.put(secondRoom,door);
    }

    @Override
    public boolean equals(Object obj) {
        if(obj == this) return true;
        if(!(obj instanceof Room)) return false;
        Room room = (Room) obj;
        return (name.equals(room.getRoomName()));
    }

    @Override
    public int hashCode() {
        return name.hashCode();
    }
}
