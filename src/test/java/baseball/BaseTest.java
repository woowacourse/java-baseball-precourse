package baseball;

import org.assertj.core.util.Strings;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.io.PrintStream;
import java.util.NoSuchElementException;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

public abstract class BaseTest {
    private OutputStream captor;

    protected void setUp() {
        captor = new ByteArrayOutputStream();
        System.setOut(new PrintStream(captor));
    }

    /**
     * 사용자의 입력을 기다리는 상황에서 테스트 종료
     * @param args
     */
    protected void running(final String... args) {
        assertThatExceptionOfType(NoSuchElementException.class).isThrownBy(
                () -> subject(args)
        );
    }

    /**
     * 프로그램이 정상적으로 종료
     * @param args
     */
    protected void run(final String... args) {
        subject(args);
    }

    protected void verify(final String... args) {
        assertThat(output()).contains(args);
    }

    private void subject(final String... args) {
        command(args);
        runMain();
    }

    public abstract void runMain();

    private void command(final String... args) {
        final byte[] buf = Strings.join(args).with("\n").getBytes();
        System.setIn(new ByteArrayInputStream(buf));
    }

    protected String output() {
        return captor.toString().trim();
    }
}
