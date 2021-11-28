package baseball.util;

import baseball.constants.ValueConstants;
import baseball.constants.MessageConstants;

public class InputCheck {
        public static void checkGameNumber(String input){
            //길이 확인
            if(input.length() != ValueConstants.GAME_NUMBER_LEN)
                throw new IllegalArgumentException(MessageConstants.DIFF_NUMBER_INPUT_MESSAGE);

            for(int i=0; i<input.length() ; ++i){

                if(!checkNumberBound(input.charAt(i), ValueConstants.GAME_NUMBER_BOUND_START, ValueConstants.GAME_NUMBER_BOUND_END))
                    throw new IllegalArgumentException(MessageConstants.DIFF_NUMBER_INPUT_MESSAGE);

            }
        }

        public static void checkOptionNumber(String input){
            //길이 확인
            if(input.length() != ValueConstants.GAME_OPTION_LEN)
                throw new IllegalArgumentException(MessageConstants.DIFF_OPTION_INPUT_MESSAGE);

            //1혹은 2인지 확인
            if(!checkNumberBound(input.charAt(0), ValueConstants.GAME_OPTION_BOUND_START, ValueConstants.GAME_OPTION_BOUND_END))
                throw new IllegalArgumentException(MessageConstants.DIFF_OPTION_INPUT_MESSAGE);

        }

        public static boolean checkNumberBound(char num, int start, int end){
            if('0' + start <= num && num <= '0' + end)
                return true;

            return false;
        }

}
