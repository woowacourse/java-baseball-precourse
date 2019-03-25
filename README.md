<h1>구현할 기능 리스트</h1>
<ol>
    <li>난수발생을 이용하여 컴퓨터의 숫자 3자리 생성 후 comNum[3] 배열에 저장</li>
    <li>사용자의 입력을 받을 userNum[3] 배열 생성 후 Scanner를 통해 입력받는 기능 구현</li>
    <li>comNum, userNum 배열을 전달인자로 하고, 두 수를 비교하여 스트라이크와 볼의 갯수를 판별하는 void judge(int comNum, int userNum); 메소드 구현</li>
    <li>judge 메소드 안에 변수 strike, ball을 선언하고, 이 두 변수를 전달인자로 하여 결과를 출력해주는 void print(int strike, int ball); 메소드 구현</li>
    <li>2-4번 과정을 반복해야 하기때문에 while문을 통해 무한반복시킨다. break조건은 judge 메소드에서 strike가 3이 되면 숫자를 맞춘 것이므로 축하한다는 메세지를 출력하고 break한다.</li>
</ol>
 