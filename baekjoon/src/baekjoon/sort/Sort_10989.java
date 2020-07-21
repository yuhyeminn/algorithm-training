package baekjoon.sort;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

/**
 * 10989
 * N개의 수가 주어졌을 때, 이를 오름차순으로 정렬하는 프로그램을 작성하시오.(시간, 메모리 제한)
 * 
 * [입력]
 * 첫째 줄에 수의 개수 N(1 ≤ N ≤ 10,000,000)이 주어진다. 둘째 줄부터 N개의 줄에는 숫자가 주어진다. 이 수는 10,000보다 작거나 같은 자연수이다.
 *
 * [출력]
 * 첫째 줄부터 N개의 줄에 오름차순으로 정렬한 결과를 한 줄에 하나씩 출력한다.
 */
public class Sort_10989 {

	public static void main(String[] args) throws IOException{
		
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			
			int size = Integer.parseInt(br.readLine());
			int arr[] = new int[10001];
			
			for(int i=0;i<size;i++) {
				int n = Integer.parseInt(br.readLine());
				arr[n]++;
			}
			
			BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
			
			for(int i=0;i<arr.length;i++) {
				if (arr[i] > 0) { 
	                for (int j = 0; j < arr[i]; j++) {
	                    bw.write(Integer.toString(i) + "\n");
	                }
	            }
			}
			
			br.close();
			bw.close();
	}
	
	
}
