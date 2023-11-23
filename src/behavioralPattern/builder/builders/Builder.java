package behavioralPattern.builder.builders;

import behavioralPattern.builder.components.Engine;
import behavioralPattern.builder.motobikes.MotoType;
import behavioralPattern.builder.components.Transmission;
import behavioralPattern.builder.motobikes.WheelType;

import java.awt.*;

public interface Builder {
    void setMotoType(MotoType type);
    void setEngine(Engine engine);
    void setTransmission(Transmission transmission);
    void setWheelType(WheelType wheelType);
    void setColor(Color color);
}
