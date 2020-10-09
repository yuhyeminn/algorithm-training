package programmers.challenge_1008;

public class challenge1 {

	public static void main(String[] args) {
		int n = 45;
		System.out.println(solution(n));
	}
	
	public static int solution(int n) {
        //3진수로 변환
        String num = "";
        while(n != 0) {
        	if(n%3 < 10) {
        		num = (n % 3) + num;
        		n /= 3;
        	}else {
        		int temp = (char)((n%3)+55);
        		num = Integer.toString(temp) + num;
        	}
        }
        
        //num 뒤집기
        String reverse = "";
        for(int i=num.length()-1;i>=0;i--) {
        	reverse += num.charAt(i) - '0';
        }
        
        //다시 10진수로 변환
        int k = 1;
        int result = 0;
        for(int i=reverse.length()-1;i>=0;i--) {
        	result += (reverse.charAt(i)-'0') * k;
        	k *= 3;
        }
        return result;
    }
	/*
	 public int solution(int n) {
        int answer = 0;
        StringBuilder result = new StringBuilder();
        while(n>0){
            result.append(n%3);
            n = n/3;
        }
        char[] temp = result.toString().toCharArray();
        int mul = 1;
        for(int i=temp.length-1; i>=0; i--){
            answer += (temp[i]-48)*mul;
            mul *= 3;
        }

        return answer;
    }
	*/
}
