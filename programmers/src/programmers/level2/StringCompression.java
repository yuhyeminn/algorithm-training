package programmers.level2;

/**
 * 문자열 압축
 * 
 * [문제]
 * https://programmers.co.kr/learn/courses/30/lessons/60057
 * ...
 * 압축할 문자열 s가 매개변수로 주어질 때, 위에 설명한 방법으로 1개 이상 단위로 문자열을 잘라 압축하여 표현한 문자열 중 가장 짧은 것의 길이를 return 하도록 solution 함수를 완성해주세요.
 *
 * [제한사항]
 * s의 길이는 1 이상 1,000 이하입니다.
 * s는 알파벳 소문자로만 이루어져 있습니다.
 */
public class StringCompression {

	public static void main(String[] args) {
		String s = "aabbaccc";
		System.out.println("result="+solution(s));
	}
	
	public static int solution(String s) {
		int answer = s.length();
		
		//i = 문자열을 자르는 단위(개수) = 1 ~ 전체문자열길이/2
		for(int i=1;i<=(s.length()/2);i++) {
			StringBuilder result = new StringBuilder();
			int count = 1;
			//첫번째 문자열 초기화
			String str = s.substring(0,i);
			for(int j=1;j<=(s.length()/i);j++) {
				int end = (j*i)+i > s.length()?s.length():(j*i)+i;
				String next_str = s.substring((i*j),end);
//				System.out.println(next_str);
				if(str.equals(next_str)) {
					count++;
					continue;
				}
				//다음 문자열과 같지 않은 경우 count와 현재 문자열 result에 append
				//count 1 은 생략
				if(count>1) result.append(count+str);
				else result.append(str);
				
				str = next_str;
				count = 1;
			}
			//마지막 문자열 처리
			if(count>1) result.append(count+str);
			else result.append(str);
			
			System.out.println(result);
			answer = Math.min(answer, result.length());
		}
		return answer;
	}
}
