import java.util.ArrayList;
import java.util.Scanner;

class Assignment {
    String name;
    int month, day, hour, minute;
    double score, totalPoints, totalWeight;
    public Assignment(){}
    public Assignment(String name, int month, int day, int hour, int minute) {
        this.name=name;
        this.month=month;
        this.day=day;
        this.hour=hour;
        this.minute=minute;
    }

    public String getName() {
        return name;
    }

    public int getMonth() {
        return month;
    }

    public int getDay() {
        return day;
    }

    public int getHour() {
        return hour;
    }

    public int getMinute() {
        return minute;
    }

    public double getScore() {
        return score;
    }

    public double getTotalPoints() {
        return totalPoints;
    }

    public double getTotalWeight() {
        return totalWeight;
    }

    public void setScore(double score) {
        this.score = score;
    }

    public void setTotalPoints(double totalPoints) {
        this.totalPoints = totalPoints;
    }

    public void setTotalWeight(double totalWeight) {
        this.totalWeight = totalWeight;
    }

    @Override
    public String toString() {
        return super.toString();
    }
}

class Lab extends Assignment {
    String specification;
    public Lab(){
        super();
    }

    public Lab(String name, int month, int day, int hour, int minute, String specification) {
        super(name, month, day, hour, minute);
        this.specification=specification;
    }

    @Override
    public String toString() {
        return super.toString();
    }
}

class Project extends Assignment {
    String specification, dataFile;

    public Project(String name, int month, int day, int hour, int minute, String specification, String dataFile) {
        super(name, month, day, hour, minute);
        this.specification = specification;
        this.dataFile = dataFile;
    }

    @Override
    public String toString() {
        return super.toString();
    }
}

class AssignmentList {
    ArrayList<Assignment> itemList = new ArrayList<>();
    public AssignmentList(){
        System.out.println("List of assignment created!");
    }
    public void addItem(Assignment item) {
        this.itemList.add(item);
    }
    public double computeCourseGrade() {
        double num=0, den=0;
        for (Assignment assignment : this.itemList) {
            num += ((assignment.getTotalWeight()) * (assignment.getScore()) / (assignment.getTotalPoints()));
            den += assignment.getTotalWeight();
        }
//        int n=this.itemList.size();
//        for (int i=0; i<n; i++) {
//            num+=((this.itemList.get(i).totalWeight)*(this.itemList.get(i).score)/(this.itemList.get(i).totalPoints));
//            den+=this.itemList.get(i).totalWeight;
//        }
        return num/den;
    }

    @Override
    public String toString() {
        return super.toString();
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner scr = new Scanner(System.in);
        AssignmentList course1 = new AssignmentList();

        int n;
        System.out.print("Enter number of Assignments: ");
        n=scr.nextInt();
        scr.nextLine();
        for(int i=0; i<n; i++) {
            System.out.println("\nEnter details for Assignment: "+(int)(i+1));
            boolean isLab = false;
            System.out.print("Is it a Lab assignment?: ");
            isLab = scr.nextBoolean();
            scr.nextLine();
            if(isLab) {
                System.out.println("Creating a lab assignment...!");
                System.out.print("Enter lab assignment name: ");
                String name = scr.nextLine();
                System.out.print("Enter month: ");
                int mon = scr.nextInt();
                System.out.print("Enter day: ");
                int day = scr.nextInt();
                System.out.print("Enter hour: ");
                int hour = scr.nextInt();
                System.out.print("Enter min: ");
                int min = scr.nextInt();
                System.out.print("Enter score: ");
                double score = scr.nextDouble();
                System.out.print("Enter total points: ");
                double totalPoints = scr.nextDouble();
                System.out.print("Enter total weight: ");
                double totalWeight = scr.nextDouble();
                scr.nextLine();
                System.out.println("Enter specifications: ");
                String specs = scr.nextLine();
                Lab ass = new Lab(name,mon,day,hour,min,specs);
                ass.setScore(score);
                ass.setTotalPoints(totalPoints);
                ass.setTotalWeight(totalWeight);
                course1.addItem(ass);
            } else {
                System.out.println("Creating a project assignment...!");
                System.out.print("Enter project assignment name: ");
                String name = scr.nextLine();
                System.out.print("Enter month: ");
                int mon = scr.nextInt();
                System.out.print("Enter day: ");
                int day = scr.nextInt();
                System.out.print("Enter hour: ");
                int hour = scr.nextInt();
                System.out.print("Enter min: ");
                int min = scr.nextInt();
                System.out.print("Enter score: ");
                double score = scr.nextDouble();
                System.out.print("Enter total points: ");
                double totalPoints = scr.nextDouble();
                System.out.print("Enter total weight: ");
                double totalWeight = scr.nextDouble();
                scr.nextLine();
                System.out.println("Enter specifications: ");
                String specs = scr.nextLine();
                System.out.println("Enter dataFile: ");
                String df = scr.nextLine();
                Project ass = new Project(name,mon,day,hour,min,specs,df);
                ass.setScore(score);
                ass.setTotalPoints(totalPoints);
                ass.setTotalWeight(totalWeight);
                course1.addItem(ass);
            }
        }

        int choice=1;
        while (choice!=0) {
            System.out.print("\nEnter your choice: ");
            choice = scr.nextInt();
            switch (choice) {
                case 0:
                    break;
                case 1:
                    System.out.println("Printing assignment list");
                    for (int i = 0; i < n; i++) {
                        System.out.println("\nDetails of Assignment: " + (int) (i + 1));
                        System.out.println("Assignment name: " + course1.itemList.get(i).name);
                        System.out.println("Date as (mon | day): " + course1.itemList.get(i).month + " | " + course1.itemList.get(i).day);
                        System.out.println("Time as (hours | min): " + course1.itemList.get(i).hour + " | " + course1.itemList.get(i).minute);
                        System.out.println("Score: " + course1.itemList.get(i).score);
                        System.out.println("Total Points: " + course1.itemList.get(i).totalPoints);
                        System.out.println("Total Weight: " + course1.itemList.get(i).totalWeight);
                    }
                    double CourseGrade = course1.computeCourseGrade();
                    System.out.println("\nCourse grade: " + CourseGrade);
                    break;
                case 2:
                    System.out.println("Printing Lab assignment list");
                    for (int i = 0; i < n; i++) {
                        if (course1.itemList.get(i) instanceof Lab) {
                            System.out.println("Lab assignment!");
                            System.out.println("\nDetails of Assignment: " + (int) (i + 1));
                            System.out.println("Assignment name: " + course1.itemList.get(i).name);
                            System.out.println("Date as (mon | day): " + course1.itemList.get(i).month + " | " + course1.itemList.get(i).day);
                            System.out.println("Time as (hours | min): " + course1.itemList.get(i).hour + " | " + course1.itemList.get(i).minute);
                            System.out.println("Score: " + course1.itemList.get(i).score);
                            System.out.println("Total Points: " + course1.itemList.get(i).totalPoints);
                            System.out.println("Total Weight: " + course1.itemList.get(i).totalWeight);
                        } else if (course1.itemList.get(i) instanceof Project) {
                            System.out.println("Project assignment!");
                            System.out.println("\nDetails of Assignment: " + (int) (i + 1));
                            System.out.println("Assignment name: " + course1.itemList.get(i).name);
                            System.out.println("Date as (mon | day): " + course1.itemList.get(i).month + " | " + course1.itemList.get(i).day);
                            System.out.println("Time as (hours | min): " + course1.itemList.get(i).hour + " | " + course1.itemList.get(i).minute);
                            System.out.println("Score: " + course1.itemList.get(i).score);
                            System.out.println("Total Points: " + course1.itemList.get(i).totalPoints);
                            System.out.println("Total Weight: " + course1.itemList.get(i).totalWeight);
                        }
                    }
                    break;
                case 3:
                    System.out.print("Enter Day: ");
                    int x = scr.nextInt();
                    for (int i = 0; i < n; i++) {
                        if (course1.itemList.get(i).day==x) {
                            System.out.println("\nDetails of Assignment: " + (int) (i + 1));
                            System.out.println("Assignment name: " + course1.itemList.get(i).name);
                            System.out.println("Date as (mon | day): " + course1.itemList.get(i).month + " | " + course1.itemList.get(i).day);
                            System.out.println("Time as (hours | min): " + course1.itemList.get(i).hour + " | " + course1.itemList.get(i).minute);
                            System.out.println("Score: " + course1.itemList.get(i).score);
                            System.out.println("Total Points: " + course1.itemList.get(i).totalPoints);
                            System.out.println("Total Weight: " + course1.itemList.get(i).totalWeight);
                        }
                    }
                    scr.nextLine();
                    break;
                case 4:
                    System.out.print("Enter total point threshold: ");
                    double t = scr.nextDouble();
                    for (int i = 0; i < n; i++) {
                        if (course1.itemList.get(i).totalPoints>t) {
                            System.out.println("\nDetails of Assignment: " + (int) (i + 1));
                            System.out.println("Assignment name: " + course1.itemList.get(i).name);
                            System.out.println("Date as (mon | day): " + course1.itemList.get(i).month + " | " + course1.itemList.get(i).day);
                            System.out.println("Time as (hours | min): " + course1.itemList.get(i).hour + " | " + course1.itemList.get(i).minute);
                            System.out.println("Score: " + course1.itemList.get(i).score);
                            System.out.println("Total Points: " + course1.itemList.get(i).totalPoints);
                            System.out.println("Total Weight: " + course1.itemList.get(i).totalWeight);
                        }
                    }
                    break;
                default:
                    System.out.println("Invalid choice!");
            }
        }

//        Assignment ass1 = new Assignment("Strings",4,23,5,45);
//        ass1.setScore(5);
//        ass1.setTotalPoints(4);
//        ass1.setTotalWeight(10);
//
//        Assignment ass2 = new Assignment("Arrays",6,27,8,47);
//        ass2.setScore(8);
//        ass2.setTotalPoints(9);
//        ass2.setTotalWeight(10);
//
//        Assignment ass3 = new Assignment("Inheritance",7,27,14,12);
//        ass2.setScore(8);
//        ass2.setTotalPoints(10);
//        ass2.setTotalWeight(15);

    }
}