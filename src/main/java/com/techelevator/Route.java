package com.techelevator;

public abstract class Route implements Climbable{
    //instance variables
    private String name;
    private String grade;
    private String location;
    private int height;

    //constructor
    public Route(String name){
        this.name=name;
    }
    public Route(String name, String grade){
        this.grade=grade;
        this.name=name;
    }
    public Route(String name, String grade, String location){
        this.name=name;
        this.grade=grade;
        this.location=location;
    }

    //getters
    @Override
    public String getName() {
        return name;
    }
    @Override
    public String getGrade() {
        return grade;
    }
    @Override
    public String getLocation() {
        return location;
    }
    public int getHeight() {
        return height;
    }

    //setters
    public void setName(String name) {
        this.name = name;
    }
    public void setGrade(String grade) {
        this.grade = grade;
    }
    public void setLocation(String location) {
        this.location = location;
    }
    public void setHeight(int height) {
        this.height = height;
    }

    @Override
    public String toString() {
        String info=name;
        if(grade!=null){
            info+=", "+grade;
        }
        if(location!=null){
            info+=" at " + location;
        }
        return info;
    }
}
