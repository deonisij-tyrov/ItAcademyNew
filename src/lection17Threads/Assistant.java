package lection17Threads;

public class Assistant extends Scientist implements Runnable {
    Dump dump;

    public Assistant(Dump dump) {
        this.dump = dump;
    }

    @Override
    public void run() {
        while (true) {
            dump.getRobotComponents()
                    .stream()
                    .forEach(component -> super.getComponents().put();
        }
    }
}
