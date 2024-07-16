package codefile;

import java.util.Stack;

public class Solution844 {
	public boolean backspaceCompare(String s, String t) {
        Stack<String> st = new Stack<>();
        Stack<String> st1 = new Stack<>();
        
        for (int i = 0; i<s.length(); i++) {
        	if (String.valueOf(s.charAt(i)).equals("#")) {
        		if (st.empty()) continue;
        		st.pop();
        	}else {
        		st.push(String.valueOf(s.charAt(i)));
        	}
        }
        
        for (int i = 0; i<t.length(); i++) {
        	if (String.valueOf(t.charAt(i)).equals("#")) {
        		if (st1.empty()) continue;
        		st1.pop();
        	}else {
        		st1.push(String.valueOf(t.charAt(i)));
        	}
        }
        
        while(!st.empty() && !st1.empty()) {
        	if (st.pop().equals(st1.pop())) {
                continue;
            }else{
                return false;
            }
        	
        }
        return st1.empty() && st.empty();
 
    }
}
