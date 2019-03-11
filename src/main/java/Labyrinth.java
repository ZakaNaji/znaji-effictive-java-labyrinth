import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

public class Labyrinth {

    private static final int DOOR_SEPARATOR_INDEX = 1;
    private Set<Room> listOfRooms;
    private List<Room> walkingPath;

    public Labyrinth(String...args){
        listOfRooms = new LinkedHashSet<Room>();
        walkingPath = new ArrayList<Room>();
        for (String arg : args){
            addRooms(arg);
        }
    }

    private void addRooms(String roomsArgs) {
        Parser parser = new SepateRoomsParser();
        Room firstRoom = new Room(parser.parse(roomsArgs, DOOR_SEPARATOR_INDEX)[0]);
        Room secondRoom = new Room(parser.parse(roomsArgs, DOOR_SEPARATOR_INDEX)[2]);
        Door door = new Door(parser.parse(roomsArgs, DOOR_SEPARATOR_INDEX)[1],true);
        addFirstRoom(firstRoom,secondRoom,door);
        addSecondRoom(secondRoom);
    }

    private void addSecondRoom(Room secondRoom) {
        listOfRooms.add(secondRoom);
    }

    private void addFirstRoom(Room firstRoom, Room secondRoom, Door door) {
        listOfRooms.add(firstRoom);
        firstRoom.addNeighbor(secondRoom,door);
    }

    public void getRooms(){
        for (Room room : listOfRooms){
            System.out.println(room);
        }
    }

    public void popIn(String roomName) {
        walkingPath.add(new Room(roomName));
    }
}
