package baseball;


import baseball.computer.Computer;
import baseball.user.User;

public class Application {
    public static void main(String[] args) {
        //computer 클래스 생성
        Computer computer= new Computer();

        User user = new User();
        user.getInput();
        System.out.println(user.input[0]);
        System.out.println(user.input[1]);
        System.out.println(user.input[2]);

    }
}
