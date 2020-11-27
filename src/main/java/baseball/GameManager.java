package baseball;

import java.util.Scanner;

import modules.InputOutputManager;
import modules.NumberGenerator;

public class GameManager {
    public static final int NUMBER_SIZE = 3;

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
            // TODO: 승리 시의 처리
            return;
        }

        // 숫자를 모두 맞추지 못했다면 다시 한 라운드 시작
        playOneRound();
    }
}
