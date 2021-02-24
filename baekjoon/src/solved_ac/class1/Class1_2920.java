package solved_ac.class1;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Class1_2920 {
    
	public static void main(String[] args) throws Exception{
       BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
       String[] str = br.readLine().split(" ");
       
       for(int i=0;i<str.length-1;i++) {
    	  int a = Integer.parseInt(str[i]);
    	  int b = Integer.parseInt(str[i+1]);
    	  if(Math.abs(a-b)!=1) {
    		  System.out.println("mixed");
    		  return;
    	  }
       }
       
       if(Integer.parseInt(str[0])==1) {
    	   System.out.println("ascending");
       }else {
    	   System.out.println("descending");
       }
       
	}
}