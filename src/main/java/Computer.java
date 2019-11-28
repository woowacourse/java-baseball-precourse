public class Computer {
    private Numbers numbersOfComputer;

    public Computer() {
        numbersOfComputer = new Numbers();
    }

    public void compareNumbersWith(Numbers numbersFromUser) {
        int strike = numbersOfComputer.countStrike(numbersFromUser);
        int ball = numbersOfComputer.countBall(numbersFromUser);

        if((strike == 0) && (ball == 0)) {
            System.out.println("낫싱");
            return;
        }

        System.out.println(strike + " 스트라이크 " + ball + " 볼");

        if(strike == 3) {
            System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
        }
    }
}