# 숫자야구

## 회고

- depth가 2 넘지않도록 의식해서 프로그래밍 했고 그 결과 더러워보이지는 않도록 프로그래밍할 수 있었다.
- 함수가 한가지일을 하도록 만들라 했는데 함수에서 여러 메소드를 실행하는 경우도 포함인지 궁금하다
- 한번의 기능을 만들 때 마다 커밋하는게 힘들었다.A를 만드는 도중 B를 만들어야 A가 동작해서 B를 만드는데 또 C를 만들어야 하는 경우가 많았어서 커밋 시기를 많이 놓쳤다. 다음 과제에는 최대한 신경써야겠다.

## 기능 정의

### Target 숫자 구현

- computer 클래스 생성
    - makeTargetSet()
        - `camp.nextstep.edu.missionutils.Randoms`의 `pickNumberInRange()`
        - LinkedHashSet 사용하여 중복 값 방지
    - toIntArray()

### 입력 구현

- User 클래스 생성
    - getInput()
        - `camp.nextstep.edu.missionutils.Console`의 `readLine()`
    - checkLen()
        - 3자리수인지 확인
    - isSame()
        - 입력값에 중복 있으면 오류 발생
    - toInt()
        - 문자열을 숫자로 바꿈
    - toArray()
        - 3자리 숫자를 배열로 바꿈

### 심판 구현

- Umpire 클래스 생성
    - init()
    - isStrike()
    - isBall()
    - contains()
        - 배열안에 숫자가 있는지 확인
    - isNothing()
    - isEnd()
        - 3스트라이크인지 확인
    - checkResult()
        - 스트라이크, 볼 , 낫싱 결과를 알려줌

### 리팩토링

- 숫자야구 3자리 변경 가능하도록 상수처리
- 전체 코드 컨벤션 확인

### 테스트

- Computer가 숫자를 잘 받아오는지 확인하기 위해 테스트 작성
