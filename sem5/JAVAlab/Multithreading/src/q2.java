import java.util.Arrays;
import java.util.Scanner;

class moreThreads extends Thread {
    String s;

    public moreThreads(String s) {
        this.s = s;
    }

    @Override
    public void run() {
        int [] counter = new int[256];
        Arrays.fill(counter,0);
        for (int i=0; i<s.length(); i++) {
            counter[s.charAt(i)]++;
        }
        for (int i=0; i<counter.length; i++) {
            if (counter[i]!=0)
                System.out.println((char)i+" : "+counter[i]);
        }
    }
}

public class Q {
    public static void main(String[] args) throws InterruptedException {
        Scanner scr = new Scanner(System.in);
        System.out.print("Enter Number of Counters : ");
        int n = scr.nextInt();
        scr.nextLine();
        moreThreads[] arrayOfThreads = new moreThreads[n];
        String [] arrayOfStrings = new String[n];
        for (int i=0; i<n; i++) {
            System.out.println("Enter text for counter "+(i+1)+": ");
            arrayOfStrings[i]=scr.nextLine();
        }
        for(int i=0; i<n; i++) {;
            arrayOfThreads[i] = (new moreThreads(arrayOfStrings[i]));
            System.out.println("Counter "+(i+1)+" Result :");
            arrayOfThreads[i].start();
            arrayOfThreads[i].join();
        }
    }
}

