Main Class
---
* #### Main Method
```
1. Manage Class의 start Method 호출로 게임 시작.
2. 첫 게임 종료 후 재시작 및 프로그램 종료여부 확인. 
```

Computer Class
---
<<<<<<< HEAD
* #### generate_randomNumber Method
=======
* #### generateRandomNumber Method
>>>>>>> master
```
1. 랜덤 숫자 생성 및 중복 여부 검사. 
    1.1 3개의 변수를 선언하고 1 ~ 9 사이의 난수로 초기화.
    1.2 중복된 숫자가 있을 경우 다시 초기화.
    1.3 중복이 없을 경우 3 자리의 숫자 저장.
```
<<<<<<< HEAD
* #### make_checkBoard Method
=======
* #### makeCheckBoard Method
>>>>>>> master
```
1. 볼 판정을 위한 boolean 배열 선언
    1.1 generate_randomNumber Method에서 저장한 숫자를 boolean 배열에 기록.
```
<<<<<<< HEAD
* #### get_randomNumber Method
=======
* #### getRandomNumber Method
>>>>>>> master
```
1. generate Method에서 저장한 숫자 반환.
```

<<<<<<< HEAD
* #### get_checkBoard Method
=======
* #### getCheckBoard Method
>>>>>>> master
```
1. make_check_board Method에서 기록한 배열을 반환.
```

<<<<<<< HEAD
* #### check_userNumber Method
=======
* #### checkUserNumber Method
>>>>>>> master
```
1. 사용자가 제시한 숫자가 유효한지 검사
    1.1 숫자가 아닌 다른 문자가 포함되어있는지 검사
    1.2 유효한 자릿수(3자리)인지 검사
    1.3 0 포함 여부 검사
    1.4 중복된 숫자가 있는지 검사 
    1.5 이상이 없을 경우 true 반환 
```

<<<<<<< HEAD
* #### count_strike_and_balls Method
=======
* #### countStrikeAndBalls Method
>>>>>>> master
```
1. 랜덤 숫자와 사용자의 숫자를 비교하여 결과를 반환
    1.1 숫자와 자릿수가 같으면 스트라이크
    1.2 1.1을 만족하지 않지만, 자릿수가 다르다면 볼
    1.3 스트라이크 및 볼 모두 0이라면 낫싱
    1.4 3 스트라이크일 경우 종료 결과 반환 
```


Manager Class
---
<<<<<<< HEAD
* #### start_game Method
=======
* #### startGame Method
>>>>>>> master
```
1. while문을 이용하여 게임 진행 
    1.1 정답이 아니라면 반복 
    1.2 정답이라면 종
```

<<<<<<< HEAD
* #### restart_or_end_game Method
=======
* #### restartOrEndGame Method
>>>>>>> master
```
1. 첫 게임 종료 호출됨, 재시작 여부 판단
    1.1 새로 시작할 경우 1, 재시작
    1.2 종료할 경우 2, 종료 
    1.3 입력이 잘못되었을 경우 반복
```

User Class
---
<<<<<<< HEAD
* #### input_userNumber Method
=======
* #### inputUserNumber Method
>>>>>>> master
```
1. 사용자의 숫자 입력 처리 및 저장 
    1.1 String 형태로 입력을 받음
    1.2 Computer class의 check_userNumber Method를 통해 유효성 검사
    1.3 유효할 경우 String을 정수 배열형태로 저장
```

<<<<<<< HEAD
* #### get_userNumber Method
=======
* #### getUserNumber Method
>>>>>>> master
```
1. input_user_number Method에서 저장된 정수 배열을 반환
```




