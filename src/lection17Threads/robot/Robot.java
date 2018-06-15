package lection17Threads.robot;

import lombok.Data;

@Data
public class Robot {
    private Head head;
    private Body body;
    private LeftHand leftHand;
    private RightHand rightHand;
    private LeftFood leftFood;
    private RightFood rightFood;
    private CPU cpu;
    private RAM ram;
    private HDD hdd;

    public boolean isReady() {
        return head != null && body != null && leftHand != null
                && rightHand != null && leftFood != null && rightFood != null
                && cpu != null && ram != null && hdd != null;
    }
}
