# 미션 - 숫자 야구 게임


## ✔️ 구현 목록

1. 시작
   - 3자리 난수 생성
2. 게임 진행
   - 3자리 숫자 입력
     - 입력값 유효성 검사
     - String -> ArrayList<Integer> 변환
   - strike, ball count
   - 결과 출력
4. 종료
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

---
###ver2

####개요
    이전 버전에서 프로그램의 구조를 생각하지 않고
    실행할 기능의 순서대로만 짰던 것에 문제가 있다고 판단
    Game을 Class로 개념화하여 생각해보자

1. 시작 (Game 객체 instance화) ✔Game.java Class 추가
    - 3자리 난수 생성: 생성자 호출 시 answer 초기화 ✔
2. 게임 진행 (game.play()) ✔game.play() 추가
    - 3자리 숫자 입력 ✔game.inputToArrayList()
        - 입력값 유효성 검사
        - String -> ArrayList 변환
    - strike, ball count ✔game.countScore()
    - 결과 출력 ✔game.printScore()
4. 종료 ✔game.endsGame()
    - 재시작 여부 검사
        - 입력값 유효성 검사