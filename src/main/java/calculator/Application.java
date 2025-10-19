package calculator;

import java.util.Arrays;
import java.util.List;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

import camp.nextstep.edu.missionutils.Console;

public class Application {
    public static int getSum(List<Integer> v) {
        int ret = 0;

        for (int k : v)
            ret += k;

        return ret;
    }

    public static List<Integer> parseNumbers(String str) {
        String customDelimiter = "[,:]";
        int st = 0;

        try {
            if (str.startsWith("//")) {
                customDelimiter = Pattern.quote(String.valueOf(str.charAt(2)));

                st = str.indexOf("\\n");
                if (st != 3)
                    throw new IllegalArgumentException();
            }

            return Arrays.stream(str.substring(st + 2).split(customDelimiter))
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

    public static void printAns(int ans) {
        System.out.printf("결과 : %s", ans);
    }

    public static String readInput() {
        System.out.println("덧셈할 문자열을 입력해 주세요.");
        return Console.readLine();
    }

    public static void main(String[] args) {
        String str = readInput();
        List<Integer> v = parseNumbers(str);
        int ans = getSum(v);

        printAns(ans);
    }
}
