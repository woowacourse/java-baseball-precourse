Main Class
---
####Main Method
'''
* Manage Class의 start Method 호출로 게임 시작.

'''

Computer Class
---
####generate Method
'''
* 랜덤 숫자 생성 및 중복 여부 검사. 
    + 3개의 변수를 선언하고 1 ~ 9 사이의 난수로 초기화.
    + 중복된 숫자가 있을 경우 다시 초기화.
    + 중복이 없을 경우 3 자리의 숫자 저장.
    
'''
####make_check_board Method
'''
* 스트라이크 및 볼 판정을 위한 boolean 배열 선언
    + generate Method에서 저장한 숫자를 배열에 기록.

'''
####get_random_number Method
'''
* generate Method에서 저장한 숫자 반환.

'''
####get_check_board Method
'''
* make_check_board Method에서 기록한 배열을 반환.

'''
####is_valid_number Method
'''
* 사용자가 제시한 숫자가 유효한지 검사
    + 숫자가 아닌 다른 문자가 포함되어있는지 검사
    + 유효한 자릿수(3자리)인지 검사
    + 0 포함 여부 검사
    + 중복된 숫자가 있는지 검

'''
####count_strike_ball Method
'''
* 랜덤 숫자와 사용자의 숫자를 비교하여 결과를 반환
    + 숫자와 자릿수가 같으면 스트라이크
    + 자릿수가 다르다면 볼
    + 스트라이크 및 볼 모두 0이라면 낫싱
    + 3 스트라이크일 경우 종료 결과 반환 

'''

GameManager Class
---
####start_game Method
'''
* while문을 이용하여 게임 진행 
    + 정답이 아니라면 반복 
    + 정답이라면 restart_or_end Method 호출

'''
####restart_or_end Method
'''
* 이전 게임 종료 후 재시작 여부 판단
    + 새로 시작할 경우 1, 재시작
    + 종료할 경우 2, 종료 
    + 입력이 잘못되었을 경우 반복
'''

User Class
---
####input_user_number Method
'''
* 사용자의 숫자 입력 처리 및 저장 

'''
####get_user_number Method
'''
* input_user_number Method에서 저장된 숫자를 반환

'''



