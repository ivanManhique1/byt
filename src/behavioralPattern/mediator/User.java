package behavioralPattern.mediator;

public class User {
    private Mediator mediator;
    private String name;

    public User( String name) {
        this.name = name;
    }

    public void setMediator(Mediator mediator) {
        this.mediator = mediator;
    }

    public String getName() {
        return name;
    }

    public void bookHotel(){
        mediator.bookHotel(this);
    }

}
