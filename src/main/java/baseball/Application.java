package baseball;


import baseball.computer.Computer;

public class Application {
    public static void main(String[] args) {
        //computer 클래스 생성
        Computer computer= new Computer();
        //맞춰야 하는 target 숫자 생성
        computer.makeTarget();

    }
}
