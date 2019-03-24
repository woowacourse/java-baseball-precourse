public class BaseBall {

    private int strike;
    private int ball;
    private int result[] = new int[3];         // 컴퓨터의 숫자
    private boolean check[] = new boolean[10]; // 1~9까지의 숫자의 존재유무

    BaseBall() {

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
}