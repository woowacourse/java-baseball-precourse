package domain;

@FunctionalInterface
public interface Validator {

    String compareRandomNumberWithUserInput(int randomNumber, int userInput);

}
