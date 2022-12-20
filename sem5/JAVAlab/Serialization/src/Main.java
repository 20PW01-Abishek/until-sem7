import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

class User {
    private String name;
    private String email;
    private String username;
    private String password;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public User() {
    }

    public User(String name, String email, String username, String password) {
        this.name = name;
        this.email = email;
        this.username = username;
        this.password = password;
    }

    @Override
    public String toString() {
        return name+" "+email+" "+username+" "+password;
    }
}

class UserBO {
    public List<User> readFromFile(BufferedReader br) throws IOException {
        List <User> userList = new ArrayList<>();
        String s = br.readLine();
        while (s != null) {
            String[] user_details = s.split(",");
            User obj = new User();
            obj.setName(user_details[0]);
            obj.setEmail(user_details[1]);
            obj.setUsername(user_details[2]);
            obj.setPassword(user_details[3]);
            userList.add(obj);
            s=br.readLine();
        }
        return userList;
    }

    public void display(List <User> list) {
        for (User i : list){
            System.out.println(i.toString());
        }
    }
}

public class Main {
    public static void main(String[] args) {
        try {
            File fl = new File("employee.csv");
            BufferedReader br = new BufferedReader(new FileReader(fl));
            UserBO obj = new UserBO();
            List<User> userList = obj.readFromFile(br);
            if (userList.size() == 0) {
                System.out.println("The list is empty!");
            } else {
                obj.display(userList);
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}