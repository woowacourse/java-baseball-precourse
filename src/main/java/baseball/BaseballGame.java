package baseball;

import camp.nextstep.edu.missionutils.Console;

import java.util.Arrays;

public class BaseballGame{


    final int STRIKE = 0;
    final int BALL = 1;
    final int NOTHING = 2;

    final int MAXIMUM_VALUE = 999;
    final int MINIMUM_VALUE = 111;

    final String[] resultType = new String[] {"스트라이크", "볼", "낫싱"};

    private boolean restart = false;
    private boolean isCorrect = false;
    final private Computer computer;
    final private Player player;

    public BaseballGame() {
        this.computer = new Computer();
        this.player = new Player();

    }

    public boolean getRestart() {
    /*
        [definition]
        게임 종료 후, 재시작 값을 조사하기 위한 함수입니다.

        [return]
        저장된 restart 값 반환
     */
        return restart;
    }

    public void play() {
        // 랜덤 수 생성
        computer.generateValidRandom();

        // 게임 반복
        do {

            // 사용자 입력 받기
            int playerInput = getPlayerInput("숫자를 입력해 주세요.: ");
            // 만약 허용 범위를 넘어가는 값 입력 받았을 시, 종료
            if(playerInput > MAXIMUM_VALUE || playerInput < MINIMUM_VALUE) throw new InvalidInputException(playerInput);

            // player 개체에 값 초기화
            player.setInputValue(playerInput);
            //  유효성 검사 후, 만약 유효하지 않은 수인 경우, 종료
            if (!player.isValidNumber()) throw new InvalidInputException(playerInput);

            // 랜덤 값과 사용자 입력 값 비교
            int[] result = compareComputerWithPlayer(computer.randomValue, player.inputValue);

            // 비교 결과 출력 및 결과에 따른 correct update
            manageResult(result,3);

        } while(!isCorrect);

        setRestart();
    }

    public int getPlayerInput(String msg) {
    /*
        [definition]
        사용자에게 입력을 받기 위한 함수있니다.

        [return]
        입력으로 받은 string 값을 정수형으로 전환해 반환

     */
        System.out.println(msg);
        return Integer.parseInt(Console.readLine());
    }

    public int[] compareComputerWithPlayer(int[] computer, int[] player) {
        /*
            [definition]
            컴퓨터 개체에서 생성한 랜덤 값과 사용자에게 입력받은 값을 비교하는 함수입니다.

            [parameters]
            computer: 컴퓨터 개체에서 입력받은 랜덤 값
            player: 사용자에게 입력받은 랜덤 감

            - 두 값 모두 배열 형태로 전달됩니다.
            - 1 ~ 9 사이의 유효한 값이 전달됨을 보장합니다.

            [return]
            스트라이크, 볼 순으로 각각의 개수를 담은 배열
            만약 하나도 같은 것이 없다면 초기값({0, 0})으로 반환
        **/

        int[] answer = new int[2];
        int[] position = new int[10];
        Arrays.fill(position, -1);

        /*
         * 랜덤값 차례대로 랜덤값에 해당하는 위치에 인덱스 값 저장
         * random value = 427
         * [-1, -1, 1, -1, 0, -1, -1, 2, -1, -1]
         **/
        for(int randomIndex = 0; randomIndex < computer.length; randomIndex++) {
            position[computer[randomIndex]] = randomIndex;
        }

        for (int userValueIndex = 0; userValueIndex < player.length; userValueIndex++) {
            if (position[player[userValueIndex]] == -1) continue;

            // 해당 포지션에 저장되어 있는 인덱스 값과 현재 인덱스 값이 같다면, strike
            if (position[player[userValueIndex]] == userValueIndex) answer[0] += 1;
            else answer[1] += 1;
        }
        return answer;
    }

    public void setRestart() {

        // 사용자로부터 게임 재게 여부 확인 (1 or 2)
        int answer = getPlayerInput("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");

        if(!(answer == 1 || answer == 2)) throw new InvalidInputException("1 or 2가 아닌 수: "+answer);

        // 재게 여부에 따른 flag 변수 수정
        this.restart = answer == 1;
    }

    public void manageResult(int[] result, int randomValueSize) {
         /*
            [definition]
            비교 결과에 대한 내용을 출력합니다.

            [parameters]
            result: 비교한 결과
            randomValueSize: 콤퓨터가 게임의 시작과 동시에 생성한 랜덤 값이 담긴 배열의 사이즈

            [return]
            3스트라이크의 경우, true
            그 외, false
        **/
        StringBuilder stringBuilder = new StringBuilder();

        // strike = 0, ball = 0
        if((result[STRIKE]|result[BALL]) == 0) {
            System.out.println(resultType[NOTHING]);
            return;
        }
        // ball - strike 순으로 역으로 출력
        for (int index = result.length-1; index >= 0; index--) {
            if (result[index]==0) continue;
            stringBuilder.append(result[index]);
            stringBuilder.append(resultType[index]);
            stringBuilder.append(" ");
        }
        // 마지막 띄어쓰기 제거
        stringBuilder.deleteCharAt(stringBuilder.length() - 1);

        // strike = 3, ball = 0
        if((result[STRIKE]^randomValueSize) == 0) {
            stringBuilder.append('\n');
            stringBuilder.append("3개의 숫자를 모두 맞히셨습니다! 게임 종료");

            // 비교 결과에 따른 correct 변수 수정
            isCorrect = true;
        }

        System.out.println(stringBuilder);
    }
}
