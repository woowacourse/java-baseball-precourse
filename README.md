# ⚾ 숫자 야구 게임

## 📢 구현 기능 목록

1. 1 ~ 9 까지의 서로 다른 임의의 수 3개를 생성한다.
    - RandomUtils 클래스를 이용하여 임의의 수 3개를 생성한다.
2. 정답을 맞추기 위한 3자리수를 입력받는다.
    - 비정상적인 입력에 대해서는 `IllegalArgumentException`을 유도
3. 정답이 아닌 경우 입력값에 대한 `볼`, `스트라이크`, `낫싱` 총 3개의 힌트가 제공된다.
    1. `볼` : 다른 자리에 숫자가 있는 경우
    2. `스트라이크` : 같은 자리에 같은 숫자가 있는 경우
    3. `낫싱` : 같은 숫자가 하나도 없는 경우
4. 입력값이 정답인 경우 게임이 종료, 정답이 아닌 경우 2번으로 다시 이동한다.
5. 게임 종료 후 게임을 다시 시작하거나 완전히 종료할 수 있다.

<br>

## 📝 프로그래밍 요구사항

아래 문항을 반복적으로 체크하자.

1. [Java Code Convention](https://velog.io/@bosl95/JAVA-Code-Convention)
2. [Commit Message Convention](https://velog.io/@bosl95/Commit-Message-Convention)

- 들여쓰기는 '2 spaces'가 아닌 '4 spaces'로 한다.
- indent(인덴트, 들여쓰기) depth를 3이 넘지 않도록 구현한다. 2까지만 허용한다
- 3항 연산자를 쓰지 않는다.
- 함수(또는 메소드)가 한 가지 일만 하도록 최대한 작게 만들어라.
- System.exit 메소드를 사용하지 않는다.
- 비정상적 입력에 대해서는 `IllegalArgumentException`을 발생시킨다. (구현 기능 목록 2번 항목)

- Application 클래스를 활용해 구현해야 한다.
- Application의 패키지 구조와 구현은 변경하지 않는다.
- `final Scanner scanner = new Scanner(System.in);`는 변경하지 않는다.
- `// TODO 구현 진행` 이후 부터 구현한다.

- RandomUtils 클래스를 활용해 랜덤 기능을 구현
- RandomUtils의 패키지 구조와 구현은 변경하지 않는다.

<br>

