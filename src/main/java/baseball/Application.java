package baseball;


public class Application {
    public static void main(String[] args) {
        //TODO: 숫자 야구 게임 구현
        BaseBall baseBall;
        do {
            baseBall = new BaseBall(
                    new Referee(),
                    new RandomNumberGenerator(),
                    new PredictInput(),
                    new DecideNextInput()
            );
            baseBall.playGame();
        } while (baseBall.decideNextGame());
    }

}
