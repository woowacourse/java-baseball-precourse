package baseball;
import utils.RandomUtils;

import java.util.*;

public class Application {
    final static int dataLen =3;
    public static void main(String[] args) {
        final Scanner scanner = new Scanner(System.in);
        // TODO 구현 진행
        boolean EndGame =false;
        while(!EndGame){
            boolean EndRound =false;
            //랜덤으로 정답 생성
            final int[] answer = makeRandom();
            while(!EndRound) {
                //사용자 입력 받기
                final int[] userInput = userInput(scanner);
                final int strike = Computer.getStrikeNum(userInput, answer);
                final int ball = Computer.getBallNum(userInput, answer);
                printResult(ball,strike);
                if(strike == dataLen) EndRound = true;
            }
            //RETRY 결정
            if(isEndGame(scanner)) EndGame = true;
        }
    }
    public static boolean isEndGame(Scanner scanner){
        final String RETRY_MESSAGE = "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.";
        System.out.println(RETRY_MESSAGE);
        try{
            String userNumberString = scanner.nextLine();
            if(userNumberString.equals("1")){
                return false;
            }
            else if(userNumberString.equals("2")){
                return true;
            }
            else{
                throw new IllegalArgumentException("잘못된 입력입니다");
            }
        }catch(IllegalArgumentException e){
            System.out.println("잘못된 입력입니다");
        }
        return true;
    }

    public static void printResult(int ball, int strike){
        if(ball ==0 && strike ==0){
            System.out.print("낫싱");
        }
        if(ball!=0){
            System.out.print(ball + "볼 ");
        }
        if(strike !=0){
            System.out.print(strike + "스트라이크 ");
        }
        System.out.println();
        if(strike == dataLen){
            final String RESULT_MESSAGE = "3개의 숫자를 모두 맞히셨습니다! 게임 종료";
            System.out.println(RESULT_MESSAGE);
        }
    }

    public static int[] makeRandom(){
        int[] userInput = new int[dataLen];
        Set<Integer> randNum = new LinkedHashSet<Integer>();
        while(true){
            if(randNum.size() == dataLen) break;
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
        int[] userInput = new int[dataLen];
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
        for(int i=0; i<dataLen; i++){
            userInput[i] = inputString.charAt(i) -'0';
        }
        return userInput;
    }

    public static void isThree(String inputString){
        if(inputString.length() != dataLen ){
            throw new IllegalArgumentException("잘못된 입력입니다");
        }
    }

    public static void isNumber(String inputString){
        for(int i=0; i<dataLen; i++){
            if(inputString.charAt(i) <'1' || inputString.charAt(i) >'9')
                throw new IllegalArgumentException("잘못된 입력입니다");
        }
    }
}
