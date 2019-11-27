## 구현해야 하는 기능
#### 0. main 함수 작성 

#### 1. run 함수 작성 & 상수, 변수 정의하기
    static final int INPUT_SIZE = 3;
    int answer;
    int userInput;
    int ballCount;
    int strikeCount;
    
#### 2. 1~9 사이의 서로 다른 수로 이루어진 3자리 수를 만들어 리턴하는 함수
    int makeRandomNumber(int numberSize);
    
#### 3. 사용자의 입력(세 수) 받는 함수
    int getUserInput();
    
#### 4. 사용자가 입력한 세 수 valid/ invalid 체크하는 함수

    boolean chekUserInput();
    int inputTemp = 0;
   - 사용자가 숫자를 1자리나 2자리만 입력하는 경우 `int userInputSize;`
   - 사용자가 숫자 0을 입력하는 경우 `Scanner 사용해서 한 글자씩 입력`, `inputTemp에 추가`
   - 사용자가 숫자가 아닌 문자를 섞어서 입력하는 경우 `상동`
    
#### 5. 스트라이크/볼/낫싱 출력해주는 함수

	void printResult(int answer, int userInput);
    int strikeCount = 0;
    int ballCount = 0;
    boolean isNothing = false;
   - 스트라이크 체크해주는 함수 `int checkStrike(int answer, int userInput);`
   - 볼 체크해주는 함수 `int checkBall(int answer, int userInput);`
   - 낫싱 체크해주는 함수 `bool checkNothing(int answer, int userInput);`
   
#### 6. 맞췄는지 틀렸는지 true/false 리턴해주는 함수<br>
    boolean isCorrect(int answer, int userInput);
    
#### 7. 게임 종료 & 반복해주는 함수<br>
    boolean continue();

### - 고민거리
사용자의 입력과 정답을 int answer = 123; 이렇게 int 형으로 저장 & 관리하는게 나을 것인가
아님 int[] answer = { 1, 2, 3}; 이와 같이 배열로 저장하는 것이 편할 것인가

-> 배열로 사용하면 확장성?이 떨어질 것 같다. 확장성의 이유로 static final int INPUT_SIZE = 3; 과 같이 정의를 하는데

