package algorithm;

import java.util.Scanner;

/**
 * 그리디 알고리즘(Greedy Algorithm)
 * - 당장 눈 앞에 보이는 최적의 상황만을 쫓는 알고리즘
 * - 전체적인 상황을 종합적으로 판단하고, 고려하여 결정하는 것이아니라 현 시점의 정보를 바탕으로 가장 이익이 되는 원소들을 선택하는 방법
 * - 가장 단순한 알고리즘
 * - 항상 최적의 결과를 도출하는 것은 아님.
 * - 그리디 알고리즘 적용 : 크루스칼 알고리즘, 프림 알고리즘
 * - 대표적인 예 : 거스름 돈 문제
 * 
 * 최적해를 구하기 위해 다음 세 가지 작업을 수행
 * 1. 선택작업 : 현 상테에서 최적해에 포함시킬 대안을 선택
 * 2. 타당성 조사 : 선택된 해가 주어진 문제의 조건을 만족하는지 검사
 * 3. 해답 조사 : 원래의 문제가 해결되었는지를 조사

 */
//거스름돈 문제 : 무조건 더 큰 화폐 단위부터 거슬러주면 최적의 해를 보장할 수 있음.
public class GreedyAlgorithm {
	/* 
	[백준 5585 거스름돈]
	타로는 자주 JOI잡화점에서 물건을 산다. JOI잡화점에는 잔돈으로 500엔, 100엔, 50엔, 10엔, 5엔, 1엔이 충분히 있고, 언제나 거스름돈 개수가 가장 적게 잔돈을 준다. 
	타로가 JOI잡화점에서 물건을 사고 카운터에서 1000엔 지폐를 한장 냈을 때, 받을 잔돈에 포함된 잔돈의 개수를 구하는 프로그램을 작성하시오.
	*/
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
