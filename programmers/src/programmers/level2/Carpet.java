package programmers.level2;

import java.util.Arrays;

/**
 * 카펫
 *
 * [문제]
 * Leo는 카펫을 사러 갔다가 아래 그림과 같이 중앙에는 노란색으로 칠해져 있고 테두리 1줄은 갈색으로 칠해져 있는 격자 모양 카펫을 봤습니다.
 * Leo는 집으로 돌아와서 아까 본 카펫의 노란색과 갈색으로 색칠된 격자의 개수는 기억했지만, 전체 카펫의 크기는 기억하지 못했습니다.
 * Leo가 본 카펫에서 갈색 격자의 수 brown, 노란색 격자의 수 yellow가 매개변수로 주어질 때 카펫의 가로, 세로 크기를 순서대로 배열에 담아 return 하도록 solution 함수를 작성해주세요.
 * 
 * [제한사항]
 * 갈색 격자의 수 brown은 8 이상 5,000 이하인 자연수입니다.
 * 노란색 격자의 수 yellow는 1 이상 2,000,000 이하인 자연수입니다.
 * 카펫의 가로 길이는 세로 길이와 같거나, 세로 길이보다 깁니다.
 * 
 */
public class Carpet {

	public static void main(String[] args) {
		int brown = 8;
		int yellow = 1;
		System.out.println(Arrays.toString(solution(brown, yellow)));
	}

	public static int[] solution(int brown, int yellow) {
        int height = 0; 	//카펫의 세로 길이
        int width = 0;		//카펫의 가로 길이
        
        //yellow기준으로 완전 탐색
        //brown = yellow 가로 * 2 + yellow 세로 * 2 + 4 (직사각형의 꼭짓점)
        for(int i=1;i<=yellow/2+1;i++) {
        	width = i;
        	height = (yellow%i==0)? yellow/i:yellow/i+1;
        	
        	if(width * 2 + height * 2 + 4 == brown) break;
        }
        
        int[] answer = new int[2];
        //2를 더하는 이유 : 양 끝의 꼭짓점 더해주기
        answer[0] = Math.max(width,height) + 2;		
        answer[1] = Math.min(width, height) + 2;	
        
        return answer;
    }
}
