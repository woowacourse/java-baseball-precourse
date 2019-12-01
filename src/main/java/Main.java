/*
 * @(#)Main.java        0.2 2019/12/01
 *
 * Copyright (c) 2019 lxxjn0.
 */
import com.lxxjn0.baseball.PlayBaseball;

/**
 * 게임 시작을 위한 PlayBaseball 객체를 생성하고 시작하는 Main 클래스.
 *
 * @version         0.1 2019/12/01
 * @author          JUNYOUNG LEE (lxxjn0)
 */
public class Main {
    public static void main(String[] args) {
        PlayBaseball playBaseball = new PlayBaseball();
        playBaseball.Play();
    }
}
