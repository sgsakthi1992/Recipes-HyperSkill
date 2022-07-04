import java.time.LocalTime;
import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        var input = scanner.nextLine();
        System.out.println(LocalTime.parse(input).withSecond(0));
    }
}