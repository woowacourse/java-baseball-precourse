package baseball.model;

import java.util.List;

public class BaseBallGame {
    private ParameterSet parameterSet;
    private List<Integer> randomDigitList;

    public BaseBallGame(ParameterSet givenParameterSet) {
        parameterSet = givenParameterSet;
    }

    public void generateRandomDigits() {
        randomDigitList = DataGenerator.generateRandomDigitList(parameterSet);
    }
}
