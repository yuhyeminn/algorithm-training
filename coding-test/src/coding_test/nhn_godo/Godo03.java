package coding_test.nhn_godo;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Godo03 {

	public static void main(String[] args) {
		String s = "aaaabbbbc";
		int n = 5;
		System.out.println(solution(s, n));
	}
	
	public static int solution(String s, int n){
	    
		Map<String, Integer> map = new HashMap<>();
		for(int i=0;i<s.length();i++) {
			String str = s.charAt(i)+"";
			map.put(str, map.getOrDefault(str, 0)+1);
		}
		
		int arr[] = new int[map.size()];
		int idx = 0;
		for(String key : map.keySet()) {
			int num = map.get(key);
			arr[idx] = num;
			idx++;
		}
		
		Arrays.sort(arr);
		int answer = arr[arr.length-1] - arr[0]- n;
		if(arr[0] + arr[arr.length-1] <= n) {
			answer =  arr[arr.length-1] + arr[0]- n;
		}
		
		return answer;
	}
	
	public static class Str{
		char alphabet;
		int cnt;
		
		public Str(char alphabet, int cnt) {
			this.alphabet = alphabet;
			this.cnt = cnt;
		}
	}

}
