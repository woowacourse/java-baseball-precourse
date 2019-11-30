package domain;

@FunctionalInterface
public interface Validator {

    public String randomNumberCompareToUserInput(int randomNumber, int userInput);

}
