package baseball;

import java.util.List;

import service.ComputerRandomNum;
import service.JudgeResult;
import util.InputUtil;

public class Application {
    public static void main(String[] args) {
        //TODO: 숫자 야구 게임 구현
    	//컴퓨터 숫자 생성
    	ComputerRandomNum clearNumber = new ComputerRandomNum();
    	InputUtil inputUtil = new InputUtil();
        JudgeResult judge = new JudgeResult();

        boolean again = true;
        
        while (again){
            List<Integer> computer = clearNumber.getComputerNumber();
            String result = "";
            while (!result.equals("3스트라이크")){
                result = judge.judgement(computer, inputUtil.userNumber());
                System.out.println(result);
            }
            again = inputUtil.replay();
        }
    }
    

}
