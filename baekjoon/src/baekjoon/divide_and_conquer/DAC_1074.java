package baekjoon.divide_and_conquer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Z 1074
 * https://www.acmicpc.net/problem/1074
 * 한수는 2차원 배열 (항상 2^N * 2^N 크기이다)을 Z모양으로 탐색하려고 한다. 예를 들어, 2*2배열을 왼쪽 위칸, 오른쪽 위칸, 왼쪽 아래칸, 오른쪽 아래칸 순서대로 방문하면 Z모양이다.
 * 만약, 2차원 배열의 크기가 2^N * 2^N라서 왼쪽 위에 있는 칸이 하나가 아니라면, 배열을 4등분 한 후에 (크기가 같은 2^(N-1)로) 재귀적으로 순서대로 방문한다.
 * N이 주어졌을 때, (r, c)를 몇 번째로 방문하는지 출력하는 프로그램을 작성하시오.
 *
 * [입력]
 * 첫째 줄에 N r c가 주어진다. N은 15보다 작거나 같은 자연수이고, r과 c는 0보다 크거나 같고, 2^N-1보다 작거나 같은 정수이다
 * 
 * [출력]
 * 첫째 줄에 문제의 정답을 출력한다.
 * 
 * [참고]
 * https://bcp0109.tistory.com/47
 */
public class DAC_1074 {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] input = br.readLine().split(" ");
		
		int N = Integer.parseInt(input[0]);
		int r = Integer.parseInt(input[1]);
		int c = Integer.parseInt(input[2]);
		
		//n = 2^N 
		int n = (int) Math.pow(2, N);
		int x = 0;
		int y = 0;
		
		int count = 0;
		while(n > 0) {
			n /= 2;
			
			//2차원 배열이라는 것을 명심하자,, 일반적인 좌표로 생각했다가 헷갈렸음 
			//2사분면(왼쪽 위)
			if(r < x+n && c < y+n) {
				
			}
			//1사분면(오른쪽 위)
			else if(r < x+n) {
				count += n * n;	//2사분면의 총 개수만큼 더해줌
				y += n;
			}
			//3사분면(왼쪽 아래)
			else if(c < y+n) {
				count += n * n * 2;	//1,2사분면의 총 개수만큼 더해줌
				x += n;
			}
			//4사분면(오른쪽 아래)
			else {
				count += n * n * 3;	//1,2,3사분면의 총 개수만큼 더해줌
				x += n;
				y += n;
			}
			
			//n이 1일 경우는 (x,y)가 (r,c)와 같아졌다는 것
			if(n == 1) {
				System.out.println(count);
				break;
			}
		}
	}
	
}
