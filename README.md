# 미션 - 숫자 야구 게임


## ✔️ 구현 목록

1. 시작
   - 3자리 난수 생성
   - 3자리 숫자 입력
     - 입력값 유효성 검사
2. 점수 출력
   - strike, ball count
   - 결과 출력
3. 종료
   - 재시작 여부 검사
     - 입력값 유효성 검사

---
###ver1

1. 시작
    - 3자리 난수 생성 ✔BaseballUtil.generateAnswer()
    - 3자리 숫자 입력 ✔BaseballUtil.checkAnswer()
        - 입력값 유효성 검사
2. 점수 출력
    - strike, ball count ✔BaseballUtil.countScore()
    - 결과 출력 ✔BaseballUtil.printScore()
3. 종료
    - 재시작 여부 검사 ✔Application에서 status 변수 활용
        - 입력값 유효성 검사

####문제
    - timeout 발생
        너무 많은 String 연산
        비효율적인 validation