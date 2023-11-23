package behavioralPattern.builder.motobikes;

import behavioralPattern.builder.components.Engine;
import behavioralPattern.builder.components.Transmission;

import java.awt.*;

public class Motobike {
    private MotoType type;
    private Engine engine;
    private Transmission transmission;
    private Color color;
    private WheelType wheelType;
    private double fuel;

    public Motobike(MotoType type,Engine engine, Transmission transmission, Color color, WheelType wheelType) {
        this.type = type;
        this.engine = engine;
        this.transmission = transmission;
        this.color = color;
        this.wheelType = wheelType;
    }

    public double getFuel() {
        return fuel;
    }

    public void setFuel(double fuel) {
        this.fuel = fuel;
    }

    public MotoType getType() {
        return type;
    }

    public Engine getEngine() {
        return engine;
    }

    public Transmission getTransmission() {
        return transmission;
    }

    public Color getColor() {
        return color;
    }

    public WheelType getWheelType() {
        return wheelType;
    }
}
