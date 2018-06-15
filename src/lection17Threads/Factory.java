package lection17Threads;

public class Factory implements Runnable {
    Dump dump;
    Acolyte acolyte1;
    Acolyte acolyte2;

    public Factory() {
        this.dump = new Dump();
        this.acolyte1 = new Acolyte(dump);
        this.acolyte2 = new Acolyte(dump);
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
