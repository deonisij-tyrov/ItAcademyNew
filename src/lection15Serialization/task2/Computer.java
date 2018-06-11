package lection15Serialization.task2;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@RequiredArgsConstructor
public class Computer implements Serializable {
    private static final long serialVersionUID = 1;
    private Keyboard keyboard;
    private transient Monitor monitor;
    private Mouse mouse;

    public Computer(Monitor monitor) {
        this.monitor = monitor;
    }
}
