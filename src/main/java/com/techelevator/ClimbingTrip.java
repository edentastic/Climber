package com.techelevator;

import javax.xml.stream.Location;
import java.util.ArrayList;
import java.util.List;

public class ClimbingTrip {
    private String location;
    private boolean isCapacityLimit=false;
    private int maxCapacity=-1;
    private List<Climber> climbersGoing= new ArrayList<>();
    private List<String> daysGone= new ArrayList<>();
    private String kindOfTrip;

    //constructors
    public ClimbingTrip(String location, String kindOfTrip){
        this.location=location;
        this.kindOfTrip=kindOfTrip;
    } //by default there's no limit on how many people can go on a trip
    public ClimbingTrip(String location, String kindOfTrip, boolean isCapacityLimit, int maxCapacity){
        this.location=location;
        this.kindOfTrip=kindOfTrip;
        this.isCapacityLimit=isCapacityLimit;
        this.maxCapacity=maxCapacity;
    } //specify on construction if it's an exclusive trip

    //getters
    public String getLocation() {
        return location;
    }
    public boolean isCapacityLimit() {
        return isCapacityLimit;
    }
    public int getMaxCapacity() {
        return maxCapacity;
    }
    public List<Climber> getClimbersGoing(){
        return climbersGoing;
    }
    public List<String> getDaysGone() {
        return daysGone;
    }
    public String getKindOfTrip() {
        return kindOfTrip;
    }

    //setters
    public void setLocation(String location) {
        this.location = location;
    }
    public void setCapacityLimit(boolean capacityLimit) {
        isCapacityLimit = capacityLimit;
    }
    public void setDaysGone(List<String> daysGone) {
        this.daysGone = daysGone;
    }
    public void setKindOfTrip(String kindOfTrip) {
        this.kindOfTrip = kindOfTrip;
    }
    public void setMaxCapacity(int maxCapacity) {
        if(maxCapacity>0){
            isCapacityLimit=true;
        }
        this.maxCapacity = maxCapacity;
    }

    //methods
    public void addClimber(Climber climber){
        climbersGoing.add(climber);
    } //adds climber to the trip
    public void addClimber(List<Climber> climbers){
        for(Climber climber : climbers){
            climbersGoing.add(climber);
        }
    } // adds a list of climbers reduntant- remove
    public void addDayToTrip(String day){
        daysGone.add(day);
    } // adds a day gone to the trip
    public boolean canClimberCome(Climber climber){
        if(daysGone.size()>0){
            for(String day: daysGone){
                if(!climber.isAvailable(day)){
                    return false;
                }
            }
        }
        return true;
    } // checks if a climbers availability fits the trip
    public boolean climberWantsToCome(Climber climber){
        return (climber.isInterested(kindOfTrip) && !climber.isInjured());
    } // checks if climbers interest fits the kind of trip
    public List<Climber> whichClimbersCome(List<Climber> climbers){
        List<Climber> climbersComing = new ArrayList<>();
        for(Climber climber : climbers){
            if(canClimberCome(climber) && climberWantsToCome(climber)){
                climbersComing.add(climber);
            }
        }
        return climbersComing;
    } //given a list of climbers,m, returns a list of who is both available and interested
}
