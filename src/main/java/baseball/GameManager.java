package baseball;

import java.util.Scanner;

import modules.InputOutputManager;
import modules.NumberGenerator;

public class GameManager {
    InputOutputManager inputOutputManager;
    NumberGenerator numberGenerator;

    public GameManager(Scanner scanner){
        inputOutputManager = new InputOutputManager(scanner);
        numberGenerator = new NumberGenerator();
    }
}
