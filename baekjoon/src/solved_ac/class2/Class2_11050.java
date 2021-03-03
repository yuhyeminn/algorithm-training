package solved_ac.class2;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


/**
 * 이항계수 1
 * @author hyemin
 * 
 * [해결]
 * 이항계수란?
 * 	- N개 중에서 서로다른 K개를 고르는 조합의 수
 *  - n! / ((n-k)!k!)
 */
public class Class2_11050 {

	public static void main(String args[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		
		int result = factorial(N) / (factorial(N-K) * factorial(K));
		System.out.println(result);
	}
	
	public static int factorial(int n) {
		int result = 1;
		for(int i=2;i<=n;i++) {
			result *= i;
		}
		return result;
	}
	
}