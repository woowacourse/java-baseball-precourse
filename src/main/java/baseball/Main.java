/**
 * 우아한 테크코스 1주차 - 숫자 야구
 * 메인 클래스
 *
 * @version         0.1
 * @author          황성찬
 */
package baseball;

import baseball.CreateList;

import java.util.ArrayList;

public class Main {

    public static void main(String[] args){

        CreateList userYou = new CreateList();
        CreateList userComputer = new CreateList();
        System.out.println("당신의 숫자 : "+userYou.nums);
        System.out.println("컴퓨터의 숫자 : "+userComputer.nums);

    }
}
