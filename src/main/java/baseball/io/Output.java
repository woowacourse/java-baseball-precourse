package baseball.io;

import java.util.function.Consumer;

public class Output {

    private Output() {}

    public static void println(String line) {
        System.out.println(line);
    }

    public static void print(String line) {
        System.out.print(line);
    }
}
