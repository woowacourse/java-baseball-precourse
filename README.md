# 미션 - 숫자 야구 게임

---
## 📑 구현 기능 목록
- [x] 야구게임의 정답이 되는 수를 설정한다. ( 랜덤 라이브러리 이용 )
  - 여기서 정답이 되는 수는 1부터 9까지 서로 다른 수로 이루어진 3자리 수
- [ ] 사용자에게 숫자 입력받는다.
  - 입력 받을 때 "숫자를 입력해주세요 : "가 출력된다. 
  - 1부터 9까지의 서로 다른 수로 입력받아야 한다.
  - <예외> 숫자 외 문자가 포함된 경우
  - <예외> 3자리수가 아닌 경우
  - <예외> 각 자리의 숫자의 범위가 벗어난 경우(1 <= n <= 9)
  - <예외> 숫자가 중복된 경우 (ex: 111, 222, 333)
- [ ] 사용자가 제시한 수와 야구게임의 정답과 비교한다.
  - 스트라이크 : 같은 자리, 같은 수
  - 볼 : 다른 자리, 같은 수
  - 낫싱 : 모든 수가 일치X
- [ ] 비교한 결과를 문자열로 출력한다.
  - 스트라이크, 볼, 낫싱
  - 볼 -> 스트라이크 순서로 출력이 된다.
- [ ] 게임 종료 시 재시작 여부를 묻는다.
  - 1 입력 => 재시작
  - 2 입력 => 종료
