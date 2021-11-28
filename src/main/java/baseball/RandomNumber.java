package baseball;

import camp.nextstep.edu.missionutils.Randoms;

public class RandomNumber {

    /**
     * 랜덤한 숫자를 배열로 받습니다.
     * 0번째 : 백의 자리
     * 1번째 : 십의 자리
     * 2번째 : 일의 자리
    */
    private static int[] randomArray;



    /**
     * 랜덤 배열에 새로 생성된 수가 존재하는지 확인
     * 존재하면 true
     * 존재하지 않으면 false 반환
     * */
    private boolean exists(int inputUnitRandomNum) {
        for (int i = 0; i < randomArray.length; i++) {
            if(randomArray[i] == inputUnitRandomNum)
                return true;
        }
        return false;
    }

    /**
     * 각 자리수마다 1~9 사이의 숫자를 랜덤으로 받아옵니다.
     * 이 때, exist함수를 이용해서 중복을 확인하고
     * 중복되지 않을 때, 해당 수를 반환합니다.
     * */
    private int unitRandomNum(){
        int inputNum = 0;
        do{
            inputNum = (int)(Randoms.pickNumberInRange(1,9));
        } while (exists(inputNum));
        return inputNum;
    }

    /**
     * 조건에 맞는 랜덤 함수를 작성합니다.
     * 3번의 for문으로 서로 다른 숫자를 받아 배열에 저장한 후 랜덤한 숫자를 생성합니다.
     * */
    private int randomNum(){
        randomArray = new int[3];
        for(int i = 0; i< randomArray.length; i++){
            randomArray[i] = unitRandomNum();
        }
        int ran = randomArray[0] * 100 + randomArray[1] * 10 + randomArray[2];
        return ran;
    }

    /**
     * 추후 다른 클래스에서는
     * random 배열만 필요하기 때문에
     * 랜덤 숫자를 생성하는 함수를 실행한 후 랜덤 배열만 다른 클래스가 접근할 수 있도록 구현하였습니다.
     */
    public int[] getRandom() {
        randomNum();
        return randomArray;
    }
}
