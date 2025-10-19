package calculator;

import java.util.Arrays;
import java.util.List;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

import camp.nextstep.edu.missionutils.Console;

public class Application {
    private static final int NEWLINE_INDEX = 3;
    private static final int CUSTOM_DELIMITER_INDEX = 2;
    private static final int CUSTOM_DELIMITER_LENGTH = 5;

    public static void main(String[] args) {
        String inputString = readInput();

        List<Integer> numbers = parseNumbers(inputString);

        int sum = calculateSum(numbers);

        printResult(sum);
    }

    public static String readInput() {
        System.out.println("덧셈할 문자열을 입력해 주세요.");
        return Console.readLine();
    }

    public static List<Integer> parseNumbers(String inputString) {
        String customDelimiter = "[,:]";

        int startIdx = 0;
        if (inputString.startsWith("//")) {
            if (inputString.indexOf("\\n") != NEWLINE_INDEX) {
                throw new IllegalArgumentException();
            }

            customDelimiter = Pattern.quote(String.valueOf(inputString.charAt(CUSTOM_DELIMITER_INDEX)));
            startIdx = CUSTOM_DELIMITER_LENGTH;
        }

        if (inputString.length() == 0
                || (startIdx == CUSTOM_DELIMITER_LENGTH && inputString.length() == CUSTOM_DELIMITER_LENGTH)) {
            return List.of(0);
        }

        return Arrays.stream(inputString.substring(startIdx)
                .split(customDelimiter))
                .map(Integer::parseInt)
                .peek(k -> {
                    if (k < 1) {
                        throw new IllegalArgumentException();
                    }
                })
                .collect(Collectors.toList());
    }

    public static int calculateSum(List<Integer> numbers) {
        int sum = 0;
        for (int number : numbers) {
            sum += number;
        }

        return sum;
    }

    public static void printResult(int sum) {
        System.out.printf("결과 : %d\n", sum);
    }
}
