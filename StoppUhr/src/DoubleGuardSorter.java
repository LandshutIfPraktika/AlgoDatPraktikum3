/**
 * Created by s-gheldd on 5/3/16.
 */
public abstract class DoubleGuardSorter extends GuardSorter implements IntSorter {

    public int[] addGuards(final int[] keys) {
        final int[] result = new int[keys.length + 2];
        result[0] = Integer.MIN_VALUE;
        result[result.length - 1] = Integer.MAX_VALUE;
        System.arraycopy(keys, 0, result, 1, keys.length);
        return result;
    }
}
