package numberBaseball.player;

import java.util.Scanner;

public class User implements Player {
    public void setThreeNumber() {

    }

    public boolean hasInvalid(String guessed) {
        return false;
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