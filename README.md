## 구현해야 하는 기능
#### 0. main 함수 작성 & 생성자 작성
<br>

#### 1. 상수, 변수 정의하기
    static final int INPUT_SIZE = 3;
    static final int MAX_NUMBER = 9;
    static final int CONTUNUE = 1;
    static final int EXIT = 2;
    int answer;
    int userInput;
<br>
    
#### 2. 1~9 사이의 서로 다른 수로 이루어진 3자리 수를 만들어 리턴하는 함수
    int makeRandomNumber(int numberSize);
<br>

#### 3. 사용자의 입력(세 수) 받는 함수
    boolean getUserInput();
    
   - 사용자가 숫자가 아닌 문자를 섞어서 입력하는 경우 체크하는 함수<br>`boolean checkInputContainsChar(String input);`
   - 사용자가 입력한 숫자의 길이를 체크하는 함수<br>`boolean checkInputLengthIsCorrect(String input, int size);`
   - 사용자가 숫자 0을 입력하는 경우 체크하는 함수 <br>`boolean checkInputContainsZero(String input);`
   - 사용자가 동일한 숫자를 입력한 경우를 체크하는 함수 <br>`boolean checkInputContainsSameNumber(int input);`
 
 <br>  
    
#### 4. 스트라이크/볼/낫싱 출력해주는 함수

	void printResult(int answer, int userInput);
	boolean Nothing = false;
    int strikeCount = 0;
    int ballCount = 0;
    
   - 낫싱 체크해주는 함수 `boolean checkNothingExist(int answer, int userInput);` 
   - 스트라이크 카운트해주는 함수 `int countStrike(int answer, int userInput);`
   - 볼 카운트해주는 함수 `int countBall(int answer, int userInput, int strikeCount);`
   

<br>
   
#### 6. 맞췄는지 틀렸는지 true/false 리턴해주는 함수<br>
    boolean isCorrect(int answer, int userInput);
<br>
    
#### 7. 게임 시작/종료/반복 해주는 함수<br>
    void start();
    boolean checkContinue();
    int getUserInputAOrB(int inputA, int inputB, String guideMessage);
<br>

### - 고민거리
~~1.사용자의 입력과 정답을 int answer = 123; 이렇게 int 형으로 저장 & 관리하는게 나을 것인가<br>
아님 int[] answer = { 1, 2, 3}; 이와 같이 배열로 저장하는 것이 편할 것인가<br>
-> 배열로 사용하면 확장성?이 떨어질 것 같다. 확장성의 이유로 static final int INPUT_SIZE = 3; 과 같이 정의를 하는데~~<br>
<br>
2.문자를 입력받는 부분을 굳이 checkInputContainsChar 함수로 빼지 않고<br> 
getUserInput 함수 내에서 try-catch 문을 사용함으로 검사하고 정수로 변환할 수 있는데<br>
가독성을 위해 지금 처럼 함수로 빼는 것이 나은가 아님 그냥 함수 내에서 처리하는것이 나은가..?<br>
-> 우선 구현은 함수로 빼서 구현 함. 어떤것이 나은 진 잘 모르겠음.<br>
<br>
~~3.checkContinue() 함수가 사용자가 1 또는 2의 값에 따라 게임을 재실행 하거나 종료하는 함수이고<br>
getUserInputAOrB() 함수가 사용자에게 inputA 또는 inputB의 입력을 받아 리터하는 함수인데<br>
"System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");"<br>
위 명령문을 getUserInputAOrB() 함수에 넣어버림.<br>
함수의 네이밍&기능과 System.out.println() 문의 내용이 조금 다른 느낌<br>
-> 함수에 인자로 String optionalMessage를 넣어서 출력하면 해결 될듯!~~<br>