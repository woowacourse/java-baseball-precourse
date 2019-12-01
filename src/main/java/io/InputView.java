package io;

import java.io.InputStream;
import java.util.Scanner;

public class InputView {
	static Scanner scanner;

	public InputView(InputStream inputStream) {
		scanner = new Scanner(inputStream);
	}

	public String getNumbers(){
		System.out.print("숫자를 입력해 주세요: ");
		return scanner.next();
	}





}
