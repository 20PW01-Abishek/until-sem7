<<<<<<< HEAD
import java.util.Scanner;

public class q2 {
    public static void main(String[] args) {
        Scanner scr = new Scanner(System.in);
        String s = scr.nextLine().toLowerCase();
        int [] arr = new int[26];
        for(int i=0; i<s.length(); i++) {
            if(s.charAt(i)>='a' && s.charAt(i)<='z')
            arr[(int)s.charAt(i)-97] += 1;
        }
        for(int i=0; i<26; i++) {
            if(arr[i]!=0)
                System.out.println((char)(i+97)+ " - " +arr[i]);
        }
=======
import java.util.Arrays;
import java.util.Scanner;

public class q2 {
    static void rotate(int [] ar, int d, int n) {
        int [] arr = new int [n];
        for (int i=d; i<n+d; i++) {
            arr[i-d]=ar[i%n];
        }
        System.arraycopy(arr, 0, ar, 0, n);
    }
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int [] arr = new int [n];
        for (int i=0; i<n; i++){
            arr[i] = scan.nextInt();
        }
        int d = scan.nextInt();
        rotate(arr,d,n);
        System.out.print(Arrays.toString(arr));
>>>>>>> 3012fa224642d23e97a5c68343ae7868c07dbd53
    }
}
