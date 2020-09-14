package programmers.line;

import java.util.Arrays;

public class Line3 {
	static int count = 0;
	public static void main(String[] args) {
		int num= 10007;
		System.out.println(Arrays.toString(solution(num)));
	}
	
	public static int[] solution(int n) {
        int[] answer = new int[2];
        
        int result = getSmall(n);
//        System.out.println(result);
//        System.out.println(count);
        answer[0] = count;
        answer[1] = result;
        
        return answer;
    }
	
	public static int getSmall(int n) {
		String num = Integer.toString(n);
		if(num.length() == 1) return Integer.parseInt(num);
		
		int min = Integer.MAX_VALUE;
		for(int i=1;i<=num.length()-1;i++) {
			String s1 = num.substring(0,i);
			String s2 = num.substring(i);
			System.out.println(s1 +", " + s2);
			if(s1.charAt(0) == '0' || s2.charAt(0) == '0') continue;
			int a = Integer.parseInt(s1);
			int b = Integer.parseInt(s2);
			System.out.println(a + ", " + b);
			if(min > a+b) {
				min = a+b;
			}
			System.out.println(min);
		} 
		count++;
		
		return getSmall(min);
	}
}
