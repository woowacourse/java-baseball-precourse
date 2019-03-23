package kr.latera.baseball;

import kr.latera.baseball.interfaces.IUserInterface;
import org.junit.Assert;
import org.junit.Test;

import java.io.*;

public class StreamUserInterfaceTest {
  private DataInputStream is = new DataInputStream(new ByteArrayInputStream("132\n268\n1\n2\n3".getBytes()));
  private ByteArrayOutputStream baos = new ByteArrayOutputStream();
  private DataOutputStream os = new DataOutputStream(baos);

  private IUserInterface ui = new StreamUserInterface(is, os);

  @Test
  public void testInput() throws Exception {

    int[] arr = ui.promptInput();
    Assert.assertArrayEquals(new int[] {1, 3, 2}, arr);

    arr = ui.promptInput();
    Assert.assertArrayEquals(new int[] {2, 6, 8}, arr);

    Assert.assertEquals(IUserInterface.UserSelection.RESTART, ui.promptRestart());
    Assert.assertEquals(IUserInterface.UserSelection.EXIT, ui.promptRestart());
    Assert.assertEquals(IUserInterface.UserSelection.INVALID, ui.promptRestart());

  }

  @Test
  public void testOutput() {
    baos.reset();
    ui.displayResult(2, 0);
    Assert.assertEquals("2스트라이크\n", baos.toString());
    baos.reset();
    ui.displayResult(0, 1);
    Assert.assertEquals("1볼\n", baos.toString());
    baos.reset();
    ui.displayResult(1, 2);
    Assert.assertEquals("1스트라이크 2볼\n", baos.toString());
    baos.reset();
    ui.displayResult(0, 0);
    Assert.assertEquals("낫싱\n", baos.toString());
  }
}
