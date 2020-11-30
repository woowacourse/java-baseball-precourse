1. Random Number 3개 설정
    -
    - 1~9까지의 랜덤한 숫자 세개를 생성하여 target int 배열에 저장한다.
2. 플레이어 숫자 입력
    -
    - Scanner를 통해 플레이어에게 세자리 숫자를 받은 후 input int 배열에 저장한다.
    
        2.1) 예외 처리 - IllegalArgumentException 발생
        
        - 숫자가 아닌 문자가 입력되었을 경우
        - 입력된 숫자의 개수가 3개가 아닌 경우
        - 숫자 0을 입력하였을 경우
            
            -> 숫자 1 ~ 9가 아닌 모든 경우에 대해 throw IllegalArgumentException
3. 스트라이크 확인
    - 
    - target과 input 배열을 비교하여 스트라이크 갯수 체크
    - strike int 변수에 값 저장
4. 볼 확인
    -
    - target과 input 배열을 비교하여 볼 갯수 체크
    - ball int 변수에 값 저장
5. 결과 출력
    -
    - 저장된 strike와 ball의 값을 출력
    - strike와 ball이 모두 0이면 "낫싱" 출력
    - strike가 3인 경우 "3스트라이크" 출력 후 "3개의 숫자를 모두 맞히셨습니다! 게임 종료" 문구 출력
    - 한 라운드 종료 후 "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요." 출력
6. 반복
    -
    - 1을 입력받으면 다시 target을 설정하고 guess 시작