import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.Random;
import java.util.Scanner;
import java.util.Set;

public class BaseballGame {

    public static ArrayList<String> generateRandomNumber() {
        Random rand = new Random();
        ArrayList<String> resultArray = new ArrayList<String>(3);
        Set<String> set = new LinkedHashSet<String>();

        while (set.size() < 3) {
            set.add(Integer.toString(rand.nextInt(9) + 1));
        }

        for (String x : set) {
            resultArray.add(x);
        }
        //  System.out.println(resultArray);
        return resultArray;
    }

    public static boolean checkResult(ArrayList<String> input1, String input2) {
        int strikeCount = 0;
        int ballCount = 0;
        boolean isNothing = false;

        ArrayList<String> computerInputArray = input1;
        ArrayList<String> userInputArray = new ArrayList<String>();

        for(int i = 0; i < input2.length(); i++) {
            userInputArray.add(String.valueOf(input2.charAt(i)));
        }

        for(int i = 0; i < userInputArray.size(); i++) {
            if (computerInputArray.get(i).equals(userInputArray.get(i)) == true) {
                strikeCount++;
            } else if (computerInputArray.contains(userInputArray.get(i)) == true) {
                ballCount++;
            }
        }

        if (strikeCount == 0 && ballCount == 0) {
            isNothing = true;
        }

        if (isNothing == true) {
            System.out.println("낫싱");
        } else if (strikeCount == 3) {
            System.out.println("3개의 숫자를 모두 맞추셨습니다. 게임 종료.");
            return true;
        } else {
            System.out.println(strikeCount + " 스트라이크 " + ballCount + " 볼");
        }
        return false;
    }

    public static void playGame() {
        Scanner userInput = new Scanner(System.in);
        ArrayList<String> computerNumber = generateRandomNumber();
        boolean isCorrect = false;

        do {
            System.out.println("숫자를 입력해주세요 : ");
            String userNumber = userInput.next();
            isCorrect = checkResult(computerNumber, userNumber);
        } while (isCorrect == false);

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
