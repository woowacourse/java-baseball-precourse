package BaseBall.java;

import java.util.Scanner;


/**
 * Main클래스에서 computer객체를 생성하고, 게임을 진행한다.
 */

public class Main {

    
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        
        Computer com = new Computer();             // Computer객체 생성
        Scanner sc = new Scanner(System.in);        
        int isEnd=0;    //종료조건을 위한 변수
        int num;        //입력받는 숫자를 위한 변수
        while(isEnd<2)
        {            
            isEnd=0;                 //게임을 초기화
            com.makeNumber();        //게임을 초기화         
            while(isEnd<1){                
                num=com.playGame();
                /* isEnd의 값에 따라 게임을 종료할지, 새로 시작할지, 계속진행할지 결정*/
                isEnd=com.isGameEnd(num / 100 % 10,num / 10 % 10,num % 10); 
            }
        }
    }

}
