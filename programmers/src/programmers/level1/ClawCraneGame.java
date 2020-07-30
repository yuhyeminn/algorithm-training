package programmers.level1;

import java.util.Stack;

/**
 * 크레인 인형뽑기 게임(2019 카카오)
 * https://programmers.co.kr/learn/courses/30/lessons/64061
 * 
 */
public class ClawCraneGame {

	public static void main(String[] args) {
		int[][] board = {{0,0,0,0,0},{0,0,1,0,3},{0,2,5,0,1},{4,2,4,4,2},{3,5,1,3,1}};
		int[] moves = {1,5,3,5,1,2,1,4};
		
		System.out.println("result="+ ClawCraneGame.solution(board, moves));
	}
	
	public static int solution(int[][] board, int[] moves) {
		int answer = 0;
		Stack<Integer> basket = new Stack<>();
		for(int i=0;i<moves.length;i++) {
			for(int j=0;j<board.length;j++) {
				int doll = board[j][moves[i]-1];
				if(doll == 0) continue;
				else if(!basket.isEmpty() && basket.peek() == doll) {
					basket.pop();
					answer++;
				}else {
					basket.push(doll);
				}
				board[j][moves[i]-1] = 0;
				break;
			}
		}
		return answer * 2;
	}
}
