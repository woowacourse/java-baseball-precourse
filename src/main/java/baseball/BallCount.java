package baseball;

public class BallCount {

    /**
     * 메서드 checkStrikeAndBall()은 타깃넘버와 플레이어가 입력한 숫자를 비교하여 결과를 볼, 스트라이크 갯수로 표시합니다.
     * @param targetNumber 플레이어가 맞춰야 할 타깃넘버입니다.
     * @param userInputNumber 플레이어가 콘솔에 입력한 숫자입니다.
     * @return 결과에 따라 볼, 스트라이크 갯수나 낫싱을 리턴합니다.
     */
    public static String checkStrikeAndBall(int targetNumber, int userInputNumber) {
        int [] targetArray;
        targetArray = makeArray(targetNumber);
        int [] userArray;
        userArray = makeArray(userInputNumber);

        int strike = 0;
        int ball = 0;

        /* targetArray[0] 이랑 겹치는것을 판별한다 */
        for(int i=0; i<3; i++) {
            if((targetArray[0] == userArray[i]) && (i == 0)) {
                strike++;
            } else if ((targetArray[0] == userArray[i]) && (i != 0)) {
                ball++;
            }
        }
        //targetArray[1] 이랑 겹치는것?
        for(int i=0; i<3; i++) {
            if((targetArray[1] == userArray[i]) && (i == 1)) {
                strike++;
            } else if ((targetArray[1] == userArray[i]) && (i != 1)) {
                ball++;
            }
        }
        //targetArray[2] 이랑 겹치는것?
        for(int i=0; i<3; i++) {
            if((targetArray[2] == userArray[i]) && (i == 2)) {
                strike++;
            } else if ((targetArray[2] == userArray[i]) && (i != 2)) {
                ball++;
            }
        }

        String result = resultStrikeAndBall(strike, ball);
        return result;
    }

    /**
     * 메서드 resultStrikeAndBall()은 checkStrikeAndBall()에서 strike, ball 갯수를 넘겨받아 결과를 String 형식으로 반환합니다.
     * @param strike checkStrikeAndBall() 에서 넘겨받은 strike 갯수
     * @param ball checkStrikeAndBall() 에서 넘겨받은 ball 갯수
     * @return 볼, 스트라이크 갯수나 낫싱을 리턴합니다.
     */
    public static String resultStrikeAndBall(int strike, int ball) {
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
        System.out.println(result);
        return result;
    }

    /**
     * 메서드 makeArray()는 3자리수 숫자를 첫째자리, 둘째자리, 셋째자리 순서로 integer 배열에 저장해 이를 리턴해줍니다.
     * @param number 3자리수 (타깃넘버나 유저인풋넘버) 입니다.
     * @return 받은 3자리수를 첫째자리, 둘째자리, 셋째짜리로 나누어 integer 배열로 저장해 리턴합니다.
     */
    public static int[] makeArray(int number) {
        int [] temp = new int[3];
        temp[0] = number/100;               /* 첫째자리 */
        temp[1] = (number/10)%10;           /* 둘째자리 */
        temp[2] = number%10;                /* 셋째자리 */
        return temp;
    }

}
