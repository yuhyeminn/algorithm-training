package coding_test.naver;

import java.util.Arrays;

public class Naver_02 {
	static int[][] pyramid;
	public static void main(String[] args) {
		int[][] blocks = {{0, 50}, {0, 22}, {2, 10}, {1, 4}, {4, -13},{5, 12}};
		System.out.println(Arrays.toString(solution(blocks)));
	}
	
	public static int[] solution(int[][] blocks) {
		int answer[] = {};
		
		int n = blocks.length;
		pyramid = new int[n][n];
		for(int i=0;i<blocks.length;i++) {
			//한층씩 해결
			pyramid[i][blocks[i][0]] = blocks[i][1];
			int count = 0;
			int j = 0;
			while(j <= i && count != i+1) {
				if(getInt(i,j++)) {
					count++;
				}
				if(count!=i+1 && j == i+1) {
					j = 0;
					count = 0;
				}
			}
		}
		
		for(int i=0;i<pyramid.length;i++) {
			for(int j=0;j<i+1;j++) {
				System.out.print(pyramid[i][j] +" ");
			}
			System.out.println();
		}
		return answer;
	}
	
	public static boolean getInt(int i, int j) {
		if(i < 0 || i >= pyramid.length) return false;
		if(j < 0 || j > i+1) return false;
		int num = pyramid[i][j];
		if(num != 0) return true;
		if(j!=i && pyramid[i][j+1] != 0) {
			int x = pyramid[i-1][j] - pyramid[i][j+1];
			pyramid[i][j] = x;
			return true;
		}
		if(j!=0 && pyramid[i][j-1] != 0) {
			int x = pyramid[i-1][j-1] - pyramid[i][j-1];
			pyramid[i][j] = x;
			return true;
		}
		return false;
	}
}
