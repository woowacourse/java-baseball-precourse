package baseball;

import java.util.stream.IntStream;

public class Computer {
    private int num[];
    private String message = "";

    Computer(){
        init();
    }

    private void init(){
        makeRandomNumber();
        message = "숫자를 입력해주세요 : ";
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
            message = "낫싱";
        }
        if (ball >= 1) {
            message = ball + " 볼 ";
        }
        if (strike >= 1){
            message = strike + " 스트라이크 " + message;
        }
        message += "\n" + "숫자를 입력해주세요 : ";
        if (strike == 3){
            message = strike + " 스트라이크 " + "\n" + "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요. ";
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

    public String sendMessage(){
        return message;
    }

    public void readMessage(int[] message){
        if (message.length == 3){
            checkNum(message);
        }
    }

}
