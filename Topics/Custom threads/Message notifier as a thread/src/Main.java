import java.util.stream.IntStream;

class MessageNotifier extends Thread {

    private final String msg;
    private final int repeats;

    public MessageNotifier(String msg, int repeats) {
        this.msg = msg;
        this.repeats = repeats;
    }

    @Override
    public void run() {
        IntStream.range(0, repeats).forEach(i -> System.out.println(msg));
    }
}
