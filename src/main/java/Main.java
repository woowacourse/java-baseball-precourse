/*
 * @(#)Main.java        0.2 2019/12/02
 *
 * Copyright (c) 2019 lxxjn0.
 */
import com.lxxjn0.baseball.PlayBaseball;

/**
 * 게임 시작을 위한 Main 클래스.
 *
 * @version         0.2 2019/12/02
 * @author          JUNYOUNG LEE (lxxjn0)
 */
public class Main {
    /**
     * PlayBaseball 클래스의 객체를 생성하여 게임을 시작하는 main 메서드.
     * @param args 입력되는 매개변수 존재하지 않음.
     */
    public static void main(String[] args) {
        PlayBaseball playBaseball = new PlayBaseball();
        playBaseball.play();
    }
}
