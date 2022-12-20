import java.util.Scanner;

class Thread1 extends Thread {
    int [] arr;
    int sum = 0;
    double avg;
    Thread1(int [] arr) {
        this.arr = new int[arr.length];
        System.arraycopy(arr, 0, this.arr, 0, arr.length);
    }
    public void run(){
        for (int i : arr) {
            sum += i;
        }
        avg=(double)sum/arr.length;
        System.out.println("Avg: "+avg);
    }
}

class Thread2 extends Thread {
    int [] arr;
    int min = Integer.MAX_VALUE;
    Thread2(int [] arr) {
        this.arr = new int[arr.length];
        System.arraycopy(arr, 0, this.arr, 0, arr.length);
    }
    public void run(){
        for (int i : arr) {
            if (i<min)
                min = i;
        }
        System.out.println("Min: "+min);
    }
}

class Thread3 extends Thread {
    int [] arr;
    int max = Integer.MIN_VALUE;
    Thread3(int [] arr) {
        this.arr = new int[arr.length];
        System.arraycopy(arr, 0, this.arr, 0, arr.length);
    }
    public void run(){
        for (int i : arr) {
            if (i>max)
                max = i;
        }
        System.out.println("Max: "+max);
    }
}

public class q1 {
    public static void main(String[] args) {
        Scanner scr = new Scanner(System.in);
        System.out.print("Enter length of array: ");
        int n = scr.nextInt();
        System.out.println("Enter array elements below");
        int [] arr = new int[n];
        for(int i=0; i<n; i++)
            arr[i]= scr.nextInt();
        Thread1 t1 = new Thread1(arr);
        Thread2 t2 = new Thread2(arr);
        Thread3 t3 = new Thread3(arr);
        t1.start();
        t2.start();
        t3.start();
    }
}
