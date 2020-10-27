package programmers.level2;

/**
 * 괄호 변환
 * 
 * [문제]
 * https://programmers.co.kr/learn/courses/30/lessons/60058
 *
 * [참고]
 * https://keepgoing0328.tistory.com/entry/2020%EC%B9%B4%EC%B9%B4%EC%98%A4-%EA%B3%B5%EC%B1%84-%EA%B4%84%ED%98%B8-%EB%B3%80%ED%99%98-%EC%9E%90%EB%B0%94
 */
public class ParenthesisConversion {

	public static void main(String[] args) {
		String p = ")(";
		System.out.println("result="+solution(p));
	}
	
	static String solution(String p) {
		return makeCorrect(p);
	}
	
	static String makeCorrect(String p) {
		//1. 입력이 빈 문자열인 경우, 빈 문자열을 반환합니다. 
		if(p.length()==0) return "";
		
		//2. 문자열 w를 두 "균형잡힌 괄호 문자열" u, v로 분리함. 
		//단, u는 "균형잡힌 괄호 문자열"로 더 이상 분리할 수 없어야 하며, v는 빈 문자열이 될 수 있음.
		int cut = division(p);
		String u = p.substring(0, cut);
		String v = p.substring(cut);
		
		//3. 문자열 u가 "올바른 괄호 문자열" 이라면 문자열 v에 대해 1단계부터 다시 수행함.
		if(isCorrect(u)) {
			//3-1. 수행한 결과 문자열을 u에 이어 붙인 후 반환.
			return u + makeCorrect(v);
		}
		else {
			//4. 문자열 u가 "올바른 괄호 문자열"이 아니라면 아래 과정을 수행
			// 4-1. 빈 문자열에 첫 번째 문자로 '('를 붙임. 
			// 4-2. 문자열 v에 대해 1단계부터 재귀적으로 수행한 결과 문자열을 이어 붙임. 
			// 4-3. ')'를 다시 붙임.
			String s = '(' + makeCorrect(v) + ')';
			// 4-4. u의 첫 번째와 마지막 문자를 제거하고, 나머지 문자열의 괄호 방향을 뒤집어서 뒤에 붙임.
			// 4-5. 생성된 문자열을 반환.
			u = u.substring(1,u.length()-1);
			u = reverse(u);
			return s + u;
		}
	}
	
	//두 균형잡힌 괄호 문자열 u,v로 분리하기 위함
	static int division(String w) {
		int close = 0;
		int open = 0;
		for(int i=0;i<w.length();i++) {
			if(w.charAt(i) == '(') open++;
			else close++;
			
			if(close == open) return i+1;
		}
		return close;
	}
	
	//문자열 u가 올바른 괄호 문자열인지 판별
	static boolean isCorrect(String u) {
		int count = 0;
		for(int i=0;i<u.length();i++) {
			if(u.charAt(i)=='(') count++;
			else count--;
			
			if(count < 0) return false;
		}
		return count == 0;
	}
	
	//괄호 방향 뒤집기
	static String reverse(String u) {
		StringBuffer sb = new StringBuffer();
		for(int i=0;i<u.length();i++) {
			if(u.charAt(i) == '(') sb.append(")");
			else sb.append("(");
		}
		return sb.toString();
	}

}
