package baekjoon.greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 병든 나이트
 * 병든 나이트가 N × M 크기 체스판의 가장 왼쪽아래 칸에 위치해 있다. 병든 나이트는 건강한 보통 체스의 나이트와 다르게 4가지로만 움직일 수 있다.
 * 	1. 2칸 위로, 1칸 오른쪽
 * 	2. 1칸 위로, 2칸 오른쪽
 * 	3. 1칸 아래로, 2칸 오른쪽
 * 	4. 2칸 아래로, 1칸 오른쪽
 * 병든 나이트는 여행을 시작하려고 하고, 여행을 하면서 방문한 칸의 수를 최대로 하려고 한다.
 * 병든 나이트의 이동 횟수가 4번보다 적지 않다면, 이동 방법을 모두 한 번씩 사용해야 한다. 
 * 이동 횟수가 4번보다 적은 경우(방문한 칸이 5개 미만)에는 이동 방법에 대한 제약이 없다.
 * 체스판의 크기가 주어졌을 때, 병든 나이트가 여행에서 방문할 수 있는 칸의 최대 개수를 구해보자.
 * 
 * [입력]
 * 첫째 줄에 체스판의 세로 길이 N와 가로 길이 M이 주어진다. N과 M은 2,000,000,000보다 작거나 같은 자연수이다.
 * 
 * [출력]
 * 병든 나이트가 여행에서 방문할 수 있는 칸의 개수중 최댓값을 출력한다.
 * 
 * [참고]
 * https://lipcoder.tistory.com/entry/%EB%B3%91%EB%93%A0-%EB%82%98%EC%9D%B4%ED%8A%B8-%EB%B0%B1%EC%A4%80-1783%EB%B2%88
 */
public class Greedy_1783 {

	static int N, M;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		System.out.println(solve());
	}
	
	public static int solve() {
		//높이가 1일때 움직일 수 없으므로 1
		if(N == 1) return 1;
		else if(N == 2) {
			//높이가 2일 때
			//오른쪽으로 2칸씩만 이동(2번,3번)할 수 있기 때문에 (M+1)/2
			//이동횟수가 4회 이상일 경우 모든  조건을 실행해야 하므로 최대 3+1(초기값)칸 방문
			if((M+1)/2 > 4) return 4;
			else return (M+1)/2;
		}
		else {
			//높이가 3이상일 경우 제약 없음
			//가로가 7이상일 경우 부터 +1,-1로 매 칸마다 방문 할 수 있음.
			//(가로가 7일 경우 == 이동횟수 4번째 되는 경우 == 모든 조건을 사용하여 방문한 칸이 5가됨)
			if(M >= 7) return  M - 7 + 5;
			else return Math.min(M, 4);
		}
	}
	
}
