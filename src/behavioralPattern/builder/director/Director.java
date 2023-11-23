package behavioralPattern.builder.director;

import behavioralPattern.builder.builders.Builder;
import behavioralPattern.builder.components.Engine;
import behavioralPattern.builder.components.Transmission;
import behavioralPattern.builder.motobikes.MotoType;
import behavioralPattern.builder.motobikes.WheelType;

import java.awt.*;

public class Director {
    public void constructTwoWheelsBike(Builder builder) {
        builder.setMotoType(MotoType.TWO_WHEELS);
        builder.setEngine(new Engine(3.0, 0));
        builder.setTransmission(Transmission.MANUAL);
        builder.setColor(Color.BLACK);
        builder.setWheelType(WheelType.HYBRID);
    }
    public void constructFourWheelsBike(Builder builder) {
        builder.setMotoType(MotoType.FOUR_WHEELS);
        builder.setEngine(new Engine(3.0, 0));
        builder.setTransmission(Transmission.AUTOMATIC);
        builder.setColor(Color.WHITE);
        builder.setWheelType(WheelType.OFFROAD);
    }

}
