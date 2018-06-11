package lection15Serialization.task3;

import lection15Serialization.task2.Computer;
import lection15Serialization.task2.Monitor;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Notebook extends Computer {
    private Touchpad touchpad;

    public Notebook(Monitor monitor, Touchpad touchpad) {
        super(monitor);
        this.touchpad = touchpad;
    }

    @Override
    public String toString() {
        return "Notebook{" +
                "touchpad=" + touchpad +
                "Monitor=" + super.getMonitor() +
                '}';
    }
}
