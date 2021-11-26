package baseball;


import baseball.computer.Computer;
import baseball.umpire.Umpire;
import baseball.user.User;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class Application {
    public static void main(String[] args) {
        //클래스 생성
        Computer computer;
        User user = new User();
        Umpire umpire = new Umpire();

        int end =1;

        while(end==1){
            computer = new Computer();
            game(computer,user,umpire);
            umpire.init();
            System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
            System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
            end = Integer.valueOf(readLine());
        }
    }

    private static void game(Computer computer, User user, Umpire umpire){
        while (!umpire.isEnd()){
            umpire.init();
            user.getInput();
            umpire.checkResult(computer.target, user.input);
        }
    }
}
