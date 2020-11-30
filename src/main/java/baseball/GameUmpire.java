package baseball;

public class GameUmpire {

    static int umpirePitch(BallChoice computerChoice, BallChoice userChoice) {
        int strike = 0;
        int ball = 0;
        for (int i = 0; i < computerChoice.choice.length(); i++) {
            if (computerChoice.choice.charAt(i) == userChoice.choice.charAt(i)) {
                strike += 1;
            }
        }

        for (int i = 0; i < userChoice.choice.length(); i++) {
            if (calculateBall(computerChoice, userChoice.choice.charAt(i))) {
                ball += 1;
            }
        }

        ball -= strike;
        callUmpire(strike,ball);
        return strike;
    }

    static boolean calculateBall(BallChoice computerChoice, int pitch) {
        boolean ball = false;

        for (int i = 0; i<computerChoice.choice.length(); i++) {
            if (computerChoice.choice.charAt(i) == pitch) {
                ball = true;
            }
        }
        return ball;
    }

    static void callUmpire(int strike, int ball) {
        if (strike == 0 && ball == 0) {
            System.out.println("낫싱");
        }else if (strike == 0 && ball != 0) {
            System.out.println(ball+"볼");
        }else if (strike !=0 && ball == 0) {
            System.out.println(strike+"스트라이크");
        }else {
            System.out.println(ball+"볼 "+strike+"스트라이크");
        }
    }
}
