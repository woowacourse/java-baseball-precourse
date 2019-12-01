/*
 * @(#)Pitcher.java 2019/12/1
 *
 * Copyright (c) 2019 Geunwon Lim
 * All rights reserved.
 */

package precourse.baseball;

import java.util.List;

/**
 * @version     1.00 2019년 12월 1일
 * @author      임근원
 */
public interface Pitcher extends Player {
    /* Pitcher 인터페이스는 투수라면 반드시 가져야 할 함수를 명시합니다. */

    List<Integer> pitch();
}
