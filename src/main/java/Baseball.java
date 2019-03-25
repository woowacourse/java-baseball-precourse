/*
 * 클래스 이름: Baseball
 *
 * 날짜: 2019.03.22~2019.03.28
 */

import java.util.Arrays;
import java.util.Scanner;

public class Baseball {
    /*
     * 입력 값이 유효한지 검사하는 매서드
     * 유효성 검사
     *  (1) 입력 숫자가 3자리인지 확인
     *  (2) 입력 숫자에 0이 있는지 확인
     *  (3) 입력 값이 숫자만 있는지 확인
     */
    public static boolean validInput(String[] numArr) {
        if (!(numArr.length == 3)) {
            return false;
        }

        if (Arrays.toString(numArr).contains("0")) {
            return false;
        }

        try {
            for (String num : numArr) {
                Integer.parseInt(num);
            }
        } catch (NumberFormatException e) {
            return false;
        }

        for(int i=1; i<numArr.length; i++){
            if(numArr[i].equals(numArr[0])){
                return false;
            }
        }

        if(numArr[1].equals(numArr[2])){
            return false;
        }

        return true;
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        Game game = new Game();
        String[] numArr;
        boolean flag = false; // while문을 탈출하기 위한 변수

        while (!flag) {
            do {
                System.out.print("숫자를 입력해주세요: ");
                numArr = input.next().split("");
            } while (!validInput(numArr));

            game.compareAnswer(numArr);
            flag = game.checkAnswer();
            game.print();

            if (flag) {
                System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
                System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");

                int temp = input.nextInt();
                flag = game.exitGame(temp);
            }
        }
    }
}
