import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

import com.sqli.nespresso.labyrinth.exception.ClosedDoorException;
import com.sqli.nespresso.labyrinth.exception.IllegalMoveException;

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
        firstRoom.addNeighbor(secondRoom,door);
        listOfRooms.add(firstRoom);
    }

    public Room getRoomsFromList(String roomToFindName){
        for (Room room : listOfRooms){
            if(room.getRoomName().equals(roomToFindName)) return room;
        }
        return null;
    }

    public void popIn(String roomName) {
        walkingPath.add(new Room(roomName));
    }

    public void walkTo(String roomName) throws IllegalMoveException, ClosedDoorException {
        Room currentRoom = new Room(roomName);
        if(!listOfRooms.contains(currentRoom)) throw new IllegalMoveException();
        else {
            Room previousRoom = walkingPath.get(walkingPath.size()-1);
            System.out.println(previousRoom.getRoomName());
            if(previousRoom.hasForNeighbor(currentRoom)){
                Door door = previousRoom.getDoorSeparatingNextRoom(currentRoom);
                if(door.doorIsOpen()){
                    walkingPath.add(currentRoom);
                }else {
                    throw new ClosedDoorException();
                }
            }else{
                throw new IllegalMoveException();
            }
        }
    }


}
