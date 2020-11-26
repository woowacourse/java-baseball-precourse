package baseball;

public class Validate {
    public boolean validate(int number) {
        int first = number / 100;
        int second = (number % 100) / 10;
        int third = number % 10;

        if (number >= 1000 || number < 100) {
            return false;
        }
        else if (first == second || first == third || second == third) {
            return false;
        }
        return true;
    }
}
