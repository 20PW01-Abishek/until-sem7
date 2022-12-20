package q9;
import java.util.Scanner;

public class q9 {
    public static void main(String[] args) {
        Scanner scr = new Scanner(System.in);
        int n = scr.nextInt();
        int m = scr.nextInt();
        int[][] a = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                a[i][j] = scr.nextInt();
            }
        }
        int top = 0, left = 0, right = m, bottom = n;
        while (top > bottom || right > left) {
            for (int i = left; i <= right; i++) {
                System.out.print(a[top][i]);
            }
            top++;
            for (int i = top; i <= bottom; i++) {
                System.out.print(a[i][right]);
            }
            right--;
            for (int i = right; i >= left; i--) {
                System.out.print(a[bottom][i]);
            }
            bottom--;
            for (int i = bottom; i >= top; i--) {
                System.out.print(a[i][left]);
            }
            left++;
        }
    }
}