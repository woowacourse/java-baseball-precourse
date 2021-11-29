# 미션 - 숫자 야구 게임⚾

---

## 1. 디렉토리 구조 💡

```bash
├─main
│  └─java
│      └─baseball
│          │  Application.java
│          │
│          ├─domain
│          │      Game.java
│          │      Hint.java
│          │      RandomNumber.java
│          │
│          ├─exception
│          │      UserInput.java
│          │
│          └─view
│                  InputView.java
│                  OutputView.java
│
└─test
    └─java
        └─baseball
                ApplicationTest.java

```



## 2. 기능 목록 📝

- [x] 서로 다른 세 자리의 난수 생성

- [x] 사용자 숫자 입력 받기
  - [x] "숫자를 입력해주세요" 출력 후 입력 받기
  - [x] 입력된 숫자 유효성 검사🔍
    - [x] 1~9까지의 숫자로만 입력했는지(문자나 0은 제외)
    - [x] 입력된 숫자가 세자리수인지
    - [x] 서로 다른 숫자가 입력됐는지 
  
- [x] 숫자에 따른 힌트 주기
  
  - [x] 스트라이크, 볼, 낫싱으로 처리
  
- [x] 세 가지 숫자들 모두 맞춘 경우 -> 게임 종료

- [x] 게임 종료 시, 새로 게임을 시작할지 묻기 -> 사용자 입력 받기

  - [x] 입력된 숫자 유효성 검사🔍

    - [x] 1 또는 2로만 입력했는지

      

## 3. 요구사항 📢

* [진행방식](/markdown/진행방식.md)
* [기능 요구사항](/markdown/기능요구사항.md)
* [프로그래밍 요구사항](/markdown/프로그래밍요구사항.md)



