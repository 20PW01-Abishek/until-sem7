package q2;

import java.util.Scanner;

abstract class Event{
    protected String name, detail, type, organizer;
    public abstract double calculateAmount();

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getOrganizer() {
        return organizer;
    }

    public void setOrganizer(String organizer) {
        this.organizer = organizer;
    }

    public Event(String name, String detail, String type, String organizer) {
        this.name = name;
        this.detail = detail;
        this.type = type;
        this.organizer = organizer;
    }
}

class Exhibition extends Event{
    private int noOfStalls;
    private double rentPerStall;

    public int getNoOfStalls() {
        return noOfStalls;
    }

    public void setNoOfStalls(int noOfStalls) {
        this.noOfStalls = noOfStalls;
    }

    public double getRentPerStall() {
        return rentPerStall;
    }

    public void setRentPerStall(double rentPerStall) {
        this.rentPerStall = rentPerStall;
    }

    @Override
    public double calculateAmount() {
        return this.rentPerStall*this.noOfStalls;
    }

    public Exhibition(String name, String detail, String type, String organizer, int noOfStalls, double rentPerStall) {
        super(name, detail, type, organizer);
        this.noOfStalls = noOfStalls;
        this.rentPerStall = rentPerStall;
    }
}

class StageEvent extends Event{
    private int noOfShows;
    private double costPerShow;

    public int getNoOfShows() {
        return noOfShows;
    }

    public void setNoOfShows(int noOfShows) {
        this.noOfShows = noOfShows;
    }

    public double getCostPerShow() {
        return costPerShow;
    }

    public void setCostPerShow(double costPerShow) {
        this.costPerShow = costPerShow;
    }

    @Override
    public double calculateAmount() {
        return this.noOfShows*this.costPerShow;
    }

    public StageEvent(String name, String detail, String type, String organizer, int noOfShows, double costPerShow) {
        super(name, detail, type, organizer);
        this.noOfShows = noOfShows;
        this.costPerShow = costPerShow;
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner scr = new Scanner(System.in);
        int choice = 1;
        String [] s;
        String name, detail, type, organizer;
        while (choice!=0) {
            System.out.println("Enter your choice: ");
            System.out.println("1.Exhibition\n" + "2.StageEvent");
            choice = scr.nextInt();
            scr.nextLine();
            if (choice == 1) {
                System.out.println("Input format for Exhibition is in the CSV format:");
                s = scr.nextLine().split(",");
                name = s[0];
                detail = s[1];
                type = s[2];
                organizer = s[3];
                int noOfStalls = Integer.parseInt(s[4]);
                double rentPerStall = Double.parseDouble(s[5]);
                Exhibition e1 = new Exhibition(name, detail, type, organizer, noOfStalls, rentPerStall);
                System.out.println("Amount for exhibition: " + e1.calculateAmount());
            } else if (choice == 2) {
                System.out.println("Input format for StageEvent is in the CSV:");
                s = scr.nextLine().split(",");
                name = s[0];
                detail = s[1];
                type = s[2];
                organizer = s[3];
                int noOfShows = Integer.parseInt(s[4]);
                double rentPerShow = Double.parseDouble(s[5]);
                StageEvent e2 = new StageEvent(name, detail, type, organizer, noOfShows, rentPerShow);
                System.out.println("Amount for stage event: " + e2.calculateAmount());
            } if (choice == 0) {
                break;
            }
            else {
                System.out.println("Invalid choice!");
            }
        }
    }
}
