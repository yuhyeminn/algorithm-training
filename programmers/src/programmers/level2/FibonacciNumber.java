package programmers.level2;

public class FibonacciNumber {

	static int[] memo;
	public static void main(String[] args) {
		int n = 2;
		System.out.println("result="+solution(n));
	}
	
	public static int solution(int n) {
	    int answer = 0;
	    
	    memo = new int[n+1];
	    answer = fibonacci(n);
	    
	    return answer;
	}
	
	public static int fibonacci(int n) {
		if(n == 1) return 1;
		if(n == 2) return 1;
		if(memo[n]!=0) return memo[n];
		return memo[n] =(fibonacci(n-1) + fibonacci(n-2))%1234567;
	}

}
