package lection15Serialization.task2;

import lombok.Data;

import java.io.Serializable;

@Data
public class Mouse implements Serializable {
    String model;

}
