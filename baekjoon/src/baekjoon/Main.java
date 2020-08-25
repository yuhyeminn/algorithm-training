package baekjoon;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int cost = sc.nextInt();
		System.out.println(greedy(cost));
	}
	public static int greedy(int cost) {
		int n = 0;
		int result = 0;
		
		n = 1000 - cost;
		result += n / 500;
		n %= 500;
		result += n / 100;
		n %= 100;
		result += n / 50;
		n %= 50;
		result += n / 10;
		n %= 10;
		result += n / 5;
		n %= 5;
		result += n;
		
		/*System.out.println(result);*/
		return result;
	}
}
