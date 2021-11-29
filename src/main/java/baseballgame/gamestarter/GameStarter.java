package baseballgame.gamestarter;

import baseballgame.CommonConstant;
import baseballgame.inputprocessor.Processor;
import baseballgame.inputvalidator.Validator;
import camp.nextstep.edu.missionutils.Randoms;
import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.List;

public class GameStarter {
    private String randomNumber;
    public GameStarter(){
    }
    public void start(){
        while (true) {
            play();
            System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
            System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
            String inputNumber = Console.readLine();
            Validator.validateUserInputOnFinishedGame(inputNumber);
            if (inputNumber.equals(CommonConstant.FINISH_GAME_STATE)) break;
        }
    }
    private void play(){
        makeRandomNumber();
        while (true){
            System.out.print("숫자를 입력해주세요 : ");
            String inputNumber = Console.readLine();
            Validator.validateUserInputOnGame(inputNumber);
            String hint = Processor.getHint(randomNumber,inputNumber);
            System.out.println(hint);
            if(hint.equals("3스트라이크")) break;
        }
    }
    public void makeRandomNumber(){
        List<Integer> numberList = new ArrayList<>();
        while(numberList.size() <3){
            int number = Randoms.pickNumberInRange(CommonConstant.MIN_NUMBER,CommonConstant.MAX_NUMBER);
            if(!numberList.contains(number)){
                numberList.add(number);
            }
        }
        randomNumber = String.valueOf(numberList.get(0)) + String.valueOf(numberList.get(1))+ String.valueOf(numberList.get(2));
    }

    public String getNumber() {
        return randomNumber;
    }
}
