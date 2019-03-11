import java.util.HashSet;
import java.util.Set;

public class Labyrinth {

    private Set<Room> listOfRooms;

    public Labyrinth(String...args){
        listOfRooms = new HashSet<Room>();
        Parser parser = new SepateRoomsParser();
        for (String arg : args){

        }
    }
}
