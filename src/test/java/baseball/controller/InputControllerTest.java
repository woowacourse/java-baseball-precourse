package baseball.controller;

import jdk.jfr.Description;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.*;

class InputControllerTest {

    @ParameterizedTest
    @ValueSource(strings = {"123", "532", "863", "375"})
    @Description("toIntegers테스트 String을 List<Integer>로 변환, 순서유지, 다시 String으로 조립해도 같은 값이나와야함")
    public void toIntegerListTest(String input) {

        //given
        List<Integer> integerList = Arrays.stream(input.split(""))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
        //when
        StringBuffer sb = new StringBuffer();
        for (Integer integer : integerList) {
            sb.append(integer);
        }
        //then
        assertEquals(sb.toString(), input);
    }


}