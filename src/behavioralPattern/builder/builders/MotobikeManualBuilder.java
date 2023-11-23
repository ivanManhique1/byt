package behavioralPattern.builder.builders;

import behavioralPattern.builder.components.Engine;
import behavioralPattern.builder.components.Transmission;
import behavioralPattern.builder.motobikes.Manual;
import behavioralPattern.builder.motobikes.MotoType;
import behavioralPattern.builder.motobikes.WheelType;

import java.awt.*;

public class MotobikeManualBuilder implements Builder {

    private MotoType type;
    private Engine engine;
    private Transmission transmission;
    private Color color;
    private WheelType wheelType;


    @Override
    public void setMotoType(MotoType type) {
        this.type = type;
    }

    @Override
    public void setEngine(Engine engine) {
        this.engine = engine;
    }

    @Override
    public void setTransmission(Transmission transmission) {
        this.transmission = transmission;
    }

    @Override
    public void setWheelType(WheelType wheelType) {
        this.wheelType = wheelType;
    }

    @Override
    public void setColor(Color color) {
        this.color = color;
    }

    public Manual getResult() {
        return new Manual(type, engine, transmission, color, wheelType);
    }
}
