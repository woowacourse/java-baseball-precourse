import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String answer = makeNumbers();
//        System.out.println("정답: " + answer);
        String input = inputNumbers(sc);
//        System.out.println("입력값: " + input);
    }

    public static String makeNumbers() {
        String ballNumbers = "";
        int temp;

        while (ballNumbers.length() < 3) {
            temp = (int) Math.floor(Math.random() * 10);
            if ((temp != 0) && !ballNumbers.contains(String.valueOf(temp))) {
                ballNumbers += temp;
            }
        }
        return ballNumbers;
    }

    public static String inputNumbers(Scanner sc) {
        String inputNumbers = "";

        while (inputNumbers.equals("")) {
            inputNumbers = sc.nextLine();
        }
        return inputNumbers;
    }
}
