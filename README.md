# 미션 - 숫자 야구 게임

---

## 구현할 기능 목록

### 난수 생성하기

- 컴퓨터는 임의의 3자리 수를 랜덤으로 생성한다.
    * 각 자릿수는 1~9까지의 정수이다. ✅
    * 각 자릿수는 중복되지 않는다. ✅

### 사용자 입력받기

- 사용자에게 정답으로 예상되는 3자리의 수를 입력받는다.
    * 숫자의 개수가 3개가 아닌 입력은 허용되지 않는다.
    * 1~9까지의 정수가 아닌 입력은 허용되지 않는다.
    * 중복되는 숫자는 허용되지 않는다.
    * 허용되지 않은 입력의 경우 IllegalArgumentException 이 발생한다.

### 게임 진행하기

- 승리
    * 사용자의 입력과 컴퓨터가 생성한 난수가 동일한 경우 승리로 간주한다.
    * 승리했을 경우 이를 출력한다.
    * 새로운 게임을 시작하거나 게임을 종료할 수 있다.
    * 새로운 게임 시작 혹은 종료를 위한 입력값( 0 또는 1 )이 아닌 입력은 허용되지 않는다.
    * 허용되지 않은 입력의 경우 IllegalArgumentException 이 발생한다.

- 진행
    * 사용자의 입력과 정답이 동일하지 않은 경우 스트라이크, 볼, 낫싱 결과를 계산한다.
    * 계산된 결과를 출력한다.
    * 입력으로 되돌아간다.

---

## Class 설계

### Application

- public static void main(String[] args)
    * BaseballGame 선언, 호출

### BaseballGame

- private final Computer computer
- private final User_Input user_input
- private final Score score

- BaseballGame()
    * 생성자

- public void start()
    * 난수 생성, 게임 시작
    * 종료될 때 까지 반복

- private void play()
    * 사용자 입력 받기
    * 결과 계산
    * 힌트 출력
    * 정답 맞출 때 까지 반복

- private void printSuccess()
    * 성공 출력

- private boolean is_restart()
    * 새로운 게임 시작 or 종료 선택

### Computer

- private final int[] answer ✅

- public Computer() ✅
    * 생성자
    * 사전에 지정된 개수만큼의 길이로 answer 초기화

- public void setAnswer() ✅
    * 숫자 중복 확인을 위해 사전에 지정된 개수만큼 boolean[] user 생성, false 초기화
    * 사전에 지정된 개수만큼 generateRandomNumber()를 통해 난수 생성하여 answer에 입력

- private int generateRandomNumber(boolean[] used) ✅
    * camp.nextstep.edu.missionutils.Randoms의 pickNumberInRange()를 활용하여 난수 생성, used 이용하여 숫자 중복 확인

- public int[] getAnswer() ✅
    * answer 반환

### UserInput

- private int[] input

- public UserInput()
    * 생성자
    * 사전에 지정된 개수만큼 배열 초기화

- public void setInput()
    * camp.nextstep.edu.missionutils.Console의 readLine()을 활용하여 숫자 입력받기
    * 잘못된 입력은 아닌지 검증

- public int[] getInput()
    * 사용자 입력 반환

### Score

- private int strike
    * 스트라이크 개수
- private int ball
    * 볼 개수

- public Score()
    * 생성자
    * strike=0 , ball=0 초기화

- public boolean is_success(int[] answer, int[] input)
    * 성공여부 확인

- public void grade(int[] answer, int[] input)
    * 점수 계산

- public void printResult()
    * 결과 출력

### Validation

- public static void isValidInput(String input)
    * 야구게임을 위한 숫자를 입력했는지 확인
    * 잘못입력했다면 IllegalArgumentException 발생

- public static void isValidRestart(String input)
    * 재시작 혹은 종료를 위한 숫자를 입력했는지 확인
    * 잘못입력했다면 IllegalArgumentException 발생

- private static boolean isValidNumber(String input)
    * MIN_VALUE~MAX_VALUE 숫자 중 하나인지 확인

- private static boolean isValidLength(String input)
    * NUMBER_OF_NUMBERS 개수만큼 입력했는지 확인

- private static boolean isDuplicated(String input)
    * 중복값이 있는지 확인

### Constant

- public static final int MIN_VALUE ✅
    * 숫자 야구게임에서 가질 수 있는 숫자의 최솟값

- public static final int MAX_VALUE ✅
    * 숫자 야구게임에서 가질 수 있는 숫자의 최댓값

- public static final int NUMBER_OF_NUMBERS ✅
    * 숫자놀이를 진행할 숫자의 개수

- public static final int RESTART_VALUE ✅
    * 재시작을 위한 숫자

- public static final int EXIT_VALUE ✅
    * 종료를 위한 숫자

- public static final String PLEASE_INPUT_NUMBER ✅
    * 숫자 입력 요청

- public static final String SUCCESS ✅
    * 정답

- public static final String STRIKE ✅
    * 스트라이크

- public static final String BALL ✅
    * 볼

- public static final String NOTHING ✅
    * 낫싱

- public static final String RESTART_OR_EXIT ✅
    * 재시작 혹은 종료 선택 요청
