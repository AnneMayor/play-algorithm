package codingtest;

import java.util.Arrays;

public class WSol1 {

    public String solution(String[] params) {
        String result = Arrays.stream(params)
        .filter(s -> s.length() >= 5 && s.length() <= 10)
        .map(String::toUpperCase)
        .findFirst()
        .orElse("없음");

        return result;
    }

}
