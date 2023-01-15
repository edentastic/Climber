package com.techelevator;

public class SportRoute extends Route{
    //instance variables
    private int numberOfBolts;
    public final String STYLE="sport climbing";

    //constructor
    public SportRoute(String name) {
        super(name);
    }
    public SportRoute(String name, String grade) {
        super(name, grade);
    }
    public SportRoute(String name, String grade, String location) {
        super(name, grade, location);
    }

    //getter
    public int getNumberOfBolts() {
        return numberOfBolts;
    }

    //setter
    public void setNumberOfBolts(int numberOfBolts) {
        this.numberOfBolts = numberOfBolts;
    }
}
