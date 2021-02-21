package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    
	public static void main(String[] args) throws Exception{
       BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
       int N = Integer.parseInt(br.readLine());
       String[] strs = br.readLine().split(" ");
       int arr[] = new int[strs.length];
       
       for(int i=0;i<arr.length;i++) {
    	   arr[i] = Integer.parseInt(strs[i]);
       }
       Arrays.sort(arr);
       System.out.println(arr[0] +" " + arr[N-1]);
	}
	
}