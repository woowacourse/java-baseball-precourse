package baseball;



public class Service {

    public int ballCount;
    public int strikeCount;

    /* 볼, 스트라이크 카운트 메소드 */
    public void counter(String opponentNumber, String playerNum) {
        int totalCount = 0;
        for(int i=0; i<3; i++) {
            String opponentDigit = opponentNumber.split("")[i];
            String playerDigit = playerNum.split("")[i];

            if(opponentNumber.contains(playerDigit) ) {
                totalCount++;
            }
            if(opponentDigit.equals(playerDigit)) {
                strikeCount++;
            }
        }

        ballCount = totalCount - strikeCount;
    }

    /* 힌트 출력 메소드 */
    public void printHint(int ballCount, int strikeCount) {
        if (ballCount != 0 && strikeCount == 0) {
            System.out.println(ballCount + "볼");
            return;
        }

        if (ballCount == 0 && strikeCount != 0) {
            System.out.println(strikeCount + "스트라이크");
            return;
        }

        if (ballCount != 0 && strikeCount != 0) {
            System.out.println(ballCount + "볼 " + strikeCount + "스트라이크");
            return;
        }

        if (ballCount == 0 && strikeCount == 0) {
            System.out.println("낫싱");
        }
    }

    /* 승리 확인 메소드 */
    public boolean isWin(int ballCount, int strikeCount) {
        if(strikeCount==3 && ballCount==0) {
            System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
            return true;
        }
        return false;
    }

    /* 게임 초기화 여부를 결정하는 메소드 */
    public static boolean finishBaseball(String playerInput) {
        if(playerInput.equals("1")) {
            return true;
        }

        if(playerInput.equals("2")) {
            return false;
        }
        return true;
    }

}
