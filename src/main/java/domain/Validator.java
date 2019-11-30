package domain;

@FunctionalInterface
public interface Validator {

    String compareRandomNumberWithUserNumber(int randomNumber, int userInput);

}
