# 기능 목록 단위

## 모델

---

### Hitter

수를 가지는 타자(컴퓨터)

- 생성자
  - [x] 기본 생성자 : 랜덤 수 설정
  - [x] 추가 생성자 : 해당 숫자를 기반으로 수 설정
    - [x] 예외 처리 : 3자리, 서로 다른 수, 0~9 -> `IllegalArgumentException`
- 내부 구조
  - [x] 리스트 ~~순서가 있어야하고 3 고정 크기니까 배열로 두는게 편하려나? 아님 `LinkedHashSet`?~~
- 예상 인터페이스
  - [x] +hit(Int,Int)->HittingResult : x[0-2] 번째 수에 y[0-9] 수 제시
    - [x] 예외 처리 : 각각 수의 범위 체크 -> IllegalArgumentException
    - [x] 값에 따라 STRIKE, BALL, NOTHING

---
    
### Pitcher

수를 던지는 투수(사용자)

- 생성자(String)
  - [x] 문자열을 받아서 파싱
  - [x] 예외 처리 : 3자리, 서로 다른 수, 0~9 -> `IllegalArgumentException`
- 내부 구조
  - [x] 리스트~~순서가 있어야하고 3 고정 크기니까 배열로 두는게 편하려나? 아님 `LinkedHashSet`?~~
- 예상 인터페이스
  - [x] +play(Hitter) -> PitchingResult

#### Pitcher.PitchingResult

투수의 플레이 결과

- 생성자(List<HittingResult>)
  - [x] HittingResult 에 따라 결과를 기록
  - [x] 예외 처리 : 3 개 이상 올 수 없다 -> `IllegaArgumentExcetpion`
- 예상 인터페이스
  - ~~[ ] toString() 으로 문자열 만들까... 뷰의 역할이긴한데 편의성으루,,,~~

---

### BaseBallGame

타자와 투수를 구성해주는 야구 게임 모델

- 생성자
  - [x] 타자만 초기화 시켜주면 될듯
- 내부 구조
  - [x] 타자 하나 가진다.
- 예상 인터페이스
  - [x] restart()
  - [x] mount(String) -> PitchingResult
  - [x] mount(Pitcher) -> PitchingResult
    - [x] 게임이 이미 끝난경우 -> `IllegalStateException`

---

## 뷰 컨트롤러 느낌

---

### BaseBallGamePlay

그냥 진행로직 전부 때려박자
