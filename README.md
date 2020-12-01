# 우아한테크코스 1주차 미션 - 숫자 야구 게임

## 🚀 TODO
- [X] 상수 클래스
- [X] 에러 메시지 열거형
- [X] 게임 결과 저장용 클래스
    - [X] 클래스 변수
    - [X] 생성자
    - [X] 스트라이크 갯수를 알려주는 메소드
    - [X] 볼 갯수를 알려주는 메소드
    - [X] 게임 종료 여부를 판별해주는 메소드
- [X] 유틸리티 클래스
    - [X] 무작위 숫자로 이루어진 정답 베열을 생성해주는 메소드
    - [X] 저장된 게임 결과를 이용해 출력할 문자열을 생성하는 메소드
    - [X] 사용자의 정답 추측 문자열을 파싱하는 메소드
    - [X] 사용자의 게임 재시작 요청 문자열을 파싱하는 메소드
    - [X] 사용자의 정답 추측 문자열에 이상이 없는지 확인하는 메소드
    - [X] 사용자의 게임 재시작 요청 문자열에 이상이 없는지 확인하는 메소드
- [X] `BaseballNumbers` 클래스
    - [X] 클래스 변수
    - [X] 생성자
    - [X] 배열의 크기가 지정된 제한을 넘는지 확인하는 메소드
    - [X] 배열 내에 중복된 요소가 없는지 확인하는 메소드
    - [X] 배열 내에 범위를 벗어난 요소가 없는지 확인하는 메소드 
    - [X] 특정 인덱스와 특정 값의 스트라이크를 판별해주는 메소드
    - [X] 특정 인덱스와 특정 값의 볼을 판별해주는 메소드
    - [X] 두 개의 `BaseballNumbers` 객체를 비교하여 스트라이크를 세어주는 메소드
    - [X] 두 개의 `BaseballNumbers` 객체를 비교하여 볼을 세어주는 메소드
- [X] `BaseballGame` 클래스
    - [X] 클래스 변수
    - [X] 생성자
    - [X] 경기를 진행하는 메소드
- [X] `ConsoleBaseballProgram` 클래스
    - [X] 게임 진행 메소드
    - [X] 게임 반복 메소드
- [X] `Application` 클래스
    - [X] `main` 메소드

## 🤔 구현 세부 사항

게임의 시작/재시작과 입출력을 맡을 `Application` 클래스, 게임 내에서 사용할 변수들을 담당할 `BaseballGame` 클래스, 야구 게임의 숫자들을 저장하고 비교할 `BaseballNumbers` 클래스로 나누었다.

### `BaseballNumbers` 클래스

#### 클래스 내 변수

- `MAX_PITCH`
    - 최대 투구 횟수를 저장하는 `public static int` 상수
    - 미션에 명세되어 있는 대로 이 값은 3이다
- `numberList`
    - 정답 또는 사용자의 추측을 저장할 `List<Integer>` 자료형

#### 클래스 내 메소드

- `BaseballNumbers(List<Integer> numberList)`
    - 입력받은 `numberList`을 검증한 후 `this.numberList`에 저장
    - 내부 구현:
        - `validateSize(numberList)`와 `validateDuplicate(numberList)`를 실행
        - `this.numberList`에 `numberList`를 저장
- `private void validateSize(List<Integer> numberList)`
    - `numberList`의 크기가 `MAX_PITCH`와 일치하는지 검사
    - 내부 구현:
        - `numberList.size()`의 값이 `MAX_PITCH`와 일치하는지 확인
        - 만일 일치하지 않을 경우 `IllegalArgumentException()` 발생
- `private void validateDuplicate(List<Integer> numberList)`
    - `numberList` 내에 중복된 원소가 없는지 검사
    - 내부 구현:
        - `numberList`를 이용하여 `HashSet<Integer> numberListSet` 생성
        - `numberList.size()`의 값이 `numberListSet.size()`와 일치하는지 확인
        - 만일 일치하지 않을 경우 `IllegalArgumentException()` 발생
- 작성중

### `BaseballGame` 클래스

#### 클래스 내 변수

- `MIN_NUMBER`
    - 숫자 야구 게임에 사용할 가장 작은 숫자를 저장하는 `public static int` 상수
    - 미션에 명세되어 있는 대로 이 값은 1이다
- `MAX_NUMBER`
    - 숫자 야구 게임에 사용할 가장 큰 숫자를 저장하는 `public static int` 상수
    - 미션에 명세되어 있는 대로 이 값은 9이다
- 작성중

#### 클래스 내 메소드

- `BaseballGame()`
    - 작성중
- `private List<Integer> generateAnswer(final int listSize)`
    - 길이가 `listSize`인 서로 다른 수를 가진 `List<Integer>`를 생성
    - 내부 구현:
        - `LinkedHashSet<Integer> answerSet` 생성
        - `RandomUtils.nextInt(1, 9)` 호출을 통해 `MIN_NUMBER`~`MAX_NUMBER` 사이의 랜덤한 숫자 추출하여 `answerCandidate`로 설정
        - `answerSet.contains(answerCandidate)`를 통해 해당 숫자가 `answerSet에 있는지 확인
        - 해당 숫자가 이미 `answerSet`에 있을 경우, `answerSet`에 없는 숫자를 얻을 때까지 앞의 과정 반복
        - `answerSet`에 해당 숫자를 삽입
        - `answerSet`의 크기가 `listSize`가 될 때까지 숫자를 넣는 과정 반복
        - `answerSet`을 이용해 생성한 `ArrayList<Integer>` 반환
- 작성중

### `Application` 클래스

#### 클래스 내 변수

- 작성중

#### 클래스 내 메소드

- `List<Integer> parseUserGuessString(string userGuessString)`
    - 사용자가 입력한 문자열인 `userGuessString`을 `List<Integer>`로 변환
    - 내부 구현:
        - 작성중
- `main()`
    - 프로그램의 동작을 제어하고 입출력을 담당
    - 내부 구현:
        - 매 반복마다 새로운 `BaseballGame` 객체 생성
        - 사용자에게 숫자 입력을 요청하는 문구 출력
        - `scanner.nextLine()`을 통해 문자열을 입력을 받음
        - 문자열을 파싱하여 `List<Integer>`로 변환
        - 변환된 `List<Integer>`를 `BaseballGame` 객체에 전달
        - 스트라이크와 볼을 이용해 알맞는 문구 출력
        - 게임이 종료되었는지 확인
        - 게임이 종료되지 않은 경우, 문자열 입력 단계부터 절차를 반복
        - 게임이 종료된 경우, 게임 종료를 안내하고 게임을 다시 시작할지 질문 
        - 다시 시작하지 않길 원할 때까지 위의 절차를 반복
        - 다시 시작하지 않길 원하는 경우 반복 종료
- 작성중

## 📝 License

This project is [MIT](https://github.com/woowacourse/java-baseball-precourse/blob/master/LICENSE) licensed.
