package programmers.level2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class EnglishWordRelay {

	public static void main(String[] args) {
		int n = 3;
		String words[] = {"tank", "kick", "know", "wheel", "land", "dream", "mother", "robot", "tank"};
		System.out.println(Arrays.toString(solution(n,words)));
	}

	public static int[] solution(int n, String[] words) {
        int[] answer = {0,0};
        
        List<String> list = new ArrayList<>();
        list.add(words[0]);
        
        for(int i=1;i<words.length;i++) {
        	String pre = words[i-1];
        	String curr = words[i];
        	
        	if(pre.charAt(pre.length()-1) != curr.charAt(0) || list.indexOf(curr) > -1) {
        		int cnt = (i+1)/n;
        		answer[0] = (i+1)%n == 0?n:(i+1)%n;
        		answer[1] = (i+1)%n == 0?cnt:cnt+1;
        		return answer;
        	}
        	
        	list.add(curr);
        }
        
        return answer;
    }
}
