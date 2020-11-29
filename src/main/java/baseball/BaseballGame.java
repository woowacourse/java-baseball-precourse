package baseball;

public class BaseballGame {

    public void run(){

        Computer computer = new Computer();
        Player player = new Player();

        //랜덤 숫자 생성
        computer.makeRandomNumber();

        String inputNumber = "";

        do{
            inputNumber = player.getNumber();

            if(computer.checkStrikeAndBall(inputNumber)){
                break;
            }
        }while(true);

    }
}
