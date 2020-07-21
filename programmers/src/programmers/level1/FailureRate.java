package programmers.level1;

import java.util.ArrayList;
import java.util.List;

/**
 * 실패율 (2019 카카오)
 * https://programmers.co.kr/learn/courses/30/lessons/42889
 * 
 * - 실패율 : 스테이지에 도달했으나 아직 클리어하지 못한 플레이어의 수 / 스테이지에 도달한 플레이어 수
 * - 실패율이 높은스테이지부터 내림차순으로 스테이지의 번호가 담긴 배열 return
 * - 실패율이 같은 스테이지가 있다면 작은 번호의 스테이지가 먼저 오도록 하면 됨.
 */
public class FailureRate {

	public static void main(String[] args) {
		
	}
	
	public static int[] solution(int n, int[] stages) {
		int[] answer = {};
		List<Stage> list = new ArrayList<>();
		
		for(int i=0;i<n;i++) {
			list.add(new Stage(i+1));
		}
		
		for(int i=0;i<stages.length;i++) {
			if(stages[i]<=n) {
				list.get(stages[i]).userCnt++;
			}
		}
		
		System.out.println(list.toString());
		return answer;
	}
	
}
//Stage 커스텀 객체 만들기
class Stage implements Comparable<Stage>{
	int stageNumber;
	//현재 도달한 유저 수
	int userCnt;
	int failureRate;
	
	public Stage(int stageNumber) {
		this.stageNumber = stageNumber;
	}
	
	@Override
	public int compareTo(Stage s) {
		if(this.failureRate > s.failureRate) {
			return -1;
		}else if(this.failureRate < s.failureRate) {
			return 1;
		}else {
			return Integer.compare(this.stageNumber, s.stageNumber);
		}
	}
	
}
