package programmers.level2;

import java.util.HashSet;
import java.util.Set;

/**
 * 폰켓몬
 *
 * [문제]
 * https://programmers.co.kr/learn/courses/30/lessons/1845
 * 
 */
public class Phoneketmon {

	public static void main(String[] args) {
		int nums[] = {3,3,3,2,2,4};
		System.out.println("result="+solution(nums));
	}
	
	static int solution(int[] nums) {
	    int answer = 0;
	    int cnt = nums.length / 2;
	    
	    Set<Integer> set = new HashSet<>();
	    for(int i=0;i<nums.length;i++) {
	    	set.add(nums[i]);
	    }
	    
	    answer = cnt > set.size() ? set.size():cnt;
	    
	    return answer;
	}

}
