# 숫자 야구 게임 _ 우아한 테크코스 1주차 미션

https://github.com/okskna/java-baseball

---

## MainClass

- main 메서드를 포함하는 클래스
- 숫자야구게임

#### 메인 메서드. public static void main(String[] args)

숫자 야구 게임의 시작부터 끝에 해당하는 메서드. 사용자가 종료에 해당하는 입력을 하기 전 까지 무한루프를 수행한다.

1. 메서드 1 _ public static void setAnsArr() 실행
2. 메서드 2 _ public static void startGame () 실행
3. 메서드 3 _ public static boolean exitMode() 실행



#### 메서드 1. public static void setAnsArr()

 무작위로 세 자리의 수를 뽑아 배열(int[] ansArr)에 저장하는 메서드를 만든다. 이 배열은 게임에서 맞춰야 하는 수들이 저장된 공간이다. 

- **메서드 1-1. public static void setArrayList(ArrayList<Integer> numbSeqArr)**
  - 0 ~ 9 까지 순차적으로 저장된 ArrayList를 만든다.
- **메서드 1-2. public static void popArrayList(ArrayList<Integer> numbSeqArr)**
  -  numbSeqArr의 무작위 번째 방의 값을 ansArr[i = 0 ~ 3]에 저장한다. 이로써 무작위 수를 뽑아 ansArr 배열에 저장하는 것이 완료된다.



#### 메서드 2. public static void startGame ()

 게임 시작 메서드. userInArr 배열에 사용자로부터 입력받은 수를 저장한 후, ansArr배열과 userInArr배열이 일치할 경우 현재 게임을 종료한다. 일치 하지 않을 경우 무한 루프를 수행한다.

- **메서드 2-1. public static void numDivider(int userInNum)**
  - userInNum의 각 자리수를 분리하여 userInArr에 순차적으로 저장시키는 메서드이다.
- **메서드 2-2. public static void idxCounter()**
  - ansArr과 userInArr을 비교하기 위해 index를 순차적으로 증가시키는 메서드. 
  - 얻은 index로 compareValue 메서드를 호출한다.
  - **메서드 2-2-1. public static void compareValue(int ansIdx, int inIdx)**
    -  idxCounter메소드로부터 얻은 참조값을 이용하여 ansArr배열의 값과 userInArr배열의 값을 비교하는 메소드.
- **메서드 2-3. public static boolean is3Strike ()**
  - 스트라이크가 3일 경우 게임을 종료한다. 그 외의 경우 strike와 ball의 개수에 관한 메세지만 출력.



#### 메서드 3. public static boolean exitMode()

 게임을 계속 할지에 대해 사용자에게 입력을 받는다. 이 입력에 따라 메인 메서드를 반복하거나 프로그램을 종료한다.

