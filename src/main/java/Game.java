/*
 * 클래스 이름: Game
 *
 * 작성 날짜: 2019.03.22 ~ 2019.03.28
 */

import java.util.Random;

public class Game {
    private final static int MAX_LENGTH = 3;
    private final static int RANDOM_NUMBER = 9;

    private char[] answer;
    private int[] bs; // {ball, strike}

    public Game() {
        answer = generateAnswer();
    }

    /*
     * 컴퓨터의 랜덤 숫자를 생성하는 메서드
     * 불리는 시점: (1) 클래스 생성 (2) 게임을 다시 시작할 때
     */
    private char[] generateAnswer() {
        Random random = new Random();
        char[] str = new char[MAX_LENGTH];
        int[] randomCheck = new int[RANDOM_NUMBER];

        int i = 0;
        while (i < str.length) {
            int num = random.nextInt(RANDOM_NUMBER) + 1;

            if (randomCheck[num - 1] != 1) {
                str[i] = (char) (num + '0');
                randomCheck[num - 1]++;
                i++;
            }
        }

        return str;
    }

    /**
     * \
     * @param question 입력한 숫자
     */
    public void compareAnswer(String[] question) {
        bs = new int[2];
        String str = String.valueOf(answer);
        int i = -1;

        for (String e : question) {
            i++;
            if (!str.contains(e)) {
                continue;
            }

            if (answer[i] == e.charAt(0)) {
                bs[1]++; // strike 증가
            } else {
                bs[0]++; // ball 증가
            }
        }
    }

    /**
     *
     * @return 정답이면 true, 정답이 아니면 false
     */
    public boolean checkAnswer() {
        if (bs[1] == MAX_LENGTH) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * compareAnswer에서 확인된 결과를 출려하는 함수
     */
    public void print() {
        String response = "";

        if (bs[1] != 0) {
            response += bs[1] + " 스트라이크 ";
        }
        if (bs[0] != 0) {
            response += bs[0] + " 볼";
        }

        if (response.equals("")) {
            response += "낫싱";
        }

        System.out.println(response);
    }

    /**
     *
     * @param temp 1: 게임 끝 2:
     * @return
     */
    public boolean exitGame(int temp) {
        if (temp == 1) {
            answer = generateAnswer();
            return false;
        } else {
            return true;
        }
    }
}
