/*
 * Batter.java
 *
 * 2019/12/3
 */

import java.util.LinkedHashSet;

/**
 * Precourse 1주차
 * Batter.java
 * Purpose : 숫자 야구게임에서 컴퓨터(상대방)에 해당하는 클래스
 *
 *   @version         1.00 2019/12/3
 *   @author          김태헌
 */
class Batter {
    private final static int BATTING_COUNT = 3;     //컴퓨터의 배팅횟수를 나타내주는 static 상수
    private LinkedHashSet<Integer> batting;         //컴퓨터의 batting 위치를 순서대로 나타내주는 LinkedHashSet

    /**
     * Batter class 의 생성자. Batting 에 대한 LinkedHashSet 인스턴스를 생성해주고,
     * 1부터 9사이의 3개의 랜덤 정수를 중복되지 않게 넣어준다.
     */
    public Batter() {
        batting = new LinkedHashSet<>();
        while (batting.size() != BATTING_COUNT) {
            Integer tmp = (int) (Math.random() * 9 + 1);
            batting.add(tmp);
        }
    }

    /**
     * boolean game 메소드. Batter class 의 현재 인스턴스와 Parameter 로 전달받은 Pitcher instance 를 비교하여
     * 게임의 결과를 출력해주고, 게임의 종결 여부를 boolean 값으로 반환해준다.
     *
     * @param user the user(Pitcher) instance.
     * @return 게임의 종료 여부를 알려주는 boolean
     */
    public boolean game(Pitcher user) {
        int[] pitch = user.getPitching();
        Object[] bat = batting.toArray();
        int strike = 0;
        int ball = 0;
        int nothingFlag = 0;

        if (pitch[0] == 0) {

            /* Parameter 로 전달받은 Pitch instance 가 초기화 되지 않은 경우, 에러로 판단하여 처리해준다. */
            System.out.println("Error 로 인해 다시 게임을 시작합니다.");
            return false;       //Game 재개
        }
        for (int i = 0; i < BATTING_COUNT; i++) {
            if (batting.contains(pitch[i]) && (int) bat[i] == pitch[i]) {

                /* 사용자의 pitching 값과 순서가 컴퓨터의 batting 순서와 동일한 경우 strike 와 nothing flag 를 수정해준다.*/
                strike++;
                nothingFlag++;
            } else if (batting.contains(pitch[i]) && (int) bat[i] != pitch[i]) {

                /* 사용자의 pitching 값이 컴퓨터의 batting 값중에 하나와는 일치하지만, 순서가 다른경우 ball 과 nothing flag 를 수정해준다.*/
                ball++;
                nothingFlag++;
            }
        }
        if (nothingFlag == 0) {

            /* 사용자의 pitching 값이 컴퓨터의 batting 값과 일치하는게 하나도 없는 경우 nothing 을 출력해준다. */
            System.out.println("낫씽");
            return false;       //게임 재개
        } else {

            /* nothing 이 아닌 경우, 게임 결과를 출력해주고 strike 가 3개인 경우 게임이 종료되었음을 return 해준다. */
            if (strike == 3) {
                System.out.println("3 스트라이크");
                return true;            //게임 종료
            } else if (strike == 0 && ball != 0) {
                System.out.println(ball + " 볼");
                return false;           //게임 재개
            } else if (strike != 0 && ball == 0) {
                System.out.println(strike + " 스트라이크");
                return false;           //게임 재개
            } else if (strike != 0 && ball != 0) {
                System.out.println(strike + " 스트라이크 " + ball + " 볼");
                return false;           //게임 재개
            }
            return false;               //게임 재개
       }
    }

}
