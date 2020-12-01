package baseball;

import java.util.Scanner;
import service.GameService;
import service.InputService;

public class Application {
    public static void main(String[] args) {
        final Scanner scanner = new Scanner(System.in);
        // TODO 구현 진행
        do {
            GameService.start(scanner);
        } while (InputService.resume(scanner));

        return;
    }
}