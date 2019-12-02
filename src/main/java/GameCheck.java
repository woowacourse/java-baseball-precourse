class GameCheck {
    static int strike = 0;
    static int ball = 0;

    public GameCheck(int[] computer, int[] user) {
        this.getStrike(computer, user);
        this.getBall(computer, user);
    }

    public int getStrike(int[] computer, int[] user) {
        strike = 0;
        for (int i = 0; i < computer.length; i++) {
            if (computer[i] == user[i]) {
                strike++;
            }
        }
        return strike;
    }

    public int getBall(int[] computer, int[] user) {
        ball = 0;
        if (user[0] == computer[1] || user[0] == computer[2]) {
            ball++;
        }
        if (user[1] == computer[0] || user[1] == computer[2]) {
            ball++;
        }
        if (user[2] == computer[0] || user[2] == computer[1]) {
            ball++;
        }
        return ball;
    }
}
