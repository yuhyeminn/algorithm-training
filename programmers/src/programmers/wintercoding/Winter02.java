package programmers.wintercoding;

public class Winter02 {

	public static void main(String[] args) {
		String encrypted_text = "qyyigoptvfb";
		String key = "abcdefghijk";
		int rotation = 3;
		System.out.println(solution(encrypted_text,key,rotation));
	}

	public static String solution(String encrypted_text, String key, int rotation) {
        char[] arr = new char[encrypted_text.length()];
       
        //회전부터 돌려 놓기
        for(int i=0;i<arr.length;i++) {
        	int index = i-rotation;
        	index %= arr.length;
        	if(index < 0) {
        		arr[arr.length+index] = encrypted_text.charAt(i);
        	}else {
        		arr[index] = encrypted_text.charAt(i);
        	}
        }
        
        //key를 이용하여 복호화
        for(int i=0;i<arr.length;i++) {
        	int knum = key.charAt(i)-'a'+1;
        	char ch = (char) (arr[i] - knum);
        	
        	if(ch < 'a') {
        		arr[i] = (char)(ch+26);
        	}else if(ch > 'z'){
        		arr[i] = (char)(ch-26);
        	}else {
        		arr[i] -= knum;
        	}
        }
        
        StringBuilder sb = new StringBuilder();
        for(int i=0;i<arr.length;i++) {
        	sb.append(arr[i]);
        }
        
        return sb.toString();
    }
}
