/*
 *  @(#)Game.java       1.00    2019/03/25
 *
 *  Copyright   (c) 2019 Myungki Sa.
 *  Computer Science Engineering, Java, Daejeon, Korea
 *  All rights reserved.
 */

package baseball;


/**
 * Game Class는 게임을 위한 클래스이다.
 * 인스턴스 변수인 user와 computer가 있다.
 *
 *
 *
 * @version        1.00     2019년   3월  25일
 * @author         사명기
 */
public class Game {

    /** 인스턴스 변수인 user은 사용자이다. */
    private Player user;

    /** 인스턴스 변수인 computer은 컴퓨터다. */
    private Player computer;

    /**
     * Game 클래스의 생성자이다.
     * 내부에서는 user와 computer의 객체를 생성한다.
     */
    public Game(){
        this.user=new User();
        this.computer=new Computer();
    }

    /**
     * 숫자를 입력받기 전에 출력하는 메서드.
     */
    public void printGetNumber(){
        System.out.print("숫자를 입력해 주세요 : ");
    }

    /**
     * 한 이닝의 결과를 반환하는 메서드.
     * Inning 객체를 생성해서, 스트라이크와 볼 갯수를 count한다.
     * @return Inning 객체를 반환한다. Inning 객체에는 스트라이크, 볼 갯수가 저장되어있다.
     */
    public Inning getInningResult(){
        Inning inning=new Inning(0,0);
        for(int i=0; i<3; i++){
            if(this.user.getNumbers()[i] == this.computer.getNumbers()[i]){
                inning.strike++;                                                // 해당 자리수에 유저와 컴퓨터의 수가 같으면
            }
            else if((this.user.getNumbers()[i] == this.computer.getNumbers()[(i+1)%3])
                    || (this.user.getNumbers()[i] == this.computer.getNumbers()[(i+2)%3])){
                inning.ball++;           // 위치가 다르지만 같은 수가 있다면
            }
        }
        return inning;
    }

    /**
     * 한 이닝의 결과를 받아서 출력하는 메서드.
     * @param inning  getInningResult의 결과로 받은 파라미터.
     */
    public void printInningResult(Inning inning){
        System.out.println(inning.getResultToString());
    }

}

