# 미션 - 숫자 야구 게임

## ✅ 구현할 기능 목록

### 1. 랜덤 숫자 값 생성(Computer.class)
- 1부터 9까지 서로 다른 수로 이루어진 세 자리의 수
### 2. 랜덤 숫자 값을 검증(Computer.class)
- 3자리의 자연수인지 확인
- 1부터 9까지의 서로 다른 수로만 이루어져 있는지 확인
- 통과 시 true(VALID_SUCCESS), 실패 시 false(VALID_FAILED) 리턴
  - `validateNumbers()`
- 잘못된 경우 (1)의 과정 반복
### 3. 사용자 숫자 값 입력(Game.class)
- 1부터 9까지 서로 다른 수로 이루어진 세 자리의 수
### 4. 사용자 입력 숫자 값을 검증(Game.class)
- 사용자의 입력 숫자 값을 검증
  - `validateDateType()`
  - `validateCount()`
  - `validateRange()`
- 잘못 입력한 경우 `IllegalArgumentException`를 발생
### 5. 입력 숫자 값과 랜덤 숫자 값을 비교(Computer.class)
- 같은 수가 같은 자리에 있으면 스트라이크
- 같은 수가 다른 자리에 있으면 볼
- 같은 수가 전혀 없으면 포볼 또는 낫싱
### 6. 비교 결과에 따른 힌트 출력(Game.class)
- 예시 : 1볼 1스트라이크
### 7. 정답 여부 판단(Game.class)
- 오답의 경우 (3)을 반복
- 정답의 경우 통과
### 8. 야구게임 재실행 여부 입력(Controller.class)
- 1 또는 2 입력
### 9. 재실행 판단(Controller.class)
- 1 입력 시 (1)을 반복
- 2 입력 시 게임 종료
- 입력값이 1, 2가 아닐 경우 `IllegalArgumentException`를 발생

<br>

---

## 📝 License

This project is [MIT](https://github.com/woowacourse/java-baseball-precourse/blob/master/LICENSE) licensed.
