/*
 * 우아한 테크코스 프리코스 1주차 과제
 */

import java.util.HashSet;
import java.util.Random;
import java.util.Scanner;

/**
 * Baseball.java
 *
 * @version 1.0 2019.12.02
 * @author  hyesun.choi
 */
public class Baseball {

    /** sc는 Baseball 클래스의 Scanner 타입의 인스턴스 변수 */
    Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        Baseball game = new Baseball();
        game.startGame();
    }

    /** 1 ~ 9까지 서로 다른 임의의 수 3자리를 생성
     * @return 생성한 수를 문자열로 반환
     */
    private String makeAnswer() {
        String answer = "";
        Random rd = new Random();
        HashSet<Integer> hs = new HashSet<Integer>();
        for (int i = 1; i < 10; i++) {
            hs.add(i);
        }
        while (hs.size() > 6) {
            int tmp = rd.nextInt(8) + 1;
            if(hs.remove(tmp)) {
                answer += tmp;
            }
        }
        System.out.println(answer);
        return answer;
    }

    /** 사용자로부터 1 ~ 9까지 서로 다른 임의의 수 3자리를 받아옴
     * @return 받아온 수를 문자열로 반환
     */
    private String inputNumbers() {
        String numbers = "";
        boolean again = false;
        do {
            again = false;
            System.out.println("1 ~ 9까지 서로 다른 수로 이뤄진 3자리 수로 입력해주세요 : ");
            numbers = sc.nextLine();
            // 3글자가 아니거나, 1 ~ 9가 아니거나, 중복이 있다면 값을 다시 받아야 함
            if (numbers.length() != 3
                    || !('0' < numbers.charAt(0) && numbers.charAt(0) <= '9')
                    || !('0' < numbers.charAt(1) && numbers.charAt(1) <= '9')
                    || !('0' < numbers.charAt(2) && numbers.charAt(2) <= '9')
                    || numbers.charAt(0) == numbers.charAt(1)
                    || numbers.charAt(0) == numbers.charAt(2)
                    || numbers.charAt(1) == numbers.charAt(2)) {
                again = true;
            }
        } while (again);
        return numbers;
    }

    /** 생성된 수와 사용자가 입력한 수를 비교하여, 게임 진행 및 종
     * @param numbers 사용자가 입력한 수
     * @param answer  프로그램에서 생성한 수
     * @return 체크한 후 사용자가 재입력해야하면 true, 아니면 false를 반환
     */
    private boolean checkedNumbers(String numbers, String answer) {
        if (numbers.equals(answer)) {
            System.out.println("3 스트라이크");
            System.out.println("3개의 숫자를 모두 맞추셨습니다! 게임 종료");
            return false;
        }
        int[] score = new int[2];
        for(int i = 0; i < 3; i++) {
            if(numbers.charAt(i) == answer.charAt(0)
                    || numbers.charAt(i) == answer.charAt(1)
                    || numbers.charAt(i) == answer.charAt(2)) {
                score[1] += 1;
            }
            if(numbers.charAt(i) == answer.charAt(i)) {
                score[1] -= 1;
                score[0] += 1;
            }
        }
        if(score[0] == 0 && score[1] == 0) {
            System.out.println("낫싱");
        } else if(score[0] == 0 && score[1] > 0) {
            System.out.println(score[1] + "볼");
        } else if(score[0] > 0 && score[1] == 0) {
            System.out.println(score[0] + " 스트라이크");
        } else {
            System.out.println(score[0] + " 스트라이크 " + score[1] + "볼");
        }
        return true;
    }

    /** 게임의 재시작 여부
     * @return true 게임 재시작, false 게임 종료
     */
    private boolean restart() {
        String num = "";
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        do {
            num = sc.nextLine();
        } while (!num.equals("1") && !num.equals("2"));
        return num.equals("1");
    }

    /** 게임을 총괄하는 메서드, 전체 플로우가 나타나 있음 */
    public void startGame() {
        String answer = "";
        String numbers = "";
        // 게임 실행 - 종료, 재시작 가능
        do {
            answer = makeAnswer();
            // 사용자로부터 번호를 받아옴 - 틀릴 경우 재시작
            do {
                numbers = inputNumbers();
            } while (checkedNumbers(numbers, answer));
        } while (restart());
    }
}