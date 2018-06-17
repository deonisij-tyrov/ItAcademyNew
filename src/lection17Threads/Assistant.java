package lection17Threads;

import java.util.HashMap;
import java.util.Map;

public class Assistant implements Runnable {
    private Dump dump;
    private Scientist scientist;
//    Map<RobotComponents, Integer> components;
    private int countRobots = 0;

    public Assistant(Dump dump, Scientist scientist) {
        this.dump = dump;
        this.scientist = scientist;
//        components = new HashMap<>();
//        components.put(RobotComponents.BODY,0);
//        components.put(RobotComponents.CPU,0);
//        components.put(RobotComponents.HDD,0);
//        components.put(RobotComponents.HEAD,0);
//        components.put(RobotComponents.LEFT_FOOD,0);
//        components.put(RobotComponents.LEFT_HAND,0);
//        components.put(RobotComponents.RAM,0);
//        components.put(RobotComponents.RIGHT_FOOD,0);
//        components.put(RobotComponents.RIGHT_HAND,0);

    }

    @Override
    public void run() {
        while (true) {
            synchronized (dump) {
                if (dump.getRobotComponents().size() > 0) {
                    RobotComponents robotComponent = dump.getRobotComponents().remove(0);
                    System.out.println(Thread.currentThread().getName() + " get component " + robotComponent);
                    int value = 0;
                    if (scientist.getComponents().get(robotComponent) != null) {
                        value = scientist.getComponents().get(robotComponent).intValue();
                    }
                    scientist.getComponents().put(robotComponent, ++value);
                }
            }

        }
    }
}
