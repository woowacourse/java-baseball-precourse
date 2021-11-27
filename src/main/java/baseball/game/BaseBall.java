package baseball.game;

public class BaseBall {

    private Integer[] baseballNumbers;

    public BaseBall(Integer[] baseballNumbers) {
        this.baseballNumbers = baseballNumbers;
    }

    public BaseBall(String numbers) {
        this.baseballNumbers = convertStringToArray(numbers);
    }

    public Integer[] getBaseballNumbers() {
        return baseballNumbers;
    }

    private Integer[] convertStringToArray(String numbers) {
        return numbers.chars()
            .map(Character::getNumericValue)
            .boxed()
            .toArray(Integer[]::new);
    }

}
