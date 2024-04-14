package codingtest;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class WSol4 {

    public String solution(String pathVariableUrl) {
        Pattern pattern = Pattern.compile("^s*\\/payment\\/[1-9]\\d{0,8}\\/[a-zA-Z]{1,10}s*$");

        Matcher matcher = pattern.matcher(pathVariableUrl);
        if (matcher.find()) {
            String[] pathVariables = pathVariableUrl.split("/");
            return "/payment/" + pathVariables[3] + "?paymentId=" + pathVariables[2];
        }

        return "error";
    }
    
}
