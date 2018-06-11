package lection15Serialization.task2;

import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.io.Serializable;

@Data
@RequiredArgsConstructor
public class Computer implements Serializable {
    Keyboard keyboard;
    Monitor monitor;
    Mouse mouse;


}
