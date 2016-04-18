//package sortassignment;

import java.util.Scanner;

public class SelectionSort implements Sort {

    public static void main(String[] args) {
        int a[] = new int[5];
        SelectionSort s = new SelectionSort();
        Scanner in = new Scanner(System.in);

        System.out.println("Enter the numbers");

        for (int i = 0; i < a.length; i++) {
            a[i] = in.nextInt();

        }
        in.close();

        s.sort(a);

    }

    public void sort(int[] b){
        int min=0;
        int temp=0;
        for(int j=0;j<b.length-1;j++)
        {
            min=j;
            for(int i=j+1;i<b.length;i++)
            {
                if(b[min]>b[i])
                {
                    min=i;
                }
            }

            if(b[min]!=b[j])
            {
                temp = b[j];
                b[j] = b[min];
                b[min] = temp;
            }
        }
        //printArray(b);

    }

    @Override
    public String sortName() {
        return this.getClass().getName();
    }

    public static void printArray(int b[]) {
        System.out.println("------ Selection Sort ------------- \n");
        for (int i = 0; i < b.length; i++) {
            System.out.println(b[i]);
        }
    }

}


















