package baseball.view;

import camp.nextstep.edu.missionutils.Console;

import java.util.Scanner;

import static java.lang.System.out;

public class ScannerInputStrategy implements InputStrategy {

    private static final String INPUT_NUMBER = "숫자를 입력해주세요 : ";

    @Override
    public String getInput() {
        out.print(INPUT_NUMBER);
        return Console.readLine();
    }
}
