import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.*;

class FunctionUtils {

    public static Supplier<Integer> getInfiniteRange() {
        var count = new AtomicInteger();
        return count::getAndIncrement;
    }

}