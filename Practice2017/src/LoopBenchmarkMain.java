import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;


public class LoopBenchmarkMain {
    final int size = 100000;
    List<Integer> integers = null;

    public static void main(String[] args) {
        LoopBenchmarkMain benchmark = new LoopBenchmarkMain();
        benchmark.setup();

        System.out.println("iteratorMaxInteger max is: " + benchmark.iteratorMaxInteger());
        System.out.println("forEachLoopMaxInteger max is: " + benchmark.forEachLoopMaxInteger());
        System.out.println("forEachLambdaMaxInteger max is: " + benchmark.forEachLambdaMaxInteger());
        System.out.println("forMaxInteger max is: " + benchmark.forMaxInteger());
        System.out.println("forMax2Integer max is: " + benchmark.forMax2Integer());
        System.out.println("parallelStreamMaxInteger max is: " + benchmark.parallelStreamMaxInteger());
        System.out.println("streamMaxInteger max is: " + benchmark.streamMaxInteger());
        System.out.println("lambdaMaxInteger max is: " + benchmark.lambdaMaxInteger());
    }


    public void setup() {
        integers = new ArrayList<Integer>(size);
        populate(integers);
    }

    public void populate(List<Integer> list) {
        Random random = new Random();
        for (int i = 0; i < size; i++) {
            list.add(Integer.valueOf(random.nextInt(1000000)));
        }
    }

    public int iteratorMaxInteger() {
        int max = Integer.MIN_VALUE;
        for (Iterator<Integer> it = integers.iterator(); it.hasNext(); ) {
            max = Integer.max(max, it.next().intValue());
        }
        return max;
    }

    public int forEachLoopMaxInteger() {
        int max = Integer.MIN_VALUE;
        for (Integer n : integers) {
            max = Integer.max(max, n.intValue());
        }
        return max;
    }


    public int forEachLambdaMaxInteger() {
        final Wrapper wrapper = new Wrapper();
        wrapper.inner = Integer.MIN_VALUE;

        integers.forEach(i -> wrapper.inner = Integer.max(i.intValue(), wrapper.inner));
        return wrapper.inner;
    }

    public static class Wrapper {
        public int inner;
    }


    public int forMaxInteger() {
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < size; i++) {
            max = Integer.max(max, integers.get(i).intValue());
        }
        return max;
    }


    public int forMax2Integer() {
        int max = Integer.MIN_VALUE;
        List<Integer> integersLocal = integers;
        for (int i = 0; i < size; i++) {
            max = Integer.max(max, integersLocal.get(i).intValue());
        }
        return max;
    }


    public int parallelStreamMaxInteger() {
        return integers.parallelStream().mapToInt(Integer::intValue).reduce(Integer.MIN_VALUE, Integer::max);
    }


    public int streamMaxInteger() {
        return integers.stream().mapToInt(Integer::intValue).reduce(Integer.MIN_VALUE, Integer::max);
    }


    public int lambdaMaxInteger() {
        return integers.stream().mapToInt(Integer::intValue).reduce(Integer.MIN_VALUE, (a, b) -> Integer.max(a, b));
    }
}