/*
 * NAME: Kechen Zhao
 * PID: A16139826
*/
import java.util.ArrayList;

/*
 * Sorts Class
 * Contains all sorting methods
*/
public class Sorts<T extends Comparable<? super T>> {

    private static final int HALF_LIST = 2;
    /*
     * This method performs insertion sort on the input arraylist
     * 
     * @param list The arraylist we want to sort
     * @param start The inital index on subsection of Arraylist we want to sort
     * @param end The final index of the subsection of Arraylist we want to sort
    */
    public void InsertionSort(ArrayList<T> list, int start, int end) {
        T temp;
        // keep swapping elements until all elements
        // are in their correct position
        for (int i = start + 1; i <= end; i++) {
            int j = i;
            while ((j > start) && (list.get(j).compareTo(list.get(j - 1)) < 0)) {
                temp = list.get(j);
                list.set(j, list.get(j - 1));
                list.set(j - 1, temp);
                j--;
            }
        }
    }

    /*
     * This method performs merge sort on the input arraylist
     * 
     * @param list The arraylist we want to sort
     * @param start The inital index on subsection of Arraylist we want to sort
     * @param end The final index of the subsection of Arraylist we want to sort
    */
    public void MergeSort(ArrayList<T> list, int start, int end) {

        if (start < end) {
            int mid = start + (end - start) / HALF_LIST;
            MergeSort(list, start, mid);
            MergeSort(list, mid + 1, end);
            merge(list, start, mid, end);
        }
    }

    /*
     * merge helper function for MergeSort
     * 
     * @param arr The arraylist we want to sort
     * @param l left-most index we want to merge
     * @param m the middle index we want to merge
     * @param r right-most index we want to merge
    */
    private void merge(ArrayList<T> arr, int l, int m, int r) {

        int mergedSize = r - l + 1;

        ArrayList<T> mergedNums = new ArrayList<>();
        int left = l, right = m + 1;
        while (left <= m && right <= r) {
            if (arr.get(left).compareTo(arr.get(right)) <= 0) {
                mergedNums.add(arr.get(left));
                left++;
            } else {
                mergedNums.add(arr.get(right));
                right++;
            }
        }

        while (left <= m) {
            mergedNums.add(arr.get(left));
            left++;
        }
        while (right <= r) {
            mergedNums.add(arr.get(right));
            right++;
        }
        for (int i = 0; i < mergedSize; i++) {
            arr.set(l + i, mergedNums.get(i));
        }
    }

    /*
     * This method performs quick sort on the input arraylist
     * 
     * @param list The arraylist we want to sort
     * @param start The inital index on subsection of Arraylist we want to sort
     * @param end The final index of the subsection of Arraylist we want to sort
    */
    public void QuickSort(ArrayList<T> list, int start, int end) {
        int pivotIndex = 0;
        // base csse
        if (start >= end) {
            return;
        }
        // first partition the list into
        // smaller half and larger half
        // then sort each part
        pivotIndex = partition(list, start, end);
        QuickSort(list, start, pivotIndex);
        QuickSort(list, pivotIndex + 1, end);
    }

    /*
     * partition helper function for QuickSort
     * 
     * @param arr The arraylist we want to sort
     * @param l left-most index we want to merge
     * @param h right-most index we want to merge
    */

    private int partition(ArrayList<T> arr, int l, int h) {
        // select the middle element as pivot
        int middle = l + (h - l) / 2;
        T pivot = arr.get(middle);
        T temp;
        Boolean done = false;
        // compare each element with pivot
        while (!done) {
            while (arr.get(l).compareTo(pivot) < 0) {
                l++;
            }
            while (arr.get(h).compareTo(pivot) > 0) {
                h--;
            }
            if (l >= h) {
                done = true;
            } else {
                temp = arr.get(l);
                arr.set(l, arr.get(h));
                arr.set(h, temp);
                l++;
                h--;
            }
        }
        return h;
    }

    /*
     * This method performs a modified QuickSort that switches to
     * insertion sort after a certina cutoff
     *
     * @param list The arraylist we want to sort
     * @param start The inital index on subsection of Arraylist we want to sort
     * @param end The final index of the subsection of Arraylist we want to sort
     * @param cutoff the minimum length of an subsection of the arraylist
     * such that we switch to Insertion Sort
    */
    public void Modified_QuickSort(ArrayList<T> list, int start, int end, int cutoff) {
        Sorts sorts = new Sorts();
        // if the length of list is smaller than cutoff
        // perform insertion sort
        if (list.size() <= cutoff) {
            sorts.InsertionSort(list, 0, list.size() - 1);
        }
        if (start >= end) {
            return;
        }
        int pivotIndex = 0;
        pivotIndex = partition(list, start, end);
        Modified_QuickSort(list, start, pivotIndex, cutoff);
        Modified_QuickSort(list, pivotIndex + 1, end, cutoff);
    }
    /*
     * This method performs a modified QuickSort that switches to
     * insertion sort after a certina cutoff
     * 
     * @param list The arraylist we want to sort
     * @param start The inital index on subsection of Arraylist we want to sort
     * @param end The final index of the subsection of Arraylist we want to sort
     * @param param The length of the initial splits that are sorted prior to merging
    */
    public void TimSort(ArrayList<T> list, int start, int end, int param) {
        Sorts sorts = new Sorts();
        // if the length of list is smaller than cutoff
        // perform insertion sort
        if (list.size() <= param) {
            sorts.InsertionSort(list, start, end);
        }
        // sort each part using insertion sort
        for (int i = start; i < end; i += param) {
            sorts.InsertionSort(list, i, Math.min(i + param, end));
        }
        // merge each part
        for (int i = start; i < end; i += param) {
            sorts.merge(list, i, Math.min(i + param, end) - 1, Math.min(i + 2 * param, end));
        }
    }
}
