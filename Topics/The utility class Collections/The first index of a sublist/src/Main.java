import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        var firstList = Arrays.asList(scanner.nextLine().split(" "));
        var secondList = Arrays.asList(scanner.nextLine().split(" "));
        System.out.print(Collections.indexOfSubList(firstList, secondList));
        System.out.print(" ");
        System.out.print(Collections.lastIndexOfSubList(firstList, secondList));
    }
}