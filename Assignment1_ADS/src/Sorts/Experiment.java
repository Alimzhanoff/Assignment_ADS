package Sorts;

import java.util.Arrays;

public class Experiment {
    private Sorter sorter = new Sorter();
    private Searcher searcher = new Searcher();

    public long measureSortTime(int[] arr, String type) {
        int[] copy = Arrays.copyOf(arr, arr.length);
        long startTime = System.nanoTime();

        if (type.equals("basic")) {
            sorter.basicSort(copy);
        } else {
            sorter.advancedSort(copy);
        }

        return System.nanoTime() - startTime;
    }


    public long measureSearchTime(int[] arr, int target) {
        long startTime = System.nanoTime();
        searcher.search(arr, target);
        return System.nanoTime() - startTime;
    }

    public void runAllExperiments() {

        int[] sizes = {10, 100, 1000};

        for (int size : sizes) {
            System.out.println("--- Experiment with size: " + size + " ---");
            int[] randomArray = sorter.generateRandomArray(size);

            long basicTime = measureSortTime(randomArray, "basic");
            System.out.println("Bubble Sort Time: " + basicTime + " ns");

            long advancedTime = measureSortTime(randomArray, "advanced");
            System.out.println("Quick Sort Time: " + advancedTime + " ns");

            int target = randomArray[size / 2];
            long searchTime = measureSearchTime(randomArray, target);
            System.out.println("Linear Search Time: " + searchTime + " ns\n");
        }
    }
}