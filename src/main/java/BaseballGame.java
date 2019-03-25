import java.util.*;
import java.io.Console;

public class BaseballGame {
    // 1에서 9 사이의 서로 다른 임의의 정수 3개를 생성하여 배열로 반환.
    private static int[] randIntArray() {
        int[] arr = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9};
        Random rand = new Random();

        // Fisher–Yates shuffle
        int j, temp;
        for (int i = arr.length - 1; i >= 0; i--) {
            j = rand.nextInt(arr.length);
            temp = arr[j];
            arr[j] = arr[i];
            arr[i] = temp;
        }

        return Arrays.copyOfRange(arr, 0, 3);
    }

    // 지정된 길이만큼의 숫자열을 입력받아 각각 배열에 넣어 반환하는 함수.
    // 사용자 입력을 유도하는 메시지 또한 출력한다.
    // 입력 오류시 오류 메시지를 출력한 후 0으로 초기화된 배열을 반환한다.
    private static int[] getIntArray(int length, String msg) {
        int[] arr = new int[length];
        Console console = System.console();

        try {
            String inputData = console.readLine(msg);

            if (inputData.length() != length)
                throw new Exception("오류: 잘못된 길이의 입력입니다.");

            for (int i = 0, j; i < inputData.length(); i++) {
                j = inputData.charAt(i) - '0'; // type casting (char -> int)
                if (j < 0 || j > 9) {
                    throw new Exception("오류: 잘못된 숫자 입력입니다.");
                } else {
                    arr[i] = j;
                }
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return new int[length];
        }

        return arr;
    }

    // 정수 배열에서 사용하는 간단한 indexOf() 함수.
    private static int intArrayIndexOf(int[] array, int target) {
        for (int i = 0; i < array.length; i++) {
            if (array[i] == target) {
                return i;
            }
        }
        return -1;
    }

    // 두 개의 배열을 받아, 게임 결과 판정을 문자열로 반환한다.
    private static String judgement(int[] right, int[] answer) {
        int[] judge = new int[2];
        int temp;

        // 들여쓰기 깊이 제한을 충족하기 위한 코드 변경
        for (int i = 0; i < answer.length; i++) {
            temp = intArrayIndexOf(right, answer[i]);
            if (temp == i) {
                judge[0]++;
            } else if (temp != -1) {
                judge[1]++;
            }
        }

        String strike = judge[0] > 0 ? String.format("%s 스트라이크 ", judge[0]) : "";
        String ball = judge[1] > 0 ? String.format("%s볼", judge[1]) : "";

        if (judge[0] == 0 && judge[1] == 0) {
            return "낫싱";
        } else {
            return strike + ball;
        }
    }

    // 실제 게임을 진행하는 함수.
    private static void game() {
        int[] right = randIntArray();
        int[] answer;
        String result;

        // cheat code - 주석처리
        // for (int var : right) {
        //     System.out.print(var);
        // }
        // System.out.println();

        do {
            answer = getIntArray(3, "숫자를 입력해주세요 : ");
            result = judgement(right, answer);
            System.out.println(result);
        } while (!"3 스트라이크 ".equals(result));

        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
    }

    // 메인 함수.
    public static void main(String[] args) {
        int[] running = new int[]{1};
        while (running[0] == 1) {
            game();
            running = getIntArray(1,
                    "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.\n");
        }
    }
}