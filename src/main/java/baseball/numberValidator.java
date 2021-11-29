package baseball;

public class numberValidator {

    public void validateNumberInput(String numberInputStr) {
        int length = numberInputStr.length();
        if (length != 3) {
            throw new IllegalArgumentException();
        }

        for (int i = 0; i < length; i++) {
            char ch = numberInputStr.charAt(i);
            int digit = ch - '0';

            // 1부터 9까지의 숫자가 아닌 digit => 유효하지 않음
            if (!(1 <= digit && digit <= 9)) {
                throw new IllegalArgumentException();
            }
        }
    }

    public void validateReplayInput(String ReplayInputStr) {
        int length = ReplayInputStr.length();
        if (length != 1) {
            throw new IllegalArgumentException();
        }

        char ch = ReplayInputStr.charAt(0);
        if (!(ch == '1' || ch == '2')) {
            throw new IllegalArgumentException();
        }
    }
}
