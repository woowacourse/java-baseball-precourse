package baseball;

public class Test {

    public static void main(String[] args) {
        String input = "abc";
        Validator validator = new Validator();
        validator.validateNumberInput(input);

        System.out.println("성공!!");
    }
}
