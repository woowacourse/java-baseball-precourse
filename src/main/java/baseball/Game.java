package baseball;

public class Game {
    private static final int LENGTH_NUMBER = 3;
    private static final int MAX_STRIKE = 3;
    private static final String END_MESSAGE = "승리\n3개의 숫자를 모두 맞히셨습니다! 게임 종료";
    private static final String NEXT_MESSAGE = "개임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.";

    public static void runGame() {
        String numberComputer = Computer.generateNumber();
        String numberUser;
        int strikeCount = 0;
        int[] score;

        while (strikeCount != MAX_STRIKE) {
            numberUser = User.getNumber();
            score = getScore(numberComputer, numberUser);
            System.out.println(printMessage(score));
            strikeCount = score[0];
        }
        System.out.println(END_MESSAGE);
        System.out.println(NEXT_MESSAGE);

        if (User.isContinue()) {
            runGame();
        }
    }

    private static boolean isStrike(char numberComputer, char numberUser) {
        return numberUser == numberComputer;
    }

    private static boolean isBall(String numberComputer, char numberUser) {
        return numberComputer.contains(Character.toString(numberUser));
    }

    private static int[] getScore(String numberComputer, String numberUser) {
        int strikeCount = 0;
        int ballCount = 0;

        for (int i = 0; i < LENGTH_NUMBER; i++) {
            if (isStrike(numberUser.charAt(i), numberComputer.charAt(i))) {
                strikeCount++;
                continue;
            }
            if (isBall(numberComputer, numberUser.charAt(i))) {
                ballCount++;
            }
        }
        return new int[]{strikeCount, ballCount};
    }

    private static String printMessage(int[] score) {
        int strikeCount = score[0];
        int ballCount = score[1];
        String Message;
        if (strikeCount == 3) {
            return "3스트라이크";
        }
        if (strikeCount == 0 && ballCount == 0) {
            return "낫싱";
        }
        Message = ballCount + "볼 " + strikeCount + "스트라이크 ";
        return Message;
    }
}
