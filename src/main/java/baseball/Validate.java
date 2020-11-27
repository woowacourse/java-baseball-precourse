package baseball;

public class Validate {
    public static boolean validate(int number) {
        int first = number / 100;
        int second = (number % 100) / 10;
        int third = number % 10;

        if (first == 0 || second == 0 || third == 0) {
            return false;
        }
        else if (number >= 1000 || number < 100) {
            return false;
        }
        else if (first == second || first == third || second == third) {
            return false;
        }
        return true;
    }
}
