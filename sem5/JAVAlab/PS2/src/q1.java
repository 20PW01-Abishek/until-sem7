import java.util.Scanner;

public class q1 {
<<<<<<< HEAD
    public static void main(String[] args) {
        //Write a program to search a string for a specified character or substring.
        Scanner scr = new Scanner(System.in);
        String s = scr.next();
        String a = scr.next();
        boolean flag = false;
        for (int i=0; i<s.length()-a.length()+1; i++) {
            if (s.substring(i,i+a.length()).equalsIgnoreCase(a)) {
                flag = true;
                break;
            }
        }
        if(flag==true) {
            System.out.println("The string '"+a+"' is present.");
        }
        else {
            System.out.println("The string '" + a + "' is not present.");
        }
=======
    static int linearSearch(int [] a, int x) {
        for (int i=0; i<a.length; i++) {
            if (a[i]==x)
                return i;
        }
        return -1;
    }
    public static void main(String[] args) {
        int[] a = {23,25,86,77,9,54,13,36,61,98};
        Scanner scan = new Scanner(System.in);
        int x = scan.nextInt();
        System.out.println("The index of "+x+"in arr a is "+linearSearch(a,x));
>>>>>>> 3012fa224642d23e97a5c68343ae7868c07dbd53
    }
}
