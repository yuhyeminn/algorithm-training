package programmers.level2;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;
import java.util.Queue;
import java.util.Set;

/**
 * 프렌즈 4 블록
 * 
 * 도저히 못풀겠으면 다른 사람 코드를 따라 쳐보자,,!
 * 
 * [참고]
 * https://soobarkbar.tistory.com/93
 *
 */
public class Friends4Block {

	static Set<Point> remove;
	static char[][] chboard;
	static int[] dx = {1, 1, 0};
	static int[] dy = {0, 1, 1};
	static final char SPACE = '*';
	public static int solution(int m, int n, String[] board) {
        int answer = 0;
        // 부술 블록 리스트
        remove = new HashSet<>();
        chboard = new char[m][n];
        boolean canBreak = true;	//아직 부술 수 있는 블록이 남아있는지 검사
        
        // board -> char형 2차원 배열로 변환
        // 바닥이 0인덱스가 되도록 변환
        for(int i=0;i<m;i++) {
        	chboard[i] = board[m - i - 1].toCharArray();
        }
        
        while(canBreak) {
        	canBreak = false;
        	
        	for(int x=0;x<m;x++) {
        		for(int y=0;y<n;y++) {
        			//빈 공간일 경우 continue
        			if(chboard[x][y] == SPACE)
        				continue;
        			
        			//같은 블록 4개 찾기
        			find4Block(x, y);
        		}
        	}
        	
        	if(!remove.isEmpty()) {
        		canBreak = true;
        		answer += remove.size();
        		
        		//블록 부수기
        		breakBlock();
        		
        		//블록 아래로 내리기
        		downBlock();
        	}
        }
        return answer;
    }
	
	// 같은 블록 4개 찾기
	public static void find4Block(int x, int y) {
		int px,py;
		List<Point> list = new ArrayList<>();
		
		list.add(new Point(x,y));
		
		for(int i=0;i<3;i++) {
			px = dx[i] + x;
			py = dy[i] + y;
			
			if(px >= 0 && px < chboard.length && py >= 0 && py < chboard[0].length) {
				if(chboard[x][y] == chboard[px][py]) {
					list.add(new Point(px,py));
				}else {
					break;
				}
			}
		}
		
		//같은 블록 4개가 있다면 remove 리스트에 해당 블록 추가
		if(list.size() == 4) {
			for(Point p : list) {
				if(!remove.contains(p)) {
					remove.add(p);
				}
			}
		}
	}
	
	// 블록 부수기
	public static void breakBlock() {
		//remove에 포함된 좌표 빈공간으로 치환
		for(Point p : remove) {
			chboard[p.x][p.y] = SPACE;
		}
		remove.clear();
	}

	// 블록 내리기
	public static void downBlock() {
		Queue<Character> queue = new LinkedList<>();
		// 블록이 아래로 떨어지기 때문에 열->행 검사
		for(int y=0;y<chboard[0].length;y++) {
			for(int x=0;x<chboard.length;x++) {
				if(chboard[x][y] != SPACE) {
					queue.add(chboard[x][y]);
				}
			}
			
			// chboard의 바닥은 0인덱스
			int idx = 0;
			while(!queue.isEmpty()) {
				chboard[idx++][y] = queue.poll();
			}
			
			//빈공간 채워주기
			for(int i=idx;i<chboard.length;i++) {
				chboard[i][y] = SPACE;
			}
		}
	}
	
	//좌표를 저장할 클래스
	static class Point{
		int x;
		int y;
		
		public Point(int x, int y) {
			this.x = x;
			this.y = y;
		}

		@Override
		public int hashCode() {
			return Objects.hash(x,y);
		}

		@Override
		public boolean equals(Object obj) {
			if(!(obj instanceof Point)) return false;
			
			Point s = (Point)obj;
			return this.x == s.x && this.y == s.y;
		}
	}
	

	public static void main(String[] args) {
		int m = 4;
		int n = 5;
		String board[] = {"CCBDE", "AAADE", "AAABF", "CCBBF"};
		System.out.println(solution(m, n, board));
	}
}
