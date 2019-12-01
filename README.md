<h1>우아한 테크코스 프리코스</h1>
<h2>1주차 미션 - 숫자 야구 게임</h2>
<h2>제작 : 황보경(https://github.com/hwangbo)</h2>

<h3>실행 방법</h3>
<span>NumberBaseball.java에서 컴파일.</span>

<h3>기능 구현 목록</h3>
<ol>
    <li>
        NumberBaseball.java
        <ul>
            <li>메인 함수가 담겨있는 클래스.</li>
            <li>게임을 다시 시작할 지 끝낼 지 정하게 됨.</li>
        </ul>
    </li>
    <li>
        Game.java
        <ul>
            <li>게임을 시작하는 gameStart 함수.</li>
            <li>숫자를 입력받는 inputSlice 함수.</li>
            <li>정답을 확인하는 checkAnswer 함수.</li>
            <li>볼카운트를 늘리는 comparing 함수.</li>
            <li>볼카운트에 따라 출력하는 ballCount 함수.</li>
        </ul>
    </li>
    <li>
        Divider.java
        <ul>
            <li>숫자를 ArrayList로 만들어주는 divide 함수.</li>
        </ul>
    </li>
    <li>
        Answer.java
        <ul>
            <li>정답이 될 랜덤 숫자를 만들어주는 answerCreate 함수.</li>
        </ul>
    </li>
    <li>
        Check.java
        <ul>
            <li>정답이 될 숫자에 중복되는 수가 있는지 확인하는 checkCreateOverlap 함수.</li>
            <li>입력받은 숫자에 중복되는 수가 있는지 확인하는 checkOverlap 함수.</li>
        </ul>
    </li>
</ol>
