package domain;

import camp.nextstep.edu.missionutils.Console;
import ui.Input;
import ui.Output;

import java.util.ArrayList;
import java.util.List;

public class Player {

    private static final String RESTART_GAME = "1";
    private static final String EXIT_GAME = "2";


    private Balls balls;            //사용자
    private AnswerBalls answerBalls;

    private boolean isStartGame;
    private boolean isCorrectAnswer;


    public void gameStart() {

        isStartGame = true;
        while (isStartGame) {
            // 게임 재시작마다 정답공을 새로 생성
            answerBalls = new AnswerBalls();
            playerInput();
            checkRestartGame();
        }

    }

    // 사용자 입력 처리
    private void playerInput() {
        isCorrectAnswer = false;

        while (!isCorrectAnswer) {
            //숫자가 아닌 입력과 3자리 이상 에러를 잡기 위해 try catch 사용
            try {
                List<Ball> inputBalls = new ArrayList<>();
                String input = Input.playerBallNumberInput();
                String[] splitedText = input.split("");

                // Integer.parseInt로 예외처리
                for (int i = 0; i < splitedText.length; i++) {
                    validInteger(splitedText[i]);
                    inputBalls.add(new Ball(Integer.parseInt(splitedText[i])));
                }
                // balls 클래스에 집어넣고 여기서 3자리가 넘으면 에러 캐치
                balls = new Balls(inputBalls);

                isCorrectAnswer = answerBalls.isCorrectAnswer(inputBalls);

            } catch (IllegalArgumentException e) {
                System.out.println(e);
                playerInput();
            }


        }


    }

    private boolean checkRestartGame() {
        String restartNumberCheck = Input.playerGameStartNumberInput();

        if (restartNumberCheck.equals(RESTART_GAME)) {
            return isStartGame = true;
        }

        if (restartNumberCheck.equals(EXIT_GAME)) {
            return isStartGame = false;
        }

        throw new IllegalArgumentException("숫자 1 또는 2 중에서 입력하세요");

    }


    private void validInteger(String ball) {

        try {
            //문자열을 숫자로 바꿔주는 코드, 숫자가 아니면 에러 출력
            Integer.parseInt(ball);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("숫자만 입력해주세요");
        }
    }
}
