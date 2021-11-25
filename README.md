# 🚀 미션 간단 설명
해당 미션은 우리가 학생시절 자주 하였던 숫자 야구게임을 코드로 구현하는 미션입니다. 
대결은 컴퓨터와 하는 것으로 컴퓨터가 랜덤하게 3자리 수를 만들고 유저는 해당 수를 맞추는 방식으로 진행됩니다.

컴퓨터가 만드는 값은 서로 서로 다른 1~9까지의 수로 이루어진 3자리 수의 숫자이며 입력값에 따른 힌트를 기반으로 숫자를 맞춰야합니다.

## 🔒 제약사항
- 기능을 구현하기 전에 기능 목록을 만들고, 기능 단위로 커밋 하는 방식으로 진행해야한다.
- 기능 요구사항, 프로그래밍 요구사항, 과제 진행 요구사항을 지켜야한다.
- [Java code convention](https://naver.github.io/hackday-conventions-java)을 지키며 코딩해야한다.
- indent depth가 3이 넘지 않도록 구현해야합니다.
- Scanner, Random API대신 camp.nextstep.edu.missionutils에서 제공하는 Randoms, Console API를 활용해 구현해야 합니다.
- Applicatoin Test에 주어진 테스트 케이스가 모두 통과해야합니다.

<hr>

# 🛠 구현할 기능 목록
* Game 시작 메서드 생성
* 랜덤 값으로 상대방(컴퓨터) 수 생성해주는 메서드 생성
* 사용자로부터 입력 받는 함수 생성
* 입력 값이 잘못된 값인지 체크하는 함수 생성 (잘못된 값을 입력할 경우 **IllegalArgumentException**을 발생)
   * 서로다른 수인지 체크 함수
   * 1~9로만 이루어져 있는지 체크 함수
   * 3자리 수인지 체크 함수
* 정답 여부 체크 함수 생성
   * 숫자가 일치하면 게임을 다시 시작할지 선택하는 함수를 호출
   * 정답과 다르다면 힌트 출력
* 힌트 클래스 생성 
   * 사용자 입력에 대한 힌트 탐색 함수 생성
   * 힌트 출력 함수 생성
* 게임 restart를 할지 여부를 묻는 함수 호출


<hr>

# 📋 구현 체크
* [X] Game 시작 메서드 생성
* [X] 랜덤 값으로 상대방(컴퓨터) 수 생성해주는 메서드 생성
   * [X] `camp.nextstep.edu.missionutils`에서 제공하는 Randoms API를 활용해 구현해야 한다.
   * [X] Random 값 추출은 `camp.nextstep.edu.missionutils.Randoms`의 `pickNumberInRange()`를 활용해야한다.
* [X] 사용자로부터 입력 받는 함수 생성
   * [X] `camp.nextstep.edu.missionutils`에서 제공하는 Console API를 활용해야한다.
   * [X] 입력 값은 `camp.nextstep.edu.missionutils.Console`의 `readLine()`을 활용해야한다.
* [X] 입력 값이 잘못된 값인지 체크하는 함수 생성 (잘못된 값을 입력할 경우 IllegalArgumentException을 발생)
   * [X] 서로다른 수인지 체크 함수
   * [X] 1~9로만 이루어져 있는지 체크 함수
   * [X] 3자리 수인지 체크 함수
* [X] 정답 여부 체크 함수 생성
   * [X] 숫자가 일치하면 게임을 다시 시작할지 선택하는 함수를 호출
   * [X] 정답과 다르다면 힌트 출력
* [X] 힌트 클래스 생성 
   * [X] 사용자 입력에 대한 힌트 탐색 함수 생성
   * [X] 힌트 출력 함수 생성
* [X] 게임 restart를 할지 여부를 묻는 함수 호출

<br>

* [ ] indent(인덴트, 들여쓰기) depth를 3이 넘지 않도록 구현하였는가?
* [ ] 3항 연산자를 사용하지 않고 구현하였는가?
* [ ] 모든 테스트케이스가 성공하는가?


