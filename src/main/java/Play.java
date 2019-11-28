import java.util.concurrent.ThreadLocalRandom;

public class Play {
    private int[] answer;
    private int tryTimes;

    // 클래스 생성 시 랜덤으로 3자리 수를 만든다.
    public Play() {
        this.answer = ThreadLocalRandom
                .current()
                .ints(1, 10)
                .distinct()
                .limit(3)
                .toArray();
        this.tryTimes = 0;
    }

    // 생성된 3자리 수를 확인하기 위하여 구현한 메서드이다.
    public String whatIsAnswer() {
        String answerString = "";

        for (int num : answer) {
            answerString += Integer.toString(num);
        }

        return answerString;
    }
}
