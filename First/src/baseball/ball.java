package baseball;

import java.util.Random;
import java.util.Scanner;

public class ball {

	static int compu = 0;
    static int number = 0;
    static int strike = 0, ball = 0;
    static int com[] = new int[3];
    static int me[] = new int[3];
    static Random ran = new Random();
    static boolean flag = true;
    static int i=0,j=0;
    
    //메인
    //indent depth 1
    public static void main(String[] args) {
        
        Randommake();
        
        flag = true;
        
        while(flag!=false) {
            Putnumber();
            FindSB();
            Print();
        }
    }
    
    
    //컴퓨터가 3자리 수 정하기
    //indent depth 1
    static void Randommake(){
    
    	for(int k=0; k<3; k++) com[k] =0;
        // 랜덤으로 값 설정 (겹치지 않는 세 자리 수)
        while (com[0] == 0)
            com[0] = ran.nextInt(10);
        while (com[0] == com[1] || com[1] == 0)
            com[1] = ran.nextInt(10);
        while (com[0] == com[2] || com[1] == com[2] || com[2] == 0)
            com[2] = ran.nextInt(10);

        compu = com[0] * 100 + com[1] * 10 + com[2];
        
    }
    
    //값 넣기
    //indent depth 0
    static void Putnumber() {
        
        System.out.println("숫자를 입력해주세요 : ");
        Scanner sc = new Scanner(System.in);
        number = sc.nextInt();
        
        me[0] = number / 100;
        me[1] = (number % 100) / 10;
        me[2] = number % 10;
        
    }
    
    //스트라이크 & 볼 갯수 찾기
    //indent depth 2
    static void FindSB() {
        
        strike = 0;
        ball = 0;
        
        for (i = 0; i < 3; i++) {
            for (j = 0; j < 3; j++) {
                check();
            }
        }
    }
    
    //실제로 스트라이크 & 볼 갯수 세기
    //indent depth 1
    static void check() {
        if (i == j && com[i] == me[j])
            strike++;
        else if (i != j && com[i] == me[j])
            ball++;
    }
    
    //출력하기
    //indent depth 1
    static void Print() {
        
        if(strike == 0 && ball == 0) System.out.println("낫싱");
        if(strike != 0)    System.out.println(strike + " 스트라이크");
        if(ball != 0) System.out.println(ball + "볼");
        if(compu == number)    Finish();
        
    }
    //종료하기 -> 1. 게임 새로 시작, 2. 종료 선택
    //indent depth 1
    static void Finish() {
        
        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        
        Scanner sca = new Scanner(System.in);
        int play = sca.nextInt();
        
        if(play == 1) {
            Randommake();
            number = 0;
        }
        else if(play == 2) flag = false;
    }
	
}
