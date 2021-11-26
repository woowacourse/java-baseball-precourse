package baseball;


import baseball.computer.Computer;
import baseball.umpire.Umpire;
import baseball.user.User;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class Application {
    public static void main(String[] args) {
        //computer 클래스 생성
        Computer computer = new Computer();
        User user = new User();
        Umpire umpire = new Umpire();
        boolean finish = false;

        while (!finish) {
            umpire.init();
            user.getInput();
            umpire.checkResult(computer.target, user.input);

            for (int i : computer.target) {
                System.out.print(i);
            }
            System.out.println();

        }
        if (umpire.isEnd()) {
            System.out.println("모두 맞힘! 게임종료");
            System.out.println("게임 새로 시작 1 2");
            int end = Integer.valueOf(readLine());

        }
    }
}
