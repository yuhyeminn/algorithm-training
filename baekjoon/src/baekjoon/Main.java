package baekjoon;

import java.util.Arrays;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int index = 0;
		int temp = 0;
		
		int size = sc.nextInt();
		int[] arr = new int[size];
		
		for(int i=0;i<size;i++) {
			arr[i] = sc.nextInt();
		}
		
		Arrays.sort(arr);
		
		for(int i=0;i<arr.length;i++) {
			System.out.println(arr[i]);
		}
	}
	
}
