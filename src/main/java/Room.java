import java.util.HashMap;
import java.util.Map;

public class Room {
    private Map<Room,Door> nextRoom;

    public Room(){
        nextRoom = new HashMap<Room, Door>();
    }


}
