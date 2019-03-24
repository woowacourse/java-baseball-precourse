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
 * @version        1.00     2019년   3월  23일
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

}
