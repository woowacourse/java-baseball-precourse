# 미션 - 숫자 야구 게임

## 🚀 기능 목록

### 난수 발생

- ```camp.nextstep.edu.missionutils.Randoms``` 의 ```pickNumberInRange()``` 으로 3개의 난수를 생성한다.
- 1부터 9사이의 난수를 생성한다.
- 3개의 난수가 서로 다른 수인지 검증한다.

### 게임 결과 구현

- 1자리 기준
  - 같은 수 && 같은 자리 == 1스트라이크
  - 같은 수 && 다른 자리 == 1볼
- 3자리 기준
  - 모두 같은 경우 == 승리 (해당 게임 종료)
  - 모두 다른 경우 == 낫싱
  
### 사용자 입력 및 예외 처리

- 입력 
  - 야구 게임 숫자 입력 (1부터 9까지 중 서로 다른 3자리 수)
  - 종료 입력 (재시작(1), 게임 종료(2) 숫자 입력)
- 야구 게임 숫자 입력에 대한 예외 처리
  - 숫자를 입력하지 않은 경우
  - 입력한 값의 길이가 4 이상인 경우
  - 입력한 3자리 중 같은 수가 있는 경우

