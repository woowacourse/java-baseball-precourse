import java.util.List;
/**
 * SingleGame 클래스에선 실제 게임 한 판이 수행됩니다.
 * 사용자가 정답(target)을 맞출 때까지 지속됩니다.
 */


public class SingleGame {

    public static InputOutput io;

    public SingleGame() {
        io = new InputOutput();
    }

    public boolean startGame(int digit) {
        RandomNumberGenerator prng = new RandomNumberGenerator();
        List target = prng.generate(digit);

        Judgement judge = new Judgement(digit);
        List input;
        Score score;

        /* debug code */
        System.out.print("Target is: ");
        for (Object it : target)
            System.out.print(it);
        System.out.println();

        do {
            input = io.getInput(digit);
            score = judge.judge(input, target);
            io.printResult(score, digit);
            input.clear();
        } while (score.strikeCount != digit);

        if (!io.isExit()) {
            return false;
        }

        return true;    //게임 새로 시작
    }
}
