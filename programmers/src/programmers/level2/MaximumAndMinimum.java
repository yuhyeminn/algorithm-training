package programmers.level2;

import java.util.Arrays;
/**
 * 최댓값과 최솟값
 * 
 * [문제]
 * 문자열 s에는 공백으로 구분된 숫자들이 저장되어 있습니다. str에 나타나는 숫자 중 최소값과 최대값을 찾아 이를 (최소값) (최대값)형태의 문자열을 반환하는 함수, solution을 완성하세요.
 * 예를들어 s가 1 2 3 4라면 1 4를 리턴하고, -1 -2 -3 -4라면 -4 -1을 리턴하면 됩니다.
 * 
 * [제한사항]
 * s에는 둘 이상의 정수가 공백으로 구분되어 있습니다.
 * 
 */
public class MaximumAndMinimum {

	public static void main(String[] args) {
		String s ="-1 -2 -3 -4";
		System.out.println("result="+solution(s));
	}
	
	public static String solution(String s) {
		
		String[] arr = s.split(" ");
		int[] result = new int[arr.length];
		
		for(int i=0;i<result.length;i++) {
			result[i] = Integer.parseInt(arr[i]);
		}

		Arrays.sort(result);
		
		String answer = result[0] + " " + result[result.length-1];
		
		return answer;
	}
	
	/* 다른사람 풀이
	public String getMinMaxString(String str) {
        String[] tmp = str.split(" ");
        int min, max, n;
        min = max = Integer.parseInt(tmp[0]);
        for (int i = 1; i < tmp.length; i++) {
                n = Integer.parseInt(tmp[i]);
            if(min > n) min = n;
            if(max < n) max = n;
        }

        return min + " " + max;
    }
	*/
}
