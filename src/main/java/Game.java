/*
 * 클래스 이름: Game
 *
 * 작성 날짜: 2019.03.22 ~ 2019.03.28
 */

import java.util.Random;

public class Game {
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
        char[] str = new char[3];
        int[] randomCheck = new int[9];

        int i = 0;
        while (i < str.length) {
            int num = random.nextInt(9) + 1;

            if (randomCheck[num - 1] != 1) {
                str[i] = (char) (num + '0');
                randomCheck[num - 1]++;
                i++;
            }
        }

        return str;
    }

    /*
     * 사용자가 입력한 숫자와 비교해 strike, ball 를 계산하는 매서드
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

    /*
     * 3 Strike 인지 아닌지 확인하는 매서드
     */
    public boolean checkAnswer() {
        if (bs[1] == 3) {
            return true;
        } else {
            return false;
        }
    }

    /*
     * compareAnswer 매서드의 결과로 출려하는 매서드
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

    /*
     * 게임을 다시 시작할지 끝낼지 결정하는 매서드
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
