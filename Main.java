
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        // input- num of students in each row
        int n = sc.nextInt();
        int[] row = new int[n]; 
        int[] row2 = new int[n]; 
        // number of problems solved by each student in first row
        for (int i = 0; i < n; i++) {
            row[i] = sc.nextInt();
        }
        // number of problems solved by each student in the second row
        for (int i = 0; i < n; i++) {
            row2[i] = sc.nextInt();
        }
        // arrays to store target
        int[] arr = new int[n];
        int[] arr2 = new int[n];
        // init first index row 0,  row 1
        arr[0] = row[0];
        arr2[0] = row2[0];
        // fill - bottom up tabulation 
        for (int i = 1; i < n; i++) {
            // max problems solved - from row 1
            arr[i] = Math.max(arr[i - 1], arr2[i - 1] + row[i]);
            arr2[i] = Math.max(arr2[i - 1], arr[i - 1] + row2[i]); // from row 2
        }
        // max of the last elements idx
        int maxtotal = Math.max(arr[n - 1], arr2[n - 1]);
        System.out.println(maxtotal);
        sc.close();
    }
}
