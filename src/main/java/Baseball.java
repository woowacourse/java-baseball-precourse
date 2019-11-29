/*
 * @(#)Main.java        2019-11-29
 *
 * [저작권 및 라이센스 관련 정보를 여기에 작성한다.]
 */

import java.util.Random;

/**
 * @version         1.00 2019-11-29
 * @author          최근휘
 */
public class Baseball {

    /* 플레이어의 임의의 3개의 수 */
    private String playersNums;
    /* 컴퓨터의 임의의 3개의 수 */
    private String computersNums;
    /* Random 객체 */
    private Random random;

    /**
     * 생성자 Baseball()
     */
    public Baseball() {
        random = new Random();
    }

    public String getPlayersNums() {
        return playersNums;
    }

    public String getComputersNums() {
        return computersNums;
    }

    /**
     * @param threeNumString 1~9까지의 수 3개로 이루어져 있는 문자열
     */
    public void setPlayersNum(String threeNumString) {
        playersNums = new String(threeNumString);
    }

    /**
     * 컴퓨터의 3개의 숫자를 임의로 설정
     */
    public void setComputersNum() {
        computersNums = new String(makeThreeNum());
    }

    /**
     * @return 1~9까지의 수 3개로 이루어져 있는 문자열을 임의로 생성하여 반환
     */
    public String makeThreeNum() {
        StringBuilder answer = new StringBuilder("");
        for (int i = 0; i < 3; i++) {
            int num = random.nextInt(9) + 1;
            answer.append(Integer.toString(num));
        }

        return answer.toString();
    }
}







































