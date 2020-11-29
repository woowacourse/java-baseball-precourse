package baseball;

public class BaseballGame {

    static private Computer computer;
    static private Player player;
    static private boolean running = true;

    public void start(){
        //Computer와 Player 객체 생성
        createInstance();
        run();
    }

    private void run(){
        while(running){
            playGame();
        }
    }

    private void playGame(){
        //랜덤 숫자 생성
        computer.makeRandomNumber();

        //사용자가 숫자를 맞힐 때까지 숫자 입력 받기
        while(true) {
            String inputNumber = player.getNumber();
            if(computer.checkStrikeAndBall(inputNumber)){
                System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
                break;
            }
        }

        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        checkRestartOrEnd(player.getRestartOrEnd());
    }

    private void checkRestartOrEnd(int inputType){
        if(inputType == Constants.RESTART){
            running = true;
        }
        else if(inputType == Constants.EXIT){
            running = false;
        }
    }

    private void createInstance(){
        computer = new Computer();
        player = new Player();
    }
}
