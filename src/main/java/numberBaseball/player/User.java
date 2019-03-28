package numberBaseball.player;

import java.util.Scanner;

public class User implements Player {
    public void setThreeNumber() {

    }

    public boolean hasInvalidChar(String guessed) {
        for (int i = 0; i < guessed.length(); i++) {
            if (!Character.isDigit(guessed.charAt(i))) {
                System.out.println("Error: 숫자만 입력할 수 있습니다.");
                return true;
            }
        }
        return false;
    }

    public boolean hasInvalidLength(String guessed) {
        final int validLength = 3;

        if (guessed.length() != validLength) {
            System.out.println("Error: 3개의 숫자를 입력해주셔야 합니다.");
            return true;
        }
        return false;
    }

    public boolean hasInvalidZeros(String guessed) {
        if (guessed.contains("0")) {
            System.out.println("Error: 숫자에는 0이 포함될 수 없습니다.");
            return true;
        }
        return false;
    }

    public boolean hasOverlappedNumber(String guessed) {
        String checkingPart = new String();
        char checkingChar;

        for (int i = 1; i < guessed.length(); i++) {
            checkingChar = guessed.charAt(i - 1);
            checkingPart = guessed.substring(i);
            if (checkingPart.contains(String.valueOf(checkingChar))) {
                System.out.println("Error: 서로 중복되는 숫자는 포함될 수 없습니다.");
                return true;
            }
        }
        return false;
    }

    public boolean hasInvalid(String guessed) {
        return hasInvalidChar(guessed) || hasInvalidLength(guessed)
                || hasInvalidZeros(guessed) || hasOverlappedNumber(guessed);
    }

    public int[] guessThreeNumber() {
        Scanner sc = new Scanner(System.in);
        int [] guessed = {0, 0, 0};

        System.out.print("숫자를 입력해주세요 : ");
        String guessedStr = sc.nextLine().replaceAll("\\s+", "");
        while(hasInvalid(guessedStr)) {
            System.out.print("숫자를 다시 입력해주세요 : ");
            guessedStr = sc.nextLine().replaceAll("\\s+", "");
        }

        for (int i =0; i < guessedStr.length(); i++) {
            guessed[i] = Character.getNumericValue(guessedStr.charAt(i));
        }
        return guessed;
    }

    public void answerHintOf(int[] guessed) {

    }

    public boolean checkCorrect(int[] guessed) {
        return false;
    }
}