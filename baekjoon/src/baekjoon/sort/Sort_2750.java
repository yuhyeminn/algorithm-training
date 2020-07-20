package baekjoon.sort;

import java.util.Arrays;
import java.util.Scanner;

/**
 * 2750
 * N개의 수가 주어졌을 때, 이를 오름차순으로 정렬하는 프로그램을 작성하시오.
 * 
 * [입력]
 * 첫째 줄에 수의 개수 N(1 ≤ N ≤ 1,000)이 주어진다. 둘째 줄부터 N개의 줄에는 숫자가 주어진다. 
 * 이 수는 절댓값이 1,000보다 작거나 같은 정수이다. 수는 중복되지 않는다.
 *
 * [출력]
 * 첫째 줄 부터 N개의 줄에 오름차순으로 정렬한 결과를 한 줄에 하나씩 출력함
 */
public class Sort_2750 {

	//시간 복잡도가 O(n²)인 정렬 알고리즘
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int index = 0;
		int temp = 0;
		
		int size = sc.nextInt();
		int[] arr = new int[size];
		
		for(int i=0;i<size;i++) {
			arr[i] = sc.nextInt();
		}
		for(int i=0;i<arr.length;i++) {
			int min = 1001;
			for(int j=i;j<arr.length;j++) {
				if(min > arr[j]) {
					min = arr[j];
					index = j;
				}
			}
			temp = arr[i];
			arr[i] = arr[index];
			arr[index] = temp;
		}
		
		for(int i=0;i<arr.length;i++) {
			System.out.println(arr[i]);
		}
	}
}
