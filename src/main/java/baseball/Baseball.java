package baseball;

public class Baseball {

    private static boolean gameResult = false;

    public static boolean playGame(int[] user, int[] random) {
        int[] countResult = new int[2];
        int strikeCount = 0;
        int ballCount = 0;
        for (int i = 0; i < user.length; i++) {
            for (int j = 0; j < random.length; j++) {
                countResult = counterRound(i, user[i], j, random[j]);
                strikeCount += countResult[0];
                ballCount += countResult[1];
            }
        }
        printScore(strikeCount, ballCount);
        return gameResult;
    }

    public static void printScore(int strikeCount, int ballCount) {
        String gameMessage = "";
        if (ballCount != 0) {
            gameMessage += ballCount + "볼 ";
        }
        if (strikeCount != 0) {
            gameMessage += strikeCount + "스트라이크";
        }
        if (ballCount <= 0 && strikeCount <= 0) {
            gameMessage = "낫싱";
        }
        if (strikeCount == 3) {
            gameResult = true;
        }
        System.out.println(gameMessage);
    }

    public static int[] counterRound(int userRound, int userNumber, int randomRound,
        int randomNumber) {
        int[] countResult = new int[2];
        if (userNumber == randomNumber && userRound == randomRound) {
            // strike counting round
            countResult[0] += 1;
        }
        if (userNumber == randomNumber) {
            // ball counting round
            countResult[1] += 1;
        }
        return countResult;
    }

}
