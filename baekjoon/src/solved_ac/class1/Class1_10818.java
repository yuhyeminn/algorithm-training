package solved_ac.class1;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Class1_10818 {
    
	public static void main(String[] args) throws Exception{
       BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
       int N = Integer.parseInt(br.readLine());
       StringTokenizer st = new StringTokenizer(br.readLine());
       
       int min = Integer.MAX_VALUE;
       int max = Integer.MIN_VALUE;
       for(int i=0;i<N;i++) {
    	   int num = Integer.parseInt(st.nextToken());
    	   min = Math.min(num, min);
    	   max = Math.max(num, max);
       }
       
       System.out.println(min +" " + max);
	}
	
}