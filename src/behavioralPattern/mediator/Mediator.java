package behavioralPattern.mediator;

public interface Mediator {
    void registerHotel(Hotel hotel);

    void registerUser(User user);

    void bookHotel(User user);
    void retrieveUser(Hotel hotel);
}
