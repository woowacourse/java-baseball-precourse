package baseball;

import java.util.Scanner;

import baseball.modules.InputOutputManager;
import baseball.modules.NumberGenerator;

public class GameManager {
    public static final int NUMBER_SIZE = 3;
    public static final int ANSWER_YES = 1;

    InputOutputManager inputOutputManager;
    NumberGenerator numberGenerator;

    int strike = 0;
    int ball = 0;

    public GameManager(Scanner scanner){
        inputOutputManager = new InputOutputManager(scanner, NUMBER_SIZE);
        numberGenerator = new NumberGenerator(NUMBER_SIZE);
    }

    public void run(){
        numberGenerator.generate();

        playOneRound();
    }

    private void playOneRound(){
        int[] generatedNumber = numberGenerator.getNumber();
        int[] inputNumber = inputOutputManager.askUserInputNumber();

        compare(inputNumber, generatedNumber);
        handleResult();
    }

    private void compare(int[] inputNumber, int[] generatedNumber){
        // TODO 변수 인수값에 대한 예외 처리

        strike = 0;
        ball = 0;

        for(int i = 0; i < inputNumber.length; i++){
            if(inputNumber[i] == generatedNumber[i]){
                strike++;
                continue;
            }

            if(isContains(generatedNumber, inputNumber[i])){
                ball++;
            }
        }
    }

    private boolean isContains(int[] array, int value){
        for(int i = 0; i < array.length; i++){
            if(array[i] == value){
                return true;
            }
        }

        return false;
    }

    private void handleResult(){
        inputOutputManager.printResult(strike, ball);

        if(strike == NUMBER_SIZE){
            doItWhenGameWin();
            return;
        }

        // 숫자를 모두 맞추지 못했다면 다시 한 라운드 시작
        playOneRound();
    }

    private void doItWhenGameWin(){
        inputOutputManager.printWinMessage();
        int answer = inputOutputManager.askRestartGame();
        if(answer == ANSWER_YES){
            run();
        }
        
        // 게임 종료
    }
}
