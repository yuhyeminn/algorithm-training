package solved_ac.class2;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 최대공약수와 최소공배수
 * https://www.acmicpc.net/problem/2609
 * 
 * [해결]
 * 유클리드 호제법
 */
public class Class2_2609 {
    
	public static void main(String args[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int A = Integer.parseInt(st.nextToken());
		int B = Integer.parseInt(st.nextToken());
		int a = A>B?A:B;
		int b = A>B?B:A;
		
		while( b != 0)
		{
			int c = b;
			b = a%b;
			a = c;
		}
		System.out.println(a);
		System.out.print(A*B/a);
	}
	
}