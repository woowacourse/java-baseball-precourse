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

}
