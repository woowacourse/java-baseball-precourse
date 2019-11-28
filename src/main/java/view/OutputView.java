package view;

import computer.result.Results;
import view.comment.Comment;

public class OutputView {

    public static void showResult(Results results) {
        System.out.println(Comment.getComment(results));
    }

    public static void showGoalComment() {
        System.out.println("3개의 숫자를 모두 맞혔습니다! 게임 종료");
    }
}
