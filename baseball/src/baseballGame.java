import java.util.Random;

/**
 * @author SMJin
 * baseballGame Class
 * */
public class baseballGame {

    public static void main(String[] args) {

        int answerNumA = 0;
        int answerNumB = 0;
        int answerNumC = 0;

        int[] answerNum = initBaseballNumber(answerNumA, answerNumB, answerNumC);

    }

    /*
    정답 숫자들을 랜덤으로 생성하여 int형 배열로 반환하여 주는 메소드이다.
     */
    static private int[] initBaseballNumber (int answerNumA, int answerNumB, int answerNumC) {
        Random random = new Random();
        answerNumA = random.nextInt(10)+1;
        answerNumB = random.nextInt(10)+1;
        answerNumC = random.nextInt(10)+1;

        int[] answerNum = {answerNumA, answerNumB, answerNumC};

        return answerNum;
    }

    /*
    인자로 들어온 두 int 형 숫자가 같으면 TRUE 를 반환하는 메소드이다.
     */
    boolean isSame(int answerNum, int num) {
        return (answerNum == num);
    }


}
