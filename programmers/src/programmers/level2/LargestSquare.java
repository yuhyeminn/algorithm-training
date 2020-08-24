package programmers.level2;

/**
 * 가장 큰 정사각형 찾기
 * https://programmers.co.kr/learn/courses/30/lessons/12905
 * 
 * [문제]
 * 1와 0로 채워진 표(board)가 있습니다. 표 1칸은 1 x 1 의 정사각형으로 이루어져 있습니다. 
 * 표에서 1로 이루어진 가장 큰 정사각형을 찾아 넓이를 return 하는 solution 함수를 완성해 주세요. 
 *
 * [제한사항]
 * 표(board)는 2차원 배열로 주어집니다.
 * 표(board)의 행(row)의 크기 : 1,000 이하의 자연수
 * 표(board)의 열(column)의 크기 : 1,000 이하의 자연수
 * 표(board)의 값은 1또는 0으로만 이루어져 있습니다.
 */
public class LargestSquare {

	public static void main(String[] args) {
		int board[][] = {{1,1,1,1},{0,1,1,1},{1,1,1,1}};
		System.out.println("result="+solution(board));
	}
	
	public static int solution(int board[][]) {
		int x = board.length;
		int y = board[0].length;
		int max = 0;
		
		//열이 1이거나 행이1일 경우
		//최소 정사각형의 크기는 1
		if(x <=1 || y<=1) return 1;
		
		//(1,1)부터 시작 -> 우측하단이 기준
		for(int i=1;i<x;i++) {
			for(int j=1;j<y;j++) {
				//좌, 상단, 좌상단 비교
				//모두 1일 경우 정사각형을 만들 수 있음.
				if(board[i][j] >= 1) {
					int left = board[i][j-1];
					int up = board[i-1][j];
					int leftup = board[i-1][j-1];
					int min = Math.min(left,Math.min(up,leftup));
					board[i][j] = min+1;
					max = Math.max(max, min+1);
				}
			}
		}
		return (int) Math.pow(max, 2);
	}
}
