package baseball;

import camp.nextstep.edu.missionutils.*;

public class Application {
    public static void main(String[] args) {
        //TODO: 숫자 야구 게임 구현

        // 1. 타겟 넘버 생성
        int[] randomAns = createTargetNum();

        // 2. 유저에게 입력 받기
        userInputNum();

        // 3. 유저에게 결과 알려주기


        // 4. 재실행 여부
    }

    static int[] createTargetNum(){
        int[] randomAns = new int[3];
        boolean[] check = new boolean[10];
        for(int i=0; i<3; i++){
            int num = Randoms.pickNumberInRange(1,4);

            while(check[num]){
                num = Randoms.pickNumberInRange(1,4);
            }

            check[num] = true;
            randomAns[i] = num;
        }
        return randomAns;
    }

    static void userInputNum(){
        System.out.print("숫자를 입력해주세요 : ");
        String inputStr = Console.readLine();

        // 2-1. 올바른 input 인지 확인
        checkUserInputNum(inputStr);


    }

    static void checkUserInputNum(String inputStr){
        // 길이가 3미만 3초과일 경우
        if(inputStr.length()<3 || inputStr.length()>3) throw new IllegalArgumentException();

        // 숫자로 이루어지지 않았을 경우, 0이 포함 되어 있을 경우
        for(int i=0; i<3; i++){
            if(inputStr.charAt(i)=='0' || !Character.isDigit(inputStr.charAt(i))) throw new IllegalArgumentException();
        }
    }



}
