package q1;
import java.util.Scanner;

abstract class FundTransfer {
    String accountNumber;
    double balance;
    Boolean validate(double transfer){
        if (this.accountNumber.length()==10 && transfer>0 && transfer<this.balance) {
            return true;
        }
        System.out.println("Account number or transfer amount seems to be wrong");
        return false;
//        throw new IllegalArgumentException("Account number or transfer amount seems to be wrong");
    }
    abstract boolean transfer(double transfer);
    FundTransfer(String accountNumber, double balance){
        this.accountNumber=accountNumber;
        this.balance=balance;
    }
}

class NEFTTransfer extends FundTransfer {
    @Override
    boolean transfer(double transfer) {
        if(transfer+transfer*0.05<this.balance) {
            this.balance -= transfer + transfer * 0.05;
            return true;
        }
        return false;
    }
    NEFTTransfer(String accountNumber, double balance) {
        super(accountNumber,balance);
    }
}

class IMPSTransfer extends FundTransfer {
    @Override
    boolean transfer(double transfer) {
        if(transfer+transfer*0.02<this.balance) {
            this.balance -= transfer + transfer * 0.02;
            return true;
        }
        return false;
    }
    IMPSTransfer(String accountNumber, double balance){
        super(accountNumber,balance);
    }
}

class RTGSTransfer extends FundTransfer {
    @Override
    boolean transfer(double transfer) {
        if(transfer>10000) {
            this.balance -= transfer;
            return true;
        }
        return false;
    }
    RTGSTransfer(String accountNumber, double balance) {
        super(accountNumber,balance);
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner scr = new Scanner(System.in);
        System.out.println("Enter accountNumber: ");
        String accountNumber = scr.next();
        System.out.println("Enter balance: ");
        double balance = scr.nextDouble();
        System.out.println("Enter type of transfer: ");
        System.out.println("1.NEFT");
        System.out.println("2.IMPS");
        System.out.println("3.RTGS");
        int i = scr.nextInt();
        System.out.println("Enter transfer amount: ");
        double transfer = scr.nextInt();
        switch (i) {
            case 1:
                NEFTTransfer obj1 = new NEFTTransfer(accountNumber, balance);
                obj1.transfer(transfer);
                if(obj1.validate(transfer))
                    System.out.println("Balance: "+obj1.balance);
                break;
            case 2:
                IMPSTransfer obj2 = new IMPSTransfer(accountNumber, balance);
                obj2.transfer(transfer);
                if(obj2.validate(transfer))
                    System.out.println("Balance: "+obj2.balance);
                break;
            case 3:
                RTGSTransfer obj3 = new RTGSTransfer(accountNumber, balance);
                obj3.transfer(transfer);
                if(obj3.validate(transfer))
                    System.out.println("Balance: "+obj3.balance);
                break;
            default:
                throw new IllegalArgumentException("Invalid type of transfer chosen!");
        }
    }
}




