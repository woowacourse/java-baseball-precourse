/*
 * 숫자 야구 게임을 수행하는 클래스
 *
 * @version 1.0
 *
 * @date 2019.12.02
 * 
 * @author Jung dahee
 */
 
import java.util.Scanner;

public class BaseballGame {

    String player1 = null;
    String player2 = null;
    Printer printer = new Printer();
    InputVerification input = new InputVerification();

    public BaseballGame() {
        setGame();
        play();
    }
 
    /*
     * 게임을 시작하기 전에 player1을 셋팅하는 메소드
     */
    private void setGame() {
        boolean isUnique = false;
    	
        while(!isUnique){
            player1 = Computer.make();
            isUnique = input.checkData(player1);
        }
    }
 
    /*
     * 전체적인 게임의 로직을 관리하는 메소드
     */
    private void play(){
        boolean isCorrect = false;
        boolean isUnique = false;
        player2 = null;
    	
        while(true){
            printer.printMessage(0);
            player2 = inputData();
            
            if(player2 == null) {
                continue;
            }
            
            isUnique = input.checkData(player2); 
            
            if(isUnique) {
                isCorrect = judge();
            } else {
                printer.printMessage(1);
            }
            
            if(isCorrect) {
                end();
            }
        }
    }
 
    /*
     * 플레이어로부터 입력 값을 받는 메소드
     */
    private String inputData() {
    	   Scanner sc = new Scanner(System.in);
    	   String data = sc.nextLine();
    	
    	   if(data.equals("")) {
    		      printer.printMessage(2);
    		      return null;
    	   } else {
    		      return data;
    	   }
    }
 
    /*
     * 스트라이크, 볼을 판단하는 메소드
     */
    private boolean judge(){ 
        int strikeCnt = 0;
        int ballCnt = 0;
        
        for(int i = 0; i < 3; i++) {
            strikeCnt += compareNum(player1.charAt(i), player2.charAt(i));
            ballCnt += containNum(player2.charAt(i));
        }

        printer.printResult(strikeCnt, ballCnt);
        
        return (strikeCnt == 3);
    }
 
    /*
     * 숫자를 비교하는 메소드
     */
    private int compareNum(char c, char d) {
        int sameCnt = 0;
    	
        if(c == d) {
    	       sameCnt++;
    	   } 
    	   return sameCnt;
    }
}
