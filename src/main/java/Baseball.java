import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Baseball {
    private static String secretNumber;
    private static String inputNumber;

    public static void main(String[] args) {
        secretNumber = makeDifferentNumbers();

        System.out.print("숫자를 입력해주세요 : ");
        inputNumber = getInputString();
        validateInput();
    }

    private static String makeDifferentNumbers() {
        int countOfCards = 3;
        int[] randomNumbers = new int[countOfCards];
        Random random = new Random();

        int i = 0;
        while (i < countOfCards) {
            int newRandomNumber = (random.nextInt(9));
            if (!isDuplicates(randomNumbers, newRandomNumber)) {
                randomNumbers[i] = newRandomNumber;
                i++;
            }
        }
        return Arrays.toString(randomNumbers).replaceAll("[^0-9]", "");
    }

    private static boolean isDuplicates(int[] array, int num) {
        for (int value : array) {
            if (value == num) {
                return true;
            }
        }
        return false;
    }

    private static String getInputString() {
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine();
    }

    private static void validateInput() {
        while(inputNumber.length() != secretNumber.length()){
            System.out.printf("%d 자리의 숫자를 입력해주세요.\n", secretNumber.length());
            inputNumber = getInputString();
        }
    }

}
