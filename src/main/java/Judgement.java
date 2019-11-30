public class Judgement {
    private int holdCount;

    public Judgement(int holdCount) {
        this.holdCount = holdCount;
    }

    public boolean checkResult(Integer[] player, Integer[] rival) {
        int strike = 0;
        int ball = 0;
        int nothing = 3;

        for (int i = 0; i < player.length; i++) {
            if (player[i].equals(rival[i])) {
                strike++;
            } else if (isBall(player[i], i, rival)) {
                ball++;
            }
        }

        nothing -= (strike + ball);
        printState(strike, ball, nothing);
        return (strike == holdCount);
    }

    private boolean isBall(int value, int index, Integer[] input) {
        for (int i = 0; i < input.length; i++) {
            if (index != i && value == input[i]) {
                return true;
            }
        }

        return false;
    }

    private void printState(int strike, int ball, int nothing) {
        System.out.println(strike + " strike, " + ball + " ball, " + nothing + " nothing");
    }
}
