import java.util.Scanner;

/**
 * 플레이어(사람)이 행하는 기능
 *
 * @version         1.00 2019-1130
 * @author          김범준(ddaaac)
 */
public class Player {
    /* 플레이어는 추측을 하거나 추가 게임 여부를 정할 수 있음 */

    /**
     * 올바른 형식의 3자리 숫자를 입력받아 이 값을 리턴
     * @return 입력받은 3자리 숫자
     */
    public int guess() {
        String input;               // 입력받은 문자열
        int inputNumber;            // 문자열을 3자리 숫자로 변환한 숫자
        Scanner scan = new Scanner(System.in);

        while (true) {
            System.out.println("숫자를 입력해주세요 : ");
            input = scan.nextLine();
            try {
                inputNumber = Integer.parseInt(input);          // 문자열을 숫자로 변환
            } catch (Exception e) {                             // 숫자가 아니라면 다시 입력
                continue;
            }
            // 1~999 사이 숫자가 아니라면 다시 입력
            if (inputNumber > 0 && inputNumber < 1000) {
                break;
            }
        }

        return inputNumber;
    }
}
