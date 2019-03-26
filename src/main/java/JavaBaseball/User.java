/**
 * User.class        0.5 2019/03/26
 *
 * <Copyright 2019. LeeNamJun. All rights reserved.>
 */

package JavaBaseball;

import java.util.Scanner;

/**
 * 게임의 유저역할을 하는 클래스
 *
 * @version         0.5 2019/03/26
 * @author          이남준
 */
public class User {

    Scanner SC;

    /**
     * 게임의 시작여부를 사용자로 부터 입력 받고 리턴 해주는 메소드
     * @return true : 게임 시작 false : 게임 종료
     */
    public boolean startChecker() {
        SC = new Scanner(System.in);
        int start = SC.nextInt();
        SC.close();

        if(start == 1) {
            return true;
        } else if(start == 0) {
            return false;
        } else {
            System.out.println("잘못된 입력입니다. 다시 입력해주세요 : ");
            return startChecker();
        }

    }

    /**
     * 유저에게 세자리 수를 입력받는 메소드
     * @return 유저가 입력한 세자리 수
     */
    public int[] getUserNumber() {
        SC = new Scanner(System.in);
        int[] userNumber = new int[3];

        userNumber[0] = SC.nextInt();
        userNumber[1] = SC.nextInt();
        userNumber[2] = SC.nextInt();
        SC.close();

        return userNumber;
    }


}
