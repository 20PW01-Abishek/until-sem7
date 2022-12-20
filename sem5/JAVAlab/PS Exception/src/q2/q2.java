package q2;

import java.util.Scanner;
import q1.SeatNotAvailableException;

public class q2 {
    static void bookSeat(int i, boolean [][] Seat, int n) throws Exception {
        if (i<1 || i>n*n) {
            throw new ArrayIndexOutOfBoundsException("Enter index between 1 and "+(n*n));
        }
        if (Seat[(i-1)/n][(i-1)%n]) {
            throw new SeatNotAvailableException("Seat is already booked! Try again");
        }
        else {
            Seat[(i-1)/n][(i-1)%n] = true;
            System.out.println("Your seat is booked!");
        }
    }

    public static void main(String[] args) {
        Scanner scr = new Scanner(System.in);
        System.out.print("Enter total no. of rows and columns: ");
        int n = scr.nextInt();
        boolean[][] Seat = new boolean[n][n];
        System.out.print("Enter the number of seats to be booked: ");
        int s = scr.nextInt();
        for (int i = 0; i < s; i++) {
            System.out.println("Enter the seat number " + (i + 1));
            int index = scr.nextInt();
            try {
                bookSeat(index, Seat, n);
            } catch (Exception e) {
                System.err.println(e.getMessage());
                i--;
            }
        }
        System.out.println("The seats booked are:");
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(" " + (Seat[i][j] ? 1 : 0));
            }
            System.out.println();
        }
    }
}