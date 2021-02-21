package sovled_ac.class1;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Class1_8958 {
    
	public static void main(String[] args) throws Exception{
       BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
       int N = Integer.parseInt(br.readLine());
       StringBuffer sb = new StringBuffer();
       for(int i=0;i<N;i++) {
    	   String str = br.readLine();
    	   
    	   int score = getScore(str);
    	   sb.append(score).append("\n");
       }
       System.out.println(sb.toString());
	}
	
	public static int getScore(String str) {
		char[] arr = str.toCharArray();
		int score = 0;
		int cnt = 0;
		for(int i=0;i<str.length();i++) {
			if(arr[i] == 'O') {
				score += ++cnt;
			}else {
				cnt = 0;
			}
		}
		return score;
	}
}