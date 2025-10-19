package calculator;

import java.util.Arrays;
import java.util.List;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

import camp.nextstep.edu.missionutils.Console;

public class Application {
    public static void main(String[] args) {
        String str = readInput();

        List<Integer> v = parseNumbers(str);

        int ans = getSum(v);

        printAns(ans);
    }

    public static String readInput() {
        System.out.println("덧셈할 문자열을 입력해 주세요.");
        return Console.readLine();
    }

    public static List<Integer> parseNumbers(String str) {
        try {
            String customDelimiter = "[,:]";

            int st = 0;
            if (str.startsWith("//")) {
                if (str.indexOf("\\n") != 3)
                    throw new IllegalArgumentException();

                customDelimiter = Pattern.quote(String.valueOf(str.charAt(2)));
                st = 5;
            }

            if (str.length() == 0 || (st == 5 && str.length() == 5))
                return List.of(0);

            return Arrays.stream(str.substring(st)
                    .split(customDelimiter))
                    .map(Integer::parseInt)
                    .peek(k -> {
                        if (k < 1)
                            throw new IllegalArgumentException();
                    })
                    .collect(Collectors.toList());
        } catch (Exception e) {
            throw new IllegalArgumentException();
        }
    }

    public static int getSum(List<Integer> v) {
        int ret = 0;
        for (int k : v)
            ret += k;

        return ret;
    }

    public static void printAns(int ans) {
        System.out.printf("결과 : %s", ans);
    }
}
