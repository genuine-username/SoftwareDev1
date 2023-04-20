// Jackson Allaway jackson.allaway@oneidaihla.org
// for CTE software development 1
// instructor Mr Gross

package Week5;

public class BubbleSort {
    public static void main(String[] args) {
        // Create an array of unsorted ints and then sort them
        int[] numbers = {1, 3, 98, 2, 64};
        int[] sorted = bubbleSortInts(numbers);

        // Print the unsorted array
        System.out.println("\nThe original array:");
        for (int i : numbers) {
            System.out.println(i);
        }

        // Print the sorted array
        System.out.println("\nThe same array sorted:");
        for (int i : sorted) {
            System.out.println(i);
        }
        

    }

    /**
     * Sorts an array of integers from smallest to largest using a bubble sort.
     * @param array an array of ints to sort.
     * @return the sorted array.
     */
    private static int[] bubbleSortInts(int[] array) {
        // Copy the array being sorted
        int[] toSort = array.clone();

        boolean shouldContinue = true;

        // Shuffle elements until the array is sorted
        while (shouldContinue) {
            // The while loop should end if no elements were swapped as it is now sorted
            shouldContinue = false;

            // Loop through the array and check if each pair of items needs to be shuffled
            for (int i = 0; i < toSort.length - 1; i++) {
                if (toSort[i + 1] < toSort[i]) {
                    // If they do, swap them and make sure that the array is reiterated over
                    swapElements(toSort, i, i + 1);
                    shouldContinue = true;
                }
            }
        }

        return toSort;
    }

    private static void swapElements(int[] toSort, int x, int y) {
        int temp = toSort[y];
        toSort[y] = toSort[x];
        toSort[x] = temp;
    }
}