# 미션 - 숫자 야구 게임 - 정수현

## 구현 기능 목록
1. 한 자리 숫자 3개를 요소로 가지는 숫자 배열을 생성한다(AnswerGenerator).
    - 정답이 될 세 자리 난수를 생성한다.
    - 각 자리 수를 분리하기 위해 문자열로 바꾼다(generateRandomNumberString()).
    - 길이 3의 숫자로 이루어진 문자열을 하나씩 분리하여 배열에 담아 반환한다(generateRandomNumbers()).

2. 사용자 입력을 받는다(Input).
    - 세 자리 정수 형태의 문자열을 입력 받는다(getUserInput()).
    - 입력 받은 문자열을 하나씩 분리하여 배열에 담아 반환한다.(generateUserInputList())

3. 유효성 검사(NumberValidator)
    - 입력받은 배열이 다음 조건을 만족하는지 판단한다(isValid()).
        - 길이가 3이다(isValidLength()).
        - 각 요소는 0이 아니다(isNotZero()).
        - 각 요소는 서로 중복되지 않는다(isNonRedundant()).
    - 생성한 난수와 사용자 입력이 유효한 수인지 판단하는데 사용한다.

3. 사용자의 입력을 판단하고 결과를 반환(GameRule).
    - 정답과 입력 사이에 같은 인덱스와 같은 숫자가 있는지 확인(countStrike())
    - 같은 숫자 and 다른 인덱스(countBall())
    - 같은 숫자 없음(isNothing())
    - 모두 같은 숫자 and 같은 위치(isWin())

4. isWin이 참을 반환할 경우, 사용자의 입력을 받아 게임을 종료 혹은 재시작한다.
    - 게임 종료 혹은 재시작 isRestart()
    - 1을 입력 받으면 게임을 재시작하고, 2를 입력받을 경우 게임을 종료한다.

