package baseball;

import java.util.Scanner;

import modules.InputOutputManager;
import modules.NumberGenerator;

public class GameManager {
    InputOutputManager inputOutputManager;
    NumberGenerator numberGenerator;

    int strike = 0;
    int ball = 0;

    public GameManager(Scanner scanner){
        inputOutputManager = new InputOutputManager(scanner);
        numberGenerator = new NumberGenerator();
    }

    public void run(){
        numberGenerator.generate();

        playOneRound();
    }

    private void playOneRound(){}
}
