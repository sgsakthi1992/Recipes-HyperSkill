// do not remove imports

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.function.Function;
import java.util.stream.IntStream;

class ArrayUtils {
    public static <T> T[] invert(T[] a) {
        Collections.reverse(Arrays.asList(a));
        return a;
    }
}