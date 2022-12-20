package q1;

import java.util.Scanner;
public class q1 {
    static boolean [] Seat = new boolean[100];
    static void bookSeat(int i) throws Exception {
        if (i<1 || i>100) {
            throw new ArrayIndexOutOfBoundsException("Enter index between 1 and 100");
        }
        if (Seat[i - 1]) {
            throw new SeatNotAvailableException("Seat is already booked! Try again");
        }
        else {
            Seat[i-1] = true;
            System.out.println("Your seat is booked!");
        }
    }

    public static void main(String[] args) {
        Scanner scr = new Scanner(System.in);
        System.out.print("Enter the number of seats to be booked: ");
        int n=scr.nextInt();
        for(int i=0; i<n; i++) {
            System.out.println("Enter the seat number "+ (i+1));
            int index= scr.nextInt();
            try {
                bookSeat(index);
            } catch (Exception e) {
                System.err.println(e.getMessage());
                i--;
            }
        }
        System.out.println("The seats booked are:");
        for(int i=0; i<100; i++) {
            if (Seat[i]) {
                System.out.println(i+1);
            }
        }
    }
}