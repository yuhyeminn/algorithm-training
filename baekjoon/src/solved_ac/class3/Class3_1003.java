package solved_ac.class3;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * 피보나치 함수
 * @author hyemin
 *
 * fibonacci(n)의 0과 1의 개수는
 * fibonacci(n-1)과 fibonacci(n-2)의 각각의 개수의 합
 */
public class Class3_1003 {
    
	public static void main(String[] args) throws Exception{
       BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
       StringBuilder sb = new StringBuilder();
       int T = Integer.parseInt(br.readLine());
       int darr[][] = new int[41][2];
       
       darr[0][0] = 1;
       darr[0][1] = 0;
       darr[1][0] = 0;
       darr[1][1] = 1;
       
       for(int i=0;i<T;i++) {
    	   int n = Integer.parseInt(br.readLine());
    	   
    	   for(int j=2;j<=n;j++) {
    		   //점화식
    		   darr[j][0] = darr[j-1][0] + darr[j-2][0];
    		   darr[j][1] = darr[j-1][1] + darr[j-2][1];
    	   }
    	   
    	   sb.append(darr[n][0]).append(" ").append(darr[n][1]).append("\n");
       }
       
       System.out.println(sb.toString());
	}
}