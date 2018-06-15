package lection17Threads;

import lection17Threads.robot.*;

import java.util.ArrayList;
import java.util.List;

public class Acolyte implements Runnable {
    private List<Robot> robots;
    private List<RobotComponents> robotComponents;
    private Dump dump;

    public Acolyte(Dump dump) {
        this.dump = dump;
    }

    @Override
    public void run() {
        robotComponents = new ArrayList<>();
        while (true) {
            dump.getRobotComponents()
                    .stream()
                    .forEach(component -> robotComponents.add(component));
        }
    }

    public void buildRobot() {
        Robot robot= new Robot();
        while (robot.isReady()) {
            robotComponents
                    .stream()
                    .forEach(component -> switchComponents(robot, component));
        }
        robots.add(robot);
        this.buildRobot();
    }

    private void switchComponents(Robot robot, RobotComponents robotComponent) {
        switch (robotComponent) {
            case CPU:
                if (robot.getCpu() == null) {
                    robot.setCpu(new CPU());
                } else
                    break;
            case BODY:
                if (robot.getBody() == null) {
                    robot.setBody(new Body());
                }
                break;
            case HDD:
                if (robot.getHdd() == null) {
                    robot.setHdd(new HDD());
                }
                break;
            case HEAD:
                if (robot.getHead() == null) {
                    robot.setHead(new Head());
                }
                break;
            case LEFT_FOOD:
                if (robot.getLeftFood() == null) {
                    robot.setLeftFood(new LeftFood());
                }
                break;
            case LEFT_HAND:
                if (robot.getLeftHand() == null) {
                    robot.setLeftHand(new LeftHand());
                }
                break;
            case RAM:
                if (robot.getRam() == null) {
                    robot.setRam(new RAM());
                }
                break;
            case RIGHT_FOOD:
                if (robot.getRightFood() == null) {
                    robot.setRightFood(new RightFood());
                }
                break;
            case RIGHT_HAND:
                if (robot.getRightHand() == null) {
                    robot.setRightHand(new RightHand());
                }
                break;
        }
    }
}
