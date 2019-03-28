# [Baseball Game by hiwooj]



## * 함수 설명

### 1. int[] randomNumber(int[] computer)

- 야구게임 진행을 위해 컴퓨터가 갖는 값, 랜덤값 3자리 부여받음

  

### 2. boolean checkUser(char[] wrong)

- User 입력값이 3자리 인지, 중복되지 않는지, '0'이 포함되지 않는지 확인

  

### 3. int[] getUser(int[] user)

- User숫자 입력과정, 입력값이 제대로 됐는지 check함수에 적용

  

### 4. int[] getScore(int[] user, int[] computer)

- strike와 ball의 개수를 구하는 함수

  

### 5. int printResult(int strike, int ball)

- 게임 진행 과정 프린트, 게임이 끝났을 경우 게임 지속 여부 확인

  

### 6. void main (String[]args)

- 메인 함수로서, 게임 진행
- 1) 컴퓨터 값 입력 받기
- 2) User값 입력 받기
- 3) strike, ball 개수 구하기
- 4) 게임 다시 시작하는지 여부 확인