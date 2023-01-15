package com.techelevator;

public class BoulderProblem implements Climbable{
    private String name;
    private String grade;
    private String location;
    public final String STYLE="bouldering";

    //constructor
    public BoulderProblem(String name){
        this.name=name;
    }
    public BoulderProblem(String name, String grade) {
        this.name = name;
        this.grade = grade;
    }
    public BoulderProblem(String name, String grade, String location) {
        this.name = name;
        this.grade = grade;
        this.location = location;
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
}
