package xyz.zerobell.woowa.javabaseball;

import java.util.Scanner;

public class Main {

    private static int[] numCheck; //사용된 번호를 확인하기 위한 배열 전역변수. 중복값 방지를 위함.

    private static String genRandNum() {
        numCheck = new int[10];
        int tmpDigit;
        int digitCount = 0;     //자릿수를 세기 위한 변수
        String result = "";

        while (digitCount < 3) {
            tmpDigit = (int)(Math.random() * 9 + 1);
            if (numCheck[tmpDigit] > 0) {
                continue;   // 이미 numCheck에 존재한다면 중복으로 간주하고 while을 다시 실행한다.
            }
            else {
                digitCount++;
                result += tmpDigit;
            }
        }

        return result;
    }

    private static boolean isValid(String s1) {
        /*
         * TO-DO : Check validity of input value.
         */
        return true;
    }

    private static int[] match(String answer, String input) {
        /*
         * TO-DO : 정답과 입력값을 match하여 반환. [Strike, Ball]의 형식으로 반환한다.
         */
        return new int[] {3, 0};
    }

    private static String toMatchResult(int[] matchResult) {
        /*
         * TO-DO : 매칭된 결과에 따라 스트링 포맷을 적절하게 출력
         */
        return "2 스트라이크";
    }

    private static boolean makeGame() {
        int[] matchResult;
        int nextGame;
        String answer;
        String inputValue;
        Scanner sc = new Scanner(System.in);

        answer = genRandNum();
        System.out.print("숫자를 입력해주세요 : ");
        inputValue = sc.next();

        while (!isValid(inputValue)) {
            // 유효하지 않을 경우
            System.out.println("유효하지 않은 값입니다. 1. 1부터 9까지의 숫자 중에서, 2. 중복 없이, 3. 3자리인 수를 입력해주세요.");
            inputValue = sc.next();
        }

        while (true) {
            matchResult = match(answer, inputValue);
            if (matchResult[0] == 3) {
                // 정답일 경우
                System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임종료\n게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
                break;

            }
            else {
                // 오답일 경우 다시 반복
                System.out.println(toMatchResult(matchResult));
            }
        }

        while (true) {
            try {
                nextGame = sc.nextInt();
            }
            catch (Exception e) {
                System.out.println("올바른 정수를 입력해주세요!");
                continue;
            }

            if (nextGame == 1) {
                return true;
            }
            else if (nextGame == 2) {
                return false;
            }
            else {
                System.out.println("올바른 정수를 입력해주세요!");
                continue;
            }
        }

    }

    public static void main(String[] args) {
        while (makeGame()); //마지막 입력값에 따라 계속하기와 그만두기를 결정할 수 있음.
    }
}
