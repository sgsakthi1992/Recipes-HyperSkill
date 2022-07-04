import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;
import java.util.stream.Collectors;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        var list = Arrays.stream(scanner.nextLine().split(" ")).collect(Collectors.toList());
        var c = scanner.nextLine();
        System.out.println(Collections.frequency(list, c));
    }
}