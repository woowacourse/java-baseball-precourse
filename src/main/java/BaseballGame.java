import java.util.Scanner;

public class BaseballGame {
    public static void main(String[] args) {
    }

    int[] makeComNum() {
        int[] comNum = new int[3];
        int[] checkOverlap = new int[10];

        for (int i = 0; i < 3; i++) {
            comNum[i] = (int) (Math.random() * 9) + 1;

            if (checkOverlap[comNum[i]] == 0) {
                checkOverlap[comNum[i]]++;
            } else {
                i--;
                continue;
            }
        }
        return comNum;
    }

    int[] makeUserNum(int userInput) {
        int[] userNum = new int[3];

        for (int i = 2; i >= 0; i--) {
            userNum[i] = userInput % 10;
            userInput /= 10;
        }

        return userNum;
    }

    int[] countResult(int[] comNum, int[] userNum) {
        int[] result = new int[2];
        int[] num = new int[10];

        for (int i = 0; i < 3; i++) {
            num[comNum[i]]++;
        }

        for (int i = 0; i < 3; i++) {
            if (comNum[i] == userNum[i]) {
                result[0]++;
            } else if (num[userNum[i]] != 0) {
                result[1]++;
            }
        }

        return result;
    }
}
