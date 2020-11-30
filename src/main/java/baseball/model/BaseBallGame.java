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

    public ResultSet compareDigits(String digits) {
        int numberOfStrikes = 0;
        int numberOfBalls = 0;
        int aDigit;

        for (int i = 0; i < digits.length(); i++) {
            aDigit = Character.getNumericValue(digits.charAt(i));

            if (this.randomDigitList.get(i) == aDigit) {
                numberOfStrikes++;
                continue;
            }

            if (this.randomDigitList.contains(aDigit)) {
                numberOfBalls++;
            }
        }

        ResultSet resultSet = new ResultSet(numberOfStrikes, numberOfBalls);
        return resultSet;
    }
}
