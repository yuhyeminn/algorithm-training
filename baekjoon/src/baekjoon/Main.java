package baekjoon;

import java.util.Scanner;

public class Main {
    
	public static void main(String[] args) throws Exception{
       Scanner sc = new Scanner(System.in);
       int N = sc.nextInt();
       int result = 0;
       char arr[] = sc.next().toCharArray();
       for(int i=0;i<N;i++) {
    	   result += arr[i]-'0';
       }
       System.out.println(result);
	}
}