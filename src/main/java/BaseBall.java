public class BaseBall {

    private int strike;
    private int ball;
    private int result[] = new int[3];         // 컴퓨터의 숫자
    private boolean check[] = new boolean[10]; // 1~9까지의 숫자의 존재유무

    BaseBall() {

    }

    public int getStrike() {
        return strike;
    }

    public int getBall() {
        return ball;
    }

    /**
     * 스트라이크와 볼의 값을 초기화 하는 함수
     */
    public void init() {
        this.ball = 0;
        this.strike = 0;
    }

    /**
     * 3자리의 숫자를 랜덤 생성하는 함수 구현
     * 각 숫자들은 항상 서로 다른 수여야 한다.
     */
    public void createNumber() {

        int cont = 0;

        while (true) {
            if (cont == 3) {
                break;
            }
            int number = (int) (Math.random() * 9) + 1;

            if (check[number]) {
                continue;
            }
            check[number] = true;
            result[cont] = number;
            cont++;
        }
    }

    /**
     * 숫자들을 비교하여 스트라이크와 볼의 개수를 구하는 함수
     * 유저의 숫자가 컴퓨터의 다른자리에 있는지 확인하는 방법은 check[]을 이용
     */
    public void compareNumbers(int[] user) {

        for (int i = 0; i < user.length; i++) {
            if (user[i] == result[i]) {
                strike++;
            } else if (check[user[i]]) {
                ball++;
            }
        }
    }

    /**
     * 스트라이크와 볼의 개수에 따른 결과를 반환하는 함수
     *
     * @return 숫자비교의 결과
     */
    public String toString() {

        if (this.strike == 0 && this.ball == 0) {
            return "낫싱";
        }

        String ans = "";
        if (this.strike != 0) {
            ans += this.strike + " 스트라이크 ";
        }
        if (this.ball != 0) {
            ans += this.ball + " 볼";
        }

        return ans;
    }
}