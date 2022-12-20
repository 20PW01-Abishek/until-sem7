import java.util.Scanner;

public class q7 {
    static String linearSearch(int [][] a, int x) {
        for (int i=0; i<a.length; i++) {
            for (int j=0; j<a[0].length; j++) {
                if (a[i][j] == x)
                    return "YES";
            }
        }
        return "NO";
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int [][] arr = new int [n][];
        for (int i=0; i<n; i++){
            int x = scan.nextInt();
            arr[i] = new int [x];
            for (int j=0; i<x; i++)
                arr[i][j] = scan.nextInt();
        }
        int x = scan.nextInt();
        System.out.println(linearSearch(arr,x));
    }
}
