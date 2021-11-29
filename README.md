# 미션 - 숫자 야구 게임

## 기능 목록
1. 상대방 수 생성 (makeComputerNumbers)
   - Randoms.pickNumberInRange 사용하여 컴퓨터 랜덤 수 생성 메서드 구현
   - 각 자리수에 중복 숫자 방지를 위해 while 문 사용
     (서로 다른 수가 나올 때까지)
   - 1 ~ 9 사이 값 생성  
    
2. 입력 (inputNumbers)
   - BufferedReader 로 입력
   - 3자리 수/같은 수 입력할 시 IllegalArgumentException
    
3. 스트라이크 카운트 (checkStrike)
   - 자릿수별 비교(상대방 수와 입력값이 같은 경우 count++)
    
4. 볼 카운트 (checkBall)
   - 다른 자릿수에 같은 값 있을 경우 count++
    
5. 게임 시작
   - 조건에 안맞는 값 입력시 앱 종료
    
6. 재시작/종료
   - 정답 입력시 재시작 또는 종료 확인 후 동작
   
7. 출력
   - 입력 값의 볼, 스트라이크 여부 등 출력
   - 조건 분기