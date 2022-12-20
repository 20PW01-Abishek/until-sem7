 import java.util.Scanner;

public class Hosoya {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n= scan.nextInt(); //9
        int [] [] a = new int [n][];
        for(int i=0; i<n;i++) {
            a[i] = new int [i+1];
            int m=a[i].length; //i+1
            for(int j=0; j<m; j++) {
                if((i==0 && j==0) || (i==1 && j==0) || (i==1 && j==1) || (i==2 && j==1))
                    a[i][j]=1;
                else if (i==j)
                    a[i][j] = a[i-1][j-1] + a[i-2][j-2];
                else if(i<j)
                    a[i][j]= a[i-1][j] + a[i-2][j];
            }
        }
        for(int i=0; i<n; i++) {
            for (int j=0; j<=i; j++) {
                System.out.print("\t"+a[i][j]);
            }
            System.out.println();
        }
    }
}
