import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

class Stall {
    private String name, detail, type, ownerName;

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

    public String getOwnerName() {
        return ownerName;
    }

    public void setOwnerName(String ownerName) {
        this.ownerName = ownerName;
    }

    public Stall(String name, String detail, String type, String ownerName) {
        this.name = name;
        this.detail = detail;
        this.type = type;
        this.ownerName = ownerName;
    }

    @Override
    public String toString() {
        return name+", "+detail+", "+type+", "+ownerName;
    }
}

public class q2 {
    public static void main(String[] args) {
        Scanner scr = new Scanner(System.in);
        System.out.println("Enter the number of stall details");
        int n = scr.nextInt();
        scr.nextLine();
        List<Stall> stallList = new ArrayList<>();
        for (int i=0; i<n; i++) {
            System.out.println("Enter the stall "+(i+1)+" detail");
            String[] input = scr.nextLine().split(",");
            stallList.add(new Stall(input[0],input[1],input[2],input[3]));
        }
        Iterator<Stall> stallIterator = stallList.listIterator();
        while(stallIterator.hasNext()){
            Stall i = stallIterator.next();
            if(i.getName().startsWith("test")) {
                stallIterator.remove();
            }
        }
        for (Stall i : stallList)
            System.out.println(i);
    }
}
