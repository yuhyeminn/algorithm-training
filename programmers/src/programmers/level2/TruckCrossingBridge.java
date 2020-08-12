package programmers.level2;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 다리를 지나는 트럭
 *
 * [문제]
 * https://programmers.co.kr/learn/courses/30/lessons/42583
 * 
 * solution 함수의 매개변수로 다리 길이 bridge_length, 다리가 견딜 수 있는 무게 weight, 트럭별 무게 truck_weights가 주어집니다. 
 * 이때 모든 트럭이 다리를 건너려면 최소 몇 초가 걸리는지 return 하도록 solution 함수를 완성하세요.
 * 
 * [제한조건]
 * bridge_length는 1 이상 10,000 이하입니다.
 * weight는 1 이상 10,000 이하입니다.
 * truck_weights의 길이는 1 이상 10,000 이하입니다.
 * 모든 트럭의 무게는 1 이상 weight 이하입니다.
 * 
 */
public class TruckCrossingBridge {

	public static void main(String[] args) {
		
	}
	
	public static int solution(int bridge_length, int weight, int[] truck_weights) {
		int answer = 0;
		
		Queue<Integer> bridge = new LinkedList<>();
		
		/*while(true) {
			if(bridge.isEmpty()) {
				
			}
		}*/
		
		return answer;
	}
}
