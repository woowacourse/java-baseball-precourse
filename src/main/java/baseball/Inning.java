/*
 *  @(#)Game.java       1.00    2019/03/25
 *
 *  Copyright   (c) 2019 Myungki Sa.
 *  Computer Science Engineering, Java, Daejeon, Korea
 *  All rights reserved.
 */

package baseball;

/**
 * Inning Class는 한 이닝을 위한 클래스이다.
 * 인스턴스 변수 strike과 ball이 있다.
 * 메서드는 toString 메서드 하나이며, 갯수에 따라 출력할 String을 반환한다.
 *
 * @version        1.00     2019년   3월  25일
 * @author         사명기
 */
public class Inning{

    /** 인스턴스 변수 strike. strike 갯수를 저장한다. */
    int strike;

    /** 인스턴스 변수 ball. ball의 갯수를 저장한다.*/
    int ball;

    /**
     * Inning 클래스의 생성자.
     * @param strike
     * @param ball
     */
    public Inning(int strike,int ball){
        this.strike=strike;
        this.ball=ball;
    }

    /**
     * 스트라이크, 볼 갯수에 따라 결과를 String으로 반환하기 위한 메서드.
     * @return
     */
    public String getResultToString(){
        StringBuilder sb=new StringBuilder();

        if(this.strike>0){
            sb.append(this.strike).append("스트라이크");          // 스트라이크가 1개 또는 2개이면
            if(this.ball==0){
                return sb.toString();                  // 스트라이크는 있고 볼은 없으면
            }
        }

        if(this.ball>0){
            if(this.strike>0){
                sb.append(" ");            // 볼 갯수가 0 이상이고, 스트라이크 갯수가 0 이상이면 빈칸 추가.
            }
            sb.append(this.ball).append("볼");          // 볼 갯수가 0 이상이면
            return sb.toString();
        }

        return "낫싱";        // strike, ball 모두 0이면
    }
}
