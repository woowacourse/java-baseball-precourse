package baseball;

public class GameUmpire {
    
    static int umpirePitch(String computerChoice, String userChoice) {
        int strike = 0;
        int ball = 0;
        for (int i = 0; i < computerChoice.length(); i++) {
            if (computerChoice.charAt(i) == userChoice.charAt(i)) {
                strike += 1;
            }
        }

        for (int i = 0; i < userChoice.length(); i++) {
            if (calculateBall(computerChoice, userChoice.charAt(i))) {
                ball += 1;
            }
        }

        ball -= strike;
        callUmpire(strike,ball);
        return strike;
    }

    static boolean calculateBall(String computerChoice, int pitch) {
        boolean ball = false;

        for (int i = 0; i<computerChoice.length(); i++) {
            if (computerChoice.charAt(i) == pitch) {
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
