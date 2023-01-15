package com.techelevator;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class ClimberSandbox {
    //instance variables to keep track
    private List<Climber> climbers= new ArrayList<>();
    private List<ClimbingTrip> trips = new ArrayList<>();
    private Scanner input = new Scanner(System.in);

    public static void main(String[] args) {
        ClimberSandbox app=  new ClimberSandbox();
        app.run();
    }

    private void run(){
        createClimbers();
        createTrip();
        createRoutes();

        Climber mike=climbers.get(0);
        Climber lauren=climbers.get(1);
        Climber joel = climbers.get(2);
        System.out.println("Lauren and joel had their availability set during creation");

        setAllAvailability(mike);
        System.out.println();

        System.out.println();
        System.out.println("\nNow display Mike's availability");
        input.nextLine();//pause for effect
        printFullAvailability(mike);

        System.out.println();
        System.out.println("Here are Mike's interests:");
        input.nextLine(); //pause for effect
        printInterests(mike);

        System.out.println();
        System.out.println("Here are Mike and Lauren's availabilities compared:");
        input.nextLine(); //pause for effect
        printComparedAvailability(mike, lauren);

        System.out.println();
        System.out.println("Compare Joel and Mike");
        input.nextLine(); //pause for effect
        printComparedAvailability(joel, mike);

        System.out.println();
        System.out.println("What if Joel gets injured?");
        input.nextLine(); //pause for effect
        joel.injur();
        printComparedAvailability(joel, mike);

        System.out.println();
        System.out.println("And he recovers");
        input.nextLine(); //pause for effect
        joel.recover();
        printComparedAvailability(joel, mike);

        System.out.println();
        System.out.println("I can also compare the interests of two climbers: ");
        input.nextLine(); //pause for effect
        printCompareInterests(lauren, mike);

        System.out.println();
        System.out.println("I created a trip to the NRG, i can pass my list of climbers in and see who can go: ");
        input.nextLine();
        ClimbingTrip nrg = trips.get(0);
        List<Climber> climbersComingToTheNew = nrg.whichClimbersCome(climbers);
        System.out.println("These are the climbers who are available and interested in a trip \nto the New River Gorge: ");
        for(Climber climber : climbersComingToTheNew){
            System.out.println(climber.getName());
        }

    }

    private void createClimbers(){

        Climber mike = new Climber("Mike");
        Climber lauren= new Climber("Lauren");
        Climber joel = new Climber("Joel");

        //mike availaibility- remove for demo

//        mike.setAvailability("sunday",true);
//        mike.setAvailability("tuesday",true);
//        mike.setAvailability("wednesday", true);
//        mike.setAvailability("friday", true);
//        mike.setAvailability("saturday", true);


        //setting lauren's avilability
        lauren.setAvailability("sunday",true);
        lauren.setAvailability("tuesday",true);
        lauren.setAvailability("friday", true);
        lauren.setAvailability("saturday", true);

        //setting joel's availability
        joel.setAvailability("monday", true);
        joel.setAvailability("wednesday", true);
        joel.setAvailability("friday", true);


        climbers.add(mike);
        climbers.add(lauren);
        climbers.add(joel);
    }

    private void createTrip(){
        ClimbingTrip nrg = new ClimbingTrip("New River Gorge", "sport climbing");
        nrg.addDayToTrip("sunday");
        nrg.addDayToTrip("saturday");
        nrg.addDayToTrip("friday");
        trips.add(nrg);
    }

    private void createRoutes() {
        SportRoute flight = new SportRoute("Flight of the Gumby", "5.9+", "Butcher's Branch");
        SportRoute springer = new SportRoute("Springer","5.10B", "Butcher's Branch");
        BoulderProblem mechanical = new BoulderProblem("Mechanical Sensei", "V7");
        Crag butcher = new Crag("Butcher's Branch", "New River Gorge");
        butcher.addClimb(flight);
        butcher.addClimb(springer);
        butcher.addClimb(mechanical);

//        System.out.println(butcher);


    }

    public void printFullAvailability(Climber climber) {
        if (climber.getAvailability().size() == 0) {
            System.out.println(climber.getName() + " has not set up their availability yet.");
        }else if(climber.isInjured()){
            System.out.println(climber.getName() + " is injured and can't climb.");
        } else {
            for (String day : climber.DAYS_OF_THE_WEEK) {
                System.out.println(climber.getName() + " is " + (climber.getAvailability().get(day) ? "available on " : "not available on ") + day);
            }
        }
    }

    public void printInterests(Climber climber) {
        for (Map.Entry<String, Boolean> item : climber.getInterests().entrySet()) {
            System.out.println(climber.getName() + (item.getValue() ? " likes " : " doesn't like ") + item.getKey() + ".");
        }
    }

    public void printComparedAvailability(Climber climber, Climber otherClimber) {
        List<String> sharedAvailability = climber.getSharedAvailability(otherClimber);
        System.out.print(climber.getName() + " and " + otherClimber.getName());
        if (sharedAvailability.size() == 0) {
            System.out.println(" have no shared availability. Bummer");
        } else {
            System.out.print(" are both available to climb on ");
            for (int i = 0; i < sharedAvailability.size(); i++) {
                System.out.print(i==0 ? sharedAvailability.get(i) : i<sharedAvailability.size()-1 ? (", " + sharedAvailability.get(i)) : (" and "+ sharedAvailability.get(i)));
            }
            System.out.println(".");
        }
    }

    public void printCompareInterests(Climber climber, Climber otherClimber){
        List<String> sharedInterests = climber.getSharedInterests(otherClimber);
        System.out.print(climber.getName() + " and " +otherClimber.getName());
        if(sharedInterests.size()==0){
            System.out.println(" aren't into the same types of climbing. Bummer.");
        }else{
            for (int i = 0; i < sharedInterests.size(); i++) {
                System.out.print((i==0 ? " are both into " + sharedInterests.get(i) : (i==sharedInterests.size()-1 ? " and " +sharedInterests.get(i) : ", " + sharedInterests.get(i))));
            }
            System.out.println(".");
        }
    }

    public void setUpAvailability(Climber climber) {
        Scanner input = new Scanner(System.in);
        boolean done = false;
        boolean firstGo = true;
        String day = "";
        while (!done) {
            boolean isDay = false;
            while (!isDay) {
                System.out.println("What day would you like to set " +climber.getName() + "'s availability for?");
                day = input.nextLine();
                if (climber.getAvailability().containsKey(day.toLowerCase())) {
                    isDay = true;
                } else {
                    System.out.println("Hey, that's not a day. Try again");
                    continue;
                }
            }
            System.out.println("Is " + climber.getName() + " available on this day? y/n");
            String availableString = input.nextLine();
            if (availableString.equals("y")) {
                climber.setAvailability(day, true);
            } else if (availableString.equals("n")) {
                climber.setAvailability(day, false);
            }
            System.out.println("Would you like to set the availability for another day? y/n");
            String yOrN = input.nextLine();
            if (yOrN.equals("y")) {
                done = false;
            } else {
                done = true;
            }
        }
    } //uses console to prompt user to set availability

    public void setAllAvailability(Climber climber){
        Scanner input = new Scanner(System.in);
        for(String day: climber.DAYS_OF_THE_WEEK){
            System.out.println("Is "+climber.getName()+" available on "+ day +"?  y/n");
            String yOrNo=input.nextLine();
            if(yOrNo.equals("y")){
                climber.setAvailability(day,true);
            } else{
                climber.setAvailability(day,false);
            }
        }
    } //uses console to loop through every day and set availability

}



