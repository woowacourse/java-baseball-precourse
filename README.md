# 숫자 야구게임

## 게임 정의 

하나의 게임은 여러개의 턴으로 이루어져있다.

하나의 게임은 3개의 1 ~ 9 까지 중복되지 않은 숫자리스트 를 정답값으로 가지고 있다.

턴의 진행

하나의 턴은 세개의 숫자로 이루어진 예측값을 현재 게임의 정답과 확인하여 결과값을 출력하면 턴이 종료된다.

종료조건

플레이어가 제시한 3개의 수가 정답값의 자리와 숫자 모두 일치하면 종료된다.

## 프로젝트 구조

constants : 게임진행에 필요한 상수들

game : 게임을 실행하는 객체

utils : 입출력, 제약조건 검증, 난수리스트 생성 유틸

domain : 게임진행에 필요한 값을 가지고 있는 객체

---

## 기능 목록

- 게임 생성 BaseballGame

    게임의 정답값인 1 ~ 9 까지 중복되지 않은 난수 생성.

- 결과값 체크 BaseballGameTurn

    사용자가 입력한 값을 정답과 확인해 결과값을 낸다.

    볼과 스트라이크 갯수를 각각 체크한다

    - 스트라이크 : 숫자, 자리 모두일치

    - 볼 : 숫자만 일치

    - 게임 종료 조건 : 3 스트라이크
 
- 결과 메세지 생성 BaseballGameTurn

    체크된 결과값을 출력값으로 만든다

    스트라이크가 3개 *모든 숫자와 자리를 맞추었을때* 

    결과값과 함께 "3개의 숫자를 모두 맞히셨습니다! 게임 종료" 

    - Format

        결과값과 개행을 출력한다.

        "[N]볼␣[N]스트라이크"

        볼과 스트라이크가 둘다 있을때는 볼, 스트라이크 순서로 공백문자로 구별한다.

        볼과 스트라이크 모두없을때

        "낫싱"

- 입력 처리 UserInputHandler

    프롬프트를 출력하고 사용자의 입력값을 받아온다.

    - 각 턴 진행시 사용자의 예측값을 입력받는다.
    - 게임 종료시 새로운 게임 또는 종료를 위해 입력받는다.

- 입력값 검증 GameValidator

    사용자 예측값 예외 처리

        - 1 ~ 9 이외의 값을 입력했을때. 

        - 입력한값이 모두 숫자이지만 3개가 미만일때.

        - 중복된 값이 있을때.
    
    재시작 확인 입력값
        
        숫자이외의 값이 들어왔을때

    예외 발생시 IllegalArgumentException 을 발생시키고 프로그램을 종료시킨다.

- 결과 확인

    만들어진 결과값을 출력한다.

    - 정답을 맞추지 못했을때

        턴을 다시 시작한다
    - 정답을 맞춘경우

        다시 게임을 진행할지에 대한 입력값을 받아서 처리한다


---

## 세부 사항

1. BaseballGame 생성

2. Game 의 정답값 TargetNumber 생성

3. BaseballGameTurn 생성

4. Turn 을 진행할 UserExpectation 생성

5. 정답값과 비교후 결과메세지 생성

6. 결과값 출력

7. 정답을 맞추지 못했을때 -> 3. 으로 

8. 3 스트라이크시 게임진행여부 확인
   - 1 일때 -> 3. 으로 
   - 2 일때 -> 종료

