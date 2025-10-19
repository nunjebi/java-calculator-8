package calculator;

import java.util.Arrays;
import java.util.List;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

import camp.nextstep.edu.missionutils.Console;

public class Application {

    public static List<Integer> parseNumbers(String str) {
        String customDelimiter = "[,:]";
        if (str.startsWith("//")) {
            customDelimiter = Pattern.quote(String.valueOf(str.charAt(2)));

            int st = str.indexOf("\\n");
            str = str.substring(st + 2);
        }

        return Arrays.stream(str.split(customDelimiter))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
    }

    public static String readInput() {
        System.out.println("덧셈할 문자열을 입력해 주세요.");
        return Console.readLine();
    }

    public static void printAns(int ans) {
        System.out.printf("결과 : %s", ans);
    }
    
    public static void main(String[] args) {
        String str = readInput();
        List<Integer> v = parseNumbers(str);

        int ans = 0;
        for (int k : v)
            ans += k;

        printAns(ans);
    }
}
