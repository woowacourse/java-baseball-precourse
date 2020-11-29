package utils;

import java.util.Scanner;

public class PlayBall {
    UserInput userInput = new UserInput();
    Answer answer = new Answer();

    public PlayBall() {
        answer.setAnswer();
        System.out.println(answer.getAnswer());
    }

    public void play(Scanner scanner) {
        while(true) {
            getInput(scanner);
            if(checkNum() == 1) {
                break;
            }
        }
    }

    private int checkNum() {
        int strike = 0;
        int ball = 0;
        for(int i = 0; i < 3; i++) {
            int num = userInput.getUserInput().get(i);

            if(answer.getAnswer().indexOf(num) == i) {
                strike++;

            } else if(answer.getAnswer().indexOf(num) != -1) {
                ball++;
            }
        }
        if(strike == 3) {
            System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
            return 1;
        }
        if(ball > 0) {
            System.out.println(ball + "볼 ");
        }
        if(strike > 0) {
            System.out.println(strike + "스트라이크");
        }
        if(ball == 0 && strike == 0) {
            System.out.println("낫싱");
        }
        return 0;
    }

    public boolean isReplay(Scanner scanner) {
        String input = new String();
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        input = scanner.nextLine().trim();

        if(input.equals("1") || input.equals("2")) {
            return (!input.equals("1"));
        } else {
            throw new IllegalArgumentException("숫자 입력 오류입니다. 다시 입력해주세요.");
        }
    }

    private void getInput(Scanner scanner) {
        while(true) {
            try {
                userInput.setInput(scanner);
                break;
            } catch (Throwable throwable) {
                System.out.println(throwable.getMessage());
            }
        }
    }
}
