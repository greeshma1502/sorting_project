//package sortassignment;

import java.util.Scanner;

public class QuickSort implements Sort {

    public static void main(String[] args) {
        int a[] = new int[8];
        int low = 0;
        int high = a.length - 1;
        QuickSort q = new QuickSort();
        Scanner in = new Scanner(System.in);

        System.out.println("Enter the numbers");

        for (int i = 0; i < a.length; i++) {
            a[i] = in.nextInt();

        }
        in.close();

        q.sort(a);

    }


    @Override
    public void sort(int[] input) {
        int low = 0;
        int high = input.length - 1;
        quickSort(input, low, high);
       // printArray(input);
   }




    public void quickSort(int[] b, int low, int high) {
        if (b == null || b.length == 0)
            return;

        if (low >= high)
            return;


        int middle = low + (high - low) / 2;
        int pivot = b[middle];


        int i = low, j = high;
        while (i <= j) {
            while (b[i] < pivot) {
                i++;
            }

            while (b[j] > pivot) {
                j--;
            }

            if (i <= j) {
                int temp = b[i];
                b[i] = b[j];
                b[j] = temp;
                i++;
                j--;
            }
        }


        if (low < j)
            quickSort(b, low, j);

        if (high > i)
            quickSort(b, i, high);

    }

    @Override
    public String sortName() {
        return this.getClass().getName();
    }

    public static void printArray(int b[]) {
        System.out.println("-------- Quick Sort ------------\n");
        for (int i = 0; i < b.length; i++) {
            System.out.println(b[i]);
        }
    }
}




















































