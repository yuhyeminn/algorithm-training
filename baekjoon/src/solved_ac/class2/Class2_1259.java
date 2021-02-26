package solved_ac.class2;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * 팰린드롬수
 * https://www.acmicpc.net/problem/1259
 */
public class Class2_1259 {
    
	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = br.readLine();
		while(!"0".equals(str)) {
			boolean flag = isPalindrome(str);
			if(flag) {
				System.out.println("yes");
			}else {
				System.out.println("no");
			}
			str = br.readLine();
		}
	}

	private static boolean isPalindrome(String str) {
		char arr[] = str.toCharArray();
		int start = 0;
		int end = arr.length-1;
		//무의미한 0이 나올 경우 false
		if(arr[0]=='0') {
			return false;
		}
		while(start <= end) {
			if(arr[start] != arr[end]) {
				return false;
			}
			start++;
			end--;
		}
		return true;
	}
}