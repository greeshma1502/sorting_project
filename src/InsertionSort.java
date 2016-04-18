

import java.util.Scanner;

public class InsertionSort implements Sort{

    public static void main(String[] args) {

        int a[] = new int[5];
        InsertionSort q = new InsertionSort();
        Scanner in = new Scanner(System.in);

        System.out.println("Enter the numbers");

        for (int i = 0; i < a.length; i++) {
            a[i] = in.nextInt();

        }
        in.close();
        long startTime = System.currentTimeMillis();
        q.sort(a);
        long stopTime = System.currentTimeMillis();
        long elapsedTime = stopTime - startTime;
        System.out.println("Time taken is:" + elapsedTime);

    }

    @Override
    public void sort(int[] b) {
        for (int j = 1; j < b.length; j++) {
            int i = j - 1;
            int key = b[j];
            while (i >= 0 && b[i] > key) {
                b[i + 1] = b[i];
                i--;

            }
            b[i + 1] = key;
        }
        //printArray(b);

    }

    @Override
    public String sortName() {
        return this.getClass().getName();
    }

    public static void printArray(int b[]) {
        System.out.println("--------- Insertion Sort -------- \n");
        for (int i = 0; i < b.length; i++) {
            System.out.println(b[i]);
        }
    }
}

