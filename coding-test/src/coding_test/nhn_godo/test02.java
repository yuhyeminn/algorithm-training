package coding_test.nhn_godo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/*
문제 설명
어떤 도둑이 최대 int k 무게를 담을 수 있는 배낭을 매고, 금은방에 침입 했습니다.

이 도둑은 용의주도 하여서, 어제 이미 사전 조사를 했기 때문에 금은방의 모든 보석의 무게와 가치를 전부 알고 있습니다.

 

모든 보석의 무게와 가치가 다르기 때문에, 도둑은 자신이 가져갈 수 있는 가장 최대 가치의 보석을 가져가고 싶습니다.

 

각 보석의 무게는 int[] w로 주어지며, 가치는 int[] v로 주어집니다.

i번째 보석의 무게와 가치는 각각 w의 i번째, v의 i번째 이며, 무게와 가치는 정수입니다.

(모든 보석은 하나씩 존재하며, 동일한 무게와 가치를 지닌 보석은 없습니다.)

예를 들어 봅시다.
배낭의 크기 K가 50
보석1 - 무게 10, 가치 60
보석2 - 무게 20, 가치 100
보석3 - 무게 30, 가치 120

보석2,3을 담으면 가질 수 있는 최대 가치 220을 얻을 수 있습니다.

 

이 도둑이 가져갈 수 있는 최대 가치를 구해서 리턴하세요.
 */
public class test02 {

	public static void main(String[] args) {
		int[] w = { 10, 20, 30 };
		int[] v = { 60, 100, 120 };
		int k = 50;
		System.out.println("result=" + new test02().knapsack(w, v, k));
	}

	public int knapsack(int[] w, int[] v, int k) {

		List<Jewelry> list = new ArrayList<>();
		for (int i = 0; i < w.length; i++) {
			list.add(new Jewelry(w[i], v[i]));
		}

		Collections.sort(list);

		int max_value = 0;
		for (int i = 0; i < w.length; i++) {
			int kg = 0;
			int value_sum = 0;
			Jewelry jewelry = list.get(i);
			if (jewelry.weight <= k) {
				kg += jewelry.weight;
				value_sum += jewelry.value;
				for (int j = i + 1; j < w.length; j++) {
					Jewelry next = list.get(j);
					if (k - kg >= next.weight) {
						kg += w[j];
						value_sum += v[j];
					}
				}
				if (value_sum > max_value) {
					max_value = value_sum;
				}
			}
		}

		return max_value;
	}

	public class Jewelry implements Comparable<Jewelry> {
		int weight;
		int value;

		public Jewelry(int weight, int value) {
			this.weight = weight;
			this.value = value;
		}

		@Override
		public int compareTo(Jewelry o) {
			return this.weight - o.weight;
		}

	}
}
