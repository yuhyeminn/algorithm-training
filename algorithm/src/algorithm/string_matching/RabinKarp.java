package algorithm.string_matching;

/**
 * 라빈 카프 문자열 매칭 알고리즘
 * - 찾을 문자열의 hash값을 비교하여 일치 여부를 검사하여 문자열을 찾는 알고리즘
 * - 항상 빠르지는 않지만 일반적인 경우 빠르게 작동하는 간단한 구조의 문자열 매칭 알고리즘임
 * - 해시값을 먼저 비교 한 후에 일치한 경우 차례대로 부분 문자열과 매칭하여 검사함.
 * @author hyemin
 *
 */
public class RabinKarp {

	public static void main(String[] args) {
		String text = "ababacabacaabacaaba";
		String find = "abacaaba";
		rabinkarp(text,find);
	}
	
	/* 보통 정확한 해시값 일치 여부를 검증하기 위한 나머지연산(mod)을 많이 사용함 */
	/* 안정적인 프로그램을 작성하고자 할 땐 나머지 연산(mod)를 이용하는 것을 추천*/
	public static void rabinkarp(String text, String find) {
		int tlength = text.length();
		int flength = find.length();
		int textHash = 0;
		int findHash = 0; 
		int power = 1;
		
		for(int i=0;i<=tlength-flength;i++) {
			if(i==0) {
				for(int j=0;j<flength;j++) {
					textHash += text.charAt(flength-1-j)*power;
					findHash += find.charAt(flength-1-j)*power;
					if(j < flength-1) power = power * 2; //2의 제곱수
				}
			}else{
				//첫번째를 제외하고는
				//text해시값 = 2 * (text 해시 값 - 가장 앞에 있는 문자의 수치) + 새롭게 들어온 문자의 수치
				textHash = 2 * (textHash - text.charAt(i-1)*power) + text.charAt(flength-1+i);
			}
			
			// 해시값이 일치하는 경우 부분 문자열 검사
			if(textHash == findHash) {
				boolean result = true;
				for(int j=0;j<flength;j++) {
					if(text.charAt(i+j) != find.charAt(j)) {
						result = false;
						break;
					}
				}
				if(result) {
					System.out.println((i+1)+"번째에서 발견하였습니다.");
				}
			}
		}
	}
	
	
	
}
