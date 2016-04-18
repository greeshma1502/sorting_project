//package sortassignment;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class SortAnalyser {
    private List<Sort> sortingTechniques ;

    public SortAnalyser() {
        // Initialize sorting techniques to analyse
        sortingTechniques = new ArrayList<Sort>();

        sortingTechniques.add(new BubbleSort());
        sortingTechniques.add(new InsertionSort());
        sortingTechniques.add(new SelectionSort());
        sortingTechniques.add(new MergeSort());
        sortingTechniques.add(new QuickSort());

    }

    public static void main(String[] args) throws IOException {

        if (args != null && args.length > 0) {
            String fileName = args[0];

            // Initialize dataSet Generator
            GenerateDataSets generateDataSets = new GenerateDataSets();
            SortAnalyser sortAnalyser = new SortAnalyser();
            List<Integer> weights = new ArrayList();
            weights.add(100);

            for (Integer integer : weights) {
                for (Sort sort : sortAnalyser.sortingTechniques) {

                    generateDataSets.generateDateSets(GenerateDataSets.DataSetTypes.RANDOM, fileName, integer);

                    File file = new File(fileName);

                    Scanner scanner = null;
                    List<Integer> input = new ArrayList<Integer>();
                    try {
                        scanner = new Scanner(file);
                    } catch (FileNotFoundException e) {
                        e.printStackTrace();
                    }

                    while (scanner.hasNext()) {
                        input.add(Integer.parseInt(scanner.next()));
                    }


                    int[] sortInput = convertIntegers(input);

                    long startTime = System.currentTimeMillis();

                    System.out.println("Weight" + integer + "--- Starting ---- : " + sort.sortName() + "\n");
                    sort.sort(sortInput);

                    long endTime = System.currentTimeMillis();
                    long userMemoryAfterSort = usedMem();

                    printSortingTime(endTime - startTime);
                    printMemoryUsage(userMemoryAfterSort);
                }
            }
        }

    }

    public static int[] convertIntegers(List<Integer> integers)
    {
        int[] ret = new int[integers.size()];
        for (int i=0; i < ret.length; i++)
        {
            ret[i] = integers.get(i).intValue();
        }
        return ret;
    }

    public static void printListOfIntegers(List<Integer> output) {
        for (Integer next: output) {
            System.out.println(next);
        }
    }

    public static long usedMem() {
        return Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory();
    }

    public static void printSortingTime(long timeInMilliSeconds) {
        //System.out.print("--------- Total Time Take : " + String.valueOf(timeInMilliSeconds));
        System.out.print(String.valueOf(timeInMilliSeconds) + "\n");

    }
    public static void printMemoryUsage(long bytes) {
       // System.out.print("---------- Memory Usage  : " + String.valueOf(bytes/1024) + "\n");
        System.out.print(String.valueOf(bytes/1024) + "\n");

    }

}
