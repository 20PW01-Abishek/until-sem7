import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class User {
    private String userName, mobileNumber;

    public User() {
    }

    public User(String userName, String mobileNumber) {
        this.userName = userName;
        this.mobileNumber = mobileNumber;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getMobileNumber() {
        return mobileNumber;
    }

    public void setMobileNumber(String mobileNumber) {
        this.mobileNumber = mobileNumber;
    }
}

class UserBO extends Thread {
    public List <User> userList = new ArrayList<User>();
    public static List <String> message = new ArrayList<String>();
    public void run() {
        synchronized (this) {

        }
    }
}

public class q3 {

}
