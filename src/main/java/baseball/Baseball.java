package baseball;

import java.util.InputMismatchException;
import java.util.Scanner;

class Baseball {
    public static void main(String[] args) {
        new Game();
    }
}

class Game {
    Scanner scanner = new Scanner(System.in);
    int[] myNumbers = new int[3]; // 사용자 입력 숫자
    int[] yourNumbers = {1, 2, 3, 4, 5, 6, 7, 8, 9}; // 컴퓨터 랜덤 숫자, 섞은 후 앞 3자리만 사용
    int state = 1; // 상태 변수, 0 : 종료, 1 : 초기화, 2 : 게임 한 판, 3 : 종료 혹은 재시작 선택

    Game() {
        while (state > 0) {
            loop();
        }
    }

    private void loop() { // 상태에 따른 반복
        switch (state) {
            case 1 :
                init();
                break;
            case 2 :
                input();
                break;
            case 3 :
                choice();
                break;
            default :
                state = 0;
                break;
        }
    }

    private void init() { // 컴퓨터 초기화
        for (int i = 0; i < 8; i++) {
            final int j = (int)(Math.random() * (8 - i)) + 2;
            final int temp = yourNumbers[i];
            yourNumbers[i] = yourNumbers[j];
            yourNumbers[j] = temp;
        }
        state = 2;
    }

    private void input() { // 사용자 입력
        boolean test = true;
        int digits = 0;
        System.out.println("숫자를 입력해주세요 : ");
        try {
            digits = scanner.nextInt();
        } catch (InputMismatchException e) {
            scanner.next();
           test = false;
        }
        if (digits < 123 || digits >= 1000) {
            test = false;
        } else {
            myNumbers[0] = digits / 100;
            myNumbers[1] = digits % 100 / 10;
            myNumbers[2] = digits % 10;
            if (myNumbers[0] == myNumbers[1] || myNumbers[1] == myNumbers[2] || myNumbers[2] == myNumbers[0]) {
                test = false;
            }
        }
        if (test) {
            play();
        } else {
            System.out.println("잘못된 입력입니다.");
        }
    }

    private void play() { // 게임 진행
        int strike = 0;
        int ball = 0;
        for (int i = 0; i < 9; i++) {
            if (myNumbers[i / 3] == yourNumbers[i % 3]) {
                int temp = (i / 3) == (i % 3) ? strike++ : ball++;
            }
        }
        if (strike + ball == 0) {
            System.out.println("낫싱");
        } else {
            String strikeString = strike > 0 ? strike + " 스트라이크" : "";
            String space = strike > 0 && ball > 0 ? " " : "";
            String ballString = ball > 0 ? ball + "볼" : "";
            System.out.println(strikeString + space + ballString);
            if (strike == 3) {
                System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
                state = 3;
            }
        }
    }

    private void choice() { // 게임 종료 후 재시작 혹은 완전 종료 선택
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        int command = 0;
        boolean test = true;
        try {
            command = scanner.nextInt();
            if (command != 1 && command != 2) {
                test = false;
            }
        } catch (InputMismatchException e) {
            scanner.next();
            test = false;
        }
        if (test) {
            if (command == 1) {
                state = 1;
            } else {
                state = 0;
            }
        } else {
            System.out.println("잘못된 입력입니다.");
        }
    }
}