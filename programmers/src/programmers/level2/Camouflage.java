package programmers.level2;

import java.util.HashMap;
import java.util.Map;

/**
 * 위장
 * 
 * [문제]
 * 스파이들은 매일 다른 옷을 조합하여 입어 자신을 위장합니다.
 * ..
 * https://programmers.co.kr/learn/courses/30/lessons/42578
 * ..
 * 스파이가 가진 의상들이 담긴 2차원 배열 clothes가 주어질 때 서로 다른 옷의 조합의 수를 return 하도록 solution 함수를 작성해주세요.
 *
 * [제한조건]
 * clothes의 각 행은 [의상의 이름, 의상의 종류]로 이루어져 있습니다.
 * 스파이가 가진 의상의 수는 1개 이상 30개 이하입니다.
 * 같은 이름을 가진 의상은 존재하지 않습니다.
 * clothes의 모든 원소는 문자열로 이루어져 있습니다.
 * 모든 문자열의 길이는 1 이상 20 이하인 자연수이고 알파벳 소문자 또는 '_' 로만 이루어져 있습니다.
 * 스파이는 하루에 최소 한 개의 의상은 입습니다.
 */
public class Camouflage {
	public static void main(String[] args) {
		String[][] clothes = {{"yellow_hat", "headgear"},{"blue_sunglasses", "eyewear"},{"green_turban", "headgear"}};
		System.out.println("result="+solution(clothes));
	}
	
	public static int solution(String[][] clothes) {
		int answer = 1;
		Map<String,Integer> map = new HashMap<>();
		
		for(int i=0;i<clothes.length;i++) {
			map.put(clothes[i][1], map.getOrDefault(clothes[i][1], 0)+1);
		}
		/*
		 서로 다른 옷의 조합의 수 = {(의상종류1 개수 + 1) * (의상종류2 개수 + 1 ) * ... * (의상종류n 개수 + 1} - 1
		 의상종류n 개수 + 1 -> 1을 더하는 이유는 해당 종류의상을 입지 않는 경우도 있기 때문
		 마지막 결과에서 1을 빼는 이유는 모든 옷을 입지 않는 경우를 배제하기 위함 
		*/
		for(String s : map.keySet()) {
			int num = map.get(s);
			answer *= (num+1);
		}
		return answer - 1;
	}
}
