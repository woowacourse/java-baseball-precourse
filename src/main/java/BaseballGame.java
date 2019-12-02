import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.Random;
import java.util.Scanner;
import java.util.Set;

public class BaseballGame {

    public static ArrayList<String> generateRandomNumber() {
        Random rand = new Random();

        Set<String> set = new LinkedHashSet<String>();
        while (set.size() < 3) {
            set.add(Integer.toString(rand.nextInt(9) + 1));
        }

        ArrayList<String> resultArray = new ArrayList<String>(3);

        for (String x : set) {
            resultArray.add(x);
        }

        System.out.println(resultArray);

        return resultArray;
    }

    public static boolean checkResult(ArrayList<String> input1, String input2) {

        int strikeCount = 0;
        int ballCount = 0;
        boolean isNothing = false;

        ArrayList<String> input1Array = input1;
        ArrayList<String> input2Array = new ArrayList<String>();

        for(int i = 0; i < input2.length(); i++) {
            input2Array.add(String.valueOf(input2.charAt(i)));
        }

        for(int i = 0; i < input2Array.size(); i++) {
            if (input1Array.get(i).equals(input2Array.get(i)) == true) {
                strikeCount++;
            } else if (input1Array.contains(input2Array.get(i)) == true) {
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

    public static void main(String[] args) {

        ArrayList<String> computerNumber = generateRandomNumber();

        Scanner input = new Scanner(System.in);

        boolean isCorrect = false;

        do {

            System.out.print("숫자를 입력해주세요 : ");
            String userNumber = input.next();

            isCorrect = checkResult(computerNumber, userNumber);

        } while(isCorrect == false);

    }
}
