import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        var scanner = new Scanner(System.in);
        var list = Arrays.asList(scanner.nextLine().split(" "));
        var numberOfSwaps = scanner.nextInt();
        for (int i = 0; i < numberOfSwaps; i++) {
            var from = scanner.nextInt();
            var to = scanner.nextInt();
            Collections.swap(list, from, to);
        }
        System.out.println(String.join(" ", list));
    }
}