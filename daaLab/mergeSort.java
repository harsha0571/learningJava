import java.util.Scanner;
import java.util.Random;

public class mergeSort {
    static int[] a = new int[20000];

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
        MergeSort(0, n - 1);
        long stopTime = System.currentTimeMillis();
        long elapsedTime = stopTime - startTime;
        System.out.println("Time complexity is " + elapsedTime);
        System.out.println("sorted array is :");
        for (int i = 0; i < n; i++) {
            System.out.print(a[i] + " ");
        }
        input.close();
    }

    public static void MergeSort(int low, int high) {
        int mid;
        if (low < high) {
            mid = (low + high) / 2;
            MergeSort(low, mid);
            MergeSort(mid + 1, high);
            merge(low, mid, high);
        }
    }

    public static void merge(int low, int mid, int high) {
        int i, h, j;
        int[] b = new int[20000];
        h = i = low;
        j = mid + 1;
        while (h <= mid && j <= high)
            if (a[h] < a[j])
                b[i++] = a[h++];
            else
                b[i++] = a[j++];

        if (h > mid)
            for (int k = j; k <= high; k++)
                b[i++] = a[k];
        else
            for (int k = h; k <= mid; k++)
                b[i++] = a[k];

        for (int k = low; k <= high; k++)
            a[k] = b[k];
    }
}
