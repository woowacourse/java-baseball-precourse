# 프리코스 1주차 미션 - 숫자 야구 게임

---

# ⚾ 구현 기능 목록

## [ 게임 내용 ]

### 사용자 :

    - 컴퓨터(상대방), 유저(나)

### 게임 진행 과정 :

    1. 상대방(컴퓨터)가 임의의 수(3자리)를 생각한다.
    2. 유저(나)가 상대방이 생각한 수를 추측한다.
        2-1. 같은 숫자가 같은 자리에 있으면 스트라이크
        2-2. 같은 숫자가 다른 자리에 있으면 볼
        2-3. 맞는 숫자가 하나도 없으면 낫싱 or 포볼
    3. 정답을 맞출 때까지 #2의 과정을 반복한다.
    4. 게임 종료 혹은 재시작을 결정한다.

## [ 구현 기능 목록 ]

#### 게임 시작, 종료 및 진행 - BaseballGame 클래스

    1. 게임 시작 기능

    2. 게임 종료 기능
      2-1. 비정상 게임 종료
            -> IllegalArgumentException 발생 후 종료

    3. 게임 재시작 / 종료 기능

    4. 게임 진행 기능

### Package : Util

#### 나(유저) - User 클래스

    1. 유저(나) 3자리 숫자를 입력받는 기능
        -> 1~9 이외의 숫자나 문자가 입력될 경우 IllegalArgumentException 예외발생

    2. 중복 숫자를 확인하는 기능

    3. 유저가 추측한 답의 스트라이크, 볼 개수를 세는 기능

    4. 게임 재시작 / 종료 시그널(1 - 재시작, 2- 종료) 입력받는 기능.

#### 상대방(컴퓨터) - Computer 클래스

    1. 상대방(컴퓨터) 랜덤(범위 1~9) 숫자(정답)를 입력받는 기능
        
    2. 랜덤으로 입력받은 각각의 숫자를 하나의 문자열로 합치는 기능

    3. 중복숫자를 확인하는 기능
        -> 중복 숫자가 입력될 경우 숫자 재입력

    4. 입력받은 숫자의 개수를 확인하는 기능

#### 게임 세부 진행 - Game 클래스

    1. 정답 확인 기능
        -> 상대방(컴퓨터)가 선택한 값과 유저가 입력한 값이 같은지 확인.

    2. 힌트 작성 기능 
        -> 유저가 입력한 값에 대해 스트라이크, 볼 판정 후 힌트를 작성.

    3. 게임 재시작 여부 결정 기능
        -> 게임 재시작 / 종료 입력값에 따라 게임 진행여부를 결정하는 기능
        -> 입력값이 (1,2)가 아닐경우 IllegalArgumentException 예외발생 

    4. 스트라이크, 볼 판정하는 기능
        4-1. 같은 숫자 같은 자리 
            -> 스트라이크
        4-2. 같은 숫자 다른 자리 
            -> 볼
        4-3. 같은 숫자 미존재 시 
            -> 낫싱 or 포볼

### Package : view

#### 출력기능 - GameDisplay 클래스

      1. 숫자 입력 문구 출력 기능

      2. 힌트 문구 출력 기능

      3. 정답 문구 출력 기능

      4. 게임 재시작 / 종료 문구 출력 기능

### Package : domain

#### 메시지 출력 문구 - Messages

    1. 숫자 입력 문구
        -> 숫자를 입력해주세요 : 
    
    2. 정답 문구
        -> 3스트라이크
        -> 3개의 숫자를 모두 맞히셨습니다! 게임 종료

    3. 게임 진행 / 종료 문구
        -> 게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.

#### 스트라이크, 볼 문구 - DeterminationPitching

    1. 스트라이크 해당 문구
        -> 스트라이크

    2. 볼 해당 문구
        -> 볼

    3. 스트라이크, 볼 모두 해당 안될 때
        -> 낫싱
