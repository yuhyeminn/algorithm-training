package solved_ac.class2;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

/**
 * 직각삼각형
 * @author hyemin
 * 
 */
public class Class2_4153 {
	
 	public static void main(String[] args) throws Exception {
 		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
 		StringTokenizer st;
 		StringBuilder sb = new StringBuilder();
 		
 		int arr[] = new int[3];
 		while(true) {
 			st = new StringTokenizer(br.readLine());
 			arr[0] = Integer.parseInt(st.nextToken());
 			arr[1] = Integer.parseInt(st.nextToken());
 			arr[2] = Integer.parseInt(st.nextToken());
 			
 			if( arr[0] == 0 && arr[1] == 0 && arr[2] == 0 ) {
 				break;
 			}
 			
 			if(check(arr)) {
 				sb.append("right");
 			}else {
 				sb.append("wrong");
 			}
 			
 			sb.append("\n");

 		}
 		
 		System.out.println(sb.toString());
 		
	}
 	
 	public static boolean check(int[] arr) {
 		boolean result = false;
 		Arrays.sort(arr);
 		
 		double a = Math.pow(arr[0],2);
 		double b = Math.pow(arr[1],2);
 		double c = Math.pow(arr[2],2);
 		
 		if((a + b) == c) {
 			result = true;
 		}
 		
 		return result;
 	}
	
}
