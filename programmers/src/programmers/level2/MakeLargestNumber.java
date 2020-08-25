package programmers.level2;


/*탐욕법*/
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
