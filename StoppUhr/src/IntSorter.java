/**
 * Created by s-gheldd on 5/2/16.
 */

public interface IntSorter {
    void sort(final int[] keys);

    default String getName() {
        return this.getClass().getName().split("\\.")[0];
    }
}
