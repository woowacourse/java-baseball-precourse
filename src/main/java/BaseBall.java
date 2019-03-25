/*
* @(#) BaseBall.java    0.1 2019-03-25
* copyright
* */

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

/**
 * BaseBall
 * @version 0.1
 * @author yun
 *
 * 1 ~ 9의 서로 다른 3자리 수를 맞추는 게임
 * 유저는 3자리 수를 입력하여 정답과 비교
 * 자리수를 맞추면 Strike, 다른 자리에 있다면 Ball, 없다면 Nothing
 * 예) 정답 : 169
 * 입력1 : 431 -> 1 Ball
 * 입력2 : 943 -> 1 Ball
 * 입력3 : 765 -> 1 Strike
 * ...
 *
* */

public class BaseBall {

    /**
     * answerInit
     * @return List
     *
     * 중복되지 않고 1 ~ 9 중 임의의 3개의 수를 선택
     * 정답을 초기화 하는 method
     * ex) [4, 1, 9]
     * 1 ~ 9가 있는 array를 shuffle
     * index 0 ~ 2까지 slicing한 List를 반환
     * */
    private static List<Integer> answerInit() {
        List<Integer> arr;
        arr = new ArrayList<>();

        for (int i = 1; i <= 9; i++) {
            arr.add(i);
        }
        Collections.shuffle(arr); // 순서대로 1 ~ 9가 있는 List를 shuffle
        return arr.subList(0, 3); // arr[0:3] 반환
    }

    /**
     * countInit
     * @return List
     *
     * 정답과 입력을 비교를 기록하는 List
     * count = [0, 0]
     * List의 첫번째 원소는 Strike의 수, 두번째는 Ball의 수 기록
     * */
    private static List<Integer> countInit() {
        List<Integer> count;
        count = new ArrayList<>();

        count.add(0);
        count.add(0);
        return count;
    }

    /**
     * comparing
     * @param answer 정답 배열
     * @param user 유저의 입력 배열
     * @return List
     *
     * 정답과 입력을 비교하고 그 결과를 count 배열에 기록
     * loop를 3번 돌면서 정답의 i번째 원소와 입력의 i번째 원소를 비교
     * 같으면 count[0] + 1,
     * 다르면 정답이 입력 i번째 원소를 포함하면 count[1] + 1
     * */
    private static List<Integer> comparing(List<Integer> answer,
                                           List<Integer> user) {
        List<Integer> count;
        int answerNumber; // answer List의 i번째 값
        int userNumber; // user List의 i번째 값
        int strike, ball; // count List의 0번째, 1번째 값

        count = countInit(); // [0, 0]
        for (int i = 0; i < 3; i ++) {
            answerNumber = answer.get(i);
            userNumber = user.get(i);
            if (answerNumber == userNumber) {
                strike = count.get(0);
                strike += 1;
                count.set(0, strike); // count[0] + 1
            } else if (answer.contains(userNumber)) { // 입력의 i번째 값이 정답 List에 있는지 확인
                ball = count.get(1);
                ball += 1;
                count.set(1, ball); // count[1] + 1
            }
        }
        return count;
    }

    /**
     * printResult
     * @param count comparing의 return 값
     *
     * comparing의 return 값인 count List로 Strike, Ball, Nothing을 출력
     * count[0], count[1] 둘다 0 보다 큼 -> Strike, Ball 출력
     * count[0] 0 보다 큼 -> Strike 출력
     * count[1] 0 보다 큼 -> Ball 출력
     * count[0], count[1] 둘다 0 이면 Nothing 출력
     * */
    private static void printResult(List<Integer> count) {
        int strike, ball;

        strike = count.get(0);
        ball = count.get(1);
        if (strike > 0 && ball > 0) { // Strike, Ball 둘다 있을 때
            System.out.printf("%d Strike, %d Ball\n", strike, ball);
        } else if (strike > 0) { // Strike만 있을 때
            System.out.printf("%d Strike\n", strike);
        } else if (ball > 0) { // Ball 만 있을 때
            System.out.printf("%d Ball\n", ball);
        } else { // 아무것도 못 맞췄을 때
            System.out.println("Nothing");
        }
    }

    /**
     * getUser
     * @param sc 입력을 받기 위한 Scanner instance
     * @return List
     *
     * 유저가 입력한 3자리 수, number를 100의 자리, 10의 자리, 1의 자리로 나눔
     * number를 100으로 나누어 몫은 user List에 넣고
     * 나머지를 number에 할당
     * 10과 1도 위와 동일함
     * unit List는 100, 10, 1을 순서대로 저장하고 순서대로 사용함
     * ex) 367 입력 -> [3, 6, 7] 반환
     * */
    private static List<Integer> getUser(Scanner sc) {
        List<Integer> user;
        int number; // 유저가 입력한 3자리 수
        int unit; // number를 분리하기 위한 나누는 수
        int quotient; // number를 unit으로 나눈 몫

        user = new ArrayList<>();
        number = sc.nextInt();
        unit = 100; // number가 3자리라서 100으로 초기화
        for (int i = 0; i < 3; i++) { // 100, 10, 1의 자리를 구하기 위해 3번 반복
            quotient = number / unit;
            user.add(quotient);
            number %= unit;
            unit /= 10;
        }
        return user;
    }

    /**
     * play
     * @param sc 입력을 받기 위한 Scanner instance
     *
     * 게임을 실행
     * 정답을 초기화
     * 유저는 정답을 입력(getUser)
     * 정답과 입력을 비교(comparing)
     * 결과를 출력(printResult)
     * 3 Strike이면 종료, 그렇지 않으면 계속 반복
     * */
    private static void play(Scanner sc) {
        List<Integer> answer; // 정답 List
        List<Integer> user; // 유저 입력을 받아 크기 3인 List로 반환
        List<Integer> count; // 정답과 입력 비교한 크기 2인 List 반환
        int strike; // 3 Strike이면 종료

        answer = answerInit(); // 정답 할당
        while (true) {
            System.out.println("숫자를 입력해주세요");
            user = getUser(sc);
            count = comparing(answer, user);
            printResult(count); // 비교 결과에 대한 출력
            strike = count.get(0);
            if (strike > 2) {
                System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
                break;
            }
        }
    }

    /**
     * main
     *
     * Scanner instance 생성
     * play에 parameter로 전달
     * 게임이 종료되면 게임을 다시 할 것인지 물어보고 계속 진행 및 종료
     * */
    public static void main(String[] args) {
        Scanner sc; // 외부 입력을 받을 수 있는 Scanner instance 초기화
        int game; // 게임을 더 할 것인지 선택

        sc = new Scanner(System.in);
        do {
            play(sc); // 게임 시작
            System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
            game = sc.nextInt();
        } while (game <= 1);

    }
}
