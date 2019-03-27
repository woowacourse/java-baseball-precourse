/**
 * Baseball class는 숫자 야구 게임을 위한 class이다.
 * last modified: 2019.03.27
 * author: SM Jeon
 */


import java.util.*;

public class Baseball {
    public static void main(String[] args) {
            startBaseball();
    }

    /*
     * Method for start baseball game
     * Generate Random Number, check strike and ball
     */
    private static void startBaseball() {
        String comNum = "";         // Computer number(Random Number)
        String userNum;             // User number (Input)
        boolean inputFlag = true;   // for check 3 strike
        comNum = generateRandomNumber();
        while (inputFlag) {
            userNum = "123";        // Receive Input
            inputFlag = false;      // check 3 strike
        }
    }

    /*
     * Method for Computer Number(Random Number)
     * Use Collections.shuffle
     */
    private static String generateRandomNumber() {
        String ranNum = "";                                 // return value (3 digit)
        List<Integer> numList= new ArrayList<Integer>();    // 1 to 9 number list

        for (int i = 1; i < 10; i++) {
            numList.add(i);
        }
        Collections.shuffle(numList);           // Randomize number list

        for (int i = 0; i < 3; i++) {
            ranNum += numList.get(i).toString();
        }

        return ranNum;
    }

}
