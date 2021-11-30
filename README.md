# 미션 - 숫자 야구 게임

## ✔ 서비스 흐름
1. 게임이 시작되면, 게임에 사용될 랜덤 번호(111 ~ 999 사이)를 생성합니다.
2. 사용자에게 번호를 입력받습니다.
3. 사용자가 입력한 번호와 사전에 생성된 랜덤 번호를 비교합니다.
4. 비교한 결과에 대해 사용자에게 알립니다.<br>
   4-1. 정답인 경우, 정답임을 출력하고 5번으로 이동합니다.<br>
   4-2. 정답이 아닌 경우, 비교한 내용을 출력하고 2번으로 이동해 위 내용을 반복합니다.
5. 사용자에게 게임 재개여부를 입력받습니다.<br>
   5-1. 종료 값을 입력 받으면, 게임을 종료합니다.<br>
   5-2. 재개 값을 입력 받으면, 1번으로 이동해 위 내용을 반복합니다.

## ✔ 클래스
### Application
- BaseballGame game

- main(String[])

### BaseballGame
`Role: 게임 진행 클래스`

- boolean restart
- boolean isCorrect
- Computer computer
- Player player

- play()
- getPlayerInput(String)
- compareComputerWithPlayer(int[], int[])
- setRestart()
- getRestart()
- manageResult()

### Numbers
`Role: 수 관리 클래스`

- isValidNumber(int[])
- convertNumberToArray(int)
- checkDuplicatedNumbers(int[])
- checkNotInZero(int[])

### Computer extends Numbers
`Role: 사용자와 플레이하는 컴퓨터 클래스`

- int[] randomValue

- generateValidRandom()
- generateRandom()

### Player extends Numbers
`Role: 게임하는 사용자 클래스`

- int[] inputValue

- setInputValue(int)
- isValidNumber()

### InvalidInputException
`Role: 잘못된 입력에 대한 에러 처리 클래스`

only use constructor through overriding

1. 사용자가 입력한 값이 입력 범위를 넘어서는 경우 (예) 1234, 000
2. 사용자가 입력한 값에 중복된 수나 0이 있을 경우
3. (게임 재게 여부 입력 시)1과 2가 아닌 다른 값을 입력하는 경우
