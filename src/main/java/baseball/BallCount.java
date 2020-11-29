package baseball;

public class BallCount {

    private static int strike;
    private static int ball;

    /**
     * 메서드 checkStrikeAndBall()은 타깃넘버와 플레이어가 입력한 숫자를 비교하여 결과를 볼, 스트라이크 갯수로 표시해 리턴
     * @param targetNumber 플레이어가 맞춰야 할 타깃넘버
     * @param userInputNumber 플레이어가 콘솔에 입력한 숫자
     * @return 결과에 따라 볼, 스트라이크 갯수나 낫싱을 리턴
     */
    public static String checkStrikeAndBall(int targetNumber, int userInputNumber) {
        int [] targetDigits;
        targetDigits = NumberSeparator.makeArray(targetNumber);
        int [] userDigits;
        userDigits = NumberSeparator.makeArray(userInputNumber);

        strike = 0;
        ball = 0;

        for(int i=0; i<3; i++) {
            for(int j=0; j<3; j++) {
                updateStrikeOrBall(targetDigits[i], userDigits[j], i, j);
            }
        }

        String result = resultStrikeAndBall();
        return result;
    }

    public static void updateStrikeOrBall(int targetDigit, int userDigit, int targetIndex, int userIndex) {
        if((targetDigit == userDigit) && (targetIndex == userIndex)) {
            strike++;
        } else if ((targetDigit == userDigit) && (targetIndex != userIndex)) {
            ball++;
        }
    }

    public static String resultStrikeAndBall() {
        String result = "";
        if ((ball == 0) && (strike == 0)) {
            result += "낫싱";
        } else if ((ball != 0) && (strike == 0)) {
            result += Integer.toString(ball);
            result += "볼";
        } else if ((ball == 0) && (strike != 0)) {
            result += Integer.toString(strike);
            result += "스트라이크";
        } else {
            result += Integer.toString(ball);
            result += "볼 ";
            result += Integer.toString(strike);
            result += "스트라이크";
        }
        return result;
    }
}
