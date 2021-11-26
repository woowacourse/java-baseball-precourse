package baseball;

public class Game {

    Answer answer = new Answer();

    public void start() {
        System.out.println("게임이 시작됐습니다. / test");
        System.out.println(answer.answer);
    }

    public boolean afterGame() {
        return false;
    }

}
