package programmers.level3;

/**
 * 2 x n 타일링
 * 
 * [문제]
 * 가로 길이가 2이고 세로의 길이가 1인 직사각형모양의 타일이 있습니다.
 * 이 직사각형 타일을 이용하여 세로의 길이가 2이고 가로의 길이가 n인 바닥을 가득 채우려고 합니다.
 * 타일을 채울 때는 다음과 같이 2가지 방법이 있습니다.
 * 	1. 타일을 가로로 배치 하는 경우
 *  2. 타일을 세로로 배치 하는 경우
 *  
 * 직사각형의 가로의 길이 n이 매개변수로 주어질 때, 이 직사각형을 채우는 방법의 수를 return 하는 solution 함수를 완성해주세요.
 * 
 * [제한사항]
 * 가로의 길이 n은 60,000이하의 자연수 입니다.
 * 경우의 수가 많아 질 수 있으므로, 경우의 수를 1,000,000,007으로 나눈 나머지를 return해주세요.
 */
public class Tiling {
	
	public static void main(String[] args) {
		int n = 3;
		System.out.println(solution(n));
	}
	
	public static int solution(int n) {
		int answer = 0;
		
		//dp arr
		int arr[] = new int[n+1];
		answer = tiling(n,arr);
		
		return answer;
	}
	
	public static int tiling(int x, int[] arr) {
		//마지막 남은 타일의 길이가 1 또는 2일 경우로 나눠주면 됨.
		if(x == 1) return 1;
		if(x == 2) return 2;
		if(arr[x] != 0) return arr[x];
		return arr[x] = (tiling(x-1,arr) + tiling(x-2,arr)) % 1000000007;
	}
}
