package baseball;

/**
 * 난수를 생성 및 저장, 스트라이크 볼 판별, 결과 출력, 게임 재시작
 * 야구 게임 관련 책임을 가진 클래스
 */
public class BaseballGamePlayer {
    private int strikeCount = 0;
    private int ballCount = 0;
    private String goalNumberString = null;

    public void setRandomGoalNumberString() {
        goalNumberString = RandomNumberStringMaker.getRandomNumberString();
    }

    /**
     * 사용자의 문자열과 목표 문자열을 비교해서 스트라이크, 볼 필드를 초기화.
     * @param userString
     */
    public void compareString(String userString) {
        strikeCount = 0;
        ballCount = 0;

        for (int i = 0 ; i < goalNumberString.length() ; i++) {
            char number = goalNumberString.charAt(i);
            if (userString.charAt(i)==number) {
                strikeCount++;
            } else if (userString.contains(String.valueOf(number))) {
                ballCount++;
            }
        }
    }

    public void printResult() {
        if (strikeCount == 0 && ballCount == 0) {
            System.out.println("낫싱");
        } else if (strikeCount == 0) {
            System.out.println(ballCount+"볼");
        } else if (ballCount == 0) {
            System.out.println(strikeCount+"스트라이크");
        } else if (ballCount != 0 && strikeCount != 0) {
            System.out.println(ballCount+"볼 "+strikeCount+"스트라이크");
        }
    }
}
