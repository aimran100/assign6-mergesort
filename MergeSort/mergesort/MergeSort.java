package mergesort;

public class MergeSort {

    public static void main(String[] args) {
        int[] array1 = {11,43,87,27,54,8,32,71,44,12};

        showArray(array1);
        mergeSort(array1);
        showArray(array1);
    }

    public static void showArray(int[] theArray) {
        int index;

        System.out.printf("[");
        for(index = 0; index < theArray.length; index++) {
            if(index != 0) {
                System.out.printf(", ");
            }
            System.out.printf("%d", theArray[index]);
        }
        System.out.printf("]\n");
    }

    private static void mergeSort(int[] theArray, int left, int right) {
        // Base case: stop when the section has one or zero elements
        if(left >= right) {
            return;
        }

        // 1. Divide the array section into two halves
        int middle = left + (right - left) / 2;

        // 2. Recursively sort each half
        mergeSort(theArray, left, middle);
        mergeSort(theArray, middle + 1, right);

        // 3. Create temporary arrays for the two halves
        int leftSize = middle - left + 1;
        int rightSize = right - middle;

        int[] leftArray = new int[leftSize];
        int[] rightArray = new int[rightSize];

        for(int i = 0; i < leftSize; i++) {
            leftArray[i] = theArray[left + i];
        }

        for(int j = 0; j < rightSize; j++) {
            rightArray[j] = theArray[middle + 1 + j];
        }

        // 4. Merge the two sorted subarrays
        int i = 0;
        int j = 0;
        int k = left;

        while(i < leftSize && j < rightSize) {
            if(leftArray[i] <= rightArray[j]) {
                theArray[k] = leftArray[i];
                i++;
            } else {
                theArray[k] = rightArray[j];
                j++;
            }
            k++;
        }

        // Copy any remaining elements from the left subarray
        while(i < leftSize) {
            theArray[k] = leftArray[i];
            i++;
            k++;
        }

        // Copy any remaining elements from the right subarray
        while(j < rightSize) {
            theArray[k] = rightArray[j];
            j++;
            k++;
        }
    }

    public static void mergeSort(int[] array) {
        // Wrapper for the recursive mergeSort
        mergeSort(array, 0, array.length - 1);
    }
}