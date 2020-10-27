package programmers.nhn;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class NHN01 {
	
	public static void main(String[] args) {
		int numOfAllPlayers = 17;				//게임에 참여하는 사람의 수
		int numOfQuickPlayers = 5;				//달리기가 빨라 술래에 절대 걸리지 않는 사람의 수
		char[] namesOfQuickPlayers = {'B','D','I','M','P'}; //달리기가 빨라 술래에 절대 걸리지 않는 사람들의 이름
		int numOfGames = 11;						//게임 진행 횟수
		int[] numOfMovesPerGame = {3, -4, 5, 6, -7, -8, 10, -12, -15, -20, 23};		//술래가 수건을 내려놓기 위해 이동하는 칸수(첫 번째 게임은 시계방향으로 3칸 이동, 두 번째 게임은 반시계방향으로 이동)	
		
		solution(numOfAllPlayers, numOfQuickPlayers, namesOfQuickPlayers, numOfGames, numOfMovesPerGame);
	}
	
	private static void solution(int numOfAllPlayers, int numOfQuickPlayers, char[] namesOfQuickPlayers, int numOfGames, int[] numOfMovesPerGame) {
		
		List<Player> ground = new ArrayList<>();
		
		Arrays.sort(namesOfQuickPlayers);
		int qindex = 0;
		
		for(int i=0;i<numOfAllPlayers;i++) {
			char name = (char)('A'+i);
			int loc = i-1;
			boolean isQuick = false;
			if(qindex < numOfQuickPlayers && namesOfQuickPlayers[qindex] == name) {
				isQuick = true;
				qindex++;
			}
			ground.add(new Player(name, loc, isQuick, 0));
		}
		
		//게임 플레이
		play(ground, numOfGames, numOfMovesPerGame);
		
		//결과 출력
		for(Player p : ground) {
			System.out.println(p);
		}
	}
	
	private static void play(List<Player> ground, int numOfGames, int[] numOfMovesPerGame) {
		Player tagger = ground.get(0);	// 처음은 무조건 A가 술래
		ground.remove(0);
		tagger.loc = 0;					// 술래 처음 위치는 0
		tagger.loseCnt++;

		int num = ground.size();	    // 술래 제외한 플레이어 수
		for(int i=0;i<numOfGames;i++) {
			//술래 이동
			int move = tagger.loc + numOfMovesPerGame[i];
			if(move > 0) {
				move %= num;
			}else {
				while(move < 0) {
					move += num;
				}
			}
			
			//peek 뒤에 수건 놓음
			Player peek = ground.get(move);
			
			if(peek.isQuick) {
				//현재 술래가 다시 또 술래가 됨
				tagger.loc = move;
				tagger.loseCnt++;
			}else {
				//peek이 술래가 될 경우
				//현재 술래 자리 = 다음 술래 자리
				tagger.loc = peek.loc;
				ground.set(move, tagger);
				peek.loseCnt++;
				
				tagger = peek;
			}
		}
		//마지막 술래 ground에 추가
		ground.add(tagger);
	}
	
	static class Player{
		char name;
		int loc;
		boolean isQuick;
		int loseCnt;
		
		public Player(char name, int loc, boolean isQuick, int loseCnt) {
			this.name = name;
			this.loc = loc;
			this.isQuick = isQuick;
			this.loseCnt = loseCnt;
		}

		@Override
		public String toString() {
			return name + " " + loseCnt;
		}
	}
	
	
}
