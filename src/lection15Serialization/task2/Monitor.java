package lection15Serialization.task2;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.io.Serializable;

@Data
@AllArgsConstructor
public class Monitor implements Serializable {
    private String model;

}
