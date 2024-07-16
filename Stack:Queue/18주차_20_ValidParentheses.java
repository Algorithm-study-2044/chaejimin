package codefile;

import java.util.Stack;

public class Solution20 {
	public boolean isValid(String s) {
        Stack<String> st = new Stack<>();
        
        for(int i = 0; i < s.length(); i++) {
        	if (String.valueOf(s.charAt(i)).equals("{") || 
        			String.valueOf(s.charAt(i)).equals("(") ||
        			String.valueOf(s.charAt(i)).equals("[")) {
        		st.push(String.valueOf(s.charAt(i)));
        	}else {
        		if (st.empty()) return false;
        		if (String.valueOf(s.charAt(i)).equals("}") && st.peek().equals("{")) {
        			st.pop();
        		}else if (String.valueOf(s.charAt(i)).equals("]") && st.peek().equals("[")) {
        			st.pop();
        		}else if (String.valueOf(s.charAt(i)).equals(")") && st.peek().equals("(")) {
        			st.pop();
        		}else {
        			return false;
        		}
        	}
        }
        return st.empty();
    }
}
