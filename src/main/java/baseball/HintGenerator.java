package baseball;

public class HintGenerator {
    private HintGenerator() {
    }

    public static int countStrike(int[] answer, int[] guess) {
        int strikeCount = 0;
        for (int index = 0; index < 3; index++) {
            if (answer[index] == guess[index]) {
                strikeCount += 1;
            }
        }
        return strikeCount;
    }
}
