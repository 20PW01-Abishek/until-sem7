import java.util.List;
import java.util.Scanner;

class User {
    private String username, mobileNumber;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getMobileNumber() {
        return mobileNumber;
    }

    public void setMobileNumber(String mobileNumber) {
        this.mobileNumber = mobileNumber;
    }

    public User() {
    }

    public User(String username, String mobileNumber) {
        this.username = username;
        this.mobileNumber = mobileNumber;
    }
}

class userBO extends Thread{
    List<User> userList;
    static List<String> message;

    public void run(){
        synchronized (userBO.message) {

        }
    }
}

public class q3 {
    public static void main(String[] args) {
        Scanner scr = new Scanner(System.in);
        System.out.print("Enter no.of users: ");
        int n = scr.nextInt();
        scr.nextLine();
        System.out.print("Enter no.of users per thread: ");
        int k = scr.nextInt();
        for (int i=0; i<=1+n/k; i++) {

        }
    }
}
