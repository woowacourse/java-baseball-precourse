package io;

import static org.assertj.core.api.AssertionsForInterfaceTypes.*;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("유저 입력 테스트")
class InputViewTest {

	@Test
	@DisplayName("유저로부터 숫자 입력")
	void getNumbers() {

		String inputCorrectString = "136";
		InputStream inputCorrectStringStream = new ByteArrayInputStream(inputCorrectString.getBytes());
		InputView inputView = new InputView(inputCorrectStringStream);

		assertThat(inputView.getNumbers()).isEqualTo("136");
	}

}