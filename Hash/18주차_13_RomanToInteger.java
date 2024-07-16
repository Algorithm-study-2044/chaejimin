package codefile;

import java.util.Hashtable;
import java.util.Queue;
import java.util.LinkedList;


public class Solution13 {
	
	public int romanToInt(String s){
		
		Hashtable<String, Integer> ht = new Hashtable<String, Integer>();
		ht.put("I", 1);
		ht.put("V", 5);
		ht.put("X", 10);
		ht.put("L", 50);
		ht.put("C", 100);
		ht.put("D", 500);
		ht.put("M", 1000);
		
		
		Queue<String> q = new LinkedList<String>();
		String[] arr = s.split("");
		for(int i = 0; i < arr.length; i++) {
			q.offer(arr[i]);
		}

		int result = 0;
		while(q.isEmpty() == false) {
			String curr = q.poll();
			
			if (q.isEmpty() == false) {
				if (curr.equals("I")) {
					if (q.peek().equals("V")) {
						q.poll();
						result += 4;
						continue;
					}else if(q.peek().equals("X")) {
						q.poll();
						result += 9;
						continue;
					}
				}
				if (curr.equals("X")) {
					if (q.peek().equals("L")) {
						q.poll();
						result += 40;
						continue;
					}else if(q.peek().equals("C")) {
						q.poll();
						result += 90;
						continue;
					}
				}
				if (curr.equals("C")) {
					if (q.peek().equals("D")) {
						q.poll();
						result += 400;
						continue;
					}
					if(q.peek().equals("M")) {
						q.poll();
						result += 900;
						continue;
					}
				}
			}
			
			result += ht.get(curr);
			
		}
		return result;
		
	}
}
