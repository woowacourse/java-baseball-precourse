import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.Random;
import java.util.Scanner;
import java.util.Set;

public class BaseballGame {

    private static ArrayList<String> generateRandomNumber() {
        Random rand = new Random();
        ArrayList<String> resultArray = new ArrayList<String>(3);
        Set<String> set = new LinkedHashSet<String>();

        while (set.size() < 3) {
            set.add(Integer.toString(rand.nextInt(9) + 1));
        }

        resultArray.addAll(set);
        //  System.out.println(resultArray);
        return resultArray;
    }

    private static boolean checkResult(ArrayList<String> computerInputArray, String userInputString) {
        int strikeCount = 0;
        int ballCount = 0;
        boolean isNothing = false;

        ArrayList<String> userInputArray = new ArrayList<String>();

        for(int i = 0; i < userInputString.length(); i++) {
            userInputArray.add(String.valueOf(userInputString.charAt(i)));
        }

        for(int i = 0; i < userInputArray.size(); i++) {
            if (computerInputArray.get(i).equals(userInputArray.get(i))) {
                strikeCount++;
            } else if (computerInputArray.contains(userInputArray.get(i))) {
                ballCount++;
            }
        }

        if (strikeCount == 0 && ballCount == 0) {
            isNothing = true;
        }

        if (isNothing) {
            System.out.println("낫싱");
        } else if (strikeCount == 3) {
            System.out.println("3개의 숫자를 모두 맞히셨습니다. 게임 종료.");
            return true;
        } else {
            System.out.println(strikeCount + " 스트라이크 " + ballCount + " 볼");
        }
        return false;
    }

    private static void playGame() {
        Scanner userInput = new Scanner(System.in);
        ArrayList<String> computerNumber = generateRandomNumber();
        boolean isCorrect;

        do {
            System.out.println("숫자를 입력해주세요 : ");
            String userNumber = userInput.next();
            isCorrect = checkResult(computerNumber, userNumber);
        } while (!isCorrect);
    }

    public static void main(String[] args) {
        String userChoice = "";
        Scanner input = new Scanner(System.in);

        while (!userChoice.equals("2")) {
            playGame();
            System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요. ");
            userChoice = input.next();
        }
    }
}
