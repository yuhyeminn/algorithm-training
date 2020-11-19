package programmers.code_challenge.challenge_1008;

import java.util.LinkedList;
import java.util.Queue;

/* 테스트케이스 8~17 메모리초과*/
public class challenge4 {
	
	public static long solution(String s) {
        long answer = 0;
        Queue<String> queue = new LinkedList<>();
        for(int i=0;i<s.length();i++) {
        	for(int j=i;j<s.length();j++) {
        		String str = s.substring(i,j+1);
        		if(str.length() == 2) {
        			answer += str.charAt(0) == str.charAt(1)?0:1;
        		}else if(str.length()>2) {
        			queue.add(str);
        		}
        	}
        }
        
        while(!queue.isEmpty()) {
        	String str = queue.poll();
        	int beautiful = getBeautiful(str);
        	answer += beautiful;
        }
        return answer;
    }
	
	public static int getBeautiful(String str) {
		int max = 0;
		for(int i=0;i<str.length();i++) {
			for(int j=str.length()-1;j>=0;j--) {
				if(max > j-i) continue;
				if(str.charAt(i) != str.charAt(j) && max < j-i) {
					max = j-i;
				}
				if(max == str.length()-1) return max;
			}
		}
		
		return max;
	}
	
	public static void main(String[] args) {
		String s = "baby";
		System.out.println(solution(s));
	}
}
