package lection17Threads;

import lombok.Data;

import java.util.List;

@Data
public class Dump{
    private static final int START_VALUE_OF_COMPONENT = 20;
    List<RobotComponents> robotComponents;

    public Dump() {
        RobotComponents[] robotComponents1s = RobotComponents.values();
        for(int i = 0; i < START_VALUE_OF_COMPONENT; i++) {
            Double randomEnum = Math.random() * RobotComponents.values().length;
            robotComponents.add(robotComponents1s[randomEnum.intValue()]);
        }
    }

}
