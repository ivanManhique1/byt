package behavioralPattern.builder;

import behavioralPattern.builder.builders.MotobikeBuilder;
import behavioralPattern.builder.builders.MotobikeManualBuilder;
import behavioralPattern.builder.director.Director;
import behavioralPattern.builder.motobikes.Manual;
import behavioralPattern.builder.motobikes.Motobike;

public class Main {
    public static void main(String[] args) {
        Director director = new Director();

        MotobikeBuilder builder = new MotobikeBuilder();
        director.constructFourWheelsBike(builder);

        Motobike motobike = builder.getResult();
        System.out.println("moto built:\n" + motobike.getType());


        MotobikeManualBuilder manualBuilder = new MotobikeManualBuilder();

        director.constructFourWheelsBike(manualBuilder);
        Manual motoManual = manualBuilder.getResult();
        System.out.println("\nMoto manual built:\n" + motoManual.print());
    }

}
