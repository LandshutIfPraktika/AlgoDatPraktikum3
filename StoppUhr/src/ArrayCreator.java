import java.util.Random;

/**
 * Created by s-gheldd on 5/3/16.
 */
public interface ArrayCreator {

    int[] make(int n);

    default String getName(){
        return this.getClass().getName().split("\\$")[1].split("\\.")[0];
    }

    class Random implements ArrayCreator{
        @Override
        public int[] make(int n) {
            final java.util.Random random = new java.util.Random();
            final int[] result = new int[n];
            for (int i = 0; i < n; i++) {
                result[i] = random.nextInt(n);
            }
            return result;
        }
    }


    class IncRange implements ArrayCreator {

        @Override
        public int[] make(int n) {
            final int[] result = new int[n];
            for (int i = 0; i < n; i++) {
                result[i] = i;
            }
            return result;
        }
    }

    class DecRange implements ArrayCreator {

        @Override
        public int[] make(int n) {
            final int[] result = new int[n];
            for (int i = 0; i < n; i++) {
                result[i] = n - i - 1;
            }
            return result;
        }
    }

    class Uniform implements ArrayCreator {

        @Override
        public int[] make(int n) {
            final int key = new java.util.Random().nextInt(n);
            final int[] result = new int[n];
            for (int i = 0; i < n; i++) {
                result[i] = key;
            }
            return result;
        }
    }
}

