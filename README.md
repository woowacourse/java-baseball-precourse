---
## 기능 구현 순서
1. Generate 3-digit random number<br><br>
	- 'Random' API를 통해 뽑힌 3가지 랜덤 수를 문자열로 저장한다. <br><br>
2. Let User input 3-digit number <br><br>
	- 'Console' API를 통해 User에게 문자열을 입력받는다. <br><br>
	- 입력받은 문자열이 1부터 9 사이의 숫자가 아니거나, 문자열의 길이가 3자리가 아닌 경우(범위), 그리고 문자열의 문자가 2개 이상 중복 된 경우(중복) 예외처리 한다.<br><br>
	- 입력받은 문자열이 legitimate한 경우 문자열을 저장한다. <br><br>
3. Count total number of Strike <br><br>
	- 랜덤 문자열과 유저입력문자열을 비교하여 각 자리수의 수가 같을 때 마다 int 변수 strike에 1을 더한다. <br><br>
4. Count total number of Ball <br><br>
	- 유저입력문자열의 각 자리수의 수가 랜덤 문자열에 포함되어 있으나 랜덤 문자열의 자리수와 같지 않을 때 마다 int 변수 ball에 1을 더한다. <br><br> 
5. Show the result <br><br>
	- strike가 3이 아닌 경우 strike와 ball값을 각각 출력한다. 두 값 모두 0인경우 '낫싱'을 출력한다. 이후 게임을 다시 진행한다. <br><br>
	- strike가 3인 경우 성공 메시지를 출력 후, 새로운 게임을 시작하거나 종료하도록 user에게 input을 받는다. <br>

<br>

---
