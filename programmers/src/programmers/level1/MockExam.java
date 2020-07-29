package programmers.level1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 모의고사 (완전 탐색)
 * 
 * [문제]
 * 1번 수포자가 찍는 방식: 1, 2, 3, 4, 5, 1, 2, 3, 4, 5, ...
 * 2번 수포자가 찍는 방식: 2, 1, 2, 3, 2, 4, 2, 5, 2, 1, 2, 3, 2, 4, 2, 5, ...
 * 3번 수포자가 찍는 방식: 3, 3, 1, 1, 2, 2, 4, 4, 5, 5, 3, 3, 1, 1, 2, 2, 4, 4, 5, 5, ...
 * 1번 문제부터 마지막 문제까지의 정답이 순서대로 들은 배열 answers가 주어졌을 때, 가장 많은 문제를 맞힌 사람이 누구인지 배열에 담아 return 하도록 solution 함수를 작성해주세요.
 * 
 * [제한 조건]
 * 시험은 최대 10,000 문제로 구성되어있습니다.
 * 문제의 정답은 1, 2, 3, 4, 5중 하나입니다.
 * 가장 높은 점수를 받은 사람이 여럿일 경우, return하는 값을 오름차순 정렬해주세요.
 */
public class MockExam {

	public static void main(String[] args) {
		int[] answers = {1,2,3,4,5};
		System.out.println("result="+Arrays.toString(MockExam.solution(answers)));
	}
	
	public static int[] solution(int[] answers) {
		int[] s1 = {1, 2, 3, 4, 5};
		int[] s2 = {2, 1, 2, 3, 2, 4, 2, 5};
		int[] s3 = {3, 3, 1, 1, 2, 2, 4, 4, 5, 5};
		int[] cnt = new int[3];
		
		for(int i=0;i<answers.length;i++) {
			if(answers[i]==s1[i%s1.length]) {
				cnt[0]++;
			}
			if(answers[i]==s2[i%s2.length]) {
				cnt[1]++;
			}
			if(answers[i]==s3[i%s3.length]) {
				cnt[2]++;
			}
		}
		
		int max = Integer.MIN_VALUE;
		for(int i=0;i<cnt.length;i++) {
			if(max < cnt[i]) {
				max = cnt[i];
			}
		}
		
		List<Integer> list = new ArrayList<>();
		for(int i=0;i<cnt.length;i++) {
			if(cnt[i] == max) {
				list.add(i+1);
			}
		}
		
		int[] answer = new int[list.size()];
		for(int i=0;i<answer.length;i++){
			answer[i] = list.get(i);
		}
		return answer;
	}
}
