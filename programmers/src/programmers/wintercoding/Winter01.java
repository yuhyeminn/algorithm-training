package programmers.wintercoding;

public class Winter01 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int n = 6;
		int delivery[][] = { { 1, 3, 1 }, { 3, 5, 0 }, { 5, 4, 0 }, { 2, 5, 0 } };
		System.out.println(solution(n, delivery));
	}

	public static String solution(int n, int[][] delivery) {
		char products[] = new char[n + 1]; // 상품별 재고 여부
		for (int i = 1; i < n + 1; i++) {
			products[i] = '?';
		}

		for (int i = 0; i < delivery.length; i++) {
			int p1 = delivery[i][0];
			int p2 = delivery[i][1];
			boolean isDelivery = delivery[i][2] == 0 ? false : true;

			// 배송 됐을 경우
			if (isDelivery) {
				products[p1] = 'o';
				products[p2] = 'o';
			}
			// 배송되지 않았을 경우
			else {
				if (products[p1] == 'o') {
					products[p2] = 'x';
				} else if (products[p2] == 'o') {
					products[p1] = 'x';
				}
			}
		}

		StringBuilder sb = new StringBuilder();
		for (int i = 1; i < n + 1; i++) {
			sb.append(products[i]);
		}
		
		return sb.toString();
	}

}
