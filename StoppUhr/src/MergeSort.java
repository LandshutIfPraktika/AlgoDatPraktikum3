/**
 * Created by s-gheldd on 5/3/16.
 */
public class MergeSort implements IntSorter {


    private static void mergeSort(final int[] keys, final int left, final int right) {
        if (left < right) {
            final int middle = left + (right - left) / 2;
            mergeSort(keys, left, middle);
            mergeSort(keys, middle + 1, right);
            merge(keys, left, middle, right);
        }
    }

    private static void merge(final int keys[], final int left, final int middle, final int right) {
        int size_fieldLeft = middle - left + 2;
// one extra field for sentinel
        int size_fieldRight = right - middle + 1; // one extra field for sentinel
        int[] fieldLeft = new int[size_fieldLeft]; // extra memory: not in situ
        int[] fieldRight = new int[size_fieldRight]; // extra memory: not in situ

        System.arraycopy(keys, left, fieldLeft, 0, size_fieldLeft - 1);
        fieldLeft[size_fieldLeft - 1] = Integer.MAX_VALUE;

        System.arraycopy(keys, middle + 1, fieldRight, 0, size_fieldRight - 1);
        fieldRight[size_fieldRight - 1] = Integer.MAX_VALUE;

        int i_left = 0;
        int i_right = 0;
        for (int i = left; i <= right; i++)
            if (fieldLeft[i_left] <= fieldRight[i_right]) {
                keys[i] = fieldLeft[i_left];
                i_left++;
            } else {
                keys[i] = fieldRight[i_right];
                i_right++;
            }
    }

    @Override
    public void sort(int[] keys) {
        mergeSort(keys, 0, keys.length-1);
    }
}

