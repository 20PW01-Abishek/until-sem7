package q3;

import java.util.Objects;
import java.util.Scanner;

class ContactDetail {
    String mobile, alternateMobile, landLine, email, address;

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getAlternateMobile() {
        return alternateMobile;
    }

    public void setAlternateMobile(String alternateMobile) {
        this.alternateMobile = alternateMobile;
    }

    public String getLandLine() {
        return landLine;
    }

    public void setLandLine(String landLine) {
        this.landLine = landLine;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public ContactDetail(String mobile, String alternateMobile, String landLine, String email, String address) {
        this.mobile = mobile;
        this.alternateMobile = alternateMobile;
        this.landLine = landLine;
        this.email = email;
        this.address = address;
    }

    public ContactDetail(){}

    @Override
    public String toString() {
        return "Mobile: "+this.mobile+
        "\nAlternate mobile: "+this.alternateMobile+
        "\nLandLine: "+this.landLine+
        "\nEmail: "+this.email+
        "\nAddress: "+this.address;
    }
}

class DuplicateMobileNumberException extends Exception {
    public DuplicateMobileNumberException (String str) {
        super(str);
    }
}

class ContactDetailBO {
    static void validate(String mobile,String alternateMobile) throws Exception{
        if (mobile.equals(alternateMobile))
            throw new DuplicateMobileNumberException("Mobile number and alternate mobile number are same");
    }
}

public class q3 {
    public static void main(String[] args) {
        Scanner scr = new Scanner(System.in);
        while (true) {
            System.out.print("Enter the contact details: ");
            String str = scr.nextLine();
            String [] arrOfStr = str.split(",");

            try {
                ContactDetailBO.validate(arrOfStr[0],arrOfStr[1]);
                ContactDetail obj = new ContactDetail(arrOfStr[0],arrOfStr[1],arrOfStr[2],arrOfStr[3],arrOfStr[4]);
                System.out.println(obj);
                break;
            }
            catch (Exception e) {
                System.err.println(e.getMessage());
            }
        }
    }
}
