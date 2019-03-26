package BaseBall.java;
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
    
    
    public boolean calcuate(int n1, int n2, int n3)
    {
        int ball=0, strike=0; //현재 몇개의 볼과 몇개의 스트라이크를 했는지 저장하기 위한 변수
        
        /* 각각의 상황이 ball인지 strike인지 판별 */
        if(num1 == n1) 
            strike++;
        if(num2 == n2)
            strike++;
        if(num3 == n3)
            strike++;
        if(num1 == n2 || num1 == n3 )
            ball++;
        if(num2 == n1 || num2 == n3 )
            ball++;
        if(num3 == n2 || num3 == n1 )
            ball++;
        
        /* 현재의 상황을 print */
        print(strike, ball);
        
        /* strike가 3이라면 게임이 끝난경우 이므로 true를 반환 */
        if(strike==3)
            return true;
        return false;
    }
    
    public void print(int strike, int ball)
    {
        /* 각 상황에 맞게 strike와 ball을 출력 */
        if(strike!=0)
            System.out.print(strike + "스트라이크 ");
        if(ball!=0)
            System.out.println(ball + "볼");   
        if(strike==0 && ball==0)
            System.out.println("낫씽"); 
    }
    
    public int isGameEnd(int num1, int num2, int num3)
    {
        int isEnd=0;
        if(calcuate(num1,num2,num3)==true)    //숫자를 다 찾았을 때
        {
            System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임종료");
            System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
            isEnd=sc.nextInt();    
            return isEnd;
        }
        return isEnd;    //숫자를 찾지 못했을 경우 0을 리턴한다
    }
    
    public int playGame()
    {
        System.out.println("숫자입력하세요");
        int num;
        num=sc.nextInt();    //숫자를 입력받는다
        return num;
    }
}
