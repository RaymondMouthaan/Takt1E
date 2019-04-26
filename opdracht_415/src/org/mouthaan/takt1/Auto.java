package org.mouthaan.takt1;

public class Auto {
    private int actueleSnelheid = 130;

    private int gewensteSnelheid = 0;

    public void verlaagActueleSnelheid(int value) {
        this.actueleSnelheid = this.actueleSnelheid - value;
        System.out.println("De actuele snelheid is: " + this.actueleSnelheid);
    }

    // getters & setters
    public int getActueleSnelheid() {
        return actueleSnelheid;
    }

    public void setActueleSnelheid(int actueleSnelheid) {
        this.actueleSnelheid = actueleSnelheid;
    }

    public int getGewensteSnelheid() {
        return gewensteSnelheid;
    }

    public void setGewensteSnelheid(int gewensteSnelheid) {
        this.gewensteSnelheid = gewensteSnelheid;
    }
}
