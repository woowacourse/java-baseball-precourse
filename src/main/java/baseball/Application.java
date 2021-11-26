package baseball;


import baseball.computer.Computer;
import baseball.umpire.Umpire;
import baseball.user.User;

public class Application {
    public static void main(String[] args) {
        //computer 클래스 생성
        Computer computer = new Computer();

        User user = new User();
        user.getInput();
//        System.out.println(user.input[0]);
//        System.out.println(user.input[1]);
//        System.out.println(user.input[2]);

        Umpire umpire = new Umpire();
        umpire.checkResult(computer.target, user.input);
//        umpire.isEnd();
//        System.out.println("target");
        for (int i : computer.target) {

            System.out.print(i);
        }

//        System.out.println("\nst");
//        System.out.println(umpire.strike);
//        System.out.println("ball");
//        System.out.println(umpire.ball);
//
    }
}
