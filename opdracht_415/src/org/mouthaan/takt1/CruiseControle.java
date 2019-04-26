package org.mouthaan.takt1;

public class CruiseControle {
    public static void main(String[] args) {
        Auto auto = new Auto();

        auto.setGewensteSnelheid(100);

        while (auto.getActueleSnelheid() > auto.getGewensteSnelheid()) {
            auto.verlaagActueleSnelheid(1);
        }
    }
}
