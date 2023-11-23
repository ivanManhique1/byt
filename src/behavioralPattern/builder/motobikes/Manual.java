package behavioralPattern.builder.motobikes;

import behavioralPattern.builder.components.Engine;
import behavioralPattern.builder.components.Transmission;

import java.awt.*;

public class Manual{
    private final MotoType type;
    private final Engine engine;
    private final Transmission transmission;
    private final Color color;
    private final WheelType wheelType;

    public Manual(MotoType type, Engine engine, Transmission transmission, Color color, WheelType wheelType) {
        this.type = type;
        this.engine = engine;
        this.transmission = transmission;
        this.color = color;
        this.wheelType = wheelType;
    }

    public String print() {
        String info = "";
        info += "Type of motobike: " +type + "\n";
        info += "Engine: volume - " + engine.getVolume() + "; mileage - " + engine.getMileage() + "\n";
        info += "Transmission: " + transmission + "\n";
        info+=  "Color: " + color + "\n";
        info+=  "Type of Wheel: " + wheelType;
        return info;
    }

}
