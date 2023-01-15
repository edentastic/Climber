package com.techelevator;

import java.util.ArrayList;
import java.util.List;

public class Crag {
    private String name;
    private String location;
    private List<Climbable> climbs= new ArrayList<>();

    //constructor
    public Crag(String name, String location){
        this.name=name;
        this.location = location;
    }

    //getters
    public String getName() {
        return name;
    }
    public String getLocation() {
        return location;
    }
    public List<Climbable> getClimbs() {
        return climbs;
    }
    public int getNumberOfClimbs(){
        return climbs.size();
    }
    public int getNumberOfRoutes(){
        int count=0;
        for(Climbable climb : climbs){
            if( climb instanceof Route){
                count++;
            }
        }
        return count;
    }
    public int getNumberOfBoulderProblems(){
        int count=0;
        for(Climbable climb : climbs){
            if(climb instanceof BoulderProblem){
                count++;
            }
        }
        return count;
    }

    //setters
    public void setName(String name) {
        this.name = name;
    }
    public void setLocation(String location) {
        this.location = location;
    }

    //method
    public void addClimb(Climbable climb){
        climbs.add(climb);
    }

    @Override
    public String toString() {
        return name + " is located at " + location + " and has " + climbs.size() + " established climbs";
    }
}
