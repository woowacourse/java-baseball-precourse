import java.util.Random;

public class Computer {
    private int[] answer;
    private int strike;
    private int ball;

    public Computer() {
        answer = new int[3];
        strike = 0;
        ball = 0;
    }

    public void getRandom() {
        Random r = new Random();
        
        int i = 0;
        while(i < 3) {
            int n = r.nextInt(8) + 1;
            if(checkRandom(n, i)) {
                answer[i++] = n;
            }
        }
    }

    public boolean checkRandom(int n, int length) {
        for(int i = 0; i < length; i++) {
            if(answer[i] == n){
                return false;
            }
        }
        return true;
    }

    public void checkAnswer(int input) {
        strike = 0;
        ball = 0;

        int[] user = new int[3];
        for(int i = 2; i >= 0; i--) {
            user[i] = input % 10;
            input /= 10;
        }
        
        for(int i = 0; i < 3; i++) {
            compare(answer[i], user, i);
        }

        showResult();
    }

    public void compare(int answer, int[] user, int idx) {
        for(int i = 0; i < 3; i++) {
            if(answer == user[i]) {
                ball++;
            }
        }

        if(answer == user[idx]) {
            ball--;
            strike++;
        }
    }

    public void showResult() {
        if(strike != 0) {
            System.out.print(strike + " 스트라이크 ");
        }
        if(ball != 0) {
            System.out.print(ball + " 볼");
        }
        if(strike == 0 && ball == 0) {
            System.out.print("낫싱");
        }
        System.out.println();
    }

    public int getStrike() {
        return strike;
    }
}