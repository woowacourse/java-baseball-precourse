# Java Baseball

> 우아한 테크 코스 :: 온라인 과제 1주차
   
## 기능 목록

- 유저 인터페이스
    - 사용자 출력
        + 숫자를 입력해주세요
        + 게임 종료
        + 힌트
        + 리플레이 여부
    - 사용자 입력
        + guessNumber
        + 리플레이 여부
- Computer 인터페이스
    + 정답 여부
    + 힌트 얻기
- Player 인터페이스
    + guessNumber setter
    + guessNumber getter
- 게임 1회 진행
    + guessNumber 받기 `(a)`
        * 정답 : 게임 종료
        * 오답 : 힌트 출력 후, `(a)` 로 이동
- 리플레이 구현 (게임 N회 진행)
- Computer 클래스 구현
    + randomNumber(answer) 생성
- Player 클래스 구현
    + guessNumber 주입 시 유효하지 않은 범위는 IllegalArgumentException

