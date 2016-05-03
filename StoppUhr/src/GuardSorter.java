/**
 * Created by s-gheldd on 5/3/16.
 */
public abstract class GuardSorter{

    abstract public int[] addGuards(final int[] keys);

    public int[] removeGuards(final int[] keys) {
        final boolean first = keys[0] == Integer.MIN_VALUE;
        final boolean last = keys[keys.length - 1] == Integer.MAX_VALUE;
        final int[] result;

        if (first && last) {
            result = new int[keys.length - 2];
            System.arraycopy(keys, 1, result, 0, keys.length - 2);
        } else if (first) {
            result = new int[keys.length - 1];
            System.arraycopy(keys, 1, result, 0, keys.length - 1);
        } else if (last) {
            result = new int[keys.length - 1];
            System.arraycopy(keys, 0, result, 0, keys.length - 1);
        } else {
            result = keys;
        }
        return result;
    }
}
