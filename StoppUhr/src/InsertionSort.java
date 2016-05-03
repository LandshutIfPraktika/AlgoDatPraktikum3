/**
 * Created by s-gheldd on 5/2/16.
 */
public class InsertionSort extends DoubleGuardSorter implements IntSorter {
    @Override
    public void sort(int[] keysOrig) {
        final int[] keys = super.addGuards(keysOrig);
        final int length = keys.length;
        for (int i = 1; i < length; i++) {
            final int element = keys[i];
            for (int j = i - 1; j >= 0; j--) {
                final int candidate = keys[j];
                if (candidate <= element) {
                    keys[j + 1] = element;
                    break;
                } else {
                    keys[j + 1] = candidate;
                }
            }
        }
        System.arraycopy(removeGuards(keys), 0, keysOrig, 0, keysOrig.length);
    }

}
