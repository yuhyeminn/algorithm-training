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
 * [참고]
 * https://m.blog.naver.com/tlstjd436/221961918364
 */
public class TruckCrossingBridge {

	static class Truck{
		int weight;
		int enterTime;
		
		public Truck(int weight, int enterTime) {
			super();
			this.weight = weight;
			this.enterTime = enterTime;
		}
	}
	
	public static int solution(int bridge_length, int weight, int[] truck_weights) {
		// 1. 다리를 건너고 있는 트럭 저장 bridge 큐
		// 2. 대기 및 진입 시간 저장을 위한 waiting 큐
		Queue<Truck> bridge = new LinkedList<>();
		Queue<Truck> waiting = new LinkedList<>();
		
		int time = 0;
		//모든 트럭을 waiting 큐에 넣음
		for(int i=0;i<truck_weights.length;i++) {
			waiting.add(new Truck(truck_weights[i], time));
		}
		
		int total_weight = 0;
		while(true) {
			time++;
			//다리에 트럭이 있다면
			if(!bridge.isEmpty()) {
				Truck truck = bridge.peek();
				//현재 시간에서 트럭이 진입한 시간을 뺐을 때, 다리의 길이와 같거나 크다면 다리를 지나간 것
				int t = time - truck.enterTime;
				//트럭이 지나갔을 경우 total_weight에서 해당 트럭 무게를 빼주고 bridge 큐에서 빼줌
				if(t >= bridge_length) {
					total_weight -= truck.weight;
					bridge.poll();
				}
			}
			//대기중인 트럭 큐 비어있지 않다면 접근
			if(!waiting.isEmpty()) {
				//total = 현재 다리위의 트럭들 무게
				//w : 현재 다리 무게와 대기열 첫번째 트럭의 무게를 합한 것
				int w = total_weight + waiting.peek().weight;
				//w가 다리가 견딜수 있는 weight보다 크지 않은 경우 bridge 큐에 넣어줌
				if(w <= weight) {
					Truck t = waiting.poll();
					total_weight += t.weight;
					bridge.add(new Truck(t.weight,time));
				}
			}
			//두개의 큐가 모두 비게 된다면 반복문 끝
			if(waiting.isEmpty() && bridge.isEmpty()) {
				break;
			}
		}
		
		return time;
	}

	public static void main(String[] args) {
		int bridge_length = 2;
		int weight = 10;
		int [] truck_weights = {7, 4, 5, 6};	
		
		System.out.println("time = " + solution(bridge_length, weight, truck_weights));
	}
}
