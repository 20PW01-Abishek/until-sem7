import java.util.Scanner;

public class q6 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int [] arr = new int [n];
        for (int i=0; i<n; i++){
            arr[i] = scan.nextInt();
        }
        int max=arr[0];
        System.out.print(max+" ");
        for (int i=0; i<n; i++){
            if (arr[i]>max) {
                max=arr[i];
                System.out.print(arr[i]+" ");
            }
        }
    }
}
