package utils.validator;

public class DuplicateValidator implements Validator {

    @Override
    public boolean execute(String userInput) {
        String[] inputArray = userInput.split("");

        if (inputArray[0].equals(inputArray[1]) || inputArray[0].equals(inputArray[2]) || inputArray[1].equals(inputArray[2])) {
            return true;
        }

        return false;
    }
}
