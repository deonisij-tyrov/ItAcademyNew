package lection17Threads;

import lombok.Data;

import java.util.HashMap;
import java.util.Map;


@Data
public class Scientist implements Runnable {
    private Map<RobotComponents, Integer> components;
    private int countRobots = 0;


    public Scientist() {
        components = new HashMap<>();
        components.put(RobotComponents.BODY, 0);
        components.put(RobotComponents.CPU, 0);
        components.put(RobotComponents.HDD, 0);
        components.put(RobotComponents.HEAD, 0);
        components.put(RobotComponents.LEFT_FOOD, 0);
        components.put(RobotComponents.LEFT_HAND, 0);
        components.put(RobotComponents.RAM, 0);
        components.put(RobotComponents.RIGHT_FOOD, 0);
        components.put(RobotComponents.RIGHT_HAND, 0);
    }

    public Map<RobotComponents, Integer> getComponents() {
        synchronized (this) {
            return components;
        }
    }

    @Override
    public void run() {
        while (true) {
            synchronized (components) {
                long countOfComponents = components.entrySet()
                        .stream()
                        .filter(m -> m.getValue() > 0)
                        .count();
                if (countOfComponents >= 9) {
                    for (Map.Entry<RobotComponents, Integer> c : components.entrySet()) {
                        int value = c.getValue();
                        components.put(c.getKey(), --value);
                    }
                    countRobots++;
                }
            }
            try {
                Thread.sleep(200);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + " robots - " + countRobots);
        }
    }
}
