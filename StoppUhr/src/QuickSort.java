import java.util.Random;

/**
 * Created by s-gheldd on 5/2/16.
 */
public class QuickSort implements IntSorter {
    private final Random random = new Random();

    @Override
    public void sort(final int[] keys) {
        quickSort(keys, 0, keys.length - 1);
    }

    private void quickSort(final int[] keys, final int low, final int high) {
        if (low < high) {
            final int p = partition(keys, low, high);
            quickSort(keys, low, p - 1);
            quickSort(keys, p + 1, high);
        }
    }

    private int partition(final int[] keys, final int low, final int high) {
        final int pivotPos = random.nextInt(high-low) + low;
        final int pivotValue = keys[pivotPos];
        keys[pivotPos] = keys[high];

        int leftIndex = low - 1;
        int rightIndex = high;

        while (leftIndex < rightIndex) {
            leftIndex++;
            while (leftIndex < rightIndex && keys[leftIndex] < pivotValue) {
                leftIndex++;
            }
            rightIndex--;
            while (leftIndex < rightIndex && keys[rightIndex] > pivotValue) {
                rightIndex--;
            }
            if (leftIndex >= rightIndex) {
                keys[high] = keys[leftIndex];
                keys[leftIndex] = pivotValue;
            } else {
                swap(keys, leftIndex, rightIndex);
            }
        }
        return leftIndex;
    }

    private void swap(final int[] keys, final int a, final int b) {
        final int tmp = keys[a];
        keys[a] = keys[b];
        keys[b] = tmp;
    }

}
