package Dec_2019;

public class QuickSort {

    public static void main(String[] args) {
        int[] arr = {7, 5, 4, 3, 2, 21, 43, 6, 8};
        getSortedArray(arr, 0, arr.length - 1);
        //sort(arr,0,arr.length-1);
        for (int i : arr)
            System.out.print(i+" ");
    }

    private static void getSortedArray(int[] arr, int start, int end) {

        if (start < end) {
            int p = partition(arr, start, end);

            getSortedArray(arr, start, p - 1);
            getSortedArray(arr, p + 1, end);

        }
    }

    private static int partition(int[] arr, int start, int end) {
        int pIndex = start;
        for (int i = start; i < end; i++) {
            if (arr[i] <= arr[end]) {
                int temp = arr[pIndex];
                arr[pIndex] = arr[i];
                arr[i] = temp;
                pIndex++;
            }
        }

        int temp = arr[end];
        arr[end] = arr[pIndex];
        arr[pIndex] = temp;
        return pIndex ;
    }


    static int partition1(int arr[], int low, int high)
    {
        int pivot = arr[high];
        int i = (low-1); // index of smaller element
        for (int j=low; j<high; j++)
        {
            if (arr[j] <= pivot)
            {
                i++;
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }

        // swap arr[i+1] and arr[high] (or pivot)
        int temp = arr[i+1];
        arr[i+1] = arr[high];
        arr[high] = temp;

        return i+1;
    }


    static void sort(int arr[], int low, int high)
    {
        if (low < high)
        {
            /* pi is partitioning index, arr[pi] is
              now at right place */
            int pi = partition1(arr, low, high);
            System.out.println(pi + " partition index");
            // Recursively sort elements before
            // partition and after partition
            sort(arr, low, pi-1);
            sort(arr, pi+1, high);
        }
    }


}
