package programmers.wintercoding;

import java.util.ArrayList;
import java.util.List;

public class Winter01 {

	public static void main(String[] args) {
		int n = 6;
		int delivery[][] = { { 1, 3, 1 }, { 3, 5, 0 }, { 5, 4, 0 }, { 2, 5, 0 } };
		System.out.println(solution(n, delivery));
	}

	public static String solution(int n, int[][] delivery) {
		char[] stock = new char[n + 1]; // 상품별 재고 여부
		Product[] products = new Product[n+1];
		
		for (int i = 1; i < n + 1; i++) {
			stock[i] = '?';
			products[i] = new Product(i);
		}
		
		for (int i = 0; i < delivery.length; i++) {
			int p1 = delivery[i][0];
			int p2 = delivery[i][1];

			products[p1].pack.add(p2);
			products[p2].pack.add(p1);
			
			// 배송 됐을 경우
			if (delivery[i][2] == 1) {
				stock[p1] = stock[p2] = 'o';
			}
		}
		
		//**배송된 경우를 먼저 처리해주고 나머지 상품에 대한 재고상태를 처리함
		for(int i=1;i<stock.length;i++) {
			//재고있는 상품과 같이 포장되었으나 재고상태가 ?인 경우는 배송된 것이 아니므로 재고없음으로 처리
			if(stock[i] == 'o') {
				for(int p : products[i].pack) {
					if(stock[p] != 'o') {
						stock[p] = 'x';
					}
				}
			}
		}

		StringBuilder sb = new StringBuilder();
		for (int i = 1; i < n + 1; i++) {
			sb.append(stock[i]);
		}
		
		return sb.toString();
	}
	
	static class Product {
	    int num;
	    List<Integer> pack;

	    public Product(int num) {
	        this.num = num;
	        this.pack = new ArrayList<>();
	    }
	}
}
