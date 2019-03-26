import java.util.ArrayList;

public class GamePlay {
    private int[] com = new int[3];
    private int[] user = new int[3];
    private GameResult gameResult = new GameResult();

    /**
     * 길이가 3이고 중복되지 않는 1부터 9까지의 임의의 수를 만드는 메서드
     * init 을 위한 helper method
     * @return result 3개의 임의의 수를 가지고 있는 ArrayList
     */
    private ArrayList<Integer> makeRandomArrayList() {
        ArrayList<Integer> result = new ArrayList<>();
        while (result.size() < 3) {
            int tmp = (int) (Math.random() * 9 + 1);
            if (!result.contains(tmp)) {
                result.add(tmp);
            }
        }
        return result;
    }

    /**
     * ArrayList 를 primitive int 형 배열로 바꿔주는 메서드
     * @param arrayList 바꿀 ArrayList
     * @return primitive int 형 배열로 바뀐 ArrayList
     */
    private int[] arrayListToArray(ArrayList<Integer> arrayList) {
        if (arrayList.size() != 3) {
            throw new RuntimeException("Something Wrong While Making Random Array");
        }
        int[] result = new int[3];
        for (int i = 0; i < arrayList.size(); i++) {
            result[i] = arrayList.get(i);
        }
        return result;
    }

    /**
     * 게임을 초기화 하는 메서드
     */
    public void init() {
        ArrayList<Integer> tmpArr = makeRandomArrayList();
        this.com = arrayListToArray(tmpArr);
    }

    public void requestInputMessage() {
        System.out.print("숫자를 입력해주세요: ");
    }

    /**
     * 사용자의 입력을 받는 메서드
     */
    public void getUserInput(String[] userInput) {
        for (int i = 0; i < this.user.length; i++) {
            this.user[i] = Integer.parseInt(userInput[i]);
        }
    }

    public void countResult() {
        countStrike();
        countBall();
    }

    /**
     * com 배열과 user 배열의 같은 인덱스에 있는 원소가 같으면
     * gameResult 인스턴스의 strike 증가시킴.
     */
    private void countStrike() {
        for (int i = 0; i < this.user.length; i++) {
            strikeCounter(i);
        }
    }

    /**
     * 특정 인덱스에서 strike 를 카운트하는 메서드
     * @param i 인덱스
     */
    private void strikeCounter(int i) {
        if (this.com[i] == this.user[i]) {
            gameResult.oneMoreStrike();
        }
    }

    /**
     * com 배열과 user 배열의 원소 중에 인덱스가 다르고 겹치는 원소가 있으면
     * gameResult 인스턴스의 ball 증가시킴.
     */
    private void countBall() {
        for (int i = 0; i < this.com.length; i++) {
            eachBall(i);
        }
    }

    /**
     * 배열의 한 원소를 기준으로 ball 을 카운트하는 메서드
     * @param i 기준이 되는 원소의 인덱스
     */
    private void eachBall(int i) {
        for (int j = 0; j < this.user.length; j++) {
            ballCounter(i, j);
        }
    }

    /**
     * 두 배열의 각각의 위치에 있는 원소가 ball 일때 ball 을 증가시키는 메서드
     * @param i this.com 배열의 인덱스
     * @param j this.user 배열의 인덱스
     */
    private void ballCounter(int i, int j) {
        if (i != j && this.com[i] == this.user[j]) {
            gameResult.oneMoreBall();
        }
    }

    /**
     * 맞추지 못하면 매번 strike 와 ball 은 0 으로 초기화 되어야 함.
     */
    public void initGameResult() {
        gameResult.initStrikeAndBall();
    }

    /**
     * 게임의 결과를 콘솔에 출력하는 메서드
     */
    public void printGameResult() {
        gameResult.printStrikeAndBall();
    }

    /**
     * 게임이 끝인지 아닌지 체크하는 메서드
     * strike 가 3개이면 게임이 끝난다
     * @return 게임이 끝인지 아닌지 체크하는 메서드
     */
    public boolean isGameEnd() {
        return gameResult.isThreeStrike();
    }
}
