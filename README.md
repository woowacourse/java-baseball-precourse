# 미션 - 숫자 야구 게임

## 📝 기능 명세

클래스

Computer, Player, BaseballGame

> BaseballGame

- [x] 게임 흐름 관리
   - 게임 시작
   - 사용자 입력받기
   - 컴퓨터에게 입력 전달 및 결과받아서
   - 게임이 끝나지 않았다면 반복 끝났다면 사용자에게 재시작 여부 반환받음

> Computer

- [x] 정답을 결정 : determineAnswerBalls()
    - Randoms.pickNumberInRange() 사용
- [x] 결과 산출 : compareBalls(palyerInput) : Hint 반환
   - 스트라이크 : 자리와 숫자 모두 일치
   - 볼 : 자리 말고 숫자만 일치
   - 낫싱 : 0볼 0스트라이크의 경우

> Player

- [x] 컴퓨터의 숫자 예측 : predictBalls()
    - Console.readLine() 사용
    - 예외 : 입력 숫자가 3자리가 아닌 경우
    - 예외 : 입력이 숫자가 아닌 경우
    - 예외 : 입력 숫자에 0이 포함되는 경우
    - 예외 : 입력 숫자가 중복되는 경우
- [x] 재시작할지 종료할지 결정 : wantRestart()
    - Console.readLine() 사용
    - 예외 : 입력 숫자가 1이나 2가 아닌 경우

> GameOutput

- [x] 게임 힌트 출력 : printHint(hint)
   - 볼 -> 스트라이크 순서
   - 없는 경우 낫싱 출력
   - 3스트라이크시 게임 종료 출력