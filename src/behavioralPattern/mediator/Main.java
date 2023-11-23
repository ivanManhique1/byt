package behavioralPattern.mediator;

import java.util.HashMap;

public class Main {
    public static void main(String[] args) {
        Hotel hotel = new Hotel();

        Booking booking = new Booking();
        booking.registerHotel(hotel);

        User user1 = new User("Ivan");
        User user2 = new User("JUJU");
        User user3 = new User("John");

        booking.registerUser(user1);
        booking.registerUser(user2);
        booking.registerUser(user3);

        user1.bookHotel();
        user2.bookHotel();
        user3.bookHotel();

        hotel.retrieveUser();
    }
}
