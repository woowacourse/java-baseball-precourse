package baseball.baseballGame;

import utils.RandomUtils;

import java.util.ArrayList;
import java.util.List;

public class Round {
    private List<Integer> answer;
    private List<Integer> playerAnswer;
    private int NUM_LENGTH;
    private static final int MIN_NUM = 1;
    private static final int MAX_NUM = 9;

    public Round(int numLength) {
        this.NUM_LENGTH = numLength;

        answer = new ArrayList<>(NUM_LENGTH);
        makeAnswer(answer);
    }

    void makeAnswer(List<Integer> answer) {
        for (int i = 0; i < NUM_LENGTH; i++) {
            answer.add(RandomUtils.nextInt(MIN_NUM, MAX_NUM));
            System.out.print(answer.get(i));
        }
        System.out.println();
    }

    int start(Player player){
        playerAnswer = new ArrayList<>(NUM_LENGTH);

        while (true) {
            playerAnswer = player.inputNumber(NUM_LENGTH);

            String response = askAnswer(playerAnswer);

            if (response.equals("3스트라이크")) {
                System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
                System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");

                return player.inputExitButton();
            }
        }
    }

    String askAnswer(List<Integer> playerAnswer) {
        int strike = 0;
        int ball = 0;

        for (int i=0; i<NUM_LENGTH; i++) {
            if (playerAnswer.get(i) == answer.get(i)) { // strike
                strike += 1;
                continue;
            }

            if (answer.contains(playerAnswer.get(i))) { // ball
                ball += 1;
            }
        }

        return String.valueOf(strike) + "스트라이크";
    }
}
