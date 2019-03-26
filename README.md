## Java BaseBall Game

* 역할별 Class 분리
1. Main(User) Class - Main logic(User)이 진행되는 클래스
2. Computer Class - 1부터 9까지 서로다른 수로 이루어진 3자리의 수를 관리, 힌트를 제공하는 클래스

> Main Class 기능
>```
> void go() : 메인 Logic을 담고 있는 메서드, 게임을 진행할 것인지 그만할 것인지 선택하게 된다!
> void init() : 클래스 객체를 생성하는 메서드
> void matchNumber() : User가 컴퓨터랑 숫자 야구 게임을 진행하는 메서드
> String scanInput() : User의 입력값을 받아오는 메서드
> boolean isWrong(String num) : 입력받은 숫자가 1~9까지 서로 다른 3자리 숫자로 구성되어 있으면 true, 아니면 false를 리턴
> boolean analyzeResult(int []result) : 컴퓨터로 받은 결과값을 분석하여 출력해주는 메서드, 게임이 끝나면 true, 아니면 false를 리턴
>```

> Computer Class 기능
>```
> void initNumber() : 배열로 이루어진 3가지 다른 수를 0으로 초기화하는 메서드
> void createNumber() : 1부터 9까지 서로 다른 수의 난수를 뽑는 메서드
> int[] compareNumber(int userNum) : 사용자가 제시한 숫자와, 컴퓨터의 숫자를 비교하여 나온 결과를 배열로 리턴
>                                    [ Strike, Ball, Out ] 순으로 값을 리턴한다.

