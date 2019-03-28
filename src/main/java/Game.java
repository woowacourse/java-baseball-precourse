import java.util.Scanner;

public class Game {

    final private int Strike = 0;
    final private int Ball = 1;

    private Scanner sc;
    private BallCombiGenerator generator;
    private Referee referee;

    public Game() {
        sc = new Scanner(System.in);
        generator = new BallCombiGenerator();
        referee = new Referee();
    }

    public void play() {

        int [] ansBallCombi = generator.genBallCombi();

        for (int trial = 1; ; trial++) {
            int [] userBallCombi = new int [0];

            while(!generator.isValid(userBallCombi)) {
                System.out.printf("숫자를 입력해주세요: ");
                String userBallCombiStr = sc.next(); //
                userBallCombi = generator.toBallCombi(userBallCombiStr);
            }

            int [] judgement = referee.judge(ansBallCombi, userBallCombi);

            if (judgement[Strike] == 3) {
                System.out.printf("3개의 숫자를 모두 맞히셨습니다! 게임 종료 (%d 시도)\n", trial);
                break;
            }

            printJudgement(judgement);
        }
    }

    private void printJudgement(int [] judgement) {
        if (judgement[Strike] == 0 && judgement[Ball] == 0) {
            System.out.println("낫싱");
        }

        String str = "";

        if (0 < judgement[Strike]) {
            str += String.format("%d 스트라이크 ", judgement[Strike]);
        }

        if (0 < judgement[Ball]) {
            str += String.format("%d 볼", judgement[Ball]);
        }

        System.out.println(str);
    }

    public static void main(String[] args) {
        Game game = new Game();

        game.play();
    }
}
