package coding_test.nhn;

public class NHN02 {

	public static void main(String[] args) {
//		int day = 2;
//		int width = 6;
//		int blocks[][] = {{6,2,11,0,3,5}, {6,3,0,9,0,5}};
		
		int day = 3;
		int width = 10;
		int blocks[][] = {{6, 12, 0, 2, 8, 4, 0, 7, 3, 6}, {6, 1, 3, 0, 2, 8, 0, 0, 13, 8}, {6, 3, 0, 10, 6, 5, 7, 0, 0, 3}};

		solution(day, width, blocks);
	}
	
	private static void solution(int day, int width, int[][] blocks) {
		int height[] = new int[width];	//각 너비의 총 높이
		int sement = 0;
		for(int i=0;i<day;i++) {
			// 벽돌 쌓기
			for(int j=0;j<blocks[i].length;j++) {
				height[j] += blocks[i][j];
			}
			
			// 시멘트 붓기
			// base, bidx -> 구역이 나뉘는 기준
			int base = height[0];
			int bidx = 0;
			
			for(int j=1;j<width-1;j++) {
				if(height[j] < height[j+1]) {
				    int standard = base < height[j+1]?base:height[j+1];
				    int k = bidx;
				    while(k!=j) {
				    	k++;
				    	int amount = standard - height[k];
				    	//amount가 음수가 되는 경우는 이미 시멘트가 충분한 곳이기 때문에 계산하지 않음.
				    	if(amount > 0) {
				    		sement += amount;
						    height[k] += amount;
				    	}
				    }
				}
				if(base <= height[j]) {
					base = height[j];
					bidx = j;
				}
			}
		}
		System.out.println(sement);
	}
	
}
