# Java-Baseball 기능구현목록
## 1. 컴퓨터의 무작위 숫자 생성(generateComputerNumber)
-  1에서 9까지 서로 다른 수로 이루어진 무작위의 3자리 수 생성

## 2. 게임 플레이어의 숫자 입력(getUserNumber)
-  세 자리 숫자 입력 받기(getUserNumber)
-  검증하기(조건1. 세 자리 자연수(validateLength, validateInteger) 조건2. 0이 포함되어서는 안됨(validateZero) 조건3. 중복된 숫자가 있어서는 안됨(validateSameNumber))
-  검증이 실패할 시 반복해서 입력 받기
    
## 3. 입력받은 두 숫자 간의 비교를 통해 스트라이크와 볼의 개수 연산(computeCount)
- 요구사항에 적힌 통상적인 숫자야구의 규칙에 따름
- 볼의 연산(computeBalls), 스트라이크(computeStrikes)의 연산을 분리

## 4. 숫자를 모두 맞힐 때까지 반복 입력 받기(playBaseball)
- 볼과 스트라이크 개수에 따른 반복 여부 판단
- 쓰리 스트라이크 출력 시 반복 중단 및 게임 종료 

## 5. 게임의 반복시행 및 종료(askReplay, main)
-  1회차 게임이 종료되면 게임의 시작과 종료를 입력받음
-  선택 여부에 따라 게임을 반복시행 