import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * Created by s-gheldd on 04.05.16.
 */
public class CollectionsSort implements IntSorter {
    @Override
    public void sort(int[] keys) {
        final List<Integer> like = IntStream.of(keys).boxed().collect(Collectors.toList());
        Collections.sort(like);
        System.arraycopy(like.stream().mapToInt(s -> s).toArray(), 0, keys, 0, keys.length);
    }
}
