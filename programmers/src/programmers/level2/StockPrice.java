package programmers.level2;

import java.util.Arrays;
import java.util.Stack;

/**
 * 주식 가격
 * [문제]
 * 초 단위로 기록된 주식가격이 담긴 배열 prices가 매개변수로 주어질 때, 가격이 떨어지지 않은 기간은 몇 초인지를 return 하도록 solution 함수를 완성하세요.
 *
 * [제한 사항]
 * prices의 각 가격은 1 이상 10,000 이하인 자연수입니다.
 * prices의 길이는 2 이상 100,000 이하입니다.
 */
public class StockPrice {

	public static void main(String[] args) {
		int[] prices = {1, 2, 3, 2, 3};
		System.out.println(Arrays.toString(solution(prices)));
	}
	/* 스택/큐 문제인데 쓸 일이 없음.. 다른 풀이도 검색해보자 */
	public static int[] solution(int[] prices) {
		int[] answer = new int[prices.length];
		int size = prices.length;
		
		for(int i=size-1;i>0;i--) {
			answer[(size-1)-i] = i;
		}
		
		for(int i=0;i<size;i++) {
			int price = prices[i];
			for(int j=i+1;j<size;j++) {
				if(price > prices[j]) {
					answer[i] = j - i;
					break;
				}
			}
		}
		
		return answer;
	}
}
