package baseball;
import utils.RandomUtils;

import java.util.*;

public class Application {
    public static void main(String[] args) {
        final Scanner scanner = new Scanner(System.in);
        // TODO 구현 진행
        boolean flag =true;
        while(flag){
            //사용자 입력 받기
            final int[] userInput= userInput(scanner);
            //랜덤으로 정답 생성
            final int[] answer = makeRandom();
        }
    }
    public static int[] makeRandom(){
        int[] userInput = new int[3];
        Set<Integer> randNum = new LinkedHashSet<Integer>();
        while(true){
            if(randNum.size() ==3) break;
            randNum.add(RandomUtils.nextInt(1,9));
        }
        Iterator<Integer> it = randNum.iterator();
        int idx=0;
        while(it.hasNext()){
            userInput[idx++] = it.next();
        }
        return userInput;
    }

    public static int[] userInput(Scanner scanner){
        final String INPUT_MESSAGE = "숫자를 입력해주세요: ";
        System.out.print(INPUT_MESSAGE);
        String userNumberString = scanner.nextLine();
        int[] userInput = new int[3];
        try{
            //숫자의 개수가 3개가 아닐 때
            isThree(userNumberString);
            //문자를 입력 받았을 때 && 0도 처리
            isNumber(userNumberString);
            userInput = toIntArray(userNumberString);
            return userInput;
        }catch(IllegalArgumentException e){
            System.out.println("잘못된 입력입니다");
            return userInput;
        }
    }

    public static int[] toIntArray(String inputString) {
        int[] userInput = new int[3];
        for(int i=0; i<3; i++){
            userInput[i] = inputString.charAt(i) -'0';
        }
        return userInput;
    }

    public static void isThree(String inputString){
        if(inputString.length() !=3 ){
            throw new IllegalArgumentException("잘못된 입력입니다");
        }
    }

    public static void isNumber(String inputString){
        for(int i=0; i<3; i++){
            if(inputString.charAt(i) <'1' || inputString.charAt(i) >'9')
                throw new IllegalArgumentException("잘못된 입력입니다");
        }
    }
}
