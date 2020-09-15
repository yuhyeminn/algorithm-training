package baekjoon.greedy;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * 잃어버린 괄호
 * 세준이는 양수와 +, -, 그리고 괄호를 가지고 길이가 최대 50인 식을 만들었다. 그리고 나서 세준이는 괄호를 모두 지웠다.
 * 그리고 나서 세준이는 괄호를 적절히 쳐서 이 식의 값을 최소로 만들려고 한다.
 * 괄호를 적절히 쳐서 이 식의 값을 최소로 만드는 프로그램을 작성하시오.
 * 
 * [입력]
 * 첫째 줄에 식이 주어진다. 식은 ‘0’~‘9’, ‘+’, 그리고 ‘-’만으로 이루어져 있고, 가장 처음과 마지막 문자는 숫자이다. 
 * 그리고 연속해서 두 개 이상의 연산자가 나타나지 않고, 5자리보다 많이 연속되는 숫자는 없다. 수는 0으로 시작할 수 있다.
 * 
 * [출력]
 * 첫째 줄에 정답을 출력한다.
 */
public class Greedy_1541 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		char arr[] = br.readLine().toCharArray();
		int answer = 0;
		String temp = "";
		boolean minus = false;
		for(int i=0;i<=arr.length;i++) {
			if(i == arr.length || arr[i] == '+' || arr[i] == '-') {
				if(minus) {
					answer -= Integer.parseInt(temp);
				}else {
					answer += Integer.parseInt(temp);
				}
				temp = "";
				if(i != arr.length && arr[i] == '-') minus = true;
				continue;
			}
			temp += arr[i];
		}
		
//		마지막 숫자가 answer에 반영되지 않기 때문에
//		answer += minus?-Integer.parseInt(temp):Integer.parseInt(temp);
				
		System.out.println(answer);
	}
}
