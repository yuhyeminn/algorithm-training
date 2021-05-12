package programmers.code_challenge.challenge_0415;

import java.util.Stack;

/**
 * 괄호 회전하기
 * @author hyemin
 *
 * [해결]
 * Stack 이용. O(n^2)
 */
public class Challenge02 {

	public static void main(String[] args) {
		String s = "[](){}";
		System.out.println(new Challenge02().solution(s));
	}
	
	public int solution(String s) {
        int answer = 0;
        for(int i=0;i<s.length();i++) {
        	if(isCorrect(s)) {
        		answer++;
        	}
        	s = s.substring(1) + s.substring(0,1); // 첫번째 괄호를 뒤로 보내며 회전
        }
        return answer;
    }

	private boolean isCorrect(String s) {
		
		Stack<Character> stack = new Stack<>();
		for(int i=0;i<s.length();i++) {
			char now = s.charAt(i);
			
			if(now == '(' || now == '[' || now == '{') {
				stack.push(now);
			}
			else if(!stack.isEmpty()) {
				if(now == ')' && stack.peek() == '(') {
					stack.pop();
				}else if(now == '}' && stack.peek() == '{'){
					stack.pop();
				}else if(now == ']' && stack.peek() == '[') {
					stack.pop();
				}
			}else {
				return false;
			}
		}
		
		if(stack.isEmpty()) return true;
		
		return false;
	}

	
}
