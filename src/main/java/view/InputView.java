package view;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

import static java.util.stream.Collectors.toList;

public class InputView {
    private static final String DELIMITER = "";
    private static final Scanner SCANNER = new Scanner(System.in);

    public static List<Integer> inputNumbers() {
        System.out.print("숫자를 입력해 주세요 : ");
        String inputLine = SCANNER.nextLine();
        return Arrays.stream(inputLine.split(DELIMITER))
                .map(Integer::parseInt)
                .collect(toList());
    }

    public static Integer inputContinueFlag() {
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        return Integer.parseInt(SCANNER.nextLine());
    }
}
