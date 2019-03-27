package baseball;

import java.util.stream.IntStream;

public class Computer {
    private int num[];
    private String message = "";
    private final String INPUT_MESSAGE = "숫자를 입력해주세요 : ";
    private final String CONTINUE_MESSAGE = "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요. ";
    private final String ENTER_MESSAGE = "\n";
    private final String STRIKE_MESSAGE = " 스트라이크 ";
    private final String BALL_MESSAGE = " 볼 ";
    private final String NOTHING_MESSAGE = "낫싱";
    private final String WARMING_MESSAGE = "잘못된 숫자를 입력했습니다." + ENTER_MESSAGE + "3자리의 모두 다른 숫자만 가능합니다.";
    boolean endGame = true;

    Computer(){
        init();
    }

    private void init(){
        makeRandomNumber();
        message = INPUT_MESSAGE;
    }

    private void makeRandomNumber(){
        num = new int[3];

        num[0] = (int)(Math.random()*9 + 1);
        num[1] = (int)(Math.random()*9 + 1);

        while (num[0] == num[1]){
            num[1] = (int)(Math.random()*9 + 1);
        }
        num[2] = (int)(Math.random()*9 + 1);

        while ((num[0] == num[2]) || (num[1] == num[2])){
            num[2] = (int)(Math.random()*9 + 1);
        }
    }

    private void checkNum(int[] userNum){
        int strike = countStrike(userNum);
        int ball = countBall(userNum);

        if (ball == 0 && strike == 0){
            message = NOTHING_MESSAGE;
        }
        if (ball >= 1) {
            message = ball + BALL_MESSAGE;
        }
        if (strike >= 1){
            message = strike + STRIKE_MESSAGE + message;
        }
        message += ENTER_MESSAGE + INPUT_MESSAGE;
        if (strike == 3){
            message = strike + STRIKE_MESSAGE + ENTER_MESSAGE + CONTINUE_MESSAGE;
        }

    }

    private int countBall(int[] userNum){
        return IntStream.range(0,3)
                .map(i -> (num[i] == userNum[(i+1)%3]) || (num[i] == userNum[(i+2)%3]) ? 1:0)
                .sum();
    }

    private int countStrike(int[] userNum){
        return IntStream.range(0,3)
                .map(i -> (num[i] == userNum[i]) ? 1:0)
                .sum();
    }

    private boolean checkOverlap(int[] userNum){
        return (userNum[0] != userNum[1]) &&
                (userNum[0] != userNum[2]) &&
                (userNum[1] != userNum[2]);
    }

    public String sendMessage(){
        return message;
    }

    public void readMessage(int[] message){

        if (message.length == 3 && checkOverlap(message)){
            this.message = "";
            checkNum(message);
        }else if (this.message.split("")[0].equals("3") && message.length == 1){
            if (message[0] == 1){
                init();
            }else if (message[0] == 2){
                endGame = false;
            }
        }else {
            this.message = WARMING_MESSAGE + ENTER_MESSAGE + INPUT_MESSAGE;
        }
    }

}
