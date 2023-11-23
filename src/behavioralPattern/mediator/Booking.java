package behavioralPattern.mediator;

/**
 * My mediator class
 */

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Booking implements Mediator {
    private HashMap<Integer, String> rooms;
    private static int counter = 1;
    private List<User> users = new ArrayList<>();

    @Override
    public void registerHotel(Hotel hotel) {
        hotel.setMediator(this);
        rooms = hotel.getRooms();
    }

    @Override
    public void registerUser(User user) {
        user.setMediator(this);
        users.add(user);
    }

    @Override
    public void bookHotel(User user) {
        rooms.put(counter++, user.getName());
    }

    @Override
    public void retrieveUser(Hotel hotel) {
        System.out.println("Users in the hotel:");
        for (User user : users) {
            System.out.println("User name: " + user.getName());
        }
    }
}
