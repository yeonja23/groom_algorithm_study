package week_1;

import java.io.*;
import java.util.Stack;

public class B9012 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(
                new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        // 입력 개수
        int num = Integer.parseInt(br.readLine());

        for (int i = 0; i < num; i++) {
            sb.append(isVPS(br.readLine())).append('\n');
        }

        System.out.println(sb);
    }

    public static String isVPS(String s) {
        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            if (c == '(') {
                stack.push(c);
            } else if (stack.empty()) {
                return "NO";
            } else {
                stack.pop();
            }
        }

        if (stack.empty()) {
            return "YES";
        } else {
            return "NO";
        }
    }

}
