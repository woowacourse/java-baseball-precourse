package baseball;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Player {
    private String digits;
    private int length;

    public Player(int length) {
        this.length = length;
    }



    public String getDigits() {
        return digits;
    }

    public void inputDigits() {

        while (true) {
            System.out.print("숫자를 입해주세요 : ");
            digits = inputDigitsReader();

            if (Validation.isInputValid(digits, length))
                break;

            System.err.println("잘못 입력하셨습니다. 중복되지 않는 " + this.length + "자리 숫자를 다시 입력해주세요.");
        }
    }

    private String inputDigitsReader() {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = null;

        try {
            input = br.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return input;
    }
}
