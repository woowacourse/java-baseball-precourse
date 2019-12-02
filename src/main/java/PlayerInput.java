import java.util.Scanner;

/**
 * 클래스 이름      PlayerInput
 * 버전 정보        1.0
 * 날짜            2019.11.30
 * 저작권          YebinK
 */

public class PlayerInput {
    /* 사용자의 입력을 받는 클래스 */

    /** 사용자에게 받은 입력 숫자를 저장 */
    private int [] input = new int[3];

    /**
     * 사용자의 입력을 string으로 받음
     */
    public int[] getInput() {
        System.out.println("숫자를 입력해주세요: ");
        Scanner sc = new Scanner(System.in);
        String s = sc.next();

        stringToIntArr(s);

        return input;
    }

    /**
     * 입력받은 string s를 char로 쪼개 input 변수에 저장
     */
    public void stringToIntArr(String s) {
        input[0] = s.charAt(0) - '0';
        input[1] = s.charAt(1) - '0';
        input[2] = s.charAt(2) - '0';
    }
}