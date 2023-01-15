package com.techelevator;

public class TradRoute extends Route{
    //instance variables
    private String protectionNeeded;
    private String anchorType;
    public final String STYLE="trad climbing";

    //constructor
    public TradRoute(String name) {
        super(name);
    }
    public TradRoute(String name, String grade) {
        super(name, grade);
    }
    public TradRoute(String name, String grade, String location) {
        super(name, grade, location);
    }

    //getters
    public String getProtectionNeeded() {
        return protectionNeeded;
    }
    public String getAnchorType() {
        return anchorType;
    }

    //setters
    public void setProtectionNeeded(String protectionNeeded) {
        this.protectionNeeded = protectionNeeded;
    }
    public void setAnchorType(String anchorType) {
        this.anchorType = anchorType;
    }
}
