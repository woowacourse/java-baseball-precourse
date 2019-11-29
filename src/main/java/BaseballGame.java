public class BaseballGame {
    public void playGame() {
        Computer com = new Computer();
        User player = new User();

        com.getRandom();
        while(com.getStrike() != 3) {
            player.inputNumber();
            com.checkAnswer(player.getInput());
        }

        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
        System.out.print("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요. ");
        int ask = player.s.nextInt();
        if(ask == 1) {
            playGame();
        }
    }

    public static void main(String[] args) {
        BaseballGame play = new BaseballGame();

        play.playGame();
    }
}