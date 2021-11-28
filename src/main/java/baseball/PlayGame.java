package baseball;

public class PlayGame {

    private static int[] randomArray, inputArray;
    private static int strike, boll, none;
    InputNumber inputNumber;
    RandomNumber randomNumber;

    /**
     * 생성자 -> 두 클래스 초기화해주기
     * */
    public PlayGame(){
        inputNumber = new InputNumber();
        randomNumber = new RandomNumber();
    }

    /**
     * 각 결과를 저장할 변수 초기화하는 함수
     * */
    private void reset(){
        this.strike = 0;
        this.boll = 0;
        this.none = 0;
    }

    /**
     * 입력받은 배열의 index의 값이 랜덤 배열에 존재하는지 파악
     *
     * 존재한다면 존재하는 랜덤 배열의 인덱스 번호 반환
     * 존재하지 않으면 -1 반환
     * */
    private int exist(int index){
        for(int i = 0; i<3;i++){
            if(randomArray[i] == inputArray[index]){
                return i;
            }
        }
        return -1;
    }

    /**
     * 값 비교 및 결과 제공 함수
     *
     * 1. 매번 각 결과의 변수 0으로 초기화 (reset 함수 사용)
     *
     * 2. exist 함수를 이용해서 각 자리수의 수의 랜덤 배열 속 존재 유무를 확인
     * (exist 함수는 존재하지 않으면 -1, 존재하면 랜덤 배열에서 존재하는 곳의 인덱스 번호를 반환)
     *
     * 3. 결과 분석
     *  3-1) exist 함수의 반환값 인덱스가 같다면 같은 인덱스에 존재하므로 strike + 1
     *  3-2) -1이 반환되었다면 존재하지 않으므로 none + 1
     *  3-3) 그 외에는 존재하지만 같은 자리에 없는 경우이므로 boll + 1
     *
     * 4. 각 결과 상황에 맞는 문장 출력
     *  만약 strike이 3이라면 정답이므로 true 반환
     * */
    private boolean analyzeGame(){

        reset();

        for(int i = 0; i<3; i++){
            int temp = exist(i);
            if(temp == i){
                strike++;
            }else if(temp == -1){
                none++;
            }else{
                boll++;
            }
        }
        if(strike == 3){
            System.out.println("3스트라이크");
            System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
            return true;
        }else if(none == 3) {
            System.out.println("낫싱");
        }else{
            System.out.println(boll+"볼 "+strike+"스트라이크");
        }
        return false;
    }

    /**
     * 각 판마다 답이 맞을 때까지 진행되는 부분
     * 매번 사용자가 입력하는 수를 가지고 배열에 저장한 후
     * play 함수를 이용해서 게임 성공 여부를 파악
     * 실패시 : 새로운 수 입력
     * 성공시 : 해당 판 종료료
     * */
    private void playUnitGame() {
        boolean result;
        while(true){
            inputArray = inputNumber.getInputArray();
            result = analyzeGame();
            if(result == true)
                break;
        }
    }

    private int restartOrStop(){
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        return inputNumber.restart();
    }

    /**
     * 주 게임 진행 함수
     * 새로운 게임 마다 랜덤 수를 출력하고
     * 게임을 진행
     * 게임이 다 진행되면 게임 재시작, 종료 판단하기
     *
     * do~while문을 이용해서 2번을 입력받기 전까지 계속 진행하기
     * */
    public void baseballGame(){
        do {
            // 새로운 게임이 시작될 때마다 랜덤한 숫자를 받아야합니다.
            randomArray = randomNumber.getRandom();

            // 게임을 시작합니다.
            playUnitGame();

            if(restartOrStop() == 2){
                break;
            }
        }while (true);
    }
}
