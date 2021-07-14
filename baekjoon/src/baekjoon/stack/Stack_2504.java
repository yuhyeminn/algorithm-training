package baekjoon.stack;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

/**
 * 괄호의 값
 * 
 * @author hyemin
 * 
 * [https://covenant.tistory.com/224] - part2.스택의 응용
 * 
 * **
 * 다시 볼 것.. 닫는 괄호 코드 부분 정리하기..
 * 
 */
public class Stack_2504 {

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = br.readLine();

		// 올바른 괄호열 체크
		System.out.println(isCorrect(str));

	}

	static int isCorrect(String str) {
		Stack<Character> stack = new Stack<>();

		int value = 1;
		int result = 0;

		for (int i = 0; i < str.length(); i++) {
			char now = str.charAt(i);
			switch (now) {
				case '(':
					stack.push(now);
					value *= 2;
					break;
				case '[':
					stack.push(now);
					value *= 3;
					break;
				case ')':
					if (stack.isEmpty() || stack.peek() != '(') {
						result = 0;
						break;
					}
					if (str.charAt(i-1) == '(')
						result += value;
					stack.pop();
					value /= 2;
					break;
				case ']':
					if (stack.isEmpty() || stack.peek() != '[') {
						result = 0;
						break;
					}
					if (str.charAt(i-1) == '[')
						result += value;
					stack.pop();
					value /= 3;
					break;
				}
		}

		return result;
	}

}
