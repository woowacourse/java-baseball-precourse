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

    Scanner SC = new Scanner(System.in);

    /**
     * 게임의 시작여부를 사용자로 부터 입력 받고 리턴 해주는 메소드
     * @return true : 게임 시작 false : 게임 종료
     */
    public boolean startChecker() {
        int start = SC.nextInt();

        if(start == 1) {
            return true;
        } else if(start == 0) {
            return false;
        } else {
            System.out.println("잘못된 입력입니다.");
            return startChecker();
        }
    }

}
