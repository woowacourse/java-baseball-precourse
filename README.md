# 미션 - 숫자 야구 게임

## 구현 기능 목록
1. 3개의 서로 다른 랜덤 수 생성
   - camp.nextstep.edu.missionutils.Randoms의 pickNumberInRange() 활용
2. INPUT - 프롬프트 출력 & 3자리 수 입력 받기
   - [예외] 사용자가 잘못된 값을 입력한 경우 - IllegalArgumentException 발생 후 종료
      - 입력 범위가 숫자 1 이상 9 이하를 벗어난 경우
      - 문자열의 길이가 3 이상인 경우
      - 중복된 수가 입력된 경우
3. 입력에 대한 결과 판단 로직
   - 볼 / 스트라이크 / 낫싱
4. OUTPUT - 결과 출력
   - n볼 / n스트라이크 / 낫싱
   - 게임 종료 - 사용자가 3개의 숫자를 모두 맞힌 경우
6. 게임 재시작 / 종료 여부 입력 받기
   - 1 : 재시작 / 2 : 종료
   - [예외] 사용자가 잘못된 값을 입력한 경우 - IllegalArgumentException 발생 후 종료