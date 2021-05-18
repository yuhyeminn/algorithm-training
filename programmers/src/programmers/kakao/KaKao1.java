package programmers.kakao;

import java.util.HashMap;
import java.util.Map;

public class KaKao1 {

	public static void main(String[] args) {
		int[] gift = { 4, 5, 3, 2, 1 };
		int[] wants = { 2, 4, 4, 5, 1 };
		System.out.println(solution(gift, wants));
	}

	public static int solution(int[] gift_cards, int[] wants) {
		int answer = 0;
		Map<Integer, Integer> map = new HashMap<>();
		for(int i=0;i<gift_cards.length;i++) {
			int card = gift_cards[i];
			map.put(card, map.getOrDefault(card, 0)+1);
		}
		
		for(int i=0;i<wants.length;i++) {
			int w = wants[i];
			if(map.get(w)==null || map.get(w)==0) {
				answer++;
			}else {
				map.put(w, map.get(w)-1);
			}
		}
		return answer;
	}
}
