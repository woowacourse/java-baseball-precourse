package baseball;

import camp.nextstep.edu.missionutils.*;

public class Application {
    static  int[] randomAns;

    public static void main(String[] args) {
        //TODO: 숫자 야구 게임 구현

        boolean start = true;
        // 재실행 여부
        while(start){
            // 1. 타겟 넘버 생성
            randomAns = createTargetNum();

            // 2. 유저에게 입력 받기
            // 3. 유저에게 결과 알려주기
            boolean ansCheck = false;
            while(!ansCheck) ansCheck = compareToRandomAns(userInputNum());
            start = checkRestart();
        }
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

    static int[] userInputNum(){
        System.out.print("숫자를 입력해주세요 : ");
        String inputStr = Console.readLine();

        // 2-1. 올바른 input 인지 확인하고 int 배열에 숫자 각각 담기
        int[] userInputNumArr = checkUserInputNum(inputStr);

        return userInputNumArr;
    }

    static int[] checkUserInputNum(String inputStr){
        int[] userInputNumArr = new int[3];

        // 길이가 3미만 3초과일 경우
        if(inputStr.length()<3 || inputStr.length()>3) throw new IllegalArgumentException();

        // 숫자로 이루어지지 않았을 경우, 0이 포함 되어 있을 경우
        for(int i=0; i<3; i++){
            if(inputStr.charAt(i)=='0' || !Character.isDigit(inputStr.charAt(i))) throw new IllegalArgumentException();
            userInputNumArr[i] = inputStr.charAt(i)-'0';
        }

        return userInputNumArr;
    }

    static boolean compareToRandomAns(int[] userInputNumArr){
        // 같은 수가 같은 자리에 있으면 스트라이크, 다른 자리에 있으면 볼, 같은 수가 전혀 없으면 포볼 또는 낫싱


        return true;
    }

    static boolean checkRestart(){
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        String userRestartInput = Console.readLine();
        if(userRestartInput.equals("1")) return true;
        else if(userRestartInput.equals("2")) return false;
        else throw new IllegalArgumentException();
    }
}
