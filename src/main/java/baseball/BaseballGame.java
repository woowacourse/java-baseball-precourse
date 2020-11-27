package baseball;

import java.util.*;

public class BaseballGame {
    private final Scanner scanner;
    
    public BaseballGame(Scanner scanner) {
        this.scanner = scanner;
    }

    public void run(){
        boolean isContinue = true;
        while(isContinue){
            game();
            System.out.println("게임을 새로 시작하려면 1, 종료 하려면 2를 입력하세요.");
            if(scanner.nextLine().equals("2"))
                isContinue = false;
        }
    }

    public void game() {
        BaseballNumber randomBaseballNumber = new BaseballNumber();
        boolean answer = true;
        while(answer) {
            int ballCounter = 0;
            int strikeCounter = 0;
            System.out.print("숫자를 입력해주세요 : ");
            String playerBallNumber = scanner.nextLine();
            BaseballNumber playerBaseballNumber = new BaseballNumber(playerBallNumber);

            strikeCounter = strikeCompare(randomBaseballNumber.getNumbers(), playerBaseballNumber.getNumbers());
            ballCounter = ballCompare(randomBaseballNumber.getNumbers(), playerBaseballNumber.getNumbers());

            answer = resultPrint(ballCounter, strikeCounter);
        }
    }

    public int strikeCompare(List<String> ballNumberList, List<String> playerBallSplitNumberList) {
        int strikeCounter = 0;

        for (int i = 0; i < ballNumberList.size(); i++) {
            if (ballNumberList.get(i).equals(playerBallSplitNumberList.get(i)))
                strikeCounter += 1;
        }
        return strikeCounter;
    }

    public int ballCompare(List<String> ballNumberList, List<String> playerBallSplitNumberList) {
        int ballCounter = 0;
        for (int answerIndex = 0; answerIndex < 3; answerIndex++) {
            for (int playerIndex = 0; playerIndex < 3; playerIndex++) {
                if (answerIndex == playerIndex)
                    continue;
                else {
                    if (ballNumberList.get(answerIndex).equals(playerBallSplitNumberList.get(playerIndex)))
                        ballCounter += 1;
                }
            }
        }
        return ballCounter;
    }

    public boolean resultPrint(int ballCounter, int strikeCounter) {
        boolean answer = true;
        if(1 <= ballCounter && 1 <= strikeCounter){
            System.out.println(String.format("%d볼 %d스트라이크 입니다.",ballCounter,strikeCounter));
        }else if(1 <= ballCounter && strikeCounter==0){
            System.out.println(ballCounter+"볼 입니다.");
        }else if(0 == ballCounter && strikeCounter==1) {
            System.out.println(strikeCounter+"스트라이크 입니다.");
        }else if(0 == ballCounter && strikeCounter==2) {
            System.out.println(strikeCounter+"스트라이크 입니다.");
        }else if(strikeCounter==3){
            System.out.println(strikeCounter + "개의 숫자를 모두 맞히셨습니다! 게임 종료");
            answer = false;
        }else{
            System.out.println("낫싱");
        }
        return answer;
    }
}
