package lection15Serialization.task3;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.io.Serializable;

@Data
@AllArgsConstructor
public class Touchpad implements Serializable {
    private String model;
}
