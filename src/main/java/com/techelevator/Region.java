package com.techelevator;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Region {
    //instance variables
    private String name;
    private String city;
    private String state;
    private List<Crag> crags = new ArrayList<>();

    //constructor
    public Region(String name){
        this.name=name;
    }
    public Region(String name, String city, String state) {
        this.name = name;
        this.city = city;
        this.state = state;
    }

    //getters
    public String getName() {
        return name;
    }
    public String getCity() {
        return city;
    }
    public String getState() {
        return state;
    }
    public List<Crag> getCrags() {
        return crags;
    }

    //setters
    public void setName(String name) {
        this.name = name;
    }
    public void setCity(String city) {
        this.city = city;
    }
    public void setState(String state) {
        this.state = state;
    }

    //methods
    public void addCrag(Crag crag){
        crags.add(crag);
    }
}
