package lection17Threads;

public class Factory implements Runnable {
    Dump dump;
    Assistant assistant1;
    Assistant assistant2;

    public Factory() {
        this.dump = new Dump();
        this.assistant1 = new Assistant(dump);
        this.assistant2 = new Assistant(dump);
    }

    public void throwOutDetails() {
        int countOfDetails = new Double(Math.random() * 4 + 1).intValue();      /*1-4 detail(s) theow*/
        RobotComponents[] robotComponents1s = RobotComponents.values();
        for (int i = 0; i < countOfDetails; i++) {
            Double randomEnum = Math.random() * RobotComponents.values().length;
            dump.getRobotComponents().add(robotComponents1s[randomEnum.intValue()]);
        }
    }

    @Override
    public void run() {
        while (true) {
            throwOutDetails();
        }
    }
}
