import java.util.stream.LongStream;
import java.util.stream.Stream;

/**
 * Created by s-gheldd on 5/2/16.
 */
public class Main {

    private final static int[] problemSizes = new int[]{100000, 1000000};
    private final static IntSorter[] algorithms = new IntSorter[]{new InsertionSort(), new QuickSort(), new MergeSort(), new JavaSort()};
    private final static ArrayCreator[] problems = new ArrayCreator[]{new ArrayCreator.Random(), new ArrayCreator.DecRange(), new ArrayCreator.IncRange(), new ArrayCreator.Uniform()};


    public static void main(String[] args) {

        for (final int n : problemSizes) {
            final long[][] measurements = new long[algorithms.length][];
            for (int i = 0; i < algorithms.length; i++) {
                final IntSorter sorter = algorithms[i];
                final long[] measurement = new long[problems.length];
                // warm up
                for (int j = 0; j < problems.length; j++) {
                    sorter.sort(problems[j].make(n));
                    final int[] array = problems[j].make(n);
                    final long start = System.currentTimeMillis();
                    sorter.sort(array);
                    final long stop = System.currentTimeMillis();
                    measurement[j] = stop - start;
                }
                measurements[i] = measurement;
            }
            final long max = Stream.of(measurements).flatMapToLong(s -> LongStream.of(s)).max().getAsLong();
            final int maxSize = String.format("%d", max).length();
            final StringBuilder builder = new StringBuilder();
            builder.append("Problem size: ").append(n).append("\n").append("Problem: \t\t");
            for (int i = 0; i < problems.length; i++) {
                builder.append(problems[i].getName()).append("\t");
            }
            builder.append("\n");
            for (int i = 0; i < algorithms.length; i++) {
                builder.append(algorithms[i].getName()).append("\t\t");
                for (int j = 0; j < measurements[i].length; j++) {
                    builder.append(String.format(String.format("%%%dd", maxSize), measurements[i][j])).append("\t");
                }
                builder.append("\n");
            }
            System.out.println(builder.toString());

        }
    }
}
