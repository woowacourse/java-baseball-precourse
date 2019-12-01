/*
 * @(#)InvalidInputException.java 2019/12/1
 *
 * Copyright (c) 2019 Geunwon Lim
 * All rights reserved.
 */

package precourse.baseball.number.errors;

/**
 * @version     1.00 2019년 12월 1일
 * @author      임근원
 */
public class InvalidInputException extends RuntimeException {
    public InvalidInputException(String message) {
        super(message);
    }
}
