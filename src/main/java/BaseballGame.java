public class BaseballGame {
    private Numbers numbersOfComputer;
    private User user;
    private boolean gameIsRunning;

    public BaseballGame() {
        numbersOfComputer = new Numbers();
        user = new User();
        gameIsRunning = true;
    }

    public void run() {
        while(gameIsRunning) {
            Numbers numbersFromUser = user.inputNumbers();
            compareNumbersWith(numbersFromUser);
        }
    }

    public void compareNumbersWith(Numbers numbersFromUser) {
        int strike = numbersOfComputer.countStrike(numbersFromUser);
        int ball = numbersOfComputer.countBall(numbersFromUser);

        if((strike == 0) && (ball == 0)) {
            System.out.println("낫싱");
            return;
        }

        System.out.println(strike + " 스트라이크 " + ball + " 볼");

        if(strike == 3) {
            System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
        }
    }
}