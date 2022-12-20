public class Spiral {
    public static void main(String[] args) {
        int arr [] [] = {
                {1,2,3,4,5},
                {6,7,8,9,10},
                {11,12,13,14,15},
                {16,17,18,19,20},
                {21,22,23,24,25}
        };
        int m=arr.length;
        int n=arr[0].length;
        int l=0,r=n-1,t=0,b=m-1;

        while (l<r || t<b) {
            for(int i =l; i<=r; i++)
                System.out.print("\t"+arr[t][i]);
            t++;
            System.out.println();

            for(int i =t; i<=b; i++)
                System.out.print("\t"+arr[i][r]);
            r--;
            System.out.println();

            for(int i =r; i>=l; i--)
                System.out.print("\t"+arr[b][i]);
            b--;
            System.out.println();

            for(int i =b; i>=t; i--)
                System.out.print("\t"+arr[i][l]);
            l++;
            System.out.println();
        }
        System.out.println("\t"+arr[m/2][n/2]);
    }
}
