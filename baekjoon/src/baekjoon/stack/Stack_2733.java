package baekjoon.stack;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * Brainf*ck
 * 
 * @author hyemin
 * 
 */
public class Stack_2733{

	public static StringBuilder result = new StringBuilder();
	public static Map<Integer, Integer> bracketMap = new HashMap<>();	// 괄호의 짝 저장 map
	public static char arr[];	// 포인터가 가리키는 배열
	
	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		for(int i=1;i<=T;i++) {
			// 첫째 줄에 PROGRAM #n을 출력
			result.append("PROGRAM #").append(i).append(":\n");
			
			// 프로그램 실행마다 자원 초기화 및 생성하기
			StringBuilder sb = new StringBuilder();
			arr = new char[32768];
			bracketMap.clear();
			
			// 입력된 코드 정리 (공백 제거, 주석 제거)
			while(true) {
				String str = br.readLine().replace(" ", ""); //공백 제거
				if("end".equals(str)) {
					break;
				}else if(str.contains("%")) {
					str = str.substring(0, str.indexOf("%"));
				}
				sb.append(str);
			}
			
			String code = sb.toString();
			
			// 괄호 짝 체크
			if(bracketCheck(code)) {
				// 프로그램 실행
				executeProgram(code);
			}else {
				result.append("COMPILE ERROR");
			}
			result.append("\n");
		}
		
		System.out.println(result.toString());
		
	}

	public static void executeProgram(String code) {
		int p = 0;	//포인터
		
		for(int i=0;i<code.length();i++) {
			char ch = code.charAt(i);
			switch(ch) {
				case '>' : 
					p = (p == 32767) ? 0 : p + 1;
					break;
				case '<' :
					p = (p == 0) ? 32767 : p - 1;
					break;
				case '+' :
					arr[p] = (arr[p] == 255) ? 0 : (char)(arr[p] + 1);
					break;
				case '-' :
					arr[p] = (arr[p] == 0) ? 255 : (char)(arr[p] - 1);
					break;
				case '.' :
					result.append(arr[p]);
					break;
				case '[' :
					if(arr[p] == 0)
						i = bracketMap.get(i);
					break;
				case ']' :
					if(arr[p] != 0)
						i = bracketMap.get(i);
					break;
			}
		}
	}
	
	public static boolean bracketCheck(String code) {
		Stack<Integer> stack = new Stack<>();
		
		for(int i=0;i<code.length();i++){
			char ch = code.charAt(i);
			if(ch == '[') {
				stack.push(i);
			}else if(ch == ']') {
				if(stack.isEmpty()) {
					return false;
				}else {
					int idx = stack.pop();
					//괄호 짝 저장하는 bracketMap에 각각 저장해 둠
					bracketMap.put(idx, i);
					bracketMap.put(i, idx);
				}
			}
		}
		
		if(!stack.isEmpty()) {
			return false;
		}
		
		return true;
	}
}
