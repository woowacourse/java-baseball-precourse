package main.java;

/**
 * Computer 클래스는 컴퓨터가 할 수 있는 행동들을 메소드로 정의한다.
 */

import java.util.Scanner;


public class Computer {
    
    private int num1, num2, num3; //컴퓨터가 생성하는 3개의 숫자    
    Scanner sc = new Scanner(System.in);        
    /* 게임을 시작하기 위해 초기화 한다 */
    public void makeNumber() {
        do{
            /* 각 숫자들을 랜덤으로 생성을 한다. */
          num1 = (int) (Math.random() * 8) + 1;
          num2 = (int) (Math.random() * 8) + 1;
          num3 = (int) (Math.random() * 8) + 1;
        }while(num1 == num2 || num3 == num2 || num1 == num3); /* 숫자를 생성할 때 숫자가 겹치지 않을때까지 반복한다*/
    }
    
}
