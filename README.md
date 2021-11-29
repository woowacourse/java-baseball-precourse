# 미션 - 숫자 야구 게임


## 👩🏻‍💻 구현할 기능 목록

|No|**기능**|**완료 여부**|
|:---:|------|:---:|
|1|1~9로 이루어진 3자리의 난수 발생|✔️|
|2|사용자에게 3자리 수 입력 받기|✔️|
|3|+ 잘못된 입력 값일 경우 에러 처리|✔️|
|4|입력값과 볼 / 스트라이크 계산|✔️|
|5|결과 출력 ( 볼 / 스트라이크 / 낫싱 )|✔️|
|6|정답일 경우 재시작 OR 종료 입력 받기|✔️|
|7|+ 1, 2가 아닌 경우 에러 처리|✔️|

<br>

## ✅ 구현 시 체크사항
|No|**조건**|**체크 여부**|
|:---:|------|:---:|
|1|입력값을 받을 땐 Exeption 처리를 했는가?|✔️|
|2|잘못된 값을 입력할 경우 IllegalArgumentException을 발생시킨 후 애플리케이션은 종료되는가?|✔️|
|3|프로그램을 실행하는 시작점은 Application의 main()인가?|✔️|
|4|JDK 8 버전에서 실행 가능한가?|✔️|
|5|자바 코드 컨벤션을 지켰는가?|✔️|
|6|indent(인덴트, 들여쓰기) depth를 3이 넘지 않도록 구현했는가?|✔️|
|7|3항 연산자를 쓰지 않았는가?|✔️|
|8|Random 값 추출은 camp.nextstep.edu.missionutils.Randoms의 pickNumberInRange()를 활용했는가?|✔️|
|9|사용자가 입력하는 값은 camp.nextstep.edu.missionutils.Console의 readLine()을 활용했는가?|✔️|
|10|ApplicationTest에 있는 모든 테스트 케이스가 성공하는가?|✔️|