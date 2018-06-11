package lection15Serialization.task2;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.io.Serializable;

@Data
@AllArgsConstructor
public class Keyboard implements Serializable {
    private static final long serialVersionUID = 2;
    private String model;
}
