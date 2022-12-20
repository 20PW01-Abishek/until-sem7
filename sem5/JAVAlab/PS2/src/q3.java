<<<<<<< HEAD
import java.util.Locale;
import java.util.Scanner;

public class q3 {

    public static boolean isPalindrome(String str)
    {
        String rev = "";
        for (int i = str.length() - 1; i >= 0; i--) {
            rev = rev + str.charAt(i);
        }
        str=str.toLowerCase();
        rev=rev.toLowerCase();
        if (str.equals(rev)) {
            return true;
        }
        return false;
    }
    public static void main(String[] args) {
        //Program to print smallest and biggest possible palindrome word in a given string
        Scanner scr = new Scanner(System.in);
        String s = scr.next();
        String max = "";
        if(s.length()==1) {
            max = s;
        }
        else {
            for(int i=0; i<s.length()+1; i++) {
                for (int j = i; j < s.length()+1; j++) {
                    String str = s.substring(i, j);
                    if (isPalindrome(str) && str.length() >= max.length())
                        max = str;
                }
            }
        }
        System.out.println("The longest palindrome is: "+max+"\nThe smallest palindrome is: "+s.charAt(0));
=======
import java.util.Arrays;
import java.util.Scanner;

public class q3 {
    static int secondMax(int [] a) {
        Arrays.stream(a).sorted();
        return a[a.length-2];
    }
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int [] arr = new int [n];
        for (int i=0; i<n; i++){
            arr[i] = scan.nextInt();
        }
        System.out.println("The second largest element is: "+secondMax(arr));
>>>>>>> 3012fa224642d23e97a5c68343ae7868c07dbd53
    }
}
