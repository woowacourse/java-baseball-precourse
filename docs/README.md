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
  - [ ] 문자열을 받아서 파싱
  - [ ] 예외 처리 : 3자리, 서로 다른 수, 0~9 -> `IllegalArgumentException`
- 내부 구조
  - [ ] 순서가 있어야하고 3 고정 크기니까 배열로 두는게 편하려나? 아님 `LinkedHashSet`?
- 예상 인터페이스
  - [ ] +play(Hitter) -> PitchingResult

#### Pitcher.PitchingResult

투수의 플레이 결과

- 생성자(List<HittingResult>)
  - [ ] HittingResult 에 따라 결과를 기록
  - [ ] 예외 처리 : 3 개 이상 올 수 없다 -> `IllegaArgumentExcetpion`
- 예상 인터페이스
  - [ ] toString() 으로 문자열 만들까... 뷰의 역할이긴한데 편의성으루,,,

---