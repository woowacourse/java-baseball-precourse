/**
 * GamaManager.class        0.1 2019/03/26
 *
 * <Copyright 2019. LeeNamJun. All rights reserved.>
 */


package JavaBaseball;

/**
 * 게임을 관리하고 플레이하도록 해주는 클래스
 *
 * @version 0.1 2019/03/26
 * @author 이남준
 */
public class GamaManager {

    public static void main(String[] args) {

    }

    /**
     * 시작 여부를 묻는 메뉴를 출력해주는 메소드
     */
    private static void startMenu() {
        System.out.println("-------------------------------");
        System.out.println("          숫자 야구 게임");
        System.out.println("-------------------------------");
        System.out.println("Start : 1              Exit : 0");
    }

    /**
     * 시작 / 종료 메시지를 출력해주는 메소드
     * @param input 유저의 스타트 메뉴에서의 입력 값
     */
    private static void startMessage(boolean input) {
        if(input) {
            System.out.println("게임을 시작합니다!");
        } else {
            System.out.println("게임을 종료합니다.");
            System.exit(0);
        }

    }

    /**
     * 유저에게 세자리 수를 입력하라는 메시지를 출력하는 메소드
     * @param user User 오브젝트
     * @return 유저가 입력한 세자리 수
     */
    private static int[] getUserNumber(User user) {
        System.out.println("세자리 수를 입력 하세요 :");
        return user.getNumber();
    }

}


