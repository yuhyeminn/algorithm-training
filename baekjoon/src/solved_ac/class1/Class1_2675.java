package solved_ac.class1;

import java.util.Scanner;

public class Class1_2675 {
    
	public static void main(String[] args) throws Exception{
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        
        for(int i=0;i<n;i++) {
        	int r = sc.nextInt();
        	String s = sc.next();
        	
        	System.out.println(makeString(r, s));
        }
	}
	
	public static String makeString(int r, String s) {
		StringBuffer sb = new StringBuffer();
		for(int i=0;i<s.length();i++) {
			for(int j=0;j<r;j++) {
				sb.append(s.charAt(i));
			}
		}
		return sb.toString();
	}
	
}