package lection15Serialization.task3;

import lection15Serialization.task2.Computer;
import lection15Serialization.task2.Monitor;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Notebook extends Computer {
    private Touchpad touchpad;
    private transient EthAdapter ethAdapter;

    public Notebook(Monitor monitor, Touchpad touchpad, EthAdapter ethAdapter) {
        super(monitor);
        this.touchpad = touchpad;
        this.ethAdapter = ethAdapter;
    }

    @Override
    public String toString() {
        return "Notebook{" +
                "touchpad=" + touchpad +
                ", ethAdapter=" + ethAdapter +
                " motitor" + super.getMonitor().getModel()
                + '}';
    }
}
