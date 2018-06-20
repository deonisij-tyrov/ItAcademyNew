package lection17Threads;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class Dump {
    private static final int START_VALUE_OF_COMPONENTS = 20;
    private final List<RobotComponents> robotComponents;

    public Dump() {
        robotComponents = new ArrayList<>();

        for (int i = 0; i < START_VALUE_OF_COMPONENTS; i++) {
            double randomEnum = Math.random() * RobotComponents.values().length;
            robotComponents.add(RobotComponents.values()[(int) randomEnum]);
        }
        System.out.println(robotComponents.toString());
    }

    public List<RobotComponents> getRobotComponents() {
        return robotComponents;
    }


}
