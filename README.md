<h1>구현할 기능 리스트</h1>
<ol>
    <li>컴퓨터 숫자 3자리를 저장할 Number 객체의 인스턴스 "comNum"을 생성 후 난수발생을 이용하여 3자리 설정
        + 중복되지 않게 하기 위해 Number 객체의 메소드로 "isOverlap" 메서드를 작성</li>
    <li>사용자의 입력을 받을 userNum[3] 배열 생성 후 Scanner를 통해 입력받는 기능 구현</li>
    <li>comNum, userNum 배열을 전달인자로 하고, 변수 strike, ball을 선언하고, 두 수를 비교하여 
        스트라이크와 볼의 갯수를 판별하는 void judge(int comNum, int userNum); 메소드 구현</li>
    <li>judge 메소드 안에 strike, ball 두 변수를 전달인자로 하여 결과를 
        출력해주는 void printResult(int strike, int ball); 메소드 구현</li>
    <li>2-4번 과정을 반복해야 하기때문에 while문을 통해 무한반복시킨다. break조건은 judge 
        메소드에서 strike가 3이 되면 숫자를 맞춘 것이므로 축하한다는 메세지를 출력하고 break한다.</li>
    <li>2-5번 과정도 반복해야 하기때문에 메인메서드에 gameStart 메서드를 생성한 후 위 과정을 붙여넣는다. </li>
</ol>
 