package com.techelevator;

import java.util.*;

public class Climber {
    //instance variables
    private String name;
    private Map<String, Boolean> availability = new HashMap<>();
    private Map<String, Boolean> interests = new HashMap<>();
    private boolean isInjured = false;

    public final String[] DAYS_OF_THE_WEEK = new String[]{"sunday", "monday", "tuesday", "wednesday", "thursday", "friday", "saturday"};

    //constructors, and defaults for the maps
    public Climber(String name) {
        this.name = name;
        this.setAvailabilityDefault();
        this.setInterestsDefault();
    } //base constructor requires name
    public void setAvailabilityDefault() {
        availability.put("monday", false);
        availability.put("tuesday", false);
        availability.put("wednesday", false);
        availability.put("thursday", false);
        availability.put("friday", false);
        availability.put("saturday", false);
        availability.put("sunday", false);

    } //sets a default with no availability
    public void setInterestsDefault() {
        interests.put("bouldering", true);
        //interests.put("lead climbing", true);
        interests.put("top roping", true);
        interests.put("sport climbing", true);
        interests.put("trad climbing", false);
        //interests.put("alpine climbing", false);
        //interests.put("ice climbing", false);
    } //sets default interests

    //various getters
    public String getName() {
        return name;
    }
    public boolean isInjured(){
        return isInjured;
    }
    public Map<String, Boolean> getAvailability(){
        return availability;
    }
    public Map<String, Boolean> getInterests(){
        return interests;
    }

    //setters
    public void setAvailability(String day, boolean available) {
        if(day!=null){
            day=day.toLowerCase();
        }
        availability.put(day, available);
    } //set availability for a day to a given value

    //methods
    public void injur(){
        isInjured=true;
    }
    public boolean changeInterest(String climbing) { //returns false if interests doesn't contain that climbing
        if (interests.containsKey(climbing)) {
            interests.put(climbing, !interests.get(climbing));
            return true;
        } else {
            return false;
        }
    } //switches an interest to the opposite
    public void recover(){
        isInjured=false;
    }
    public boolean isAvailable(String day) {
        if(isInjured){
            return false;
        } else {
            return availability.get(day.toLowerCase());
        }
    } //true if free on a given day
    public List<String> getDaysAvailable(){
        List<String> daysAvailable = new ArrayList<>();
        if(isInjured){
            return daysAvailable;
        } else {
            for (String day : DAYS_OF_THE_WEEK) {
                if (availability.get(day)) {
                    daysAvailable.add(day);
                }
            }
        }
        return daysAvailable;
    }//returns a list of days that the climber is available to climb
    public boolean isInterested(String climbing) {
        if (!interests.containsKey(climbing)) {
            return false;
        } else {
            return interests.get(climbing);
        }
    } //true if interested in a given style of climbing
    public List<String> getSharedAvailability(Climber otherClimber){
        List<String> sharedAvailability = new ArrayList<>();
        for (String day: DAYS_OF_THE_WEEK) {
            if (this.isAvailable(day) && otherClimber.isAvailable(day)) {
                sharedAvailability.add(day);
            }
        }
        return sharedAvailability;
    }
    public List<String> getSharedInterests(Climber otherClimber){
        List<String> sharedInterests = new ArrayList<>();
        for(Map.Entry<String,Boolean> thisClimber : interests.entrySet()){
            String climbing=thisClimber.getKey();
            if(thisClimber.getValue() && otherClimber.isInterested(climbing)){
                sharedInterests.add(climbing);
            }
        }
        return sharedInterests;
    }
}

/**
 * Legacy Methods:
 *
 public Climber(String name, boolean setAvailability){
    this.name=name;
    if(setAvailability){
        setAllAvailability();
    } else{
        setAvailabilityDefault();
    }
 } //overloaded constructor that allows user to enter availability on creation


 */
