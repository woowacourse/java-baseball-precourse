# 전역 변수

```
private static Scanner scanner;
```

# 메소드

### readLine()

```
public static String readLine() {
	return getInstance().nextLine();
}

private static Scanner getInstance() {
	if (Objects.isNull(scanner) || isClosed()) {
		scanner = new Scanner(System.in);
	}
	return scanner;
}
```

- 사용자 입력을 받기 위해 이용
- 이때 getInstance()를 이용해 전역변수로 선언한 Scanner가 null이거나 닫혀 있으면 새로운 스캐너를 생성

<br>

### isClosed()

```
private static boolean isClosed() {
    try {
        final Field sourceClosedField = Scanner.class.getDeclaredField("sourceClosed");
        sourceClosedField.setAccessible(true);
        return sourceClosedField.getBoolean(scanner);
    } catch (final Exception e) {
        System.out.println("unable to determine if the scanner is closed.");
    }
    return true;
}
```

- 이를 이해하기 위해서는 [Java Reflection](https://www.oracle.com/technical-resources/articles/java/javareflection.html)에 대해 간단히 알면 좋다.
- getDeclaredField(String name)  
  - name과 동일한 이름으로 정의된 변수를 Field 클래스 타입으로 반환
- sourceClosed  
  - Scanner 클래스에서 해당 자원이 종료되었는지 저장된 boolean 변수
- setAccessible()  
  - 필드나 메소드의 접근 제어 지시자에 의한 제어 변경
  - 위의 경우, sourceClosed 변수가 private이기 때문에 접근 불가함 해당 메소드 통해 접근 가능하게 설정  
- 최종적으로 scanner 객체에 존재하는 sourceClosed 변수의 값을 return


# 생각
해당 API를 제시한건 Scanner에 존재하는 nextLine() 메소드만을 사용하고 그 외의 다양한 메소드를 지양하기 위함이라고 생각한다.  

# 궁금증
Scanner를 .close() 해주는 작업이 생략되어 있는데 이에 대해서는 처리를 안하는걸까?
[Scanner가 close()를 해야하는 이유](https://stackoverflow.com/questions/24573084/why-we-should-i-close-a-java-util-scanner-variable)에 따르면 close()하지 않는 경우 메모리 누수가 발생한다고 하는데 이에 대해 처리하지 않은 이유에 대해서는 찾지 못했다.
