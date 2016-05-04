import java.util.stream.IntStream;

/**
 * Created by s-gheldd on 04.05.16.
 */
public class StreamSort implements IntSorter {
    @Override
    public void sort(int[] keys) {
        System.arraycopy(IntStream.of(keys).sorted().toArray(), 0, keys, 0, keys.length);
    }
}
