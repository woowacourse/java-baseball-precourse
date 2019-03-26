import java.util.LinkedList;
import java.util.List;
import java.util.Random;

public class Main {

    /**
     * 컴퓨터의 3자릿수 넘버를 랜덤으로 생성해 반환
     *
     * @return String 3자릿수 랜덤넘버 스트링
     */
    private static String createComputerAnswer(){
        List leftNumList = new LinkedList();  // 중복숫자를 피하기 위해, 출력가능한 숫자 보관 List
        String answer = "";                   // 반환 answer

        // leftNumList에 1~9까지의 숫자 삽입
        for (int i = 1; i < 10; i++) {
            leftNumList.add(i);
        }

        // leftNumList에서 숫자를 랜덤으로 1개씩빼면서 랜덤숫자 생성
        for (int i = 0; i < 3; i++) {
            Random random = new Random();
            int nextIndex = random.nextInt(leftNumList.size());       //
            int nextNum = (int) leftNumList.get(nextIndex);

            leftNumList.remove(nextIndex);

            answer += (char) (nextNum + '0');
        }

        System.out.println();
        return answer;
    }

    public static void main(String[] args){
        System.out.print("hi");
    }
}
