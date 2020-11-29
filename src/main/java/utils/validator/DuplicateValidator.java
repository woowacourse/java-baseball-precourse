package utils.validator;

public class DuplicateValidator implements Validator {
    @Override
    public boolean execute(String userInput) {
        int[] countNumber = new int[10];

        for (String input : userInput.split("")){
            int intInput = Integer.parseInt(input);

            if (++countNumber[intInput] > 1) {
                return false;
            }
        }

        return true;
    }
}
