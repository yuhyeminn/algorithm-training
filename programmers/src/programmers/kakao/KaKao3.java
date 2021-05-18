package programmers.kakao;

import java.util.ArrayList;
import java.util.List;

public class KaKao3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int needs[][] = { { 1, 0, 0 }, { 1, 1, 0 }, { 1, 1, 0 }, { 1, 0, 1 }, { 1, 1, 0 }, { 0, 1, 1 } };
		int r = 2;

	}
	static int[] robot = new int[15];
	public static int solution(int[][] needs, int r) {
        int answer = 0;
        
        
        
        
        
        return answer;
    }
	
	public int buy(int cnt, int r, int[][] needs) {
		if(cnt == r) {
			return make(needs);
		}
		for(int i=0;i<needs[0].length;i++) {
			
		}
		
		return 0;
	}
	
	public int make(int[][] needs) {
		int result = 0;
		boolean flag = true;
		for(int i=0;i<needs.length;i++) {
			for(int j=0;j<needs[i].length;j++) {
				if(needs[i][j]==1) {
					if(robot[j]==1) {
						result++;
					}else {
						break;
					}
				}
			}
		}
		
		return result;
	}

}
