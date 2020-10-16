package programmers.level2;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 타겟 넘버
 * 
 * [문제] 
 * n개의 음이 아닌 정수가 있습니다. 이 수를 적절히 더하거나 빼서 타겟 넘버를 만들려고 합니다. 
 * 예를 들어 [1, 1, 1, 1,1]로 숫자 3을 만들려면 다음 다섯 방법을 쓸 수 있습니다. 
 * 	 -1+1+1+1+1 = 3
 *   +1-1+1+1+1 = 3
 *   +1+1-1+1+1 =3 
 *   +1+1+1-1+1 = 3
 *   +1+1+1+1-1 = 3
 *사용할 수 있는 숫자가 담긴 배열 numbers, 타겟 넘버 target이 매개변수로 주어질 때 숫자를 적절히 더하고 빼서 타겟 넘버를 만드는 방법의 수를 return 하도록 solution 함수를 작성해주세요.
 *
 * [제한사항] 
 * 주어지는 숫자의 개수는 2개 이상 20개 이하입니다. 
 * 각 숫자는 1 이상 50 이하인 자연수입니다. 
 * 타겟 넘버는 1 이상1000 이하인 자연수입니다.
 * 
 * [참고]
 * https://www.pymoon.com/entry/Programmers-%ED%83%80%EA%B2%9F-%EB%84%98%EB%B2%84-BFSDFS-Java-%ED%92%80%EC%9D%B4?category=929770
 *
 */
public class TargetNumber {

	public static void main(String[] args) {
		int numbers[] = { 1, 1, 1, 1, 1 };
		int target = 3;
		System.out.println(solution(numbers, target));
	}

	public static int solution(int[] numbers, int target) {
		// DFS
		int answer = DFS(numbers, target, 0, 0);
		System.out.println("DFS result="+answer);
		
		// BFS
		int answer2 = BFS(numbers, target);
		System.out.println("BFS result="+answer2);
		
		return answer;
	}

	public static int DFS(int[] numbers, int target, int index, int sum) {
		if (index == numbers.length) {
			if (sum == target) {
				return 1;
			}
			return 0;
		}
		//모든 경우의 수를 다 체크함
		//왼쪽 노드는 +numbers[index], 오른쪽 노드는  -numbers[index]라고 생각
		return DFS(numbers, target, index + 1, sum + numbers[index])
				+ DFS(numbers, target, index + 1, sum - numbers[index]);
	}

	public static int BFS(int numbers[], int target) {
		int answer = 0;

		Queue<Pair> q = new LinkedList<>();
		q.add(new Pair(numbers[0], 0));
		q.add(new Pair(-numbers[0], 0));

		while (!q.isEmpty()) {
			Pair p = q.poll();
			if(p.index == numbers.length-1) {
				if(p.cur == target) {
					answer += 1;
				}
				continue;
			}
			q.add(new Pair(p.cur + numbers[p.index+1], p.index+1));
			q.add(new Pair(p.cur - numbers[p.index+1], p.index+1));
		}
		
		return answer;
	}

	static class Pair {
		int cur;	//현재까지의 sum값
		int index;	//현재 인덱스 값

		Pair(int cur, int index) {
			this.cur = cur;
			this.index = index;
		}
	}

}
