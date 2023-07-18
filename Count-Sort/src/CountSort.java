import java.util.Arrays;
import java.util.Scanner;

public class CountSort {

    public static void countSort(int[] arr) {
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > max) {
                max = arr[i];
            }
        }
        int[] count = new int[max+1];
        for (int i = 0; i < arr.length; i++) {
            count[arr[i]]++;
        }
        for (int i = 1; i <= max; i++) {
            count[i] += count[i-1];
        }
        int[] sorted = new int[arr.length];
        for (int i = arr.length-1; i >= 0; i--) {
            sorted[count[arr[i]]-1] = arr[i];
            count[arr[i]]--;
        }
        for (int i = 0; i < arr.length; i++) {
            arr[i] = sorted[i];
        }
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] arr = new int[n];
        for(int i=0;i<n;i++)
            arr[i] = scanner.nextInt();
        countSort(arr);
        System.out.println(Arrays.toString(arr));
    }
}