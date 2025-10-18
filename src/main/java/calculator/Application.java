package calculator;

import camp.nextstep.edu.missionutils.Console;

public class Application {
    public static String readInput() {
        System.out.println("덧셈할 문자열을 입력해 주세요.");
        return Console.readLine();
    }

    public static void printAns(String ans) {
        System.out.printf("결과: %s", ans);
    }

    public static void main(String[] args) {
        // TODO: 프로그램 구현
        String str = readInput();
        
        printAns(str);
    }
}
