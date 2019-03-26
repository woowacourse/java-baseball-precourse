
public class Computer {
    private int computerNumber[];
    private boolean overlapNumber[];

    Computer() {
        getRandomNumber();
    }

    /*
     *  랜덤번호 얻어 저장하는 메소드
     */
    private void getRandomNumber() {
        computerNumber = new int[3];
        overlapNumber = new boolean[10];
        computerNumber[0] = randomNumber();
        computerNumber[1] = randomNumber();
        computerNumber[2] = randomNumber();
    }

    /*
     *  1 ~ 9 랜덤 번호 생성하는 메소드
     */
    private int randomNumber() {
        boolean check = false;
        int num = 0;
        while (!check) {
            num = (int) (Math.random() * 10);
            check = checkOverlapNum(num);
        }
        return num;
    }

    /*
     *  번호가 중복인지 체크하는 메소드
     */
    private boolean checkOverlapNum(int num) {
        if (num == 0) return false;
        if (!overlapNumber[num]) {
            overlapNumber[num] = true;
            return true;
        }
        return false;
    }

    /*
     *  세자리수 랜덤번호가 저장된 배열 리턴하는 메소드
     */
    public int[] getComputerNumber() {
        return computerNumber;
    }

}
