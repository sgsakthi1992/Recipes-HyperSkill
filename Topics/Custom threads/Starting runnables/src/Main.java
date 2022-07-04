import java.util.Arrays;
import java.util.stream.IntStream;

class Starter {

    public static void startRunnables(Runnable[] runnables) {
        Arrays.stream(runnables).forEach(i -> new Thread(i).start());
    }
}