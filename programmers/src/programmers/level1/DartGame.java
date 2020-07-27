package programmers.level1;

import java.util.Arrays;

/**
 * 다트 게임(2018 카카오)
 * https://programmers.co.kr/learn/courses/30/lessons/17682
 *
 * 다트게임 점수 계산 로직
 * 1. 다트게임은 총 3번의 기회로 구성되며 기회마다 얻을 수 있는 점수는 0점~10점.
 * 2. 점수와 함께 S(Single), D(Double), Triple(T)영역이 존재하고 각각 점수에서 1제곱, 2제곱, 3제곱으로 계산됨
 * 3. 옵션으로 *(스타상), #(아차상)이 존재함.
 *    스타상 당첨 시 해당 점수와 바로 전에 얻은 점수를 각 2배로 만듦. 아차상 당첨시 해당 점수는 마이너스가 됨
 * 4. 스타상은 첫번째 기회에도 나올 수 있음. 이 경우 첫번 째 스타상의 점수만 2배가 됨.
 * 5. 스타상의 효과는 다른 스타상의 효과와 중첩 될 수 있음. 이 경우 중첩된 스타상 점수는 4배가 됨.
 * 6. 스타상의 효과는 아차상의 효과와 중첩될 수 있음. 이 경우 중첩된 아차상의 점수는 -2배가 됨.
 * 7. S, D, T는 점수마다 하나씩 존재함
 * 8. 스타상, 아차상은 점수마다 둘 중 하나만 존재할 수 있으며, 존재하지 않을 수도 있음.
 * 
 */
public class DartGame {

	public static void main(String[] args) {
		String dartResult = "1D2S3T*";
		System.out.println("result=" + DartGame.solution(dartResult));
		
	}
	
	public static int solution(String dartResult) {
		//3번의 기회
		int[] score = new int[3];
		int scoreIndex = -1;
		//첫번째 값은 첫번째 점수
		score[0] = dartResult.charAt(0) - '0';
		
		for(int i=0;i<dartResult.length();i++) {
			char c = dartResult.charAt(i);
			//숫자일 경우 score배열에 넣기. 10점 유의하기
			if(c >= '0' && c <= '9') {
				System.out.println(i);
				scoreIndex++;
				if(dartResult.charAt(i+1)=='0') {score[scoreIndex] = 10; i++;}
				else {score[scoreIndex] = c-'0';}
			}else {
				int s = score[scoreIndex];
				switch(c) {
				case 'S' : break;
				case 'D' : score[scoreIndex] = (int) Math.pow(s, 2); break;
				case 'T' : score[scoreIndex] = (int) Math.pow(s, 3); break;
				case '*' : 
					if(scoreIndex > 0) {
						score[scoreIndex] *= 2 ;
						score[scoreIndex-1] *= 2;
					}else {
						score[scoreIndex] *= 2;
					}
					break;
				case '#' : score[scoreIndex] *= -1; break;
				}
			}
		}
		
		//System.out.println(Arrays.toString(score));
		
		return score[0]+score[1]+score[2];
	}
	
	/* 스택 이용해서 풀어내는 방법 생각해보기 */
}
