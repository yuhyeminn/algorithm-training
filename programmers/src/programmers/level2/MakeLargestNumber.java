package programmers.level2;

/**
 * 큰 수 만들기 (탐욕법)
 * 
 * [문제]
 * 어떤 숫자에서 k개의 수를 제거했을 때 얻을 수 있는 가장 큰 숫자를 구하려 합니다.
 * 예를 들어, 숫자 1924에서 수 두 개를 제거하면 [19, 12, 14, 92, 94, 24] 를 만들 수 있습니다. 이 중 가장 큰 숫자는 94 입니다.
 * 문자열 형식으로 숫자 number와 제거할 수의 개수 k가 solution 함수의 매개변수로 주어집니다. 
 * number에서 k 개의 수를 제거했을 때 만들 수 있는 수 중 가장 큰 숫자를 문자열 형태로 return 하도록 solution 함수를 완성하세요.
 *
 * [제한사항]
 * number는 1자리 이상, 1,000,000자리 이하인 숫자입니다.
 * k는 1 이상 number의 자릿수 미만인 자연수입니다.
 */
public class MakeLargestNumber {

	public static void main(String[] args) {
		String number = "4177252841";
		int k = 4;
		
		System.out.println("result="+solution(number,k));
	}
	
	public static String solution(String number, int k) {
		StringBuilder answer = new StringBuilder();
		
		int idx = 0;
		for(int i=0;i<number.length()-k;i++) {
			char max = '0';
			for(int j=idx;j<=i+k;j++) {
				if(number.charAt(j)>max) {
					max = number.charAt(j);
//					System.out.println(max);
					idx = j+1;
				}
			}
			answer.append(max);
		}
		
		return answer.toString();
	}
	
	 /* 다른사람풀이
	 public String solution(String number, int k) {
        char[] result = new char[number.length() - k];
        Stack<Character> stack = new Stack<>();

        for (int i=0; i<number.length(); i++) {
            char c = number.charAt(i);
            while (!stack.isEmpty() && stack.peek() < c && k-- > 0) {
                stack.pop();
            }
            stack.push(c);
        }
        for (int i=0; i<result.length; i++) {
            result[i] = stack.get(i);
        }
        return new String(result);
     }
	 */
}
