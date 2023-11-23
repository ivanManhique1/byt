package behavioralPattern.mediator;

import java.util.HashMap;
import java.util.List;

public class Hotel {
    private HashMap<Integer, String> rooms;
    private Mediator mediator;

    public Hotel() {
        rooms = new HashMap<>();
    }

    public void setMediator(Mediator mediator) {
        this.mediator = mediator;
    }

    public HashMap<Integer, String> getRooms() {
        return rooms;
    }

    public void setRooms(HashMap<Integer, String> rooms) {
        this.rooms = rooms;
    }

    public void retrieveUser(){
        mediator.retrieveUser(this);
    }
}
