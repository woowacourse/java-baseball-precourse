기능 구현 목록
---
 
##### 0. 자료구조
- 게임에 사용될 3자리 배열 : Number class
- 볼 카운트 데이터        : Ballcount class

##### 1. Repository, Service 인터페이스 생성
- 2~8까지의 함수를 모아둔 인터페이스와 Repository class 생성

##### 2. 게임 라이프 사이클 반복
- run() : 0 -> 1 -> 2-> 3-> 4-> 5-> 6 -> 반복 or 종료

##### 3. 컴퓨터 숫자 생성
- 컴퓨터 난수 생성 : createNumber()

##### 4. 게임 메세지 출력
- 게임 가이드 메세지 출력 : guideMessage()

##### 5. 사용자 입력
- 사용자의 값 입력 : input()

##### 6. 사용자 숫자 검사
- 1~9이외 값, 중복 검사확인 : userNumCheck()

##### 7. 볼 카운트 검사
- 스트라이크, 볼인지 검사 : playGame()

##### 8. 볼 카운트 메세지 출력
- X 스트라이크 X 볼 : printBallCount()
---

##### 게임시작 서비스 생성 
- main() : Numberbaseballgame class
- 게임시작 loop : Service 객체 생성

