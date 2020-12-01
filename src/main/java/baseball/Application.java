package baseball;

import java.util.Scanner;
import service.GameService;
import service.InputService;

public class Application {
    public static void main(String[] args) {
        final Scanner scanner = new Scanner(System.in);

        do {
            GameService.start(scanner);
        } while (InputService.resume(scanner));

        return;
    }
}