import java.time.LocalDateTime;
import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        var input = scanner.nextLine();
        System.out.println(LocalDateTime.parse(input).plusHours(11).toLocalDate());
    }
}