package programmers.level2;

import java.util.Arrays;

/**
 * 소수 만들기
 * 
 * [문제]
 * 주어진 숫자 중 3개의 수를 더했을 때 소수가 되는 경우의 개수를 구하려고 합니다. 
 * 숫자들이 들어있는 배열 nums가 매개변수로 주어질 때, nums에 있는 숫자들 중 서로 다른 3개를 골라 더했을 때 소수가 되는 경우의 개수를 return 하도록 solution 함수를 완성해주세요.
 *
 * [제한 사항]
 * nums에 들어있는 숫자의 개수는 3개 이상 50개 이하입니다.
 * nums의 각 원소는 1 이상 1,000 이하의 자연수이며, 중복된 숫자가 들어있지 않습니다.
 */
public class MakePrimeNumber {

	static boolean prime[] = new boolean[3001];
	public static void main(String[] args) {
		int nums[] = {1,2,3,4};
		System.out.println(solution(nums));
	}

	public static int solution(int[] nums) {
        int answer = 0;
        
        //에라토스테네스의 체. 소수 판별 배열 세팅
        Arrays.fill(prime, true);
        prime[0] = prime[1] = false;
        setPrimeArr();
        
        answer = dfs(nums, 0, 0, 0);

        return answer;
    }
	
	public static int dfs(int[] nums, int sum, int idx, int cnt) {
		if(cnt == 3) {
			if(prime[sum]) 
				return 1;
			else 
				return 0;
		}
		if(idx == nums.length) {
			return 0;
		}
		
		return dfs(nums, sum, idx+1, cnt) + dfs(nums, sum+nums[idx], idx+1, cnt+1);
	}
	
	public static void setPrimeArr() {
		for(int i=2;i<prime.length;i++) {
			if(!prime[i]) continue;
			for(int j = i * 2; j < prime.length; j += i) {
				prime[j] = false;
			}
		}
	}
}
