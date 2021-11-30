# 미션 - 숫자 야구 게임

🧑🏻‍💻 author    
daehwan2yo    
✉️ contact   
udsward@gmail.com  
✏️ last mod  
2021-11-30  

## 📕 Summary
Java 8과 gradle을 기반한 프로젝트로, 주어진 숫자 야구 요구사항에 맞춰 기능을 구현한다.  

## ✔️ To do
- [x] 컴퓨터의 난수 생성하기
- [x] 사용자로부터 입력받기
- [x] 입력 예외 확인하기
- [x] 입력값 비교하기 (볼카운트 판정)
- [x] 결과 출력하기
- [x] 재실행 여부 확인하기
- [x] 입력에 따라 프로그램 종료하기
- [x] 예외 처리하기

### 적용해 볼 스킬
- Functional Programming
- TDD
- Clean Code

## 📌 Commit log
[feat]    : 기능 구현  
[fix]     : 버스 수정  
[docs]    : 문서화  
[refactor]: 리팩토링  
[test]    : 테스트 구현  
[chore]   : 빌드 및 설정 변경  

## 📚 Programming requirements
<details>
  <summary> 프로그래밍 요구사항 </summary>
  <div>
    - 프로그램을 실행하는 시작점은 Application의 main()이다. <br>
    - JDK 8 버전에서 실행이 가능해야 한다. <br>
    - 자바 코드 컨벤션을 지키면서 프로그래밍한다. <br> 
      <details>
        <summary> 컨벤션 요약 </summary>
        <div> 
          <b> File Encoding </b> <br>
            UTF-8 로 인코딩을 통일한다.
          <br>
            <b> Naming </b> <br>
            식별자에는 영문/숫자/언더스코어만 허용 <br>
            한국어 발음대로 표기 금지 <br>
            패키지이름은 소문자로만 구성 (카멜, 스네이크 금지) <br>
            <b> Class, Interface </b> <br>
            클래스/인터페이스 이름에 대문자 카멜표기법 적용 <br>
            클래스 이름에는 명사만 허용 <br>
            인터페이스 이름에는 명사, 형용사만 허용 <br>
            테스트 클래스는 Test로 끝나야함 <br>
            <b> Method </b> <br>
            메서드 이름에 소문자 카멜표기법 적용 <br>
            동사, 전치사로 시작한다. <br>
            <b> Constant </b> <br>
            상수는 대문자와 스네이크 표기법 적용 <br>
            <b> Variable </b> <br>
            변수에는 소문자 카멜표기법 적용 <br>
            임시 변수 외에는 한 글자 변수명 사용 금지 <br>
            <b> Declarations </b> <br>
            static import에만 wild card 적용<br>
            어노테이션 선언 후 새 줄 활용<br>
            한 줄에 한 문장, 
             한 선언문에는 한 변수만<br>
            배열 선언 시 대괄호는 타입 뒤에<br>
            <b> Indentation </b> <br>
            하드탭 사용 , 
            4 spaces , 
            블럭 들여쓰기<br>
            <b> Braces </b> <br>
            K&R style <br>
            조건, 반복문에 중괄호 필수 사용 (생략 불가) <br>
            <b> Line-wrapping </b> <br>
            가독성을 위해 줄 바꿈을 허용하는 위치 <br>
            extends 선언 후 <br>
            implements 선언 후 <br>
            throws 선언 후 <br>
            시작 소괄호 ‘(‘ 선언 후 <br>
            콤마 ‘,’ 후 , 
            마침표 ‘.’ 전 , 
            연산자 전 <br>
            <b> Blank Lines </b> <br>
            메서드 사이에 빈 줄 삽입 <br>
            <b> Whitespace </b><br>
            대괄호 뒤에 공백 삽입 <br>
            중괄호의 시작 전, 종료 후에 공백 삽입 <br>
            제어문 키워드와 여는 소괄호 사이에 공백 사입 <br>
            식별자와 여는 소괄호 사이에 공백 미삽입 <br>
            타입 캐스팅에 쓰이는 소괄호 내부 공백 미삽입 <br>
            콤마 ’,’ 와 구분자 세미클론 ‘;’ 뒤에만 공백 삽입 <br>
            콜론 ‘:’ 앞뒤로 공백 삽입 <br>
            이항, 삼항 연산자의 앞 뒤에 공백 삽입 (삼항연산자는 사용하지 않는다.) <br>
            단항 연산자는 공백 미삽입 <br>
            주석문 전후로 공백 삽입 <br>
        </div>
    </details>
    - indent depth를 3이 넘지 않도록 구현한다. <br>
    - 3항 연산자는 사용하지 않는다. <br>
    - 메서드가 한 가지 일만 하도록 최대한 작게 만든다. <br>
  </div>
</details>

- JDK에서 기본 제공하는 Random, Scanner API 대신 `camp.nextstep.edu.missionutils`에서 제공하는 `Randoms`, `Console` API를 활용해 구현해야 한다.  
  - Random 값 추출은 `camp.nextstep.edu.missionutils.Randoms`의 `pickNumberInRange()`를 활용한다.  
  - 사용자가 입력하는 값은 `camp.nextstep.edu.missionutils.Console`의 `readLine()`을 활용한다.  

## 🚀 Functional Requirement
<b> 기본적으로 1부터 9까지 서로 다른 수로 이루어진 3자리의 수를 맞추는 게임이다. </b>
1. System에서 난수 생성
   - 0이 아닌 1~9의 정수를 중복없이 3개의 수를 생성한다.
2. User로 부터 숫자 입력 받기
   - 0이 아닌 1~9의 정수를 중복없이 입력받는다.
   - 반드시 3자리만 입력받는다.
   - 띄어쓰기는 하지 않는다.
3. System의 수와 User의 수를 자리값(index)과 실제값(value)를 비교하여 볼카운트를 확인한다.  
   - 같은 index, value : 스트라이크    
   - 다른 index, 같은 value : 볼  
   - 다른 index, value : 낫싱  
4. 과정을 반복하며, System의 수와 User의 수가 모두 같으면(index와 value) 맞춘것으로 판단되며, 게임이 종료된다.  
5. 게임을 종료한 후 User의 요청에 따라 게임을 다시 시작하거나 완전히 종료할 수 있다.



## 📎 Class Diagram
v1 (2021-11-30)  
![KakaoTalk_Photo_2021-11-30-22-42-58](https://user-images.githubusercontent.com/26921986/144058182-59f3f851-13d6-4860-9c3c-6072eef31174.png)



## 🪧 Reference
### 우아한 테크코스 4기 프리코스  
1주차 : 숫자 야구 구현  
https://github.com/woowacourse/java-baseball-precourse

### Commit log
Angular JS Commit Message Conversions  
https://gist.github.com/stephenparish/9941e89d80e2bc58a153

## 📝 License

This project is [MIT](https://github.com/woowacourse/java-baseball-precourse/blob/master/LICENSE) licensed.
