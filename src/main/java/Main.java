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

    /**
     * 입력받은 String이 유저의 predict String조건을 모두 만족하는지 체크
     * 조건1: 각자릿수는 1~9 사이 일 것
     * 조건2: 입력 String이 3자릿수 일 것
     * 조건3: 중복되는 숫자가없을 것
     *
     * @param inputStr      체크할 String
     * @return boolean      모든조건을 만족하는지 여부 반환
     */
    public static boolean checkUserInput(String inputStr){

        // 조건1: 3자리 아닐시  -> continue
        if(inputStr.length() != 3){
            System.out.println("3자리 숫자를 입력해주세요");
            return false;
        }
        // 조건2: 하나라도 1~9가 아닐시  -> continue
        boolean allComplete = true;
        for (int i = 0; i < 3; i++) {
            if((inputStr.charAt(i) < '1') || (inputStr.charAt(i) > '9')){
                allComplete = false;
                break;
            }
        }
        if (!allComplete){
            System.out.println("각 자리는 1이상 9이하의 숫자 이어야 합니다");
            return false;
        }
        // 조건3: 하나라도 같은것이 있을시 -> continue
        boolean checkArr[] = new boolean[10];
        for (int i = 0; i < checkArr.length; i++) {
            checkArr[i] = false;
        }
        boolean noOverlap = true;
        for (int i = 0; i < 3; i++) {
            int num = (int) (inputStr.charAt(i) - '0');

            if(checkArr[num]){
                noOverlap = false;
                break;
            }

            checkArr[num] = true;
        }
        if (!noOverlap){
            System.out.println("각 자리는 모두 다른 숫자로 이루어져 있어야 합니다.");
            return false;
        }

        return true;
    }

    public static void main(String[] args){
        System.out.print("hi");
    }
}
