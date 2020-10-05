package baekjoon.divide_and_conquer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 종이의 개수 1780
 * N×N크기의 행렬로 표현되는 종이가 있다. 종이의 각 칸에는 -1, 0, 1의 세 값 중 하나가 저장되어 있다. 우리는 이 행렬을 적절한 크기로 자르려고 하는데, 이때 다음의 규칙에 따라 자르려고 한다.
 *   1. 만약 종이가 모두 같은 수로 되어 있다면 이 종이를 그대로 사용한다.
 *   2. (1)이 아닌 경우에는 종이를 같은 크기의 9개의 종이로 자르고, 각각의 잘린 종이에 대해서 (1)의 과정을 반복한다.
 * 이와 같이 종이를 잘랐을 때, -1로만 채워진 종이의 개수, 0으로만 채워진 종이의 개수, 1로만 채워진 종이의 개수를 구해내는 프로그램을 작성하시오.
 * 
 * [입력]
 * 첫째 줄에 N(1≤N≤3^7, N은 3^k 꼴)이 주어진다. 다음 N개의 줄에는 N개의 정수로 행렬이 주어진다.
 * 
 * [출력]
 * 첫째 줄에 -1로만 채워진 종이의 개수를, 둘째 줄에 0으로만 채워진 종이의 개수를, 셋째 줄에 1로만 채워진 종이의 개수를 출력한다.
 *
 */
public class DAC_1780 {

	static int N;
	static int paper[][];
	static int answer[] = new int[3];	//-1 , 0, 1의 개수
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		paper = new int[N][N];
		for(int i=0;i<N;i++) {
			StringTokenizer tokenizer = new StringTokenizer(br.readLine());
			for(int j=0;j<N;j++) {
				paper[i][j] = Integer.parseInt(tokenizer.nextToken());
			}
		}
		
		cutting(0, 0, N);
		System.out.println(answer[0] + "\n" + answer[1] + "\n" + answer[2]);
		
	}
	
	public static void cutting(int row, int col, int N) {
		if(isAble(row, col, N)) {
			answer[paper[row][col]+1]++;
		}else {
			//9 분할
			int size = N/3;
			for(int i=0;i<3;i++) {
				for(int j=0;j<3;j++) {
					cutting(row + size*i, col + size*j, size);
				}
			}
		}
	}
	
	public static boolean isAble(int row, int col, int size) {
		int t = paper[row][col];
		for(int i=row;i<row+size;i++) {
			for(int j=col; j< col+size; j++) {
				if(t != paper[i][j]) return false;
			}
		}
		return true;
	}
	
}
