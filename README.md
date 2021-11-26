# 미션 - 숫자 야구 게임

## 기능 목록

* **Game.java**
  * 전체 게임을 책임지는 Class
    * 게임과 라운드를 실행
    * 라운드 재시작 여부 확인 (예외처리)

* **Computer.java**
  * 게임 진행을 책임지는 Class
    * 1부터 9까지 중복되지않는 3자리 난수 생성
    * 사용자입력과 난수 비교
    * 비교 결과에 따른 힌트 제공

* **Validation.java**
  * 예외처리를 책임지는 Class
    * 사용자입력을 분석
    * 1부터 9까지 중복되지않는 3자리수가 아닐 시 IllegalArgumentException() 발생

* **Constants.java**
  * 프로그램에 전체적으로 사용되는 상수를 책임지는 Class

## 프로그램 진행

* 게임 시작

  * 라운드 시작
    * 난수 생성
    * 숫자 예상
    * 사용자입력과 난수 비교
    * 결과 제공
      * 정답일 경우 라운드 종료
      * 오답일 경우 힌트 출력 후 숫자 재예상

  * 재시작 여부 확인
    * 입력이 "1" 일 경우 새로운 라운드 시작
    * 입력이 "2" 일 경우 게임 종료
