# 미션 - 숫자 야구 게임

### 🎯 구현할 기능 목록

#### 힌트

- [x] 같은 자리에 같은 숫자가 있는 경우 `스트라이크`
- [x] 다른 자리에 같은 숫자가 있는 경우 `볼`
- [x] 같은 숫자가 하나도 없는 경우 `낫싱`

#### 컴퓨터 랜덤 수 생성

- [x] 1 ~ 9까지 서로 다른 임의의 수 3개를 생성한다.
    - `camp.nextstep.edu.missionutils.Randoms` 의 `pickNumberInRange()` 를 활용한다.

#### 입력

- [x] 1 ~ 9까지 서로 다른 임의의 수 3개를 입력받는다.
    - `camp.nextstep.edu.missionutils.Console` 의 `readLine()` 을 활용한다.
- [x] 비정상적 입력에 대해서는 `IllegalArgumentException` 발생한다.
    - [x] 1 ~ 9가 아닌 경우
    - [x] 문자를 포함한 경우
    - [x] 중복된 숫자가 있는 경우
    - [x] 3자리수의 숫자가 아닌 경우

#### 종료

- [x] 3자리의 숫자가 정답과 같은 경우 게임이 종료된다.
    - [x] 게임을 새로 시작하려면 `1` 을 입력한다.
    - [x] 게임을 완전 종료하려면 `2` 를 입력한다.
    - [x] 비정상적 입력에 대해서는 `IllegalArgumentException` 발생한다.
        - [x] 1, 2가 아닌 다른 숫자를 입력받는 경우

### ✅ 확인할 목록

- [x] 코드 컨벤션을 지키면서 프로그램한다.
- [x] indent(인덴트, 들여쓰기) depth 3이 넘지 않도록 구현한다.
- [x] 3항 연산자를 쓰지 않는다.
- [x] 함수(메소드)가 한 가지 일만 하도록 최대한 작게 만든다.
- [x] `camp.nextstep.edu.missionutils` 에서 제공하는 `Randoms`, `Console` API 를 활용한다.