import java.util.Arrays;
import java.util.Scanner;
import java.util.function.Function;
import java.util.stream.Collectors;

class Main {

    public static final String REGEX = " ";

    public static void main(String[] args) {
        var scanner = new Scanner(System.in);
        var newspaperWords = scanner.nextLine();
        var note = scanner.nextLine();
        var busted = false;

        var newspaperWordsMap = Arrays.stream(newspaperWords.split(REGEX))
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));

        for (String word : note.split(" ")) {
            if (!newspaperWordsMap.containsKey(word) || newspaperWordsMap.get(word) < 1) {
                busted = true;
                break;
            }
            newspaperWordsMap.put(word, newspaperWordsMap.get(word) - 1);
        }

        if (busted) {
            System.out.println("You are busted");
        } else {
            System.out.println("You get money");
        }
    }
}