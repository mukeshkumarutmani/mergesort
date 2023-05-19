public class MergeSort{
    
    public static void mergeSort(int[] arr) {
        if (arr.length <= 1) {
            return; // Base case: the array is already sorted
        }
        
        int mid = arr.length / 2;
        
        // Create two subarrays: left_half and right_half
        int[] left_half =  int[mid];
        int[] right_half = new int[arr.length - mid];
        
        // Copy elements into the left_half and right_half subarrays
        for (int i = 0; i < mid; i++) {
            left_half[i] = arr[i];
        }
        for (int i = mid; i < arr.length; i++) {
            right_half[i - mid] = arr[i];
        }
        
        // Recursively sort the subarrays
        mergeSort(left_half);
        mergeSort(right_half);
        
        // Merge the sorted subarrays
        merge(arr, left_half, right_half);
    }
    
    private static void merge(int[] arr, int[] left_half, int[] right_half) {
        int i = 0; // Index for left_half
        int j = 0; // Index for right_half
        int k = 0; // Index for the merged array arr
        
        // Compare elements from left_half and right_half, and merge them into arr
        while (i < left_half.length && j < right_half.length) {
            if (left_half[i] <= right_half[j]) {
                arr[k] = left_half[i];
                i++;
            } else {
                arr[k] = right_half[j];
                j++;
            }
            k++;
        }
        
        // Copy any remaining elements from left_half
        while (i < left_half.length) {
            arr[k] = left_half[i];
            i++;
            k++;
        }
        
        // Copy any remaining elements from right_half
        while (j < right_half.length) {
            arr[k] = right_half[j];
            j++;
            k++;
        }
    }
    
    public static void main(String[] args) {
        int[] arr = {7, 3, 9, 2, 6};
        mergeSort(arr);
        
        // Print the sorted array
        for (int num : arr) {
            System.out.print(num + " ");
        }
    }
}
