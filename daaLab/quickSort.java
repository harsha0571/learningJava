import java.util.Scanner;
import java.util.Random;

public class quickSort {

    static int[] a = new int[2000000];

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        Random r = new Random();
        System.out.println("enter no of elements");
        int n = input.nextInt();
        System.out.println("unsorted array is :");
        for (int i = 0; i < n; i++) {
            a[i] = r.nextInt(10000);
            System.out.print(a[i] + " ");
        }
        long startTime = System.currentTimeMillis();
        QuickSort(0, n);
        long stopTime = System.currentTimeMillis();
        long elapsedTime = stopTime - startTime;
        System.out.println("Time complexity is " + elapsedTime);
        System.out.println("sorted array is :");
        for (int i = 0; i < n; i++) {
            System.out.print(a[i] + " ");
        }
        input.close();
    }

    public static void QuickSort(int low, int high) {
        int mid;
        if (low < high) {
            mid = partition(low, high);
            QuickSort(low, mid - 1);
            QuickSort(mid + 1, high);
        }
    }

    public static int partition(int low, int high) {
        int pivot = a[high];
        int i = low - 1;
        for (int j = low; j < high; j++) {

            if (a[j] <= pivot) {
                i++;
                int temp = a[j];
                a[j] = a[i];
                a[i] = temp;
            }
        }
        int temp = a[i + 1];
        a[i + 1] = a[high];
        a[high] = temp;
        return i + 1;
    }
}
