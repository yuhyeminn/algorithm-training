package solved_ac.class2;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * 괄호
 * @author hyemin
 *
 */
public class Class2_9012 {

	public static void main(String args[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		boolean flag = false;
		for(int i=0;i<T;i++) {
			flag = isVPS(br.readLine());
			if(flag) {
				sb.append("YES");
			}else {
				sb.append("NO");
			}
			sb.append("\n");
		}
		
		System.out.println(sb.toString());
	}
	
	public static boolean isVPS(String str) {
		char arr[] = str.toCharArray();
		int cnt = 0;
		for(int i=0;i<arr.length;i++) {
			if(arr[i] == '(') {
				cnt++;
			}else {
				cnt--;
			}
			if(cnt < 0) {
				return false;
			}
		}
		if(cnt != 0) {
			return false;
		}
		return true;
	}

}