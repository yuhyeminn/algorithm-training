package programmers.level2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 오픈 채팅 방(2019 카카오)
 * 
 * [문제]
 * https://programmers.co.kr/learn/courses/30/lessons/42888
 */
public class OpenChattingRoom {

	public static void main(String[] args) {
		String record[] = {"Enter uid1234 Muzi", "Enter uid4567 Prodo", "Leave uid1234 uid1234", "Enter uid1234 Prodo", "Change uid4567 Ryan" };
		System.out.println(Arrays.toString(solution(record)));
	}
	
	public static String[] solution(String[] record) {
        Map<String,String> nickname = new HashMap<>();
        List<User> list = new ArrayList<>();
        for(int i=0; i<record.length;i++) {
        	String info[] = record[i].split(" ");
        	String stat = info[0];
        	
        	if("Enter".equals(stat)) {
        		list.add(new User(info[1], 0));
        	}else if("Leave".equals(stat)) {
        		list.add(new User(info[1], 1));
        		continue;
        	}
        	
        	nickname.put(info[1],info[2]);
        }
        
        String answer[] = new String[list.size()];
        for(int i=0;i<list.size();i++) {
        	User u = list.get(i);
        	String msg = "";
        	if(u.status == 0) {
        		msg = nickname.get(u.uid) +"님이 들어왔습니다.";
        	}else {
        		msg = nickname.get(u.uid) +"님이 나갔습니다.";
        	}
        	answer[i] = msg;
        }
        
        return answer;
    }
	
	public static class User{
		String uid;
		int status;
		
		public User(String uid, int status) {
			super();
			this.uid = uid;
			this.status = status;
		}
	}
	
}
