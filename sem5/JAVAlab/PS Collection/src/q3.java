import java.util.*;

class Hall implements Comparable<Hall>{
    private String name, contactNumber, ownerName;
    private Double costPerDay;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getContactNumber() {
        return contactNumber;
    }

    public void setContactNumber(String contactNumber) {
        this.contactNumber = contactNumber;
    }

    public String getOwnerName() {
        return ownerName;
    }

    public void setOwnerName(String ownerName) {
        this.ownerName = ownerName;
    }

    public Double getCostPerDay() {
        return costPerDay;
    }

    public void setCostPerDay(Double costPerDay) {
        this.costPerDay = costPerDay;
    }

    public Hall(String name, String contactNumber, Double costPerDay, String ownerName) {
        this.name = name;
        this.contactNumber = contactNumber;
        this.ownerName = ownerName;
        this.costPerDay = costPerDay;
    }

    @Override
    public String toString() {
        return name+" "+contactNumber+" "+costPerDay+" "+ownerName;
    }

    public int compareTo(Hall h) {
        if (getCostPerDay() == null || h.getCostPerDay() == null) {
            return 0;
        }
        return getCostPerDay().compareTo(h.getCostPerDay());
    }
}

public class q3 {
    public static void main(String[] args) {
        Scanner scr = new Scanner(System.in);
        System.out.println("Enter the number of halls");
        int n = scr.nextInt();
        scr.nextLine();
        List<Hall> hallList = new ArrayList<>();
        for (int i=0; i<n; i++) {
            System.out.println("Enter the details of hall "+(i+1));
            String[] input = scr.nextLine().split(",");
            hallList.add(new Hall(input[0],input[1],Double.parseDouble(input[2]),input[3]));
        }
        System.out.println("Sorted Order (from the least expensive to the most):");
        System.out.println("Name Contact number Cost per day Owner name");
        Collections.sort(hallList);
        for (Hall i : hallList)
            System.out.println(i);
    }
}
